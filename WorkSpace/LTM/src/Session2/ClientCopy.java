package Session2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class ClientCopy {
	final static int port = 666;
	final static String host = "127.0.0.1";

	public static void sendRequestCopy() throws IOException {
		java.net.Socket scClient = new java.net.Socket(host, port);
		System.out.println("Send request connection to Server");
		BufferedReader brIN = new BufferedReader(new InputStreamReader(new FileInputStream("file/stcopy.txt")));
		PrintWriter prOUT = new PrintWriter(new OutputStreamWriter(scClient.getOutputStream()), true);
		String line = "";
		while ((line = brIN.readLine()) != null) {
			prOUT.println(line);
		}
		scClient.close();
		brIN.close();
		prOUT.close();
	}

	public static void sendRequestUpload() throws IOException {
		java.net.Socket scClient = new java.net.Socket(host, port);
		System.out.println("Send request connection to Server");
		BufferedReader userInfo = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("copy source_file dest_file");
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
	//	sendRequestCopy();
		sendRequestUpload();
	}

}
