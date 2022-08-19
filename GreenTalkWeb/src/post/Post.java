package post;

import java.time.LocalDateTime;

public class Post {
	int post_id;
	int post_user_id;
	LocalDateTime post_dateTime;
	String post_content;
	boolean post_isComment;
	int post_Comment_postid;
	int post_Comment_userid;
	
	public Post(int post_id, int post_user_id, LocalDateTime post_dateTime, String post_content, boolean post_isComment) {
		super();
		this.post_user_id = post_user_id;
		this.post_content = post_content;
		this.post_isComment = post_isComment;
		this.post_id = post_id;
		this.post_dateTime = post_dateTime;
	}
	
	public Post(int post_id, int post_user_id, LocalDateTime post_dateTime, String post_content, boolean post_isComment, int post_Comment_postid,
			int post_Comment_userid) {
		super();
		this.post_user_id = post_user_id;
		this.post_content = post_content;
		this.post_isComment = post_isComment;
		this.post_Comment_postid = post_Comment_postid;
		this.post_Comment_userid = post_Comment_userid;
		this.post_id = post_id;
		this.post_dateTime = post_dateTime;
	}
	
	public Post(int post_user_id, String post_content, boolean post_isComment) {
		super();
		this.post_user_id = post_user_id;
		this.post_content = post_content;
		this.post_isComment = post_isComment;
	}

	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getPost_user_id() {
		return post_user_id;
	}
	public void setPost_user_id(int post_user_id) {
		this.post_user_id = post_user_id;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public boolean isPost_isComment() {
		return post_isComment;
	}
	public void setPost_isComment(boolean post_isComment) {
		this.post_isComment = post_isComment;
	}
	public int getPost_Comment_postid() {
		return post_Comment_postid;
	}
	public void setPost_Comment_postid(int post_Comment_postid) {
		this.post_Comment_postid = post_Comment_postid;
	}
	public int getPost_Comment_userid() {
		return post_Comment_userid;
	}
	public void setPost_Comment_userid(int post_Comment_userid) {
		this.post_Comment_userid = post_Comment_userid;
	}
	public LocalDateTime getPost_dateTime() {
		return post_dateTime;
	}
	public void setPost_dateTime(LocalDateTime post_dateTime) {
		this.post_dateTime = post_dateTime;
	}
	
}
