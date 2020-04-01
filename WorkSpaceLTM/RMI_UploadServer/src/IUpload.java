import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUpload extends Remote {
	// upload từ client lên server
	// b1: tạo file đích
	public int createFile(String df) throws RemoteException;

	// b2: ghi dữ liệu ra file đích
	public void writeData(int id, byte[] arr, int length) throws RemoteException;

	// b3: đóng file đích lại
	public void closeFile(int id) throws RemoteException;

}
