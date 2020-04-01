package RMI_Download_C2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(12345);
		DownloadImpl download = new DownloadImpl();
		reg.rebind("download", download);
	}

}
