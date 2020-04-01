package model_dao;

import java.util.ArrayList;

import model.Product;

public  class ProductDAO implements IDAO {
	static ArrayList<Product> listProduct;

	@Override
	public ArrayList<Product> getListProduct() {
		if (listProduct == null) {
			listProduct = new ArrayList<>();
		}
		if (listProduct.size() == 0) {
			// add SP vao
			listProduct.add(new Product(111, "Giấy vệ sinh", 12.000, "image/h1.jpg"));
			listProduct.add(new Product(222, "Tả em bé", 12.000, "image/h2.jpg"));
			listProduct.add(new Product(333, "Giày cao gót", 12.000, "image/h3.jpg"));
			listProduct.add(new Product(444, "Sửa bò", 12.000, "image/h4.jpg"));
			listProduct.add(new Product(555, "Sữa MIlo", 12.000, "image/h5.jpg"));
			listProduct.add(new Product(666, "Gà quay", 99.000, "image/h6.jpg"));
			listProduct.add(new Product(777, "Vịt luộc", 120.000, "image/h7.jpg"));

		}

		return listProduct;
	}

	public Product lookUp(int id, ArrayList<Product> list) {
		for (Product p : list) {
			if (p.getId() == id) {
				return p;
			}

		}
		return null;
	}


}
