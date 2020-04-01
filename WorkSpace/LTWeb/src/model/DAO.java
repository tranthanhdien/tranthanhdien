package model;

import java.util.ArrayList;

public class DAO {
	private static ArrayList<Product> listProduct;

	public static ArrayList<Product> getListProduct() {
		if (DAO.listProduct == null) {
			listProduct = new ArrayList<Product>();
		}
		if (DAO.listProduct.size() == 0) {
			listProduct.add(new Product(1, "Máy quạt", "image/phone.jpg", 255000, 10.000));
			listProduct.add(new Product(2, "Máy quạt", "image/phone.jpg", 255000, 10.000));
			listProduct.add(new Product(3, "Máy quạt", "image/phone.jpg", 255000, 10.000));
			listProduct.add(new Product(4, "Máy quạt", "image/phone.jpg", 255000, 10.000));
			listProduct.add(new Product(5, "Máy quạt", "image/phone.jpg", 255000, 10.000));
			listProduct.add(new Product(6, "Máy quạt", "image/phone.jpg", 255000, 10.000));

		}
		return DAO.listProduct;
	}

}
