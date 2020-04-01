package model_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelConnection.DatabaseConnection;
import model_user.Customer;

public class ProductDAO implements IProductDAO {

	public static ArrayList<Product> listProduct;

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
					listProduct.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
							rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
							rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
							rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
							rs.getString("dienAp"), rs.getInt("baoHanh")));
				}
				stmt.close();
				conn.close();

			} catch (Exception e) {

			}
		}

		return listProduct;

	}

	// phân trang
	public static ArrayList<Product> getListByPage(ArrayList<Product> arr, int start, int end) {
		ArrayList<Product> list = new ArrayList<>();
		for (int i = start; i < end; i++) {
			list.add(arr.get(i));
		}
		return list;
	}

	// Total product number
	public static int getCount() {
		Connection conn = DatabaseConnection.getConnection();
		String sql = "SELECT count(id) FROM Product";
		int count = 0;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<Product> getDemo() {
		ArrayList<Product> list = new ArrayList<>();

		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "Select * from Product where removed=0";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// add Product vao ArrayList
				list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh")));
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {

		}

		return list;
	}

	// Phan tim kiem SP cho Shopping cart
	@Override
	public ArrayList<Product> queryTypeProduct(String type) {
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from Product where loai like ? AND removed=0";

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
			// Xá»­ lÃ½ ngoáº¡i lá»‡,

		}
		return result;
	}

	// loc DS SP theo nhom
	@Override
	public ArrayList<Product> queryGroupProduct(String group) {
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from Product where nhom like ? and removed = 0 and soLuongTrongKho > 0";

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
			// Xá»­ lÃ½ ngoáº¡i lá»‡,

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
			e.printStackTrace();

		}
		return result;

	}

	// *************** Phan cho admin: Quáº£n lÃ­ San PhÃ¢m
	public static int idDynamic() {
		// tim max(id) + 1
		String sql = "select id from Product where id =( select MAX(id) FROM Product)";
		int preID = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				preID = rs.getInt("id");
			}
			pr.close();

		} catch (Exception e) {

		}
		return preID + 1;
	}

	@Override
	public boolean addProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh) {
		String sql = "INSERT INTO Product VALUES(?,?,?,?, ?,?,?,?,?,?,?,?,?,?,0)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setString(2, name);
			pr.setString(3, decription);
			pr.setDouble(4, price);
			pr.setDouble(5, discount);
			pr.setInt(6, soLuongTrongKho);
			pr.setString(7, type);
			pr.setString(8, group);
			pr.setString(9, linkHA1);
			pr.setString(10, linkHA2);
			pr.setString(11, linkHA3);
			pr.setDouble(12, congSuat);
			pr.setString(13, dienAp);
			pr.setInt(14, baoHanh);

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

	@Override
	public boolean editProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh) {
		String sql = "update Product set name=?, desciption=?, price=?, discount=?, soLuongTrongKho =?, loai=?, nhom=?, linkHinhAnh1=?, linkHinhAnh2=?, linkHinhAnh3=?,congSuat=?,dienAp=?,baoHanh=? where id=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, name);
			pr.setString(2, decription);
			pr.setDouble(3, price);
			pr.setDouble(4, discount);
			pr.setInt(5, soLuongTrongKho);
			pr.setString(6, type);
			pr.setString(7, group);
			pr.setString(8, linkHA1);
			pr.setString(9, linkHA2);
			pr.setString(10, linkHA3);
			pr.setDouble(11, congSuat);
			pr.setString(12, dienAp);
			pr.setInt(13, baoHanh);
			pr.setInt(14, id);

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

	// xoa tat ca cac don hang co ma SP la Product:
	// => giai phap: them 1 truong removed trong db
	@Override
	public boolean removeProduct(int id) {
		// 1: da xoa; 0: chua xoa
		String sql = "update Product set removed=1 where id=?";
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

	// ****************** gio hang
	public boolean updateQuatity(int Id, int quatityNew) {
		String sql = "update Product set soLuongTrongKho = ? where id=?";
		int i = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, quatityNew);
			pre.setInt(2, Id);
			i = pre.executeUpdate();

			pre.close();
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

	ArrayList<Product> listSearch;

	public ArrayList<Product> search(String text) {
		listSearch = new ArrayList<>();
		searchOnID(text);
		searchOnName(text);
		searchOnDescription(text);
		searchOnPrice(text);
		if (text.equals("*")) {
			listSearch = getListProduct();
		}

		return listSearch;

	}

	// tÃ¬m kiáº¿m trÆ°á»�ng ID
	public ArrayList<Product> searchOnID(String text) {

		String sql = "select * from Product where id LIKE ? or id LIKE ? or id LIKE ? AND removed=0";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, "%" + text);
			pr.setString(2, text + "%");
			pr.setString(3, "%" + text + "%");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh"));
				if (!listSearch.contains(p)) {
					listSearch.add(p);
				}
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return listSearch;

	}

	// tÃ¬m kiáº¿m trÆ°á»�ng Name
	public ArrayList<Product> searchOnName(String text) {

		String sql = "select * from Product where name LIKE ? or name LIKE ? or name LIKE ? AND removed=0";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, "%" + text);
			pr.setString(2, text + "%");
			pr.setString(3, "%" + text + "%");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh"));
				if (!listSearch.contains(p)) {
					listSearch.add(p);
				}
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return listSearch;

	}

	public ArrayList<Product> searchOnDescription(String text) {

		String sql = "select * from Product where desciption LIKE ? or desciption LIKE ? or desciption LIKE ? AND removed=0";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, "%" + text);
			pr.setString(2, text + "%");
			pr.setString(3, "%" + text + "%");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh"));
				if (!listSearch.contains(p)) {
					listSearch.add(p);
				}
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return listSearch;

	}

	public ArrayList<Product> searchOnPrice(String text) {

		String sql = "select * from Product where price LIKE ? or price LIKE ? or price LIKE ? AND removed=0";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, "%" + text);
			pr.setString(2, text + "%");
			pr.setString(3, "%" + text + "%");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"),
						rs.getDouble("price"), rs.getDouble("discount"), rs.getInt("soLuongTrongKho"),
						rs.getString("loai"), rs.getString("nhom"), rs.getString("linkHinhAnh1"),
						rs.getString("linkHinhAnh2"), rs.getString("linkHinhAnh3"), rs.getDouble("congSuat"),
						rs.getString("dienAp"), rs.getInt("baoHanh"));
				if (!listSearch.contains(p)) {
					listSearch.add(p);
				}
			}
			pr.close();
			conn.close();
		} catch (Exception e) {

		}
		return listSearch;

	}

	// ***********gio hang

	public Product lookUpProductInList(int id, List<Product> list) {
		for (Product p : list) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;

	}

	// cap nhat so luong san pham torng dang sach tam
	public void updateProductInList(int id, int Newquantity, ArrayList<Product> list) {
		for (Product p : list) {
			if (p.getId() == id) {
				p.setSoLuongTrongKho(Newquantity);
			}
		}

	}

	public static void main(String[] args) {
		ProductDAO a = new ProductDAO();
		//System.out.println(a.getListProduct());
		
		System.out.println(ProductDAO.getCount());
	}

}
