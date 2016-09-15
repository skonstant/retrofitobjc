/*
 * Copyright (C) 2016 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3.internal.tls;

import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class TrustRootIndex {
  /** Returns the trusted CA certificate that signed {@code cert}. */
  public abstract X509Certificate findByIssuerAndSignature(X509Certificate cert);

  public static TrustRootIndex get(X509TrustManager trustManager) {
    return get(trustManager.getAcceptedIssuers());
  }

  public static TrustRootIndex get(X509Certificate... caCerts) {
    return new BasicTrustRootIndex(caCerts);
  }

  /** A simple index that of trusted root certificates that have been loaded into memory. */
  static final class BasicTrustRootIndex extends TrustRootIndex {
    private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... caCerts) {
      subjectToCaCerts = new LinkedHashMap<>();
      for (X509Certificate caCert : caCerts) {
        X500Principal subject = caCert.getSubjectX500Principal();
        List<X509Certificate> subjectCaCerts = subjectToCaCerts.get(subject);
        if (subjectCaCerts == null) {
          subjectCaCerts = new ArrayList<>(1);
          subjectToCaCerts.put(subject, subjectCaCerts);
        }
        subjectCaCerts.add(caCert);
      }
    }

    @Override public X509Certificate findByIssuerAndSignature(X509Certificate cert) {
      X500Principal issuer = cert.getIssuerX500Principal();
      List<X509Certificate> subjectCaCerts = subjectToCaCerts.get(issuer);
      if (subjectCaCerts == null) return null;

      for (X509Certificate caCert : subjectCaCerts) {
        PublicKey publicKey = caCert.getPublicKey();
        try {
          cert.verify(publicKey);
          return caCert;
        } catch (Exception ignored) {
        }
      }

      return null;
    }
  }
}
