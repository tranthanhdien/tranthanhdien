package model_dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import modelConnection.DatabaseConnection;
import model_shoppingcart.Invoice;
import model_user.Customer;

public class ChartDAO {
	public Map<String, Invoice> thongKeThang(String text) {
		String year = text.substring(0, text.indexOf("-"));
		String month = text.substring(text.indexOf("-") + 1, text.length());
		
		Map<String, Invoice> map = new HashMap<>();
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement statement =  conn.createStatement();
			String sql = "SELECT * FROM Invoice WHERE YEAR(ngayHD) = ";
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				Integer id = result.getInt(1);
				String idUser = result.getString(2);
				Date date = result.getDate(3);
				String totalAmout = result.getString(4);
				Boolean isProcess = result.getBoolean(5);
				map.put(id + "", new Invoice(id, new Customer(), date, totalAmout, isProcess));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi thống kê theo tháng");
		}
		return map;
		
	}

}
