package vol;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Created by stephane on 16/09/16.
 */
public class DecodeQ {

	public String decodeQuery(String q) throws DataFormatException, UnsupportedEncodingException {
				byte[] data = Base64.decode(q, Base64.URL_SAFE);

				Inflater decompresser = new Inflater();
				decompresser.setInput(data);
				byte[] result = new byte[1000];
				int resultLength = decompresser.inflate(result);
				decompresser.end();

				String query = new String(result, 0, resultLength, "UTF-8");
				query = query.replace("[]", URLEncoder.encode("[]", "UTF-8"));
				return query;
	}
}
