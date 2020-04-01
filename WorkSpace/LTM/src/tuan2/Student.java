package tuan2;

import java.io.Serializable;

public class Student implements Serializable {
	private String id;
	private String name;
	private String old;
	private String address;

	public Student(String id, String name, String old, String address) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOld() {
		return old;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" + old + "\t" + address;
	}
}
