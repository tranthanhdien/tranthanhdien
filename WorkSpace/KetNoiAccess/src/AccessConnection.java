import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnection {
	public static void main(String[] args) {
		try {
			String databasePath = "C:\\Users\\welcome\\workspace\\KetNoiAccess\\CoSoDuLieuMau.accdb";
			String strConnection = "jdbc:ucanaccess://" + databasePath;
			Connection conn = DriverManager.getConnection(strConnection);
			if (conn != null) {
				System.out.println("Kết nối tới CSDL CoSoDuLieuMau.accdb thành công");
			} else {
				System.out.println("Kết nối thât bại");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
