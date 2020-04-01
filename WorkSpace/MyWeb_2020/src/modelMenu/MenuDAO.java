package modelMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelConnection.DatabaseConnection;

public class MenuDAO {
	private static ArrayList<Menu> listMenu;

	// cap phat ID tu dong
	public static int idDynamic() {
		int i = 0;

		return 0;
	}

	// ghi menu xuong DB

	// *************menu Parent
	public void addParentMenu() {
		// danh sach cac loai SP
		String sql = "select distinct loai from Product";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				String s = rs.getString("loai");
				// tao menu
				Menu m = new Menu(MenuDAO.idDynamic(), s, "ControllerShopping?action=filterType&type=" + s, "", true);
				// ghi xuong DB
				addParent(m);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// add 1 menu vao lít
	public void addParent(Menu m) {
		// ma + ten + link + icon + isSubmenu
		String sql = "insert into MenuParent values(?,?,?,?,?)";
		int i = 0;
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, m.getId());
			pre.setString(2, m.getName());
			pre.setString(3, m.getLink());
			pre.setString(4, m.getIcon());
			pre.setBoolean(5, m.isDropdown());
			i = pre.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//ghi menu con
	

	// lay danh sach menu con co ma ID cua cha
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

	// menu ben trai
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
