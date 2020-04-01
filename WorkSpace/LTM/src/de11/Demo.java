package de11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



public class Demo {
	public static void saveStudents(ArrayList<Student> listStudents, String path) throws UnsupportedEncodingException, FileNotFoundException {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
		for (Student st : listStudents) {
			pw.println(st.save());
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
				st.addSubject(new Subject(nameSubject, score));
				i+=2;
			}

			listStudents.add(st);
		}
		for (Student st : listStudents) {
			System.out.println(st.average());
		}
		return listStudents;
		
	}
	public static void main(String[] args) throws IOException {
		String path = "de11/saveStudent.txt";
		ArrayList<Student> listStudents = new ArrayList<>();
		Subject sb1 = new Subject("Lập trình mạng", 9.5);
		Subject sb2 = new Subject("Lập trình nâng cao", 8.5);
		Subject sb3 = new Subject("Lập trình web", 10);
		Subject sb4 = new Subject("Lập trình cơ bản", 7.5);
		Subject sb5 = new Subject("Lập trình java", 8.0);
		Student st1 = new Student("16130326", "Trần Thanh Điền");
		Student st2 = new Student("16130312", "Đặng Văn Đa");
		Student st3 = new Student("16130315", "Nguyễn Thị Hồng Duyên");
		Student st4 = new Student("16130317", "Võ Xuân Oai");
		st1.addSubject(sb1);
		st1.addSubject(sb2);
		st2.addSubject(sb2);
		st2.addSubject(sb3);
		st2.addSubject(sb4);
		st3.addSubject(sb1);
		st3.addSubject(sb4);
		st4.addSubject(sb3);
		st4.addSubject(sb4);
		st4.addSubject(sb1);
		st4.addSubject(sb4);
		listStudents.add(st1);
		listStudents.add(st2);
		listStudents.add(st3);
		listStudents.add(st4);
		saveStudents(listStudents, path);
		readStudents(path);
	}

}
