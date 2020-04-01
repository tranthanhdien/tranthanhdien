package hethongthongtin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class ProductDAO {

	// lay danh sach tat ca san pham hien co
	public ArrayList<Product> getListProduct() {
		ArrayList<Product> listProduct = null;
		if (listProduct == null) {
			listProduct = new ArrayList<>();
		}

		if (listProduct.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from ProductHTTT";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
				}
				stmt.close();
				conn.close();

			} catch (Exception e) {

			}
		}
		return listProduct;
	}

	public boolean removeProduct(int id) {
		String sql = "delete from ProductHTTT where id=?";
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

	public boolean updateProduct(int id, String name, String description, double price) {
		String sql = "update ProductHTTT set name =?,desciption=?,price=? where id=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setNString(1, name);
			pr.setNString(2, description);
			pr.setDouble(3, price);
			pr.setInt(4, id);
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

	public int dynamicID() {
		String sql = "select * from ProductHTTT where id =( select MAX(id) FROM ProductHTTT)";
		int preID = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				preID = rs.getInt("id");
				rs.getString("name");
				rs.getString("desciption");
				rs.getDouble("price");

			}
			pr.close();

		} catch (Exception e) {

		}
		return preID + 1;

	}

	public boolean addProduct(int id, String name, String description, double price) {
		String sql = "insert into ProductHTTT values(?,?,?,?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setNString(2, name);
			pr.setNString(3, description);
			pr.setDouble(4, price);
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

	public Product lookProduct(int id) {
		Product p = null;
		String sql = "select * from ProductHTTT where id=?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return p;
	}
}
