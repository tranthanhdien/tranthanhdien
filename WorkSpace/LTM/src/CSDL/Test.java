package CSDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	public static boolean connectDatabase() throws SQLException {
		boolean result = false;
		Connection conn;
		String databasePath = "csdl/SinhVien.accdb";
		String strConnection = "jdbc:ucanaccess://" + databasePath;
		conn = DriverManager.getConnection(strConnection);
		if (conn != null) {
			result = true;
			System.out.println("DSSV from Database");
			Statement statement = conn.createStatement();
			String sql = "SELECT * FROM SinhVien";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("Ma") + "\t" + rs.getString("Ten") + "\t" + rs.getString("Tuoi"));
			}
		} else {
			result = false;
		}
		return result;

	}

	public static void findByName() throws SQLException {
		String text;
		System.out.println("findByName: ");
		Scanner input = new Scanner(System.in);
		text = input.nextLine();
		String databasePath = "csdl/SinhVien.accdb";
		String strConn = "jdbc:ucanaccess://" + databasePath;
		Connection conn = DriverManager.getConnection(strConn);
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM SinhVien WHERE Ten LIKE '%" + text + "%' OR Ma LIKE '%" + text + "%'";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("Ma") + "\t" + rs.getString("Ten") + "\t" + rs.getString("Tuoi"));
		}

	}

	public static void findByAge() throws SQLException {
		String text;
		System.out.println("findByAge: ");
		Scanner input = new Scanner(System.in);
		text = input.nextLine();
		String databasePath = "csdl/SinhVien.accdb";
		String strConn = "jdbc:ucanaccess://" + databasePath;
		Connection conn = DriverManager.getConnection(strConn);
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM SinhVien WHERE Tuoi = " + text;;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("Ma") + "\t" + rs.getString("Ten") + "\t" + rs.getString("Tuoi"));
		}
	}
	// <= tuổi
	public static void findByUnderAge() throws SQLException {
		String text;
		System.out.println("findByUnderAge: ");
		Scanner input = new Scanner(System.in);
		text = input.nextLine();
		String databasePath = "csdl/SinhVien.accdb";
		String strConn = "jdbc:ucanaccess://" + databasePath;
		Connection conn = DriverManager.getConnection(strConn);
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM SinhVien WHERE Tuoi <= " + text;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("Ma") + "\t" + rs.getString("Ten") + "\t" + rs.getString("Tuoi"));
		}
	}
	// >= tuổi
	public static void findByUpperAge() throws SQLException {
		String text;
		System.out.println("findByUpperAge: ");
		Scanner input = new Scanner(System.in);
		text = input.nextLine();
		String databasePath = "csdl/SinhVien.accdb";
		String strConn = "jdbc:ucanaccess://" + databasePath;
		Connection conn = DriverManager.getConnection(strConn);
		Statement statement = conn.createStatement();
		String sql = "SELECT * FROM SinhVien WHERE Tuoi >= " + text;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("Ma") + "\t" + rs.getString("Ten") + "\t" + rs.getString("Tuoi"));
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(Test.connectDatabase());
		System.out.println("============================");
		Test.findByName();
		System.out.println("============================");
		Test.findByAge();
		System.out.println("============================");
		Test.findByUnderAge();
		System.out.println("============================");
		Test.findByUpperAge();
	}
}
