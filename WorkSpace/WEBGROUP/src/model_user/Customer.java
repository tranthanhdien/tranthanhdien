package model_user;

public class Customer {
	// ma, ten dang nhap, email, pass
	private int id;
	private String username;
	private String fullName;
	private String phone;
	private String address;
	
	public Customer() {
		super();
	}
	public Customer(int id, String username, String fullName, String phone, String address) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
