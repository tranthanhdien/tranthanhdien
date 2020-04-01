package tracuusinhvien;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentImpl extends UnicastRemoteObject implements IStudent {
	private static final long serialVersionUID = 1L;
	Statement statement;
	ResultSet result;
	Connection conn;

	protected StudentImpl() throws RemoteException {
		super();
		try {
			String csdl = "C:\\CSDL\\Student.accdb";
			String url = "jdbc:ucanaccess://" + csdl;
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Student> findById(String mssv) throws RemoteException {
		ArrayList<Student> list = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM Student WHERE mssv = '" + mssv + "'";
			result = statement.executeQuery(sql);
			while (result.next()) {
				list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Student> findByName(String name) throws RemoteException {
		ArrayList<Student> list = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM Student WHERE name = '" + name + "'";
			result = statement.executeQuery(sql);
			while (result.next()) {
				list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Student> findByAge(int age) throws RemoteException {
		ArrayList<Student> list = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM Student WHERE age = '" + age + "'";
			result = statement.executeQuery(sql);
			while (result.next()) {
				list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Student> findByScore(double score) throws RemoteException {
		 ArrayList<Student> list = new ArrayList<>();
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM Student WHERE score = '" + score + "'";
			result = statement.executeQuery(sql);
			while (result.next()) {
				list.add(new Student(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
