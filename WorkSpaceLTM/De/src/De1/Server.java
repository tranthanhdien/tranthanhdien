package De1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket server;
	static final int PORT = 12345;
	public Server() {
		
	}
	public void start() throws IOException {
		try {
			server = new ServerSocket(PORT);
			System.out.println("Waiting...");
			while (true) {
				Socket socket = server.accept();
				System.out.println("Connected");
				FileServerProcess fsp = new FileServerProcess(socket);
				fsp.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start();
	}

}
