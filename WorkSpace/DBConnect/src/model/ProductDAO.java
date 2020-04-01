package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.DatabaseConnection;
import javafx.scene.chart.PieChart.Data;

public class ProductDAO {
	private static ArrayList<Product> listProduct;

	public static ArrayList<Product> getListProduct() {
		if (ProductDAO.listProduct == null) {
			listProduct = new ArrayList<Product>();
		}
		if (ProductDAO.listProduct.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement statement = conn.createStatement();
				String sql = "SELECT * FROM PRODUCT";
				ResultSet result = statement.executeQuery(sql);
				// System.out.println("Thực thi thành công");
				while (result.next()) {
					listProduct.add(new Product(result.getInt("MASP"), result.getString("TENSP"),
							result.getString("DVT"), result.getString("NUOCSX"), result.getInt("GIA")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ProductDAO.listProduct;
	}

	public static boolean regCourse(String id, String name, String dvt, String nsx, double gia) {

		String sql = "INSERT INTO EMPLOYEE(MASP, TENSP, DVT, NUOCSX, GIA) VALUES(" + id + ", '" + name + ", '" + dvt
				+ ", '" + nsx + ", '" + gia + "')";
		int x = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement statement = conn.createStatement();
			x = statement.executeUpdate(sql);
			statement.close();
		} catch (Exception e) {
			// return false;
		}
		if (x > 0) {
			return true;
		} else {
			return true;
		}

	}

	public static ArrayList<Product> searchData(String name) {
		String sql = "SELECT * FROM PRODUCT WHERE TENSP LIKE '%" + name + "%' ";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
		
			pr.setString(1, name);

			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ProductDAO.listProduct;

	}

	public static boolean addProductData(int maSP, String tenSP, String dvt, String nuocSX, double gia) {
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, maSP);
			pr.setString(2, tenSP);
			pr.setString(3, dvt);
			pr.setString(4, nuocSX);
			pr.setDouble(5, gia);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

	public static boolean deleteInList(int id) {
		for (int i = 0; i < listProduct.size(); i++) {
			if (listProduct.get(i).getId() == id) {
				listProduct.remove(i);
				return true;
			}
		}
		return false;
	}

	public static boolean deleteProductData(int id) {
		String sql = "DELETE FROM PRODUCT WHERE MASP=?";
		int i;
		try {
			PreparedStatement pr = DatabaseConnection.getConnection().prepareStatement(sql);
			pr.setInt(1, id);
			i = pr.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;
	}

	public boolean updateProductDatabase(int id, String tenSP, String dvt, String nuocSX, double price) {
		String sql = "UPDATE PRODUCT SET TENSP=?, DVT=?, NUOCSX=?, GIA=? WHERE MA=?";
		int i;
		try {
			PreparedStatement pr = DatabaseConnection.getConnection().prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, tenSP);
			pr.setString(3, dvt);
			pr.setString(4, nuocSX);
			pr.setDouble(5, price);
			i = pr.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}

}
