package model;

import java.util.ArrayList;


public class MenuDAO {
	public static ArrayList<Menu> getMenuList() {
		ArrayList<Menu> lstMenus = new ArrayList<Menu>();
		lstMenus.add(new Menu("Trang chủ", "index.jsp"));
		lstMenus.add(new Menu("About", "about.jsp" ));
		lstMenus.add(new Menu("Contact", "contact.jsp"));
		lstMenus.add(new Menu("Exercise", "exercise.jsp"));
		return lstMenus;

	}
}
