package model_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelConnection.DatabaseConnection;

public class ReportDB {

	public static String getInvoiceSumary(String reportTitle, String startDate, String endDate) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement st = null;
		ResultSet re = null;
		String sql = "SELECT userInfo.*, Invoice.id as idInvoice, Invoice.ngayHD,Invoice.totalAmount  FROM userInfo JOIN Invoice ON userInfo.id= Invoice.idUser where Invoice.isProcess=1 and ngayHD <= ?  AND ngayHD >= ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, endDate);
			st.setString(2, startDate);
			re = st.executeQuery();
			String d = "\t";
			StringBuilder report = new StringBuilder(reportTitle + "\n\n" + "Start date: " + startDate + "\n"
					+ "End date: " + endDate + "\n\n" + "Mã Hóa đơn" + d + "Tên khách hàng" + d + "Số điện thoại" + d
					+ "Địa chỉ" + d + "Ngày đặt hàng" + d + "Tổng giá" + "\n");

			while (re.next()) {
				re.getInt("id");
				re.getString("username");
				String userName = re.getString("fullname");
				String phone = re.getString("phone");
				String address = re.getString("address1");
				int idInvoice = re.getInt("idInvoice");
				Date date = re.getDate("ngayHD");
				java.util.Date realDate = new java.util.Date(date.getTime());
				double price = re.getDouble("totalAmount");
				report.append(idInvoice + d + userName + d + phone + d + address + d + realDate + d + price + "\n");

			}
			st.close();
			conn.close();

			return report.toString();
		} catch (Exception e) {
			return null;
		}

	}

	public static String reportCustomer(String title) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement st = null;
		ResultSet re = null;
		String sql = "select userInfo.*, userpass.username as email, userpass.hasadmin from userInfo join userpass on userInfo.id=userpass.idUser";
		try {
			st = conn.prepareStatement(sql);
			re = st.executeQuery();
			String d = "\t";
			StringBuilder report = new StringBuilder(title + "\n\n" + "ID" + d + "User name" + d + "Full name" + d
					+ "Phone" + d + "address" + d + "Email" + d + "Has Admin" + "\n");

			while (re.next()) {
				report.append(re.getInt("id") + d + re.getString("username") + d + re.getString("fullname") + d
						+ re.getString("phone") + d + re.getString("address1") + d + re.getString("email") + d
						+ re.getBoolean("hasadmin") + "\n");

			}
			st.close();
			conn.close();

			return report.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static String reportProduct() {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement st = null;
		ResultSet re = null;
		String sql = "Select * from Product where removed=0";
		try {
			st = conn.prepareStatement(sql);
			re = st.executeQuery();
			String d = "\t";
			StringBuilder report = new StringBuilder("Danh sách sản phẩm" + "\n\n" + "ID" + d + "Name" + d + "Price" + d
					+ "Quantity" + d + "Capacity" + d + "Voltage" + d + "Guarantee" + "\n");

			while (re.next()) {
				report.append(re.getInt("id") + d + re.getString("name") + d + re.getDouble("price") + d
						+ re.getInt("soLuongTrongKho") + d + re.getDouble("congSuat") + d + re.getString("dienAp") + d
						+ re.getInt("baoHanh") + "\n");

			}
			st.close();
			conn.close();
			return report.toString();
		} catch (Exception e) {
			return null;
		}
	}

}
