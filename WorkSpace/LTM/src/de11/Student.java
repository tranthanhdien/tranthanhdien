package de11;

import java.util.ArrayList;

public class Student {
	private String id;
	private String name;
	private ArrayList<Subject> listSubject;

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.listSubject = new ArrayList<Subject>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Subject> getListSubject() {
		return listSubject;
	}

	@Override
	public String toString() {
		String result = "";
		return result;
	}

	public void addSubject(Subject sb) {
		listSubject.add(sb);
	}

	public double average() {
		double result = 0;
		for (Subject sb : listSubject) {
			result += sb.getScore();
		}
		return result / (listSubject.size());
	}

	public String save() {
		String line = id + "\t" + name + "\t";
		for (Subject sb : listSubject) {
			line += sb.getName() + "\t" + sb.getScore() + "\t";
		}
		return line;
	}

}
