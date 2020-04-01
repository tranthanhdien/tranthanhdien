package tracuusinhvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		ArrayList<Student> list = new ArrayList<>();
		String csdl = "C:\\CSDL\\Student.accdb";
		String url = "jdbc:ucanaccess://" + csdl;
		Connection conn = DriverManager.getConnection(url);
		Statement state = conn.createStatement();
		String sql = "SELECT * FROM Student";
		ResultSet result = state.executeQuery(sql);
		while (result.next()) {
			list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)));

		}
		System.out.println(list);

	}

}
