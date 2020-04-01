package lt.udp;

import java.io.Serializable;

public class Student implements Serializable{
	private int id;
	private String name;
	private double grade;

	public Student(int id, String name, double grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + grade;
	}

}
