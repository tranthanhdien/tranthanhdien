package RMI;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DownloadIml extends UnicastRemoteObject implements IDownload {
	List<BufferedInputStream> listOfFile = new ArrayList<>();

	protected DownloadIml() throws RemoteException {
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
	public byte[] readData(int ssID) throws RemoteException {
		BufferedInputStream bis = listOfFile.get(ssID);
		byte[] arr = new byte[1024 * 100];
		try {
			int size = bis.read(arr);
			if (size == -1)
				return null;
			byte[] data = new byte[size];
			System.arraycopy(arr, 0, data, 0, size);
			return data;
		} catch (IOException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeFile(int ssID) throws RemoteException {
		try {
			listOfFile.get(ssID).close();
		} catch (IOException e) {
			throw new RemoteException(e.getMessage());
		}
	}

}
