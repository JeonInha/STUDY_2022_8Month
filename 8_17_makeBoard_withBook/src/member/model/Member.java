package member.model;
import java.util.Date;

public class Member {
	
	private String id;
	private String name;
	private String passsword;
	private Date regDate;

	public Member(String id, String name, String passsword, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.passsword = passsword;
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
		return passsword;
	}
	public void setPassword(String possword) {
		this.passsword = possword;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public boolean matchPassword(String pwd) {
		return passsword.equals(pwd);
	}
	
	
	
}
 