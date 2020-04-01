package De1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class FileServerProcess extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String serverDir;

	public FileServerProcess(Socket socket) throws IOException {
		this.socket = socket;
		dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

	}

	public void run() {
		try {
			String line;
			while (true) {
				try {
					// đọc lên từ Client
					line = dis.readUTF();
				
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
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void process(String line) throws IOException {
		StringTokenizer token = new StringTokenizer(line);
		String action = token.nextToken();
		String sf, df;
		switch (action) {
		case "SET_SERVER_DIR":
			// lệnh này phải được server xử lí
			dos.writeUTF(line);
			break;
//		case "SET_CLIENT_DIR":
//			serverDir = token.nextToken();
//			break;
		case "SEND":
			df = token.nextToken();
			receiveFile(df);
			break;
		case "GET":
			sf = token.nextToken();
			sendFile(sf);
			break;
		default:
			break;
		}
		dos.flush();
	}

	private void sendFile(String sf) throws IOException {
		File file = new File(serverDir + File.separator + sf);
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

	private void receiveFile(String df) throws IOException {
		File file = new File(serverDir + File.separator + df);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		long size = dis.readLong();
		int byteRead, byteMustRead;
		long remain = size;
		byte[] arr = new byte[1024*100];;
		while(remain>0) {
			byteMustRead = arr.length > remain ? (int)remain : arr.length;
			byteRead = dis.read(arr, 0, byteMustRead);
			bos.write(arr, 0, byteRead);
			remain-=byteRead;
		}
		bos.close();

	}
}