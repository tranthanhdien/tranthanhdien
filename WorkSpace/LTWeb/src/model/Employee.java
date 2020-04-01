package model;

import java.util.Date;

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

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
