package ttdien.rmi.file;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ttdien.rmi.model.Data;
import ttdien.rmi.model.Product;
import ttdien.rmi.model.User;

public class FileImpl extends UnicastRemoteObject implements IFile {
	private static final long serialVersionUID = 1L;
	ArrayList<User> listUser;
	ArrayList<Product> listProduct;
	User user;
	Product product;

	protected FileImpl() throws RemoteException {
		super();
		user = new User();
		listUser = Data.createListUser();
		product = new Product();
		listProduct = Data.createListProduct();

	}

	@Override
	public boolean checkName(String name) throws RemoteException {
		for (User user : listUser) {
			if (user.getName().equalsIgnoreCase(name)) {
				this.user.setName(name);
				return true;
			}
		}
		this.user.setName(null);
		return false;
	}

	@Override
	public boolean checkPass(String pass) throws RemoteException {
		if (user == null) {
			// nếu = null thì quăng về cho client biết
			throw new RemoteException("Vui lòng nhập tên");
		}
		for (User user : listUser) {
			if (user.getName().equalsIgnoreCase(this.user.getName()) && user.getPass().equalsIgnoreCase(pass)) {
				this.user = new User(this.user.getName(), pass);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(String id, String name, int count, double price) throws RemoteException {
		String sql = "INSERT INTO Product VALUES(?, ?, ?, ?)";
		int i = 0;
		try {
			Connection conn = Data.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setString(2, name);
			pr.setInt(3, count);
			pr.setDouble(4, price);
			i = pr.executeUpdate();
			pr.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(String id) throws RemoteException {
		String sql = "DELETE FROM Product WHERE idsp=?";
		int i = 0;
		try {
			Connection conn = Data.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			i = pr.executeUpdate();
			pr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean edit(String id, String name, int count, double price) throws RemoteException {
		String sql = "UPDATE Product SET idsp=?, name=?, count=?, price=? WHERE idsp=?";
		int i = 0;
		try {
			Connection conn = Data.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setString(2, name);
			pr.setInt(3, count);
			pr.setDouble(4, price);

			pr.setString(5, id);
			i = pr.executeUpdate();
			pr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<Product> find(String name) throws RemoteException {
		ArrayList<Product> list = new ArrayList<>();
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
				list.add(new Product(id, name1, count, price));
			}
			for (Product p : list) {
				System.out.println(p);
			}

			pr.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
