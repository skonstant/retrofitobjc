package vol;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

/**
 * Created by stephane on 15/09/16.
 */
public class Vol {

	public List<Repo> parse() {
		new Gson().toJson("ello");


            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://api.github.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                return retrofit.create(GitHubService.class).listRepos("skonstant").execute().body();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
