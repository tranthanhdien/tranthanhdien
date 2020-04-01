package RMI_Download_C2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI_Download_C2.IDownload;

public class Client {
	public static void download(String sf, String df) throws IOException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 12345);
		IDownload download = (IDownload) reg.lookup("download");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(df));
		download.openSource(sf);
		byte[] data;
		while ((data = download.readData()) != null) {
			dos.write(data);
		}
		download.closeFile();
		dos.close();
	}

	public static void main(String[] args) throws IOException, NotBoundException, RemoteException {
		String sf = "rmidownload/download.docx";
		String df = "rmidownload/download.docx";
		download(sf, df);

	}

}
