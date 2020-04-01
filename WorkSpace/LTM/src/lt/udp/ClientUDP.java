package lt.udp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {
	public static void main(String[] args) throws IOException {
		int port = 7;
		Student st = new Student(16130326, "Trần Thanh Điền", 9.5);
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket(new byte[0], 0);
		packet.setAddress(InetAddress.getByName("127.0.0.1"));
		packet.setPort(port);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(st);
		oos.flush();
		byte[] buf = baos.toByteArray();
		packet.setData(buf);
		packet.setLength(buf.length);
		socket.send(packet);
		socket.close();
	}

}
