package lt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	DataInputStream dis;
	DataOutputStream dos;

	public Server() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Waiting...");
		Socket socket = server.accept();
		System.out.println("Connected");
		

	}

	public static void main(String[] args) throws IOException {
		new Server();
	}
}
