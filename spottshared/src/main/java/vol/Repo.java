package vol;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stephane on 15/09/16.
 */
public class Repo {

	public String id;
	public String name;
	@SerializedName("private")
	public boolean private_;
}
