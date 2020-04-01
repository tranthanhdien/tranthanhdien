package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.DatabaseConnection;

public class ProductDAO {
	private static ArrayList<Product> listProducts;

	public static ArrayList<Product> getListProduct() {
		if (listProducts == null) {
			listProducts = new ArrayList<Product>();
		}
		if (listProducts.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stt = conn.createStatement();
				String sql = "SELECT * FROM PRODUCT_TEST";
				ResultSet rs = stt.executeQuery(sql);
				while (rs.next()) {
					listProducts.add(new Product(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"),
							rs.getString("IMAGE"), rs.getInt("QUANTITY")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ProductDAO.listProducts;
	}

	public static boolean addProductData(int id, String name, double price, String image, int quantity) {
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, name);
			pr.setDouble(3, price);
			pr.setString(4, image);
			pr.setInt(5, quantity);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

}
