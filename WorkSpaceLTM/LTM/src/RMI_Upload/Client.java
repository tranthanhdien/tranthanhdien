package RMI_Upload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 12345);
		IUpload upload = (IUpload) reg.lookup("upload");
		// tạo file nguồn
		File sf = new File("rmiupload/sourceFile.docx");
		if (!sf.exists()) {
			System.out.println("File not exits");
		} else {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sf));
			int id = upload.createFile("rmiupload/upload.docx");
			if (id == -1) {
				System.out.println("Server create new file not success");
			} else {
				byte[] arr = new byte[1024 * 100];
				long fileSize = sf.length();
				int byteRead, readSize;
				while (fileSize > 0) {
					readSize = (int) ((arr.length > fileSize) ? fileSize : arr.length);
					byteRead = bis.read(arr, 0, readSize);
					upload.writeData(id, arr, byteRead);
					fileSize -= byteRead;
				}
				bis.close();
				upload.closeFile(id);
				System.out.println("Success!");
			}

		}
	}

}
