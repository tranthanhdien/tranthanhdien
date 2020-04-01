package lt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {
	final static int port = 666;
	final static String host = "127.0.0.1";
	public static void sendRequestDown() throws IOException {
		java.net.Socket scClient = new java.net.Socket(host, port);
		System.out.println("Send request connection to Server");
		BufferedReader userInfo = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("get source_file dest_file");
		String readUser = userInfo.readLine();
		PrintWriter sendtoServer = new PrintWriter(scClient.getOutputStream(), true);
		sendtoServer.println(readUser);
		BufferedReader receive = new BufferedReader(new InputStreamReader(scClient.getInputStream()));
		String line = "";
		while ((line = receive.readLine()) != null) {
			sendtoServer.println(line);
		}
		scClient.close();
		userInfo.close();
		receive.close();
	}
	public static void main(String[] args) throws IOException {
		sendRequestDown();
	}
}
