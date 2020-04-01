package model_user;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;
import tools.SendMail;

public class CustomerDAO {
	// lay danh sach khach hang da dang ki
	private static ArrayList<Customer> listUser;

	// danh sach tat ca san pham
	public static ArrayList<Customer> getListCustomer() {

		if (listUser == null) {
			listUser = new ArrayList<>();
		}

		if (listUser.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from username";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					// add User vao ArrayList
					listUser.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

				}
				stmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		/* ThÃªm cÃ¡c Product vÃ o danh sÃ¡ch báº±ng cÃ¡ch nháº­p thá»§ cÃ´ng */
		return listUser;
	}

	// thao tac voi database
	// cap phat ID tu dong
	public static int dynamicIDCustomer() {
		Customer c = listUser.get(listUser.size() - 1);
		int idPre = c.getId();

		return idPre + 1;
	}

	// them, xoa, sua voi database
	public static boolean addCustomerOnDatabase(int id, String user, String email, String pass) {
		String sql = "insert into username values(?,?,?,?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, dynamicIDCustomer());
			pr.setString(2, user);
			pr.setString(3, email);
			pr.setString(4, pass);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}

		if (i > 0)
			return true;

		return false;

	}

	// kt email da dk chua
	public static Customer lookUpEmail(String email) {
		Customer result = null;
		String sql = "select * from username where email like ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				result = new Customer(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("pass"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xá»­ lÃ½ ngoáº¡i lá»‡,

		}

		return result;
	}

	public static boolean forgotPass(String email) {

		String sql = "SELECT pass FROM userpass where username like ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String result = rs.getString("pass");
				SendMail.sendMail(email, "Change Passwword", "Mật khẩu của bạn là: " + result);
				return true;

			}
			pr.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
