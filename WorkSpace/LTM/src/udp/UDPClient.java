package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	final static int port = 666;
	final static String host = "localhost";

	public static void send() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Typing:  findByName name ");
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName(host);
		byte[] sendData = new byte[1024 * 10];
		byte[] receiveData = new byte[1024 * 10];
		String line = input.readLine();
		sendData = line.getBytes();
		// send to Server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
		socket.send(sendPacket);
		// receive from Server
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		socket.send(receivePacket);

		String modified = new String(receiveData, 0, receivePacket.getLength());
		if (modified.equalsIgnoreCase("Exit")) {
			System.out.println("Close: " + socket);
			System.out.println("Goodbye");
			socket.close();
			return;
		} else if (modified.equalsIgnoreCase("Incorrect")) {
			System.out.println("From Server: " + modified);
		} else {
			System.out.println("From Server: " + modified);
		}
		socket.close();

	}

	public static void main(String[] args) throws IOException {
		send();
	}
}
