package RMI_Upload;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(12345);
		IUpload upload = new UploadImp();
		reg.rebind("upload", upload);
	}

}
