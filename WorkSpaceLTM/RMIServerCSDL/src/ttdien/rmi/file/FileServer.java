package ttdien.rmi.file;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
	public static void main(String[] args) throws RemoteException {
		Registry re = LocateRegistry.createRegistry(1212);
		IFile file = (IFile) new FileImpl();
		re.rebind("test", file);
	}

}
