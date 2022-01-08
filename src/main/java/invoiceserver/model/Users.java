package invoiceserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	public static enum UserRole {admin, accountant, approver};
	@Id
	private int id;
	@Column(name = "user_name")
	private String userName;
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	UserRole userType;
	// constructors
	public Users() {
		super();
	}
	public Users(int id, String userName, String email, String password, UserRole userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		// this.userType = userType;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserType() {
		return userType;
	}
	public void setUserType(UserRole userType) {
		this.userType = userType;
	}

}
