package vol;

import com.google.gson.Gson;
import retrofit.RestAdapter;

import java.util.List;

/**
 * Created by stephane on 15/09/16.
 */
public class Vol {

	public List<Repo> parse() {
		new Gson().toJson("ello");
		RestAdapter.Builder builder = new RestAdapter.Builder()
				.setEndpoint("https://api.github.com");
		RestAdapter adapter = builder.build();
		return adapter.create(GitHubService.class).listRepos("skonstant");
    }
}
