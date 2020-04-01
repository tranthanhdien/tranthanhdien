package tuan2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import tuan2.Student;

public class IOClass {
	public static boolean fileCopy(String sFile, String destFile, boolean moved) throws IOException {
		boolean result = false;
		if (!moved) {
			System.out.println("Chưa thực hiện thao tác copy");
			result = false;
		} else {
			File in = new File(sFile);
			File out = new File(destFile);
			if (in.exists()) {
				InputStream bis = new BufferedInputStream(new FileInputStream(in));
				// OutputStream bos = new BufferedOutputStream(new FileOutputStream(out));
				OutputStream bos = null;
				if (out.exists()) {
					out = new File(destFile, in.getName());
					out.createNewFile();
					bos = new FileOutputStream(out);
				} else {
					bos = new FileOutputStream(out);
				}
				long beginTime = System.currentTimeMillis();
				int data;
				// byte[] byt = sFile.getBytes();
				byte[] arr = new byte[1024 * 100];
				while ((data = bis.read(arr)) != -1) {
					bos.write(arr, 0, data);
					result = true;

				}
				long endTime = System.currentTimeMillis();
				System.out.println("Run time: " + (endTime - beginTime));
				bis.close();
				bos.close();
			}
		}
		return result;
	}

	public boolean folderCopy(String sFolder, String destFolder, boolean moved) throws IOException {
		boolean result = false;
		if (!moved) {
			System.out.println("Chưa thực hiện thao tác Copy");
		} else {
			File in = new File(sFolder);
			File out = new File(destFolder);
			if (in.exists()) {
				result = true;
				if (in.isDirectory()) { // folder
					for (File subFile : in.listFiles()) {
						String nameFile = subFile.getName();
						File subIN = new File(in, nameFile);
						File subOUT = new File(out, nameFile);
						folderCopy(subIN.getAbsolutePath(), subOUT.getAbsolutePath(), true);

					}
				} else { // file
					FileInputStream input = new FileInputStream(in);
					FileOutputStream output = new FileOutputStream(out);
					byte[] arr = new byte[1024 * 100];
					int readData;
					while ((readData = input.read(arr)) != -1) {
						output.write(arr, 0, readData);
					}

				}
			}
		}

		return result;

	}

	// bai12:
	public static boolean saveFile(ArrayList<Student> lstStudents, String path) throws FileNotFoundException {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(lstStudents);
			oos.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Student> readFile(String path) {
		ArrayList<Student> lstStudents = new ArrayList<Student>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			Object data = ois.readObject();
			lstStudents = ((ArrayList<Student>) data);
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstStudents;
	}

	// bai12:
	public String fileType(String fname) {
		String result = "";
		int i = fname.lastIndexOf(".");
		return result.substring(i + 1);

	}

	public void pack(String sFolder, String destFile) throws IOException {
		File sf = new File(sFolder);
		File df = new File(destFile);
		if (!sf.exists())
			return;
		RandomAccessFile raf = new RandomAccessFile(df, "rw");
		File[] listFile = sf.listFiles();
		raf.writeInt(listFile.length);
		for (File f : listFile) {
			raf.writeUTF(f.getName());
			raf.writeLong(f.length());
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			int data;
			while ((data = bis.read()) != -1) {
				raf.write(data);
				bis.close();
			}
			raf.close();
			System.out.println("Thành công");
		}

	}

	// tach file
	public static boolean fileSplit(String pathSrc, int sizeSplit) throws IOException {
		boolean result = false;
		File in = new File(pathSrc);
		if (!in.exists()) {
			System.out.println("File không tồn tại");
			return false;
		} else {
			result = true;
			int numFile = 0;
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(in));
			BufferedOutputStream output = null;
			if (in.length() % sizeSplit == 0) {
				numFile = (int) (in.length() / sizeSplit);
			} else {
				numFile = (int) (in.length() / sizeSplit) + 1;
			}
			int data = 0;
			byte[] arr = new byte[sizeSplit];
			for (int i = 0; i < numFile; i++) {
				String pathDest = in.getPath() + ".part" + i;
				data = input.read(arr);
				if (data != -1) {
					output = new BufferedOutputStream(new FileOutputStream(pathDest));
					output.write(arr);
					output.close();
				}
			}
			input.close();
		}

		return result;
	}

