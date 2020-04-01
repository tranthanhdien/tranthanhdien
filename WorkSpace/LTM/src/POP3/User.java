package POP3;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String userName;
	private String pass;

	public User(String user, String pass) {
		super();
		this.userName = user;
		this.pass = pass;
	}

	
	public String getUserName() {
		return userName;
	}


	public String getPass() {
		return pass;
	}


	@Override
	public String toString() {
		return userName + "\t" + pass;
	}

}
