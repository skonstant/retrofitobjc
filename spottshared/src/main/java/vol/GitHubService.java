package vol;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by stephane on 15/09/16.
 */
public interface GitHubService {
		@GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
}
