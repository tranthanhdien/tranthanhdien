package model_user;

public class Customer {
	// ma, ten dang nhap, email, pass
	private int id;
	private String username;
	private String email;
	private String pass;

	public Customer() {
		
	}
	public Customer(String username, String email, String pass) {
		super();
		this.username = username;
		this.email = email;
		this.pass = pass;
	}

	public Customer(int id, String username, String email, String pass) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.username + "\t" + this.email + "\t" + this.pass;
	}

}
