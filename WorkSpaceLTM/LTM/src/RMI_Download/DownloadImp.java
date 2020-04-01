package RMI_Download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DownloadImp extends UnicastRemoteObject implements IDownload {
	List<BufferedInputStream> listOfFile = new ArrayList<>();

	protected DownloadImp() throws RemoteException {
		super();

	}

	@Override
	public int openFile(String sourceFile) throws RemoteException {
		try {
			listOfFile.add(new BufferedInputStream(new FileInputStream(new File(sourceFile))));
		} catch (FileNotFoundException e) {
			return -1;
		}
		return listOfFile.size() - 1;
	}

	@Override
	public byte[] readData(int id) throws RemoteException {
		BufferedInputStream bis = listOfFile.get(id);
		byte[] arr = new byte[1024 * 100];
		try {
			int size = bis.read(arr);
			if (size == -1)
				return null;
			byte[] data = new byte[size];
			System.arraycopy(arr, 0, data, 0, size);
			return data;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeFile(int id) throws RemoteException {
		try {
			listOfFile.get(id).close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}

	}

}
