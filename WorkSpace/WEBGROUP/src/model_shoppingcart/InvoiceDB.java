package model_shoppingcart;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.crypto.spec.IvParameterSpec;

import modelConnection.DatabaseConnection;
import model_product.Product;
import model_user.Customer;

public class InvoiceDB {

	// chon cac hoa don da duoc xu li
	public ArrayList<Invoice> getListInvoice() {
		ArrayList<Invoice> result = new ArrayList<>();
		String sql = "SELECT userInfo.*, Invoice.id as idInvoice, Invoice.ngayHD,Invoice.totalAmount , Invoice.isProcess FROM userInfo JOIN Invoice ON userInfo.id= Invoice.idUser where Invoice.isProcess=1";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet re = pre.executeQuery();
			while (re.next()) {
				Customer customer = new Customer(re.getInt("id"), re.getString("username"), re.getString("fullname"),
						re.getString("phone"), re.getString("address1"));
				int idInvoice = re.getInt("idInvoice");
				// truy xuat gio hang co ma hoa don xxxx
				ShoppingCart shop = getShoppingCartInInvoiceID(idInvoice);
				Date date = re.getDate("ngayHD");
				java.util.Date utilDate = new java.util.Date(date.getTime());
				double price = re.getDouble("totalAmount");
				boolean isProcess = re.getBoolean("isProcess");
				result.add(new Invoice(idInvoice, customer, utilDate, shop, isProcess));
			}
			re.close();
			pre.close();
			conn.close();

		} catch (Exception e) {

		}

		return result;
	}

	// cap phat ID tu dong
	public int dynamicID() {
		// tim max(id) + 1
		String sql = "select * from Invoice where id =( select MAX(id) FROM Invoice)";
		int preID = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				preID = rs.getInt("id");
				rs.getInt("idUser");
				rs.getDate("ngayHD");
				rs.getDouble("totalAmount");
				rs.getBoolean("isProcess");
			}
			pr.close();

		} catch (Exception e) {

		}
		return preID + 1;
	}

	// them, xoa, sua voi database
	public boolean add(int id, int idCuctomer, Date ngayHD, double totalAmount, boolean isProcess) {
		String sql = "insert into Invoice values(?,?,?,?,?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setInt(2, idCuctomer);
			pr.setDate(3, ngayHD);
			pr.setDouble(4, totalAmount);
			pr.setBoolean(5, isProcess);

			i = pr.executeUpdate();
			pr.close();

		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;
		return false;

	}

	// tim 1 hoa don dua vao IdInvoice
	public Invoice lookInvoice(int idInvoice) {
		Invoice invoi = null;
		String sql = "SELECT userInfo.*, Invoice.id as idInvoice, Invoice.ngayHD, Invoice.isProcess FROM userInfo JOIN Invoice ON userInfo.id= Invoice.idUser where Invoice.id = ? AND Invoice.isProcess=1";
		ResultSet re = null;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idInvoice);
			re = pr.executeQuery();
			while (re.next()) {
				Customer customer = new Customer(re.getInt("id"), re.getString("username"), re.getString("fullname"),
						re.getString("phone"), re.getString("address1"));
				int id = re.getInt("idInvoice");
				// truy xuat gio hang co ma hoa don idInvoice
				ShoppingCart shop = getShoppingCartInInvoiceID(id);
				Date date = re.getDate("ngayHD");
				java.util.Date utilDate = new java.util.Date(date.getTime());
				boolean isProcess = re.getBoolean("isProcess");
				invoi = new Invoice(id, customer, utilDate, shop, isProcess);
			}
			pr.close();
			conn.close();

		} catch (Exception e) {

		}
		return invoi;
	}

	// xoa hoa don + xoa ItemCart co ma hoa don nay
	public boolean removeItemCart(int idInvoice) {
		String sql = "delete from ItemCart where idInvoice=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idInvoice);
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

	public boolean removeInvoice(int idInvoice) {
		String sql = "delete from Invoice where id=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idInvoice);
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

	// quan li hoa don: cap nhat hoa don
	// xoa gio hang: xoa ItemCart dua vao idInvoice va idProduct
	public boolean removeItemCart_Invoice(int idInvoice, int idProduct) {
		String sql = "delete from ItemCart  where idInvoice=? AND idProduct=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idInvoice);
			pr.setInt(2, idProduct);
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

	// cap nhat invoice
	// se cap nhat trong Invoice + Itemcart thuc hien o nut xoa roi
	public boolean updateProduct(int id, String name, String description, double price) {
		String sql = "update Invoice set name =?,desciption=?,price=? where id=?";
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

//**************chuc nang xu li hoa don
	// lay Shoping cua 1 hoa don
	public ShoppingCart getShoppingCartInInvoiceID(int idInvoice) {
		ArrayList<ItemCart> result = new ArrayList<>();
		ShoppingCart shop = new ShoppingCart();
		String sql = "SELECT ItemCart.quantity, Product.* FROM ItemCart JOIN Product ON ItemCart.idProduct=Product.id where ItemCart.idInvoice = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idInvoice);
			ResultSet re = pre.executeQuery();
			while (re.next()) {
				// tao Product tu cac ruong phia sau
				int quantity = re.getInt("quantity");
				Product p = new Product(re.getInt("id"), re.getString("name"), re.getString("desciption"),
						re.getDouble("price"), re.getDouble("discount"), re.getInt("soLuongTrongKho"),
						re.getString("loai"), re.getString("nhom"), re.getString("linkHinhAnh1"),
						re.getString("linkHinhAnh2"), re.getString("linkHinhAnh3"), re.getDouble("congSuat"),
						re.getString("dienAp"), re.getInt("baoHanh"));
				// tao ItemCart vs Product vua tao + quantity
				ItemCart item = new ItemCart(p, quantity);
				result.add(item);

			}
			re.close();
			pre.close();
			conn.close();

		} catch (Exception e) {

		}

		shop.setListCart(result);

		return shop;
	}

	// chon cac hoa don chua xu li
	public ArrayList<Invoice> unprocessInvoices() {
		ArrayList<Invoice> result = new ArrayList<>();
		String sql = "SELECT userInfo.*, Invoice.id as idInvoice, Invoice.ngayHD,Invoice.totalAmount , Invoice.isProcess FROM userInfo JOIN Invoice ON userInfo.id= Invoice.idUser where Invoice.isProcess=0";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet re = pre.executeQuery();
			while (re.next()) {
				Customer customer = new Customer(re.getInt("id"), re.getString("username"), re.getString("fullname"),
						re.getString("phone"), re.getString("address1"));
				int idInvoice = re.getInt("idInvoice");
				ShoppingCart shop = getShoppingCartInInvoiceID(idInvoice);
				Date date = re.getDate("ngayHD");
				java.util.Date utilDate = new java.util.Date(date.getTime());
				boolean isProcess = re.getBoolean("isProcess");
				result.add(new Invoice(idInvoice, customer, utilDate, shop, isProcess));
			}
			re.close();
			pre.close();
			conn.close();

		} catch (Exception e) {

		}
		return result;
	}

	public boolean updateProcess(int idInvoice) {
		String sql = "update Invoice set isProcess = 1 where id=?";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, idInvoice);
			i = pr.executeUpdate();
			pr.close();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}
	// ***************//xu li ho don

}
