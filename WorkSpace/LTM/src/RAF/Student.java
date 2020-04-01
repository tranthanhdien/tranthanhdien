package RAF;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
	private String mssv;
	private String name;
	private ArrayList<Subject> listSubjects;

	public Student(String mssv, String name) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.listSubjects = new ArrayList<Subject>();
	}

	public void addSubject(Subject sb) {
		listSubjects.add(sb);
	}

	public String getMssv() {
		return mssv;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Subject> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(ArrayList<Subject> listSubjects) {
		this.listSubjects = listSubjects;
	}

	@Override
	public String toString() {
		String result = "";
		result += mssv + "\t" + name + "\t";
		for (Subject sb : listSubjects) {
			result += sb.getName() + "\t" + sb.getGrade();
		}
		return result;
	}

	public void save(DataOutputStream dos) throws IOException {
		dos.writeUTF(mssv);
		dos.writeUTF(name);
		dos.writeInt(listSubjects.size());
		for (Subject sb : listSubjects) {
			dos.writeUTF(sb.getName());
			dos.writeDouble(sb.getGrade());
		}

	}

	public double average() {
		double result = 0;
		for (Subject sb : listSubjects) {
			result += sb.getGrade();
		}
		return result / (listSubjects.size());
	}
	public String print() {
		return mssv + "\t" + name + "\t" + average();
	}

}
