package user;

import java.sql.Date;

public class UserDTO {

	private int idx;
	private String userid;
	private String pw;
	private String name;
	private String phone;
	private Date joindate;
	private String email;
	private String address;
	
	
	
	
	
	public UserDTO(int idx, String userid, String pw, String name, String phone, Date joindate, String email,
			String address) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.joindate = joindate;
		this.email = email;
		this.address = address;
	}

	public UserDTO() {
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
	
}
