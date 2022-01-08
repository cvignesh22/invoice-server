package invoiceserver.model;

import javax.persistence.Column;

public class LoginBody {
	
	private String userName;
	private String password;
	public LoginBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginBody(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
