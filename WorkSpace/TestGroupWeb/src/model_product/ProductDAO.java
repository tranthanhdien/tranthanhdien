package model_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;
import model_user.Customer;

public class ProductDAO implements IProductDAO {

	private static ArrayList<Product> listProduct;

//lay danh sach tat ca san pham hien co
	@Override
	public ArrayList<Product> getListProduct() {
		if (listProduct == null) {
			listProduct = new ArrayList<>();
		}

		if (listProduct.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from Product";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					// add Product vao ArrayList
					listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getDouble(12), rs.getString(13), rs.getInt(14)));

				}
				stmt.close();
				conn.close();

			} catch (Exception e) {

			}
		}
		return listProduct;
	}

	// Phan tim kiem SP cho Shopping cart
	@Override
	public ArrayList<Product> queryTypeProduct(String type) {
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from Product where loai like ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, type);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				result.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
						rs.getDouble("discount"), rs.getString("linkHinhAnh1")));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}
		return result;
	}

	// loc DS SP theo nhom
	@Override
	public ArrayList<Product> queryGroupProduct(String group) {
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from Product where nhom like ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, group);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				result.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
						rs.getDouble("discount"), rs.getString("linkHinhAnh1")));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}
		return result;
	}

	public Product lookUp(int id) {
		Product result = null;
		String sql = "select * from Product where id = ?";

		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {
				result = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh"));
			}
			pr.close();
			conn.close();
		} catch (Exception e) {
			// Xử lý ngoại lệ,

		}

		return result;

	}

	// Phan cho admin: Quản lí San Phâm
	@Override
	public boolean addProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product exportToExcel() throws SQLException {
		Product result = null;
		String sql = "insert into OPENROWSET('Microsoft.Jet.OLEDB.4.0', \r\n"
				+ "    'Excel 8.0;Database=D:\\testing.xls;', \r\n"
				+ "    'SELECT * FROM [SheetName$]') select * from SQLServerTable";
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement pr = conn.prepareStatement(sql);
		ResultSet rs = pr.executeQuery();
		while(rs.next()) {
			result = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
					rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
					rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
					rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
					rs.getString("dienAp"), rs.getInt("baoHanh"));
		}
		return result;
	}

	

}
