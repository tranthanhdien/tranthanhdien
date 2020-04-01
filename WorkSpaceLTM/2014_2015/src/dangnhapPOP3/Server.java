package dangnhapPOP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {
	// Server đợi kết nối từ Client qua Socket
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	String userName = "", userPass = "";

	public Server() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("Waiting...");
		// Socket đợi Client kết nối tới Server
		socket = ss.accept();
		// sau khi kết nối xong thì đọc dữ liệu từ Client
		// lấy dữ liệu từ Client gửi lên
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream(), true);
		System.out.println(br.readLine());
		pw.println("Mời bạn đăng nhập");
		processLogin(br, pw);
	}

	public void processLogin(BufferedReader br, PrintWriter pw) throws IOException {
		String command, action, data;
		StringTokenizer token;
		while (true) {
			command = br.readLine();
			token = new StringTokenizer(command, "\t");
			action = token.nextToken();
			if (action.equalsIgnoreCase("user")) {
				data = token.nextToken();
				if (UserDAO.checkUserName(data)) {
					pw.println("Username OK!");
				} else {
					pw.println("Username fail!");
				}
				this.userName = data;
			}
			if (action.equalsIgnoreCase("pass")) {
				data = token.nextToken();
				if (UserDAO.checkUserPass(this.userName, data)) {
					pw.println("Login success!");
				} else {
					pw.println("Login fail!");
				}
				this.userPass = data;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Server();
	}

}
