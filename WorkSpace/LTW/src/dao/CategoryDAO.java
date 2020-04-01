package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DatabaseConnection;
import model.Category;

public class CategoryDAO {
	// lấy danh sách từng loại
	public ArrayList<Category> getListCategory() throws SQLException {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM Category";
		PreparedStatement pr = conn.prepareStatement(sql);
		ResultSet rs = pr.executeQuery();
		ArrayList<Category> list = new ArrayList<>();
		while (rs.next()) {
			Category cate = new Category();
			cate.setCategoryID(rs.getInt("category_id"));
			cate.setCategoryName(rs.getString("category_name"));
			list.add(cate);
		}
		return list;
	}
	public static void main(String[] args) throws SQLException {
		CategoryDAO dao = new CategoryDAO();
		for (Category cate : dao.getListCategory()) {
			System.out.println(cate.getCategoryID() + "\t" + cate.getCategoryName());
		}
	}

}
