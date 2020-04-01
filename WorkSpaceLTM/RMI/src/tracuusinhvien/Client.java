package tracuusinhvien;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {
	public Client() throws RemoteException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry(12345);
		IStudent st = (IStudent) rg.lookup("st");
		System.out.println("Mời bạn nhập lệnh");
		System.out.println("findByName");
		System.out.println("findById");
		System.out.println("findByAge");
		System.out.println("findByScore");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<Student> list;
		while (true) {
			String command = sc.nextLine();
			StringTokenizer token = new StringTokenizer(command, "[\t]");
			String request = token.nextToken();
			switch (request) {
			case "findById":
				list = st.findById(token.nextToken());
				print(list);
				break;
			case "findByName":
				list = st.findByName(token.nextToken());
				print(list);
				break;
			case "findByAge":
				list = st.findByAge(Integer.parseInt(token.nextToken()));
				print(list);
				break;
			case "findByScore":
				list = st.findByScore(Double.parseDouble(token.nextToken()));
				print(list);
				break;
			default:
				System.out.println("Nhập lệnh sai, nhập lại đi!");
				break;
			}
		}
	}

	public void print(List<Student> list) {
		for (Student st : list) {
			System.out.println(st);
		}
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		new Client();
	}

}
