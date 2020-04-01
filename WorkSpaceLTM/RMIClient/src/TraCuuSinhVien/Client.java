package TraCuuSinhVien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 12345);
		// IStudent student = (IStudent) reg.lookup("tracuu");
		IStudent student = (IStudent) reg.lookup(IStudent.class.getName());

		// truy cap dichh vu remote
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("findByName nameFind");
		String line = input.readLine();
		String[] info = line.split(" ");
		String comm = info[0];
		String result = "";
		if (comm.length() == 1) {
			if (comm.equalsIgnoreCase("findList")) {
				result = student.findList();
				System.out.println(result);
			}
		} else if (info.length == 2) {
			String find = info[1];
			if (comm.equalsIgnoreCase("findByName")) {
				result = student.findByName(find);
				;
				System.out.println(result);
			}
		}
	}

}
