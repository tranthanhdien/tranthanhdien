package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DatabaseConnection;

public class PeopleDAO {
	static ArrayList<People> listPeople;
	static Connection conn;
	static PreparedStatement ps;
	static String sql;
	static ResultSet rs;

	public static ArrayList<People> getInformation() {
		if (listPeople == null) {
			listPeople = new ArrayList<>();
		}
		if (listPeople.size() == 0) {
			try {
				conn = DatabaseConnection.getConnection();
				String sql = "SELECT * FROM People";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String gender = rs.getString(3);
					String birthday = rs.getString(4);
					int cmnd = rs.getInt(5);
					String address = rs.getString(6);
					String job = rs.getString(7);
					int phone = rs.getInt(8);
					String avatar = rs.getString(9);

					People p = new People(id, name, gender, birthday, cmnd, address, job, phone, avatar);
					listPeople.add(p);
				}
				System.out.println(listPeople);

				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listPeople;
	}

	public static void addPeople(int id, String name, String gender, String day, int cmnd, String address, String job,
			int phone, String img) {
		try {
			conn = DatabaseConnection.getConnection();
			sql = "INSERT INTO people VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, day);
			ps.setInt(5, cmnd);
			ps.setString(6, address);
			ps.setString(7, job);
			ps.setInt(8, phone);
			ps.setString(9, img);
			int rs = ps.executeUpdate();
			System.out.println("Thuc hien thanh cong add People");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void editInfomation(int id, String name, String gender, String day, int cmnd, String address,
			String job, int phone, String img) {
		try {
			conn = DatabaseConnection.getConnection();
			sql = " update people set user_name = ?,gender=?,birthday=?,cmnd=?,address=?,job=?,phone=?,image=? where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, day);
			ps.setInt(4, cmnd);
			ps.setString(5, address);
			ps.setString(6, job);
			ps.setInt(7, phone);
			ps.setString(8, img);
			ps.setInt(9, id);
			int rs = ps.executeUpdate();
			System.out.println("Thuc hien thanh cong chinh sua thong tin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deletePeople(int id) throws ClassNotFoundException {
		try {
			conn = DatabaseConnection.getConnection();
			sql = " delete from people where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			System.out.println("Thuc hien thanh cong xoa thong tin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PeopleDAO.getInformation();

	}

}
