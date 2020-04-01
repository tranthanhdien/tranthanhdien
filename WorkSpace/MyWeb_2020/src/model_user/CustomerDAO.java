package model_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class CustomerDAO {
	// lay danh sach khach hang da dang ki
	static ArrayList<Customer> listUser;

	// danh sach tat ca san pham
	public ArrayList<Customer> getListCustomer() {
		if (listUser == null) {
			listUser = new ArrayList<>();
		}
		if (listUser.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from userInfo";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					listUser.add(new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
							rs.getString("phone"), rs.getString("address1")));
				}
				stmt.close();
				conn.close();

			} catch (Exception e) {
				// Xá»­ lÃ½ ngoáº¡i lá»‡, trong trÆ°á»�ng há»£p nÃ y lÃ  Connection cÃ³ thá»ƒ
				// lÃ  null, hoáº·c cÃ¢u
				// lá»‡nh SQL khÃ´ng Ä‘Ãºng
			}

		}
		/* ThÃªm cÃ¡c Product vÃ o danh sÃ¡ch báº±ng cÃ¡ch nháº­p thá»§ cÃ´ng */
		return listUser;
	}

	public ArrayList<Customer> getListCustomer2() {

		ArrayList<Customer> listUser = new ArrayList<>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "Select * from userInfo";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listUser.add(new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("phone"), rs.getString("address1")));
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// Xá»­ lÃ½ ngoáº¡i lá»‡, trong trÆ°á»�ng há»£p nÃ y lÃ  Connection cÃ³ thá»ƒ
			// lÃ  null, hoáº·c cÃ¢u
			// lá»‡nh SQL khÃ´ng Ä‘Ãºng
		}

		/* ThÃªm cÃ¡c Product vÃ o danh sÃ¡ch báº±ng cÃ¡ch nháº­p thá»§ cÃ´ng */
		return listUser;
	}

	// ********** Phan cho admin quan li
	// Khach hang chi thuc hien duoc sua thong tin thoi => k co xoa hay them
	public int dynamicIDCustomer() {
		int result = -1;
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from userpass where idUser=(select MAX(idUser) from userpass)";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt("idUser");
				rs.getString("username");
				rs.getString("pass");
				rs.getBoolean("hasadmin");
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {

		}

		return result + 1;
	}

	// them, xoa, sua voi database
	public boolean add(int id, String userName, String fullName, String phone, String address) {
		String sql = "insert into userInfo values(?,?,?,?,?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, userName);
			pr.setString(3, fullName);
			pr.setString(4, phone);
			pr.setString(5, address);
			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

	// xoa User trong database
	public boolean remove(int id) {
		String sql = "delete from userInfo where id=?";
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

	// them, xoa, sua voi database
	public boolean edit(int id, String username, String fullname, String phone, String address) {
		String sql = "update userInfo set ID=?, username=?, fullname=?, phone=?, address1=? where ID=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, username);
			pr.setString(3, fullname);
			pr.setString(4, phone);
			pr.setString(5, address);
			pr.setInt(6, id);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

	// dua vao id de truy xuat User tu table UserInfo
	public Customer mappingUserInfo(int idUser) {
		Customer result = null;
		String sql = "select * from userInfo where id = ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idUser);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("phone"), rs.getString("address1"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			return null;

		}

		return result;
	}

	// dua vao id de truy xuat User tu table UserInfo
	// neu khong viet cai nay thi hong truy xuat duoc
	public String mappingUserName(int id) {
		String result = "new user";
		String sql = "select * from userInfo where id = ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
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
			return null;

		}

		return result;
	}

	// lay day du danh sach khach hang
	public ArrayList<User> getListUser() {
		ArrayList<User> listUser = new ArrayList<>();
		String sql = "SELECT userpass.idUser, userpass.username as email, userpass.pass, userpass.hasadmin, userInfo.* FROM userpass LEFT JOIN userInfo on userInfo.id=userpass.idUser";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Login l = new Login(rs.getInt("idUser"), rs.getString("email"), rs.getString("pass"),
						rs.getBoolean("hasadmin"));
				Customer c = new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("phone"), rs.getString("address1"));
				listUser.add(new User(c, l));

			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			return null;

		}

		return listUser;
	}

}
