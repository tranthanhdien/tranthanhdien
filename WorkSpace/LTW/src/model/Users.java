package model;

public class Users {
	private long userID;
	private String userEmail;
	private String userPass;
	private boolean userRole;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long userID, String userEmail, String userPass, boolean userRole) {
		super();
		this.userID = userID;
		this.userEmail = userEmail;
		this.userPass = userPass;
		this.userRole = userRole;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public boolean isUserRole() {
		return userRole;
	}

	public void setUserRole(boolean userRole) {
		this.userRole = userRole;
	}

}
