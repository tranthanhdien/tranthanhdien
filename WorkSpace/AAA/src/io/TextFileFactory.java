package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import model.KhachHang;

public class TextFileFactory {
	public static boolean luuFile(ArrayList<KhachHang> dsKhachHang, String path) {//lưu ds vào đường path
		// lưu có nghĩa là xuất là khỏi bộ nhớ(Output từ trong ra ngoài)
		try {
			FileOutputStream fos = new FileOutputStream(path);//tạo ra file để xuất ra ổ cứng, path có nghĩa là lưu vào đâu trong ổ cứng
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//lưu file đó dưới dạng UTF-8
			BufferedWriter bw = new BufferedWriter(osw);//đưa vào bộ đệm để lưu
			//bây giờ ghi từng dòng nó ra
			for (KhachHang kh : dsKhachHang) {
				String line = kh.getMa()+"\t"+kh.getTen();//từng dòng
				bw.write(line);//ghi
				bw.newLine();//xuống dòng để lưu dòng kế tiếp
			}
			bw.close();//kết thúc đóng file đó và lưu phải đó lại, k làm nữa
			osw.close();
			fos.close();
			return true;
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;//nếu ko thành công thì sẽ return về false;
	}
	public static ArrayList<KhachHang> docFile(String path) {//đọc từ đường path
		ArrayList<KhachHang> dsKH = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);//file cần đọc
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);//bộ đệm để đọc
			String line = br.readLine();//lấy dữ liệu về đọc từng dòng
			while (line!=null) {//trong khi dòng đó không rỗng
				String[] arr = line.split("\t");// cắt nhau bởi nhau tách
				if (arr.length==2) {// mã và tên
					KhachHang kh = new KhachHang(arr[0], arr[1]);
					dsKH.add(kh);
				}
				line = br.readLine();//đọc xong 1 dòng sẽ xuống dòng tiếp theo
			}
			br.close();//làm xong đóng lại
			isr.close();
			fis.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dsKH;
		
	}

}
