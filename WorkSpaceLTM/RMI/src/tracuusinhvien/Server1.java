package tracuusinhvien;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server1 {
	public Server1() throws RemoteException {
		Registry rg = LocateRegistry.createRegistry(12345);
		IStudent st = new StudentImpl();
		rg.rebind("st", st);
	}

	public static void main(String[] args) throws RemoteException {
		new Server1();
	}

}
