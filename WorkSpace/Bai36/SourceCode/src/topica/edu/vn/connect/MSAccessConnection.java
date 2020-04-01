package topica.edu.vn.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class MSAccessConnection {
	public static Connection getConnection()
	{
		return getConnection("csdl/qlCongVan.accdb");
	}
	public static Connection getConnection(String database)
	{
		try
		{
			String strConn="jdbc:ucanaccess://"+database;
			return DriverManager.getConnection(strConn);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
