package RAF;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveRead_RAF {
	public static void saveStudents(ArrayList<Student> listStudents, String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		dos.writeInt(listStudents.size()); // lưu số lượng sinh viên
		for (int i = 0; i < listStudents.size(); i++) {
			listStudents.get(i).save(dos);
			
		}
		dos.close();
		System.out.println("Lưu thành công");
	}
	public static ArrayList<Student> readStudents(String path) throws IOException {
		ArrayList<Student> listStudents = new ArrayList<>();
		DataInputStream dis = new DataInputStream(new FileInputStream(path));
		int count = dis.readInt();
		for (int i = 0; i < count; i++) {
			Student st = new Student(dis.readUTF(), dis.readUTF());
			int numberSub = dis.readInt();
			if (numberSub>0) {
				for (int j = 0; j < numberSub; j++) {
					String nameSub = dis.readUTF();
					double grade = dis.readDouble();
					st.addSubject(new Subject(nameSub, grade));
				}
			}
			listStudents.add(st);
		}
		for (Student st : listStudents) {
			System.out.println(st.print());
		}
		dis.close();
		System.out.println("Read is done!");
		return listStudents;
	}
	public static void main(String[] args) throws IOException {
		String path = "de12/saveStudent.txt";
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
