package de22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	private ArrayList<Student> students;

	public Demo() {
		super();
		this.students = new ArrayList<Student>();
	}

	public void NapDuLieuBanDau(String fileSV, String fileDiem) throws IOException {
		File fileS = new File(fileSV);
		File fileD = new File(fileDiem);
		if (!fileD.exists() || !fileS.exists()) {
			System.out.println("file nguon khong ton tai");
			return;
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileS), "UTF-16"));
		String line;
		bufferedReader.readLine();
		Map<String, Double> danhSachDiemTrungBinh = danhSachDiemTrungBinh(fileDiem);
		while ((line = bufferedReader.readLine()) != null) {
			String[] s = line.split("\t");
			String mssv = s[0];
			String ten = s[1];
			int tuoi = Integer.parseInt(s[2]);
			double diemTrungBinh = 0;
			try {
				diemTrungBinh = danhSachDiemTrungBinh.get(mssv);
			} catch (Exception e) {
			}
			students.add(new Student(mssv, ten, tuoi, diemTrungBinh));
			
		}
		System.out.println(students.toString());
		bufferedReader.close();
	}

	public Map<String, Double> danhSachDiemTrungBinh(String fileD) throws IOException, FileNotFoundException {
		Map<String, Double> res = new HashMap<String, Double>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileD), "UTF-16"));
		String line;
		bufferedReader.readLine();
		while ((line = bufferedReader.readLine()) != null) {
			String[] arr = line.split("\t");
			double average = 0;
			double sum = 0;
			try {
				for (int i = 1; i < arr.length; i++) {
					sum += Double.parseDouble(arr[i]);
				}
			} catch (Exception e) {
			}
			average = sum / (double) (arr.length - 1);
			res.put(arr[0], average);

		}
		bufferedReader.close();

		return res;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		String result = "";
		for (Student st : students) {
			result += st.getMssv() + "\t" + st.getTen() + "\t" + st.getTuoi() + "\t" + st.getDiemTB() + "\n";
		}
		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		Demo management = new Demo();
		management.NapDuLieuBanDau("file/sinhvien.txt", "file/diem.txt");
		
	}

}
