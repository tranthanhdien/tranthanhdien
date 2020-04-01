package De1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private BufferedReader userIn; // cái này để người dùng tương tác qua qua Consolve
	static final String HOST = "127.0.0.1";
	static final int PORT = 12345;
	private String clientDir;

	public Client() {
		clientDir = "C:\\source";

	}

	// mở kết nối bên client và tiến hành xử lí
	public void request() throws UnknownHostException, IOException {
		try {

			this.socket = new Socket(HOST, PORT);
			dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			userIn = new BufferedReader(new InputStreamReader(System.in)); // đọc client nhập vào
			String line;
			// vòng lặp vô tận để đọc từ consolve
			while (true) {
				try {
					// đọc lệnh từ người dùng
					line = userIn.readLine();
					// nếu là QUIT thì thoát khỏi vòng lặp
					if (line.equalsIgnoreCase("QUIT"))
						break;
					process(line);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			dis.close();
			dos.flush();
			dos.close();
			userIn.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void process(String line) throws IOException {
		while (true) {
			// đọc lệnh từ người dùng nhập
			line = userIn.readLine();
			StringTokenizer token = new StringTokenizer(line); // không để \t mặc định là 5 kí tự đăc biệt: \t \n \...
			String action = token.nextToken();
			String sf, df;
			switch (action) {
			case "SET_SERVER_DIR":
				// lệnh này phải được server xử lí
				dos.writeUTF(line);
				break;
			case "SET_CLIENT_DIR":
				clientDir = token.nextToken();
				break;
			case "SEND":
				// send từ file nguồn tới file đích
				// gửi lên server: SEND df
				sf = token.nextToken();
				df = token.nextToken();
				dos.writeUTF(action + " " + df);
				sendFile(sf);
				break;
			case "GET":
				// gửi lên server: GET sf
				sf = token.nextToken();
				df = token.nextToken();
				dos.writeUTF(action + " " + sf);
				receiveFile(df);
				break;
			case "QUIT":
				// lệnh này báo cho server biết kết thúc vòng lặp
				dos.writeUTF(line);
				break;
			}
		}

	}

	// lấy file
	private void receiveFile(String df) throws IOException {
		// hàm này ở phía server
		File file = new File(clientDir + File.separator + df);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		long size = dis.readLong();
		int byteRead, byteMustRead;
		long remain = size;
		byte[] arr = new byte[1024 * 100];
		;
		while (remain > 0) {
			byteMustRead = arr.length > remain ? (int) remain : arr.length;
			byteRead = dis.read(arr, 0, byteMustRead);
			bos.write(arr, 0, byteRead);
			remain -= byteRead;
		}
		bos.close();
	}

	// gửi file
	private void sendFile(String sf) throws IOException {
		File file = new File(clientDir + File.separator + sf);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		dos.writeLong(file.length());
		byte[] arr = new byte[1024 * 100];
		int data;
		while ((data = bis.read(arr)) != -1) {
			dos.write(arr, 0, data);
		}
		dos.flush();
		bis.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.request();
	}
}