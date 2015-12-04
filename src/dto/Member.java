package dto;

public class Member {

	int no_mem;
	String id_mem;
	String pwd_mem;
	String name_mem;
	String email_mem;
	String intro_mem;
	
	public int getNo_mem() {
		return no_mem;
	}
	public void setNo_mem(int no_mem) {
		this.no_mem = no_mem;
	}
	public String getId_mem() {
		return id_mem;
	}
	public void setId_mem(String id_mem) {
		this.id_mem = id_mem;
	}
	public String getPwd_mem() {
		return pwd_mem;
	}
	public void setPwd_mem(String pwd_mem) {
		this.pwd_mem = pwd_mem;
	}
	public String getName_mem() {
		return name_mem;
	}
	public void setName_mem(String name_mem) {
		this.name_mem = name_mem;
	}
	public String getEmail_mem() {
		return email_mem;
	}
	public void setEmail_mem(String email_mem) {
		this.email_mem = email_mem;
	}
	public String getIntro_mem() {
		return intro_mem;
	}
	public void setIntro_mem(String intro_mem) {
		this.intro_mem = intro_mem;
	}
	@Override
	public String toString() {
		return "Member [no_mem=" + no_mem + ", id_mem=" + id_mem + ", pwd_mem=" + pwd_mem + ", name_mem=" + name_mem
				+ ", email_mem=" + email_mem + ", intro_mem=" + intro_mem + "]";
	}
	
}
