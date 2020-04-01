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
				// Xử lý ngoại lệ, trong trường hợp này là Connection có thể là null, hoặc câu
				// lệnh SQL không đúng
			}

		}
		/* Thêm các Product vào danh sách bằng cách nhập thủ công */
		return listUser;
	}

	// ********** Phan cho admin quan li
	// Khach hang chi thuc hien duoc sua thong tin thoi => k co xoa hay them
	public int dynamicIDCustomer() {

		return 0;
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

	public Customer lookUpID(int id) {
		Customer result = null;
		String sql = "select * from username where id = ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("phone"), rs.getString("address1"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}

		return result;
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
			// Xử lý ngoại lệ,

		}

		return result;
	}

//	// kt email da dk chua
//	public static Customer lookUpEmail(String email) {
//		Customer result = null;
//		String sql = "select * from username where email like ?";
//
//		try {
//			Connection conn = DatabaseConnection.getConnection();
//			PreparedStatement pr = conn.prepareStatement(sql);
//			pr.setString(1, email);
//			ResultSet rs = pr.executeQuery();
//			while (rs.next()) {
//				result =new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
//						rs.getString("phone"), rs.getString("address1"));
//			}
//			pr.close();
//			conn.close();
//		} catch (Exception e) {
//			// Xử lý ngoại lệ,
//
//		}
//
//		return result;
//	}

	

}
