package model_product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductDAO {

	public ArrayList<Product> getListProduct();

	public ArrayList<Product> queryTypeProduct(String type);

	public ArrayList<Product> queryGroupProduct(String group);

	public boolean addProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh);

	public boolean editProduct(int id, String name, String decription, double price, double discount,
			int soLuongTrongKho, String type, String group, String linkHA1, String linkHA2, String linkHA3,
			double congSuat, String dienAp, int baoHanh);

	public boolean removeProduct(int id);
	public Product exportToExcel() throws SQLException;

}
