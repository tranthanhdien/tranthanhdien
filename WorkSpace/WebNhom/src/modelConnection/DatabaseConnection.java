package modelConnection;

import java.sql.DriverManager;


public class DatabaseConnection {
	public static java.sql.Connection getConnection() {
		java.sql.Connection connection = null;
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=BanThietBiChieuSang";
		String user = "sa";
		String pass = "dien1998";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			// Orther err
			e.printStackTrace();
		}
		return connection;
	}


	public static void main(String[] args){
		java.sql.Connection connection = DatabaseConnection. getConnection() ;
		if (connection != null ) {
		System.out.println("Kết nối thành công");
		}else {
		System.out.println("Kết nối thất bại");
		}
	}

}
