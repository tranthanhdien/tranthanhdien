package model_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class LoginDAO {
	// lay danh sach khach hang da dang ki
	ArrayList<Login> listLogin;

	// danh sach tat ca san pham
	public ArrayList<Login> getListLogin() {
		if (listLogin == null) {
			listLogin = new ArrayList<>();
		}
		if (listLogin.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from userpass";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					listLogin.add(new Login(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
							rs.getBoolean("hasadmin")));

				}
				stmt.close();
				conn.close();

			} catch (Exception e) {

			}

		}
		return listLogin;
	}

	// kt email da dk chua
	public static Login lookUpEmail(String email) {
		Login result = null;
		String sql = "select * from userpass where username like ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = new Login(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("hasadmin"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}

		return result;
	}

	public static int dynamicID(ArrayList<Login> list) {
//		// tim max(id) + 1
//		String sql = "select * from userpass where idUser= (SELECT MAX(idUser) FROM userpass)";
//		int preID = 0;
//		try {
//			Connection conn = DatabaseConnection.getConnection();
//			PreparedStatement pr = conn.prepareStatement(sql);
//			ResultSet rs = pr.executeQuery();
//			pr.close();
//			while (rs.next()) {
//				preID = rs.getInt("idUser");
//				rs.getString("username");
//				rs.getString("pass");
//				rs.getBoolean("hasadmin");
//
//			}
//
//		} catch (Exception e) {
//
//		}
		
		Login l = list.get(list.size()-1);
		int pre = l.getIdUser();
		return pre + 1;

	}

	// them, xoa, sua voi database
	public boolean addUser(int id, String email, String pass) {
		String sql = "insert into userpass values(?,?,?,?);";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, email);
			pr.setString(3, pass);
			pr.setBoolean(4, false);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	// tim admin
	public Login findAdmin(String email) {
		Login result = null;
		String sql = "select * from userpass where hasadmin=1 and username like ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = new Login(rs.getInt("idUser"), rs.getString("username"), rs.getString("pass"),
						rs.getBoolean("hasadmin"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}

		return result;
	}

	// cho nay chi hien thuc phuong thuc: edit=> user cap nhat mat khau hay email
}
