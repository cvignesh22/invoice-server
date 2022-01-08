package invoiceserver.model;

import invoiceserver.model.Users.UserRole;

public class UserDetails {
	private String userName;
	private UserRole role;
	private String token;
	private String status;
	
	
	
	public UserDetails(String userName, UserRole role, String token, String status) {
		super();
		this.userName = userName;
		this.role = role;
		this.token = token;
		this.status = status;
	}



	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole userRole) {
		this.role = userRole;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public UserDetails setUserBody(Users users , String token) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(users.getUserName());
		userDetails.setRole(users.getUserType());
		userDetails.setToken(token);
		userDetails.setStatus("OK");
		return userDetails;
	}
}
