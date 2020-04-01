package tuan2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Review {
	public static boolean copyFile(String sFile, String dFile, boolean moved) throws IOException {
		boolean result = false;
		if (!moved) {
			result = false;
			System.out.println("Chưa thực hiện thao tác copy");
		} else {
			result = true;
			File in = new File(sFile);
			File out = new File(dFile);
			if (in.exists()) {
				InputStream input = new BufferedInputStream(new FileInputStream(in));
				OutputStream output = new BufferedOutputStream(new FileOutputStream(out));
				long beginTime = System.currentTimeMillis();
				int data;
				byte[] arr = new byte[100 * 1024];
				while ((data = input.read(arr)) != -1) {
					output.write(data);
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Run time: " + (endTime - beginTime));
				System.out.println("Copy thành công");
				input.close();
				output.close();
			}
		}
		return result;
	}

	public static boolean copyFile1(String sFile, String dFile, boolean moved) throws IOException {
		boolean result = false;
		if (!moved) {
			System.out.println("Chưa thực hiện thao tác copy");
			result = false;
		} else {
			File in = new File(sFile);
			File out = new File(dFile);
			if (in.exists()) {
				InputStream bis = new BufferedInputStream(new FileInputStream(in));
				// OutputStream bos = new BufferedOutputStream(new FileOutputStream(out));
				OutputStream bos = null;
				if (out.exists()) {
					out = new File(dFile, in.getName());
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

	public static boolean unpackFile(String sFile, String dPath, String fileName) throws IOException {
		File sf = new File(sFile);
		File df = new File(dPath);
		if(!sf.exists()) return false;
		System.out.println("File nguồn k tồn tại");
		if(!df.exists()) return false;
		System.out.println("File đích k tồn tại");
		RandomAccessFile raf = new RandomAccessFile(sf, "rw");
		//int count = raf.readInt();  // đếm tất cả số lượng trong file
		while(true) { // chạy từ đầu đến hết file
			String fname = raf.readUTF(); // tên file
			long fileSize = raf.readLong();	  // kích cỡ file
			long nextEntry = raf.getFilePointer(); // vị trí của con trỏ
			if (fname.equals(fileName)) {   // tiến hành đọc và ghi file đó ra
				File df1 = new File(df + File.separator + fname);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(df1));
				for (int j = 0; j < fileSize; j++) {
					bos.write(raf.read());
				}
				bos.close();
				raf.close();
				System.out.println("Unpack file success");
				return true;
			} else {
				raf.seek(nextEntry + fileSize);
			}
			if (nextEntry == 0) {
				System.out.println("khong co file can tim");
				break;
			}
		}
		System.out.println("Unpack file fail");
		raf.close();
		return false;
	}

	// Lưu file nhị phân
	public static void saveFile(List<Student> lstStudents, String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		for (Student st : lstStudents) {
			dos.writeChar('\t');
			dos.writeUTF(st.getId());
			dos.writeChar('\t');
			dos.writeUTF(st.getName());
			dos.writeChar('\t');
			dos.writeUTF(st.getOld());
			dos.writeChar('\t');
			dos.writeUTF(st.getAddress());
			dos.writeChar('\n');
		}
		System.out.println("Lưu file thành công");
		dos.close();
	}

	// Đọc file nhị phân
	public static void readFile(String path) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(path));
		while (dis.available()>0) {
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
			System.out.println(st);
		}
		System.out.println("Read is OK!");
		dis.close();
	}
	
	public static void main(String[] args) throws IOException {
		// Lưu file
		ArrayList<Student> lstStudents = new ArrayList<>();
		lstStudents.add(new Student("111", "Trần Thanh Điền", "20", "Thủ Đức"));
		lstStudents.add(new Student("222", "Đặng Văn Đa", "21", "Bình Chánh"));
		lstStudents.add(new Student("333", "Trần Ngọc Thọ", "22", "Bình Dương"));
		lstStudents.add(new Student("444", "Võ Xuân Trường", "23", "Gò Vấp"));
		String path = "pack/saveFile.txt";
		//saveFile(lstStudents, path);
		//readFile(path);

		//String sFile = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\save.txt";
		//String dFile = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG\\Lap_Trinh_Mang\\save_copy.txt";
		String sFile1 = "F:\\TÀI LIỆU\\excel.xlsx";
		String dFile1 = "F:\\";
		// copyFile(sFile, dFile, true);
		// copyFile1(sFile1, dFile1, true);

		String sFile = "file";
		String dPath = "pack/unpack.txt";
		String fileName = "test.txt";
		boolean result = unpackFile(sFile, dPath, fileName);
		System.out.println(result);
		
	}

}
