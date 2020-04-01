package model;

public class Customer {
	private String userName;
	private String pass;
	private String name;

	public Customer(String userName, String pass, String name) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", pass=" + pass + ", name=" + name + "]";
	}

}
