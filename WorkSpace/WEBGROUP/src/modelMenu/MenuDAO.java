package modelMenu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class MenuDAO {
	private static ArrayList<Menu> listMenu;

	//lay danh sach menu con co ma ID cua cha
	public static ArrayList<Menu> getListMenuSub(int i) {
		ArrayList<Menu> listSubMenu = new ArrayList<>();
		try {
			// thiet lap ket noi
			Connection conn = DatabaseConnection.getConnection();
			// mo state ment de thuc hien sql
			Statement stmt = conn.createStatement();
			// danh sach menu con
			ResultSet r = stmt.executeQuery("select * from MenuChildren where idParent=" + i);
			while (r.next()) {
				listSubMenu.add(new Menu(r.getInt(1), r.getString(2), r.getString(3)));
			}
		} catch (Exception e) {
			
		}

		return listSubMenu;
	}

	public static ArrayList<Menu> getListMenu() {
		if (listMenu == null) {
			listMenu = new ArrayList<>();

		}
		if (listMenu.size() == 0) {
			try {
				Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "Select * from MenuParent";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					// lay danh sach menu con

					// dang sach cac menu
					if (rs.getBoolean(5) == false) {
						listMenu.add(new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getBoolean(5)));
					}
					if (rs.getBoolean(5) == true) {
						listMenu.add(new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getBoolean(5), MenuDAO.getListMenuSub(rs.getInt(1))));// id cua thang cha
					}
				}

			} catch (Exception e) {
				// ngoai le,
			}
		}

		return listMenu;
	}

	//menu ben trai
	public static ArrayList<String> getListSub() {
		ArrayList<String> listSubMenu = new ArrayList<>();
		try {
			// thiet lap ket noi
			Connection conn = DatabaseConnection.getConnection();
			// mo state ment de thuc hien sql
			Statement stmt = conn.createStatement();
			// danh sach menu con
			ResultSet r = stmt.executeQuery("select distinct nhom  from Product");
			while (r.next()) {
				listSubMenu.add(r.getString("nhom"));
			}
		} catch (Exception e) {
			
		}

		return listSubMenu;
	}

}
