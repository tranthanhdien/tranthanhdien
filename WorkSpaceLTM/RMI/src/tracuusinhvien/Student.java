package tracuusinhvien;

import java.io.Serializable;

public class Student implements Serializable{
	private String mssv;
	private String name;
	private int age;
	private double score;

	public Student(String mssv, String name, int age, double score) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return mssv + "\t" + name + "\t" + age + "\t" + score + "\n";
	}

}
