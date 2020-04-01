package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.BreakIterator;
import java.util.ArrayList;

public class UDPServer extends Thread {
	final static int port = 666;
	static ArrayList<Student> listStudents = new ArrayList<Student>();
	DatagramSocket socket;

	public UDPServer(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			byte[] sendData = new byte[1024 * 100];
			byte[] receiveData = new byte[1024 * 100];
			while (true) {
				// receive from client
				DatagramPacket recPacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(recPacket);
				String recSentence = new String(receiveData, 0, recPacket.getLength());
				System.out.println("Received: " + recSentence);
				InetAddress address = recPacket.getAddress();
				int port = recPacket.getPort();
				String[] buff = recSentence.split(" ");
				String result = "";
				String comm = buff[0];
				while (buff != null) {
					if (buff.length == 1) {
						if (comm.equalsIgnoreCase("findList")) {
							result = findList();
						} else if (comm.equalsIgnoreCase("Exit")) {
							System.out.println("Goodbye!");
							result = comm;
							sendData = result.getBytes();
							DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
							socket.send(sendPacket);
							socket.close();
							return;
						} else if (buff.length == 2) {
							String agr = buff[1];
							if (comm.equalsIgnoreCase("findByName")) {
								result = findByName(agr);
							} else if (comm.equalsIgnoreCase("findByAge")) {
								result = findByAge(Integer.parseInt(agr));
							} else if (comm.equalsIgnoreCase("findByUnderAge")) {
								result = findByUnderAge(Integer.parseInt(agr));
							} else if (comm.equalsIgnoreCase("findByUpperAge")) {
								result = findByUpperAge(Integer.parseInt(agr));
							} else if (comm.equalsIgnoreCase("findByScore")) {
								result = findByScore(Integer.parseInt(agr));
							} else if (comm.equalsIgnoreCase("findByUnderScore")) {
								result = findByUnderScore(Double.parseDouble(agr));
							} else if (comm.equalsIgnoreCase("findByUpperAge")) {
								result = findByUpperAge(Integer.parseInt(agr));
							}
						} else {
							result = "Incorrect";
							System.out.println(result);
							sendData = result.getBytes();
							DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
							socket.send(sendPacket);
						}

					} else {
						result = "Incorrect";
						System.out.println(result);
						sendData = result.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
						socket.send(sendPacket);
					}
					System.out.println("Result: " + result);
					sendData = result.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
					socket.send(sendPacket);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Student> listStudent() {
		listStudents.add(new Student("Nguyen Van A", 20, 9));
		listStudents.add(new Student("Nguyen Van B", 21, 8));
		listStudents.add(new Student("Nguyen Van F", 25, 9));
		listStudents.add(new Student("Nguyen Van E", 19, 10));
		listStudents.add(new Student("Nguyen Van D", 23, 8));
		listStudents.add(new Student("Nguyen Van C", 18, 10));
		return listStudents;

	}

	public String findList() {
		String result = "";
		for (Student st : listStudents) {
			result += st.getName() + "\t" + st.getAge() + "\t" + st.getScore() + "\n";
		}
		return result;
	}

	public static String findByName(String name) {
		String result = "";
		for (Student s : listStudent()) {
			if (s.getName().equalsIgnoreCase(name)) {
				result += s + "\n";

			}
		}
		return result;
	}

	public static String findByAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == age) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUpperAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= age) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUnderAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= age) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUpperScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUnderScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static void main(String[] args) throws SocketException {
		listStudent();
		for (Student st : listStudents) {
			System.out.println(st);
		}
		System.out.println("Ready connection");
		DatagramSocket serverSocket = null;
		serverSocket = new DatagramSocket(port);
		UDPServer udp = new UDPServer(serverSocket);
		udp.start();
	}
}
