import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientComputing {
	static int PORT = 12345;
	static String host = "127.0.0.1";
	static BufferedReader userIn; // đọc từ người dùng
	
	public static void send() throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket(host, PORT);
		userIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter format number: a +-*/ b");
		String line = userIn.readLine();
		PrintWriter sendToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		sendToServer.println(line);
		System.out.println("SendToServer: " + sendToServer);
		BufferedReader readServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String lineServer = readServer.readLine();
			
		if (lineServer.equalsIgnoreCase("Exit")) {
			socket.close();
			return;
		} else {
			System.out.println();
			sendToServer.println(lineServer);
			
		}
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		send();
	}
	

}