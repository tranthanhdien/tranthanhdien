package RMI_TraCuuSV;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(12345);
		StudentImp student = new StudentImp();
		student.createList();
		reg.rebind(IStudent.class.getName(), student);
	// C2:	reg.rebind(IStudent.class.getName(), student);
	}

}
