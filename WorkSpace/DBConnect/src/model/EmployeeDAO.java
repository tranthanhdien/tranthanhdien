package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import DAO.DatabaseConnection;

public class EmployeeDAO {
	private static ArrayList<Employee> listEmployees;

	public static ArrayList<Employee> getListEmployee() {

		if (EmployeeDAO.listEmployees == null) {
			listEmployees = new ArrayList<Employee>();
		} else {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement statement = conn.createStatement();
				String sql = "SELECT * FROM EMPLOYEE";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					listEmployees.add(new Employee(result.getInt("STT"), result.getString("MANV"),
							result.getString("HOTEN"), result.getString("NGSINH"), result.getString("QUEQUAN")));
				}
				result.close();
			
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return EmployeeDAO.listEmployees;
	}

	public static boolean regCourse(int no, String id, String name, String dob, String address) {

		String sql = "INSERT INTO EMPLOYEE(STT, MANV, HOTEN, NGSINH, QUEQUAN) VALUES(" + no + ", '" + id + ", '" + name
				+ ", '" + dob + ", '" + address + "')";
		int x = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement statement = conn.createStatement();
			x = statement.executeUpdate(sql);
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (x > 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean addEmployeeData(int no, String id, String name, String dob, String address) {
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?)";
		int i;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, no);
			pr.setString(2, id);
			pr.setString(3, name);
			pr.setString(4, dob);
			pr.setString(5, address);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			return false;
		}
		if (i > 0)
			return true;

		return false;

	}
	public static boolean deleteEmpData(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE STT=?";
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

	public static boolean delete(int id) {
		String sql = "DELETE EMPLOYEE WHERE STT=?";
		int i;
		try {
			// PreparedStatement prepare = EmployeeDAO.get
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

}
