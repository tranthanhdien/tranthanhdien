package midTerm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
	private String id;
	private String name;
	private ArrayList<Subject> lstSubjects;

	public Student() {
		this.lstSubjects = new ArrayList<Subject>();
	}

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.lstSubjects = new ArrayList<Subject>();
	}

	public void addSubject(Subject sb) {
		lstSubjects.add(sb);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Subject> getLstSubjects() {
		for (int i = 0; i < lstSubjects.size(); i++) {
			lstSubjects.get(i).toString();
		}
		return lstSubjects;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + lstSubjects + "\n";
	}

	public String print() {
		return "Id = " + id + ", Name= " + name + ", Score= " + averageScore();
	}

	public double averageScore() {
		double result = 0;
		for (Subject sb : lstSubjects) {
			result += sb.getScore();
		}
		return result / (lstSubjects.size());
	}

	public void saveSubject(DataOutputStream dos) throws IOException {
		dos.writeUTF(id);
		dos.writeUTF(name);
		dos.writeInt(lstSubjects.size());
		for (Subject sb : lstSubjects) {
			dos.writeUTF(sb.getName());
			dos.writeDouble(sb.getScore());
		}
		
	}

	public String lineDataStudent() {
		String line = id + "\t" + name;
		if (lstSubjects.size() > 0) {
			for (int i = 0; i < lstSubjects.size(); i++) {
				line += "\t" + lstSubjects.get(i).getName() + "\t" + lstSubjects.get(i).getScore();
			}
		}
		return line;
	}

}
