package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.DatabaseConnection;

public class EmployeeSalaryDAO {
	private static ArrayList<EmployeeSalary> listEmployees;

	public static ArrayList<EmployeeSalary> getListEmployee() {
		if (EmployeeSalaryDAO.listEmployees == null) {
			listEmployees = new ArrayList<EmployeeSalary>();
		} else {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement statement = conn.createStatement();
				String sql = "SELECT * FROM EMPLOYEE_SALARY";
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					listEmployees.add(new EmployeeSalary(result.getInt("STT"), result.getString("MANV"),
							result.getString("HOTEN"), result.getString("LOAINV"), result.getDouble("LUONG_THEONGAY")));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return EmployeeSalaryDAO.listEmployees;
	}

}
