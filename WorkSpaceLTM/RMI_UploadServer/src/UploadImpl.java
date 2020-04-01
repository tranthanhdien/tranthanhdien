
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class UploadImpl extends UnicastRemoteObject implements IUpload {
	List<BufferedOutputStream> list = new ArrayList<>();

	protected UploadImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int createFile(String df) throws RemoteException {
		try {
			list.add(new BufferedOutputStream(new FileOutputStream(new File(df))));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		return list.size() - 1;
	}

	@Override
	public void writeData(int id, byte[] arr, int length) throws RemoteException {
		try {
			BufferedOutputStream bos = list.get(id);
			if (arr != null) {
				bos.write(arr, 0, length);
			}
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
