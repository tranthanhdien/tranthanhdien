package lt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientComputing {
	final static int port = 555;
	final static String host = "127.0.0.1";

	public static void sendComputing() throws UnknownHostException, IOException {
		//b1: thiết lạp kết nối
		while(true) {
		Socket sClient = new Socket(host, port);
		BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter format number: a +-*/ b" );
		String lineUser = inputUser.readLine(); // dùng cái này để gửi đi
		PrintWriter sendToServer = new PrintWriter(new OutputStreamWriter(sClient.getOutputStream()), true);
		sendToServer.print(lineUser);
		System.out.println("SenServer: " + lineUser);
		BufferedReader readServer = new BufferedReader(new InputStreamReader(sClient.getInputStream()));
		String lineServer = readServer.readLine();
		if (lineServer.equalsIgnoreCase("Exit")) {
			System.out.println("Goodbye^^");
			sClient.close();
			return;
		} else if (lineServer.equalsIgnoreCase("Incorrect NumberFormat")) {
			System.out.println("Incorrect NumberFormat");
		} else {
			System.out.println();
			sendToServer.println(lineServer);
			break;
		}
		
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		sendComputing();
	}

}
