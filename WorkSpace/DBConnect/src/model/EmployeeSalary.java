package model;

public class EmployeeSalary {
	private int no;
	private String id;
	private String name;
	private String employeeType;
	private double salary;

	public EmployeeSalary(int no, String id, String name, String employeeType, double salary) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.employeeType = employeeType;
		this.salary = salary;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