	public static boolean zipFile(String pathSrc, String pathDest) throws IOException {
		boolean result = false;
		File in = new File(pathSrc);
		if (in.exists()) {
			result = true;
			FileInputStream input = new FileInputStream(in);
			ZipOutputStream output = new ZipOutputStream(new FileOutputStream(pathDest));
			ZipEntry entry = new ZipEntry(pathSrc);
			output.putNextEntry(entry);
			byte[] buffer = new byte[1024 * 100];
			int read = 0;
			while ((read = (input.read(buffer))) != -1) {
				output.write(read);
			}
			output.closeEntry();
			output.close();
			input.close();
		}
		return result;
	}

	// bai15
	public void export(ArrayList<Student> lstStudents, String path) throws FileNotFoundException {
		File destFile = new File(path);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFile)));
		for (Student st : lstStudents) {
			pw.println();

		}
		pw.close();
	}
	// Bài 13
	public static void saveStudent(ArrayList<Student> list, String pathDest) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathDest));
		for (Student st : list) {
			dos.writeChar('\t');
			dos.writeUTF((st.getId()));
			dos.writeChar('\t');
			dos.writeUTF(st.getName());
			dos.writeChar('\t');
			dos.writeUTF((st.getOld()));
			dos.writeChar('\t');
			dos.writeUTF(st.getAddress());
			dos.writeChars("\n");

		}
		dos.close();
	}

	public static void saveRAF(ArrayList<Student> list, String pathDest) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(pathDest), "rw");
		for (Student st : list) {
			raf.writeChar('\t');
			raf.writeUTF(st.getId());
			raf.writeChar('\t');
			raf.writeUTF(st.getName());
			raf.writeChar('\t');
			raf.writeUTF(st.getOld());
			raf.writeChar('\t');
			raf.writeUTF(st.getAddress());
			raf.writeChar('\n');
		}
		raf.close();
	}

	public static void readStudent(String pathDest) throws IOException {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(pathDest)));
		String line = dis.readLine();
		while (line != null) {
			String[] arr = line.split("\t");
			if (arr.length == 4) {
				Student st = new Student(arr[0], arr[1], arr[2], arr[3]);
				System.out.println(st);
			}
			line = dis.readLine();
		}

	}

	public static void read(String path) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(path));
		while (dis.available() > 0) {
			dis.readChar();
			String id = dis.readUTF();
			dis.readChar();
			String name = dis.readUTF();
			dis.readChar();
			String old = dis.readUTF();
			dis.readChar();
			String address = dis.readUTF();
			dis.readChar();
			Student st = new Student(id, name, old, address);
			System.out.println(st.toString());
		}
		dis.close();
		System.out.println("Read is ok...");
	}

	public static void readStudents(String pathDest) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(pathDest), "rw");
		while (raf.getFilePointer() < raf.length()) {
			raf.readChar();
			String id = raf.readUTF();
			raf.readChar();
			String name = raf.readUTF();
			raf.readChar();
			String old = raf.readUTF();
			raf.readChar();
			String address = raf.readUTF();
			raf.readChar();
			Student st = new Student(id, name, old, address);
			System.out.println(st.toString());
		}
		raf.close();
	}

	public static void readSeek(String path, int pos) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");
		int count = 0;
		while (raf.getFilePointer() < raf.length()) {
			raf.readChar();
			String id = raf.readUTF();
			raf.readChar();
			String name = raf.readUTF();
			raf.readChar();
			String old = raf.readUTF();
			raf.readChar();
			String address = raf.readUTF();
			raf.readChar();
			Student st = new Student(id, name, old, address);
			System.out.println(st.toString());
		}

		raf.close();

	}

	static ArrayList<Student> lstStudents = new ArrayList<Student>();

	public static void importFileTxt(String pathSrc, String charSet) throws IOException {
	//	File file = new File(pathSrc);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathSrc), charSet));
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

	public static void exportFileTxt(String pathSrc, String charSet) throws IOException {
		File file = new File(pathSrc);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charSet));
		for (Student st : lstStudents) {
			String line = st.getId() + "\t" + st.getName() + "\t" + st.getOld() + "\t" + st.getAddress();
			bw.write(line);
			bw.newLine();
		}
		bw.close();
	}

	public static void importFileExcel(String pathSrc, String charSet) throws IOException {
		File file = new File(pathSrc);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charSet));
		String line = br.readLine();
