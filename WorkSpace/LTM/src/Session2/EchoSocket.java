package Session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoSocket {
	public static void main(String[] args) {
		int port = 7;
		try {
			ServerSocket server = new ServerSocket(port);
			Socket socket = server.accept();
			BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);
			netOut.println("Welcome...");
			String line;
			while ((line = netIn.readLine()) != null) {
				line = "Echo: " + line;
				netOut.println(line);
			}
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
