package model_shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelConnection.DatabaseConnection;

public class ItemCartDB {

	public int getID() {
		// tim max(id) + 1
		String sql = "select * from ItemCart where id =( select MAX(id) FROM ItemCart)";
		int preID = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();

			while (rs.next()) {

				preID = rs.getInt("id");
				rs.getInt("idInvoice");
				rs.getInt("idProduct");
				rs.getInt("quantity");
			}
			pr.close();

		} catch (Exception e) {

		}
		return preID + 1;

	}

	public boolean insert(int invoiceID, ItemCart item) {
		String sql = "insert into ItemCart values(?,?,?,?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, new ItemCartDB().getID());
			pr.setInt(2, invoiceID);
			pr.setInt(3, item.getP().getId());
			pr.setInt(4, item.getQuantity());

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
