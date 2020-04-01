import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DownloadImpl extends UnicastRemoteObject implements IDownload {
	List<BufferedInputStream> list = new ArrayList<>();

	protected DownloadImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int openFile(String sf) throws RemoteException {
		try {
			list.add(new BufferedInputStream(new FileInputStream(new File(sf))));

		} catch (Exception e) {
			return -1;
		}
		return list.size() - 1;

	}

	@Override
	public byte[] readData(int i) throws RemoteException {
		BufferedInputStream bis = new BufferedInputStream(list.get(i));
		try {
			byte[] arr = new byte[1024 * 100];
			int data;
			data = bis.read(arr);
			if (data == -1)
				return null;
			byte[] temp = new byte[data];
			System.arraycopy(arr, 0, temp, 0, data);
			return temp;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}

	}

	@Override
	public void closeFile(int id) throws RemoteException {
		try {
			list.get(id).close();
		} catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}

	}

}
