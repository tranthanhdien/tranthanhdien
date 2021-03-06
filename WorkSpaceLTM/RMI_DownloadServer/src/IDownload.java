import java.rmi.RemoteException;

public interface IDownload {
	// download từ Server về Client
	// b1: mở source trên Server ra
	public int openFile(String sf) throws RemoteException;

	// b2: đọc dữ liệu file trên Server vừa mở, đọc bắt buộc trả về mảng byte
	public byte[] readData(int id) throws RemoteException;

	// b3: đóng dữ liệu
	public void closeFile(int id) throws RemoteException;

}
