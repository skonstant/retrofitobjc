package vol;

import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * Created by stephane on 15/09/16.
 */
public interface GitHubService {
		@GET("/users/{user}/repos")
        List<Repo> listRepos(@Path("user") String user);
}
