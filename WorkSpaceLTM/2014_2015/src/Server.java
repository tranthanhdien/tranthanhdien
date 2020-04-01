import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Server {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;

	public Server() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("Wating...");
		socket = ss.accept();
		System.out.println("Connected");

		while (true) {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			process(br, pw);
			br.close();
			pw.close();
			socket.close();
		}

	}

	public void process(BufferedReader br, PrintWriter pw) throws IOException {
		String command;
		ArrayList<Student> list = null;
		while (true) {
			command = br.readLine();
			StringTokenizer token = new StringTokenizer(command, "\t");
			String request = token.nextToken();
			if (request.equalsIgnoreCase("findById")) {
				list = StudentDAO.findById(token.nextToken());
			} else if (request.equalsIgnoreCase("findByName")) {
				list = StudentDAO.findByName(token.nextToken());
			} else if (request.equalsIgnoreCase("findByAge")) {
				list = StudentDAO.findByAge(Integer.parseInt(token.nextToken()));
			} else if (request.equalsIgnoreCase("findByScore")) {
				list = StudentDAO.findByScore(Double.parseDouble(token.nextToken()));
			} else if (request.equalsIgnoreCase("exit")) {
				System.out.println("Lệnh không đúng, nhập lại");
				break;

			}
			pw.print(list.size());
			for (Student st : list) {
				pw.println(st.toString());
			}
		}

	}

	public static void main(String[] args) throws IOException {

		new Server();
	}

}