//		String[] ss = line.split(",");
//		System.out.println(ss[0] + "\t" + ss[1] + "\t" + ss[2] + "\t" + ss[3] +"\n");
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
		IOClass io = new IOClass();
//		String sFile = "F:\\TÀI LIỆU\\excel.xlsx";
//		String destFile = "F:\\";
//		boolean moved = true;
//		// System.out.println(io.fileCopy(sFile, destFile, moved));
//
//		String sFolder = "F:\\bai6";
//		String destFolder = "F:\\";
//		boolean movedd = true;
//		// System.out.println(io.folderCopy(sFolder, destFolder, movedd));
//
//		// lưu file
//		ArrayList<Student> lstStudents = new ArrayList<Student>();
//		lstStudents.add(new Student(1, "Trần Thanh Điền", 19, "Thủ Đức"));
//		lstStudents.add(new Student(2, "Nguyễn Văn A", 26, "Bình Dương"));
//		lstStudents.add(new Student(3, "Trần Văn B", 25, "Bình Thạnh"));
//		lstStudents.add(new Student(4, "Lê Thị C", 23, "Quận 1"));
//		lstStudents.add(new Student(5, "Trần Thị Tí", 21, "Quận 1"));
//		boolean kt = IOClass.saveFile(lstStudents, "file/savefile.txt");
//		if (kt == true) {
//			System.out.println("Lưu file thành công");
//		} else {
//			System.out.println("Lưu file thất bại");
//		}
//		// đọc file
//		ArrayList<Student> ds = IOClass.readFile("file/savefile.txt");
//		System.out.println("\t\t\tDANH SÁCH SINH VIÊN");
//		System.out.println("Mã\t\t" + "Tên\t\t\t" + "Tuổi\t\t" + "Địa chỉ");
//		for (Student stu : ds) {
//			System.out
//					.println(stu.getId() + "\t\t" + stu.getName() + "\t\t" + stu.getOld() + "\t\t" + stu.getAddress());
//		}
//		String s1 = "F:\\bai6";
//		String s2 = "F:\\bai6\\demo.txt";
//		io.pack(s1, s2);
		String s = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\BT.docx";
		int size = 3 * 1024;
		// System.out.println(fileSplit(s, size));
		// String pathSrc = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\BT.docx";
		// System.out.println(zipFile(pathSrc, "F:\\DOCUMENT\\LẬP TRÌNH
		// MẠNG\\Lap_Trinh_Mang\\BT.zip"));

		String path1 = "file/savefile.txt";
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("1", "Trần Thanh Điền", "20", "VT"));
		list.add(new Student("2", "Đặng Văn Đa", "21", "VT"));
		list.add(new Student("3", "Nguyễn Quốc An", "22", "VT"));
		//saveStudent(list, path1);
	//	read(path1);
		 
		 
		 
		 
		 
		 
		String path2 = "file/save.txt";
		saveRAF(list, path2);
		readStudents(path2);

		String path = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\savefile.txt";
		String pathDest = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\save.txt";
		String pathSrc = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\test.csv";

		String charSet = "UTF-8";
	//	importFileTxt(path, charSet);
		//exportFileTxt(pathDest, charSet);
		System.out.println("===============================================");
		importFileExcel(pathSrc, charSet);
	}

}
