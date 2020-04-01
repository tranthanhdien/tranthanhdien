package test;

import java.util.ArrayList;

import io.TextFileFactory;
import model.KhachHang;

public class TestKhachHang {
	public static void testLuuFile() {
		ArrayList<KhachHang> dsKH = new ArrayList<>();
		dsKH.add(new KhachHang("111", "Trần Thanh Điền"));
		dsKH.add(new KhachHang("222", "Võ Xuân Trường"));
		dsKH.add(new KhachHang("333", "Trần Văn Tí"));
		dsKH.add(new KhachHang("444", "Nguyễn Văn B"));
		dsKH.add(new KhachHang("555", "Ngyễn Văn A"));
		boolean result = TextFileFactory.luuFile(dsKH, "File");
		if (result==true) {
			System.out.println("Lưu file thành công");
		}
		else {
			System.out.println("Lưu file thất bại");
		}
		
	}
	public static void main(String[] args) {
		testLuuFile();
		ArrayList<KhachHang> dsKH = TextFileFactory.docFile("File");
		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã\tTên");
		for (KhachHang kh : dsKH) {
			System.out.println(kh);
		}
		
	}
}
