package modelMenu;

import java.util.ArrayList;

public class Menu {
	private int id;
	private String name;
	private String link;
	private String icon;
	private boolean dropdown;
	private ArrayList<Menu> listSubMenu;
	
	public Menu(int id, String name, String link, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.icon = icon;
	}
	
	public Menu(int id, String name, String link, String icon, boolean dropdown) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.icon = icon;
		this.dropdown = dropdown;
	}

	public Menu(int id, String name, String link, String icon, boolean dropdown, ArrayList<Menu> listSubMenu) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.icon = icon;
		this.dropdown = dropdown;
		this.listSubMenu = listSubMenu;
	}

	public Menu(int id, String name, String link) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isDropdown() {
		return dropdown;
	}
	public void setDropdown(boolean dropdown) {
		this.dropdown = dropdown;
	}
	public ArrayList<Menu> getListSubMenu() {
		return listSubMenu;
	}
	public void setListSubMenu(ArrayList<Menu> listSubMenu) {
		this.listSubMenu = listSubMenu;
	}
	public Menu(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
