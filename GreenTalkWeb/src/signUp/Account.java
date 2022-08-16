package signUp;

import java.util.List;

public class Account {
	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private List<String> user_followerList;
	private List<String> user_followingList;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public List<String> getUser_followerList() {
		return user_followerList;
	}
	public void setUser_followerList(List<String> user_followList) {
		this.user_followerList = user_followList;
	}
	public List<String> getUser_followingList() {
		return user_followingList;
	}
	public void setUser_followingList(List<String> user_followingList) {
		this.user_followingList = user_followingList;
	}
	
	public Account(int user_num, String user_id, String user_name, String user_pw, List<String> user_followerList,
			List<String> user_followingList) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_followerList = user_followerList;
		this.user_followingList = user_followingList;
	}
	
	public Account(int user_num, String user_id, String user_name, String user_pw) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
	}
	
	public Account(String user_id, String user_name, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
	}
	
	@Override
	public String toString() {
		return "Account [user_num=" + user_num + ", user_name=" + user_name + ", user_pw=" + user_pw
				+ ", user_followerList=" + user_followerList + ", user_followingList=" + user_followingList + "]";
	}
}
