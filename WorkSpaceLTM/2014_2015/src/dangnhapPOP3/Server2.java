package dangnhapPOP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Server2 {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	String user = "", pass = "";

	public Server2() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(1234);
		System.out.println("Waiting...");
		socket = ss.accept();
		System.out.println("Connected.");
		while (true) {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("Hãy đăng nhập, please!");
			process(br, pw);
			processLogin(br, pw);

			br.close();
			pw.close();
			socket.close();
		}
	}

	private void process(BufferedReader br, PrintWriter pw) throws IOException {
		String command;
		StringTokenizer token;
		String action, data;
		while (true) {
			command = br.readLine();
			token = new StringTokenizer(command);
			action = token.nextToken();
			if (action.equalsIgnoreCase("USER")) {
				data = token.nextToken();
				this.user = data;
				if (UserDAO.checkUserName(this.user)) {
					pw.println("OK");
				} else {
					pw.println("User không tồn tại");
				}
				continue;
			} else if (action.equalsIgnoreCase("PASS")) {
				data = token.nextToken();
				this.pass = data;
				if (UserDAO.checkUserPass(this.user, this.pass)) {
					pw.println("Đăng nhập thành công");
					return;
				} else {
					pw.println("Đăng nhập thất bại");
				}

			} else if (action.equalsIgnoreCase("EXIT")) {
				break;
			}

			else
				continue;
		}
	}

	private void processLogin(BufferedReader br, PrintWriter pw) throws IOException {
		String command;
		ArrayList<Student> list = null;
		while (true) {
			command = br.readLine();
			StringTokenizer token = new StringTokenizer(command, " ");
			String action = token.nextToken();
			if (action.equalsIgnoreCase("findByName")) {
				list = StudentDAO.findByName(token.nextToken());
			} else if (action.equalsIgnoreCase("findByAge")) {
				list = StudentDAO.findByAge(Integer.parseInt(token.nextToken()));
			} else if (action.equalsIgnoreCase("findByScore")) {
				list = StudentDAO.findByScore(Double.parseDouble(token.nextToken()));
			} else if (action.equalsIgnoreCase("exit"))
				break;
			pw.println(list.size());
			for (Student st : list) {
				pw.println(st.toString());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Server2();
	}
}
