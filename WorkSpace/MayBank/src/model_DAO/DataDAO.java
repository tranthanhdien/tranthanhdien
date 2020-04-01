package model_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model_Connection.DatabaseConnection;

public class DataDAO {
	static ArrayList<Data> listData;

	public static ArrayList<Data> getListData() {
		if (listData == null) {
			listData = new ArrayList<>();
		}
		if (listData.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement state = conn.createStatement();
				String sql = "SELECT u.ID_User, inv.ID_Invoice, u.Username, u.Password, u.Address, u.Email, inv.Date_Invoice, inv.Amount FROM Users u JOIN Invoice inv on u.ID_User = inv.ID_User \r\n"
						+ "WHERE inv.ID_Invoice = '111'";
				ResultSet rs = state.executeQuery(sql);
				while (rs.next()) {
					listData.add(new Data(rs.getInt("ID_User"), rs.getInt("ID_Invoice"), rs.getString("Username"),
							rs.getString("Password"), rs.getString("Address"), rs.getString("Address"),
							rs.getString("Date_Invoice"), rs.getString("Amount")));
					
				}
				state.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listData;
	}
	public static void main(String[] args) {
		DataDAO.getListData();
	}

}
