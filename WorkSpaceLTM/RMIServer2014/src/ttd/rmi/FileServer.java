package ttd.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
	public static void main(String[] args) throws RemoteException {
		FileImpl imp = new FileImpl();
		Registry re = LocateRegistry.createRegistry(12345);
		re.rebind("test", imp);
		
	}

}
