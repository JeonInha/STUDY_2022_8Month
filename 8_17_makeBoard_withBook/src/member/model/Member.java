package member.model;
import java.util.Date;

public class Member {
	
	private String id;
	private String name;
	private String password;
	private Date regDate;

	public Member(String id, String name, String passsword, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.password = passsword;
		this.regDate = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String possword) {
		this.password = possword;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	
	
}
 