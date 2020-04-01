package model;

import java.util.ArrayList;

public interface IDAO {
	public ArrayList<Product> getListProduct();

	public boolean add(int id, String name, double price, double cost, String link);

	public boolean remove(int id);

	public boolean edit(int id, String name, double price, double cost, String link);

}
