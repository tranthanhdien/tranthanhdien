package model;

import java.util.ArrayList;

public class EmployeeDAO {
	private static ArrayList<Employee> listEmployees;

	public static ArrayList<Employee> getListEmployee() {
		if (EmployeeDAO.listEmployees == null) {
			listEmployees = new ArrayList<Employee>();
		}
		if (EmployeeDAO.listEmployees.size() == 0) {
			listEmployees.add(new Employee(1, "NV0001", "Trần Thị Thanh Nga", "01/05/1982", "Thái Bình"));
			listEmployees.add(new Employee(2, "NV0002", "Nguyễn Văn An", "07/04/1980", "Thái Bình"));
			listEmployees.add(new Employee(3, "NV0003", "Đào Thị Mơ", "04/09/1983", "Thái Bình"));
			listEmployees.add(new Employee(4, "NV0004", "Trạch Văn Đoành", "04/07/1988", "Thái Bình"));
			listEmployees.add(new Employee(5, "NV0005", "Mai Vân Anh", "11/08/1989", "Thái Bình"));
		}
		return EmployeeDAO.listEmployees;
	}

}
