package lt.udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int port = 7;
		Student st;
		DatagramSocket socket = new DatagramSocket(port);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);

		ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
		ObjectInputStream ois = new ObjectInputStream(bais);
		st = (Student) ois.readObject();
		System.out.println(st);
		socket.close();
	}

}
