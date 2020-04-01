package ttd.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFile extends Remote {
	boolean checkName(String name) throws RemoteException; // kiểm tra tên có tồn tại k
	boolean checkPass(String pass) throws RemoteException;
	// SEND(từ Client lên Server)
	void createDest(String destFile) throws RemoteException; // tạo file đích
	void writeData(byte[] arr, int len) throws RemoteException;
	void closeData() throws RemoteException;
	// GET(lấy dữ liệu từ Server về Client)
	void openSource(String sf) throws RemoteException;
	byte[] readData() throws RemoteException;
	void closeSource() throws RemoteException;
}