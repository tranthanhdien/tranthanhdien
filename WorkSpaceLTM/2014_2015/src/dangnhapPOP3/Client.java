package dangnhapPOP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("localhost", 12345);
		System.out.println("Connected");
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		PrintWriter out = new PrintWriter(System.out);
		pw.println("Connected");
		String data;
		while (true) {
			data = in.readLine();
			pw.println(data);
			data = br.readLine();
			out.println(data);
		}
	}

}
