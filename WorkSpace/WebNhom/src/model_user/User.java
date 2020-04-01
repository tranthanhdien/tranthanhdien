package model_user;

public class User {
	Customer c;
	Login l;

	public User() {
		super();
	}

	public User(Customer c, Login l) {
		super();
		this.l = l;
		this.c = c;
	}
	
	public User(Login l) {
		super();
		this.l = l;
	}


	public Login getL() {
		return l;
	}

	public void setL(Login l) {
		this.l = l;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

}
