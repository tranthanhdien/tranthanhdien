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
	public Login lookUpEmail(String email) {
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

	// them, xoa, sua voi database
	public boolean edit(int id, String username, String pass) {
		String sql = "update userpass set username=?, pass=? where idUser=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, username);
			pr.setString(2, pass);
			pr.setInt(3, id);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

	public boolean edit2(int id, String username, String pass, boolean admin) {
		String sql = "update userpass set username=?, pass=?, hasadmin=? where idUser=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, username);
			pr.setString(2, pass);
			pr.setBoolean(3, admin);
			pr.setInt(4, id);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

	public Login lookUpID(int id) {
		Login result = null;
		String sql = "select * from userpass where idUser = ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
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

		Login l = list.get(list.size() - 1);
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

	// them, xoa, sua voi database
	public boolean addUser2(int id, String email, String pass, boolean admin) {
		String sql = "insert into userpass values(?,?,?,?);";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, email);
			pr.setString(3, pass);
			pr.setBoolean(4, admin);

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

	public boolean findAdminMain(String email) {
		Login result = null;
		// username = email
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

		if (result == null) {
			return false;

		} else {
			return true;
		}
	}

	// kiem tra 1 user co la admin khong dua vao
	public boolean findAdminByIDLogin(int id) {
		Login result = null;
		String sql = "select * from userpass where hasadmin=1 and idUser=?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
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
		if (result == null) {
			return false;
		} else {

			return true;
		}

	}

	// kiem tra cai userpass hien thoi co quyen truy cap vao khong
	public boolean checkConnectionToAdmin(int idUser) {
		String result = null;
		String sql = "select * from userpass where idUser = ? and hasadmin=1";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idUser);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				rs.getInt("id");
				result = rs.getString("username");
				rs.getString("fullname");
				rs.getString("phone");
				rs.getString("address1");
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		if (result != null) {
			return true;
		} else {
			return false;
		}

	}

	// cho nay chi hien thuc phuong thuc: edit=> user cap nhat mat khau hay email

	// xoa 1 tai khoan dang nhap
	// xoa User trong database
	public boolean remove(int id) {
		String sql = "delete from userpass where idUser=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			i = pr.executeUpdate();

			pr.close();
			conn.close();

		} catch (Exception e) {
			return false;
		}

		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	// dem so luong tai khoan da dang ki
	public int countUser() {
		int result = 0;
		String sql = "SELECT COUNT(*) as number FROM userpass ";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = rs.getInt("number");
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return result;

	}

}
