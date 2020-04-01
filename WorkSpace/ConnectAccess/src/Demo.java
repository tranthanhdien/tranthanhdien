import java.sql.Connection;
import java.sql.DriverManager;

public class Demo {
	public static void main(String[] args) {
		try {
			String path = "csdl/SinhVien.accdb";
			// String path = "E:\\WorkSpace\\ConnectAccess\\csdl\\SinhVien.accdb";
			String strConn = "jdbc:ucanaccess://" + path;
			Connection conn = DriverManager.getConnection(strConn);
			if (conn != null) {
				System.out.println("Kết nối thành công");
			} else {
				System.out.println("Kết nối thất bại");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
