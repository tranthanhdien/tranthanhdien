package RMI_Upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class UploadImp extends UnicastRemoteObject implements IUpload {
	List<BufferedOutputStream> listOfFile = new ArrayList<>();

	protected UploadImp() throws RemoteException {
		super();

	}

	@Override
	public int createFile(String name) throws RemoteException {
		try {
			listOfFile.add(new BufferedOutputStream(new FileOutputStream(new File(name))));
		} catch (Exception e) {
			return -1;
		}
		return listOfFile.size() - 1;
	}

	@Override
	public void writeData(int id, byte[] arr, int byteRead) throws RemoteException {
		try {
			BufferedOutputStream bos = listOfFile.get(id);
			if (arr != null) {
				bos.write(arr, 0, byteRead);
			}
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
