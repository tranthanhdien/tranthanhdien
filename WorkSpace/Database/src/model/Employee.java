package model;

public class Employee {
	private int no;
	private String id;
	private String name;
	private String dob;
	private String address;

	public Employee(int no, String id, String name, String dob, String address) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
