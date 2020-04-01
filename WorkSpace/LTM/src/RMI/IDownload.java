package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDownload extends Remote {
	public int openFile(String sourceFile) throws RemoteException;

	public byte[] readData(int id) throws RemoteException;

	public void closeFile(int id) throws RemoteException;
}
