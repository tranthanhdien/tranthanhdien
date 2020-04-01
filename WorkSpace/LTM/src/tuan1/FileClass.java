package tuan1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.w3c.dom.ls.LSException;

public class FileClass {
	// bai1:
	public static boolean deletes(String path) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không thấy đường dẫn cần xoá");
			return false;
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					deletes(f.getAbsolutePath());
				}
				f.delete();
				System.out.println("Xoá thành công");
			}
		}
		return true;
	}

	// bai2:
	public static boolean findFirst(String path, String pattern) {
		boolean tmp = false;
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không thấy đường dẫn");
			return tmp;
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					findFirst(f.getAbsolutePath(), pattern);
				}
				if (f.getAbsolutePath().endsWith(pattern)) {
					System.out.println(f.getAbsolutePath());
					tmp = true;
				}
			}
		}
		return tmp;
	}

	// bai3:
	public static void dirTree(String path, String tab) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không tìm thấy đường dẫn");
			return;
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					System.out.println(tab + "|+---" + f.getName());
					dirTree(f.getAbsolutePath(), tab + "\t");
				} else {
					System.out.println(tab + "\t+---" + f.getName());
				}
			}
		}
	}

	// bai4:
	public static void dirStat(String path) {
		String tab = "";
		double sumSize = 0;
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không tìm thấy đường dẫn");
			return;
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				double bytes = f.length();
				double kilobytes = (bytes / 1024);
				if (f.isDirectory()) {
					System.out.println(tab + "|+---" + f.getName() + "\t" + kilobytes + ":KB");
					dirTree(f.getAbsolutePath(), tab + "\t");
				} else {
					System.out.println(tab + "\t+---" + "\t" + "\t" + kilobytes + ":KB");
				}
			}
		}
	}

	// bai5:
	public static void findAll(String path, String ext1, String ext2) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không thấy đường dẫn");
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					findAll(f.getAbsolutePath(), ext1, ext2);
				}
				if (f.getAbsolutePath().endsWith(ext1) || (f.getAbsolutePath().endsWith(ext2))) {
					System.out.println(f.getAbsolutePath());
				}
			}
		}
	}

	// bai6:
	public static void deleteAll(String path, String ext1, String ext2) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Không thấy đường dẫn cần xoá");
		} else {
			File[] listFile = file.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					deleteAll(f.getAbsolutePath(), ext1, ext2);
				} else {
					if (f.getName().endsWith(ext1) || (f.getName().endsWith(ext2))) {
						f.delete();
					}
					System.out.println("Không tồn tại file/folder cần xoá");
				}
			}
		}
	}

	// bai7:
	public static void copyFile(String sf, String sd) throws IOException {
		InputStream fis = new BufferedInputStream(new FileInputStream(sf));
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(sd));
		long beginTime = System.currentTimeMillis();
		int data;
		byte[] byt = sf.getBytes();
		while ((data = fis.read(byt)) != -1) {
			fos.write(data);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Done in: " + (endTime - beginTime));
		fis.close();
		fos.close();
	}

	public static void copyAll(String sDir, String dDir, String ext1, String ext2) throws IOException {
		File sourceFile = new File(sDir);
		File destFile = new File(dDir);
		if (!sourceFile.exists()) {
			System.out.println("Folder không tồn tại");
		} else {
			if (sourceFile.isFile()) {
				if (sourceFile.getName().endsWith(ext1) || (sourceFile.getName().endsWith(ext2))) {
					copyFile(sDir, dDir);
				}
			}
			if (sourceFile.isDirectory()) {
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				File[] listFile = sourceFile.listFiles();
				for (File f : listFile) {
					copyAll(f.getAbsolutePath(), dDir + "/" + f.getName(), ext1, ext2);
				}
			}

		}

	}
	
	public static void main(String[] args) throws IOException {
		FileClass fileClass = new FileClass();
		// bai1:
		System.out.println("Bài1:-----------------------");
		String s1 = "F:\\tmp";
		System.out.println(deletes(s1));

		// bai2:
		System.out.println("Bài2:-----------------------");
		String s2 = "F:\\DOCUMENT\\LẬP TRÌNH MẠNG";
		String st = "ServerApp";
		System.out.println(findFirst(s2, st));

		// bai3:
		System.out.println("Bài3:-----------------------");
		String s3 = "F:\\abc";
		String str = "";
		dirTree(s3, str);

		// bai4:
		System.out.println("Bài4:-----------------------");
		String s4 = "F:\\\\abc";
		dirStat(s4);

		// bai5:
		System.out.println("Bài5:-----------------------");
		String s5 = "F:\\bai6";
		String mp3 = ".mp3";
		String mp4 = ".mp4";
		findAll(s5, mp3, mp4);
		// bai6:
		System.out.println("Bài6:-----------------------");
		String s6 = "F:\\bai6";
		String txt = ".txt";
		String pdf = ".pdf";
		deleteAll(s6, txt, pdf);

		// bai7:
		System.out.println("Bài7:-----------------------");
		String sDir = "";
		String dDir = "";
		String png = "";
		String txtt = "";
		copyAll(sDir, dDir, png, txtt);
		
	}

}
