package RMI;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", Server.PORT);
		IDownload down = (IDownload) reg.lookup("download");
		// tạo file đích
		String destFile = "rmi/download.docx";
		File df = new File(destFile);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(df));
		// mở file nguồn
		int id = down.openFile("upload/BT.docx");
		if (id == -1) {
			System.out.println("Server open file not success");
		} else {
			byte[] arr;
			while ((arr = down.readData(id)) != null)
				bos.write(arr);
			bos.close();
			down.closeFile(id);
		}

		System.out.println("Done!");

	}

}
