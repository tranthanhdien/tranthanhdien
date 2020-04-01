package RMI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static final int PORT = 12345;

	public static void main(String[] args) throws RemoteException, IOException {
		Registry reg = LocateRegistry.createRegistry(PORT);
		IDownload down = new DownloadIml();
		reg.rebind("download", down);
	}

}
