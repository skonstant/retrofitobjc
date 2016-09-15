package vol;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by stephane on 15/09/16.
 */
public class Vol {

	public List<Repo> parse() {
		new Gson().toJson("ello");
		new OkHttpClient();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
        try {
            return retrofit.create(GitHubService.class).listRepos("skonstant").execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
