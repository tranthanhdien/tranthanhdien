package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DatabaseConnection;
import model.Product;

public class ProductDAO {
	// lấy danh sách sản phẩm dựa vào mã danh mục
	public ArrayList<Product> getListProductByCategory(long category_id) throws SQLException {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM Product WHERE category_id = '" + category_id + "'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Product> list = new ArrayList<>();
		while (rs.next()) {
			Product product = new Product();
			product.setProductID(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			product.setProductDescription(rs.getString("product_description"));
			list.add(product);
		}
		return list;
	}

	// lấy thông tin chi tiết sản phẩm dựa vào id sản phẩm đó
	public static Product getProduct(long productID) throws SQLException {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM Product WHERE product_id = '" + productID + "'";
		PreparedStatement pr = conn.prepareStatement(sql);
		Product product = new Product();
		ResultSet rs = pr.executeQuery();
		while (rs.next()) {
			product.setProductID(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			product.setProductDescription(rs.getString("product_description"));

		}
		return product;
	}

	public static void main(String[] args) throws SQLException {
		ProductDAO dao = new ProductDAO();
//		for (Product p : dao.getListProductByCategory(1)) {
//			System.out.println(p.getProductID() + "\t" + p.getProductName() + "\t" + p.getProductImage() + "\t"
//					+ p.getProductPrice() + "\t" + p.getProductDescription());
//		}
		System.out.println(dao.getProduct(101).getProductName());
	}

}
