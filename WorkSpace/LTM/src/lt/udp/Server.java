package lt.udp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
	final static int port = 666;

	public static void downFile() throws IOException {
		ServerSocket server = new ServerSocket(port);
		System.out.println("Start connection......");
		System.out.println("Waiting for connection....");
		java.net.Socket sc = server.accept();
		System.out.println("Accept connection.....");
		BufferedReader readUser = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		String alylineUser = readUser.readLine();
		String[] ifo = alylineUser.split(" ");

		String comm = ifo[0];
		String sourceFile = ifo[1];
		String destFile = ifo[2];
		//// read SourceFile
		BufferedReader readSource = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));

		PrintWriter sendClient = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFile)), true);
		String line = "";
		if (ifo.length == 3) {
			if (comm.equalsIgnoreCase("get")) {
				while ((line = readSource.readLine()) != null) {
					System.out.println(line);
					sendClient.write(line);
					sendClient.write('\n');
				}
			} else {
				System.out.println("incorrect format....");
			}
		} else {
			System.out.println("incorrect format....");
		}

		readUser.close();
		readSource.close();
		sendClient.close();
		sc.close();
		server.close();
		System.out.println("Done...");
	}
	public static void main(String[] args) throws IOException {
		downFile();
	}
}
