package RMI_Download_C2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DownloadImpl extends UnicastRemoteObject implements IDownload {
	private static final long serialVersionUID = 1L;
	BufferedInputStream bis;

	protected DownloadImpl() throws RemoteException {
		super();

	}

	@Override
	public void openSource(String sf) throws RemoteException {
		try {
			bis = new BufferedInputStream(new FileInputStream(sf));
		} catch (FileNotFoundException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public byte[] readData() throws RemoteException {
		byte[] data = new byte[1024 * 100];
		int count;
		try {
			count = bis.read(data);
			if (count == -1)
				return null;
			byte[] tmp = new byte[count];
			System.arraycopy(data, 0, tmp, 0, count);
			return tmp;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public void closeFile() throws RemoteException {
		try {
			bis.close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

}
