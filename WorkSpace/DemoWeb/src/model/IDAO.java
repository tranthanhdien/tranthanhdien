package model;

import java.util.ArrayList;

public interface IDAO {
	public ArrayList<Product> getListProduct();
	
	public boolean add(int id, String name, String price, String linkImg, int quantity);
	
	public boolean delete(int id);
	
	public boolean edit(int id, Product p);
	
	public ArrayList<Product> search(String s);

}
