package post;
import java.util.List;

import signUp.Account;

public interface PostDao {
	// c
	public int uploadPost(Post post);
	public int uploadCommentPost(Post post);

	// r
	public List<Post> readPostbyUser(Account user);
	public Post readPostbyID(int postid);
	public List<Post> readPostbySearch(String s);
	
	// d
	
	public int deletePost(Post post);
	public int deletePost(int postid);
}
