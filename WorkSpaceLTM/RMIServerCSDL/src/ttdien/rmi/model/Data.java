package ttdien.rmi.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Data {
	public static Connection getConnection() throws SQLException {

		Connection conn = null;
		String csdl = "csdl/csdl.accdb";
		String url = "jdbc:ucanaccess://" + csdl;
		conn = DriverManager.getConnection(url);

		return conn;

	}

	public static ArrayList<User> createListUser() {
		ArrayList<User> list = new ArrayList<>();
		try {
			String csdl = "csdl/csdl.accdb";
			String url = "jdbc:ucanaccess://" + csdl;
			String sql = "SELECT * FROM User";
			Connection conn = DriverManager.getConnection(url);
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static ArrayList<Product> createListProduct() {
		ArrayList<Product> list = new ArrayList<>();
		try {
			String csdl = "csdl/csdl.accdb";
			String url = "jdbc:ucanaccess://" + csdl;
			String sql = "SELECT * FROM Product";
			Connection conn = DriverManager.getConnection(url);
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public boolean find(String name) throws RemoteException {
		String sql = "SELECT * FROM Product WHERE name LIKE ?";
		try {
			Connection conn = Data.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, name);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name1 = rs.getString(2);
				int count = rs.getInt(3);
				double price = rs.getDouble(4);
				System.out.println(id + "\t" + name1 + "\t" + count + "\t" + price);
				return true;
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws RemoteException {
		//System.out.println(Data.createListUser());
		// getConnection();
//		Data d = new Data();
//		System.out.println(d.find("banh"));
	}

}
