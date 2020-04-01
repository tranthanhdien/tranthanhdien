package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.DatabaseConnection;

public class EmployeeDAO {
	private static ArrayList<Employee> listEmployees = new ArrayList<>();

	public static ArrayList<Employee> getListEmployee() {
		if (listEmployees == null) {
			listEmployees = new ArrayList<>();
		}
		if (listEmployees.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement state = conn.createStatement();
				String sql = "SELECT * FROM EMPLOYEE";
				ResultSet rs = state.executeQuery(sql);
				while (rs.next()) {
					listEmployees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
				}
				state.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEmployees;
	}

	// thêm Employee
	public static boolean addEmployee(int no, String id, String name, String dob, String address) {
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?)";
		int i = 0;
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

	// Sửa Employee
	public static boolean editEmployee(Employee e) {
		String sql = "UPDATE EMPLOYEE SET No=?, Id=?, Name=?, Dob=?, Address=? WHERE No=?";
		int i = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, e.getNo());
			pr.setString(2, e.getId());
			pr.setString(3, e.getName());
			pr.setString(4, e.getDob());
			pr.setString(5, e.getAddress());

			pr.setInt(6, e.getNo());
			i = pr.executeUpdate();
			pr.close();
			conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean edit(int no, Employee e) {
		Employee em = lookUp(no, listEmployees);
		if (em != null) {
			em.setNo(e.getNo());
			em.setId(e.getId());
			em.setName(e.getName());
			em.setDob(e.getDob());
			em.setAddress(e.getAddress());
			return true;
		} else {
			return false;
		}

	}

	public static Employee lookUp(int no, ArrayList<Employee> list) {
		for (Employee e : list) {
			if (no == e.getNo()) {
				return e;
			}
		}
		return null;

	}

	// Xoá Employee
	public static boolean deleteEmployee(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE No=?";
		int i = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
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

}
