package ttdien.rmi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import ttd.rmi.IFile;

public class FileClient {
	BufferedReader userrIn;
	boolean isLogin;
	BufferedInputStream bis;
	BufferedOutputStream bos;
	String mess;

	public void start() throws NotBoundException, IOException {
		Registry re = LocateRegistry.getRegistry("127.0.0.1", 12345);
		IFile file = (IFile) re.lookup("test");
		userrIn = new BufferedReader(new InputStreamReader(System.in)); // đọc dữ liệu bàn phím
		String line;
		StringTokenizer token;
		System.out.println("Welcome...");
		// mess = "Vui lòng đăng nhập";
		while (true) {
			try {
				line = userrIn.readLine();
				if (line.equalsIgnoreCase("QUIT"))
					break;
				// ktra phải cho nó đăng nhập trước
				if (!isLogin) {
					// chưa đăng nhập, bắt buộc

					token = new StringTokenizer(line);
					String action = token.nextToken();
					switch (action) {
					case "USER":
						try {
							String name = token.nextToken();
							if (file.checkName(name)) {
								System.out.println("Username OK!");
							} else {
								System.out.println("Username fail!");
							}
						} catch (NoSuchElementException e) {
							System.out.println("Nhập sai cú pháp, thiếu dữ liệu");
						}

						break;
					case "PASS":
						try {
							String pass = token.nextToken();
							if (file.checkPass(pass)) {
								System.out.println("Login thành công");
								isLogin = true;
							} else {
								System.out.println("Login thất bại");
							}
						} catch (NoSuchElementException e) {
							System.out.println("Nhập sai cú pháp, thiếu dữ liệu");
						}

					default:
						// System.out.println("Nhập ko đúng cú pháp");
						break;
					}
				} else {
					// ngược lại đã đăng nhập
					// thực hiện SEND, GET
					token = new StringTokenizer(line);
					String action = token.nextToken();
					String sf, df;
					switch (action) {
					case "SEND":
						// gửi từ client lên server
						// SEND source_file dest_file
						try {
							sf = token.nextToken();
							df = token.nextToken();
							// đọc file nguồn
							bis = new BufferedInputStream(new FileInputStream(sf));
							// tạo file đích
							file.createDest(df);
							// đọc file nguồn và ghi vào đích
							byte[] buff = new byte[1024 * 100];
							int data;
							while ((data = bis.read(buff)) != -1) {
								file.writeData(buff, data);
							}
							System.out.println("SEND thành công!");
							bis.close();
							file.closeData();

						} catch (NoSuchElementException e1) {
							System.out.println("Sai cú pháp");
						} catch (FileNotFoundException e2) {
							System.out.println("Không mở được file nguồn của Client!");
						}
						break;
					case "GET":
						// GET dest_file source_file
						try {
							// đầu tiên mở file nguồn phía server
							// đọc dữ liệu file nguồn Server
							sf = token.nextToken();
							df = token.nextToken();
							file.openSource(df);
							// đọc xong ghi ra file nguồn Client
							bos = new BufferedOutputStream(new FileOutputStream(df));
							byte[] arr;
							// đọc đến hết dữ liệu
							while ((arr = file.readData()) != null) {
								bos.write(arr, 0, arr.length);
							}
							System.out.println("GET dữ liệu thành công!");
							bos.close();
							file.closeSource(); // đóng file đích trên server
						} catch (NoSuchElementException e) {
							System.out.println("");
						}
						break;
					default:
						break;
					}
				}
			} catch (RemoteException e) {
				System.out.println(e.getMessage());
			}
		}
		userrIn.close();
	}

	public static void main(String[] args) throws NotBoundException, IOException {
		FileClient fc = new FileClient();
		fc.start();
	}
}
