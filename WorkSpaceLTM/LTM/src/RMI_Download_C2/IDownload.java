package RMI_Download_C2;

import java.rmi.RemoteException;

public interface IDownload {
	public void openSource(String sf) throws RemoteException;

	public byte[] readData() throws RemoteException;

	public void closeFile() throws RemoteException;
}
