import org.junit.Test;
import retrofit.RestAdapter;
import vol.GitHubService;

/**
 * Created by stephane on 16/09/16.
 */
public class TestRetrofit {

	@Test
	public void testRetrofitInit() {
		RestAdapter.Builder builder = new RestAdapter.Builder()
				.setEndpoint("https://api.github.com");
		RestAdapter adapter = builder.build();
		adapter.create(GitHubService.class).listRepos("skonstant");
	}
}
