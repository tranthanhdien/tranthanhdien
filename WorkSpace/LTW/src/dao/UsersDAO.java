package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.DatabaseConnection;
import javafx.scene.chart.PieChart.Data;
import model.Users;

public class UsersDAO {
	// kiểm tra email đã tồn tại chưa
	public static boolean checkEmail(String email) throws SQLException {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM Users WHERE user_email = '" + email + "'";
		PreparedStatement pr = conn.prepareStatement(sql);
		ResultSet rs = pr.executeQuery();
		while (rs.next()) { // trong khi có email tồn tại thì đóng kết nối
			conn.close();
			return true;
		}
		return false;
	}

	// thêm mới 1 user
	public static boolean addUser(Users user) {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "INSERT INTO Users VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setLong(1, user.getUserID());
			pr.setString(2, user.getUserEmail());
			pr.setString(3, user.getUserPass());
			pr.setBoolean(4, user.isUserRole());
			pr.executeQuery();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(UsersDAO.checkEmail("abc"));
	}

}
