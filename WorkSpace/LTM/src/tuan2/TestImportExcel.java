package tuan2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestImportExcel {
	static ArrayList<Student> lstStudents = new ArrayList<Student>();
	public static void importFileExcel(String pathSrc, String charSet) throws IOException {
		File file = new File(pathSrc);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charSet));
		String line = br.readLine();
		while (line != null) {
			String[] arr = line.split("\t");
			if (arr.length == 4) {
				Student st = new Student(arr[0], arr[1], arr[2], arr[3]);
				lstStudents.add(st);
			}
			line = br.readLine();
		}
		br.close();
		for (Student st : lstStudents) {
			System.out.println(st);
		}

	}
	public static void main(String[] args) throws IOException {
		String pathSrc = "C:\\Users\\TRANTHANHDIEN1\\Desktop\\Test.xlsx";
		String charSet = "UTF-8";
		importFileExcel(pathSrc, charSet);
	}

}
