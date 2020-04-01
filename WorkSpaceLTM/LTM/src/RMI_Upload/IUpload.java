package RMI_Upload;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUpload extends Remote{
	public int createFile(String name) throws RemoteException;

	public void writeData(int id, byte[] arr,int byteRead) throws RemoteException;

	public void closeFile(int id) throws RemoteException;
}
