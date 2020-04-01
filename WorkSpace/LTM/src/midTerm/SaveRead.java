package midTerm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveRead {

	public static void saveStudents(ArrayList<Student> lstStudents, String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		for (Student st : lstStudents) {
			dos.writeChar('\t');
			dos.writeUTF(st.getId());
			dos.writeChar('\t');
			dos.writeUTF(st.getName());
			dos.writeChar('\t');
			dos.writeUTF(st.getLstSubjects() + "");
			dos.writeChar('\n');

		}
		System.out.println("Lưu thành công");
		dos.close();

	}

	public static void readStudents(String path) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(path));
		int numSubject = dis.readInt();
		while (dis.available() > 0) {
			dis.readChar();
			String id = dis.readUTF();
			dis.readChar();
			String name = dis.readUTF();
			dis.readChar();
			Student st = new Student(id, name);
			System.out.println(st);

		}
		System.out.println("Ready is OK!");
		dis.close();
	}
	
	public static List<Student> loadFileToListOfStudent(String sourceFile) throws IOException{
		File sf = new File(sourceFile);
		List<Student> list = new ArrayList<>();
		DataInputStream dis = new DataInputStream(new FileInputStream(sf));
		int count = dis.readInt();
		for (int i = 0; i < count; i++) {
			Student st=new Student(dis.readUTF(), dis.readUTF());
			int numSubject = dis.readInt();
			if(numSubject>0){
				for(int k=0;k<numSubject;k++){
					String subjectName = dis.readUTF();
					double score = dis.readDouble();
					st.addSubject(new Subject(subjectName, score));
				}
			}
			list.add(st);
		}
		dis.close();
		System.out.println("Load list of student from file data binary with DataInputStream success");
		return list;
	}

	public static void main(String[] args) throws IOException {
		String path = "file/test.txt";
		ArrayList<Student> listOfStudent = new ArrayList<>();
		Student sv1 = new Student("16130326", "Trần Thanh Điền");
		Student sv2 = new Student("16130326", "Nguyễn Văn A");
		Student sv3 = new Student("16130326", "Nguyễn Thị B");
		Student sv4 = new Student("16130326", "Lê Văn C");

		Subject ltdt = new Subject("Lý thuyết đồ thị", 9);
		Subject ltw = new Subject("Lập trình web", 5);
		Subject ltm = new Subject("Lập trình mạng", 8);
		Subject ltnc = new Subject("Lập trình nâng cao", 8);
		Subject ltcb = new Subject("Lập trình cơ bản", 3);
		Subject mmt = new Subject("Mạng máy tính", 5);
		sv1.addSubject(ltdt);
		sv1.addSubject(ltm);

		sv2.addSubject(ltcb);
		sv2.addSubject(ltm);
		sv2.addSubject(ltdt);

		sv3.addSubject(ltw);
		sv3.addSubject(ltnc);

		sv4.addSubject(mmt);
		sv4.addSubject(ltdt);
		sv4.addSubject(ltw);
		sv4.addSubject(ltnc);
		listOfStudent.add(sv1);
		listOfStudent.add(sv2);
		listOfStudent.add(sv3);
		listOfStudent.add(sv4);
		saveStudents(listOfStudent, path);
		readStudents(path);
	//	loadFileToListOfStudent(path);

	}

}
