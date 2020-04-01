package tracuusinhvien;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server {
	public Server() throws RemoteException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<Student> list;
		StudentImpl stIml = new StudentImpl();
		while (true) {

			String command = sc.nextLine();// người dùng nhập lệnh
			StringTokenizer token = new StringTokenizer(command, "/t");
			String request = token.nextToken();
			switch (request) {
			case "findById":
				list = stIml.findById(token.nextToken());
				for (Student st : list) {
					System.out.println(st);
				}
				break;
			case "findByName":
				list = stIml.findByName(token.nextToken());
				for (Student st : list) {
					System.out.println(st);
				}
				break;
			case "findByAge":
				list = stIml.findByAge(Integer.parseInt(token.nextToken()));
				for (Student st : list) {
					System.out.println(st);
				}
				break;
			case "findByScore":
				list = stIml.findByScore(Double.parseDouble(token.nextToken()));
				for (Student st : list) {
					System.out.println(st);
				}
				break;
			default:
				System.out.println("Lệnh sai, vui lòng nhập lại");
				break;
			}
		}
	}

	public static void main(String[] args) throws RemoteException {
		new Server();
	}

}
