package midTerm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

public class Demo11 {
	public static void saveStudents(ArrayList<Student> listStudents, String path) throws IOException {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
		for(Student st : listStudents){
			pw.println(st.lineDataStudent());
		}
		pw.close();
		System.out.println("Lưu thành công");
	}

	public static ArrayList<Student> readStudents(String path) throws IOException {
		ArrayList<Student> listStudents = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String line = br.readLine();
		while (line != null) {
			String[] arr = line.split("\t");
			String id = arr[0];
			String name = arr[1];
			Student st = new Student(id, name);
			for (int i = 2; i < arr.length;) {
				String nameSubject = arr[i];
				double score = Double.parseDouble(arr[i + 1]);
				Subject subject = new Subject(nameSubject, score);
				st.addSubject(subject);
				i = i + 2;
			}

			listStudents.add(st);
		}
		for (Student st : listStudents) {
			System.out.println(st);
		}
		br.close();
		return listStudents;

	}

	public static void main(String[] args) throws IOException {
		String path = "de11/save.txt";
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
		List<Student> list = readStudents(path);
		//System.out.println(list.toString());
	}

}
