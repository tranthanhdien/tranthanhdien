package modelCuHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class DanhSachCuaHangDAO {
	static ArrayList<CuaHang> listCH;

	public static ArrayList<CuaHang> getListCH(String area) {
		if (listCH == null) {
			listCH = new ArrayList<>();
		}

		if (listCH.size() == 0) {
			String sql = "select * from DanhSachCuaHang where tinh = ?";
			int i;
			try {
				// thiet lap ket noi
				Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pr = conn.prepareStatement(sql);
				pr.setString(1, area);
				ResultSet r = pr.executeQuery();
				while (r.next()) {
					listCH.add(new CuaHang(r.getInt(1), r.getString(2), r.getString(3)));
				}
			} catch (Exception e) {
			
			}
		}
		return listCH;
	}

}
