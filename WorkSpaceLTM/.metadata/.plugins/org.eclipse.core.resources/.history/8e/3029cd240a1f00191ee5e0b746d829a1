
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 12345);
		IDownload idown = (IDownload) reg.lookup("download");
		// tạo file đích để down về
		String destFile = "rmi/download.docx";
		File df = new File(destFile);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(df));
		int id = idown.openFile("rmi/upload.docx");
		if (id == -1) {
			System.out.println("Server open file not success");
		} else {
			byte[] arr;
			while ((arr = idown.readData(id)) != null)
				bos.write(arr);
			bos.close();
			idown.closeFile(id);
		}
		System.out.println("Done!");

	}

}
