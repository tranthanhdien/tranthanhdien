package midTerm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo12 {
	public static void saveStudents(ArrayList<Student> lstStudents, String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		dos.writeInt(lstStudents.size());
		for (int i = 0; i < lstStudents.size(); i++) {
			lstStudents.get(i).saveSubject(dos);
		}
		dos.close();
		System.out.println("Lưu thành công");

	}
	public static ArrayList<Student> readStudents(String path) throws IOException {
		File sf = new File(path);
		List<Student> list = new ArrayList<Student>();
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
		for (Student st : list) {
			System.out.println(st.print());
		}
		dis.close();
		System.out.println("Read is done!");
		return (ArrayList<Student>) list;
	}

	public static void main(String[] args) throws IOException {
		String path = "de12/save.txt";
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
		
	}
}
