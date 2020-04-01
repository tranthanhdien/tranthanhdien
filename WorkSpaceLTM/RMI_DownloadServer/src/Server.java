
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry re = LocateRegistry.createRegistry(12345);
		DownloadImpl down = new DownloadImpl();
		re.rebind("download", down);
	}

}
