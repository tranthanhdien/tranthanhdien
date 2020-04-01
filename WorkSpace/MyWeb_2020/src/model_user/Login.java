package model_user;

public class Login {
	private int idUser;
	private String email;
	private String pass;
	private boolean admin;
	
	public Login(int idUser, String email, String pass, boolean admin) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.pass = pass;
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	

}
