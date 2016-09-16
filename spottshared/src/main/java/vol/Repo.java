package vol;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stephane on 15/09/16.
 */
public class Repo {

	public enum Visibility {
		all,
		@SerializedName("public")
		public_,
		@SerializedName("private")
		private_
	}

	public enum Type {
		all, owner,
		@SerializedName("public")
		public_,
		@SerializedName("private")
		private_,
		member
	}

	public enum Sort {
		created, updated, pushed, full_name;
	}

	public Visibility visibility;
	public String affiliation;
	public Type type;
	public Sort sort;
}
