package model;

import java.util.ArrayList;

public class ProductDAO implements IDAO {
	static ArrayList<Product> listProduct;

	@Override
	public ArrayList<Product> getListProduct() {

		if (listProduct == null) {
			listProduct = new ArrayList<>();
		}
		if (listProduct.size() == 0) {
			listProduct.add(new Product(8023, "Sách khoa học",

					285000, 280000, "imageLab4/mwc.jpg"));
			listProduct.add(new Product(5156, "Sách vật lý",

					235000, 230000, "imageLab4/giayTheThao.jpg"));
			listProduct.add(new Product(7014, "Sách văn học",

					150000, 150000, "imageLab4/mwc1.jpg"));
			listProduct.add(new Product(5151, "Sách thư giãn",

					285000, 250000, "imageLab4/mwc2.jpg"));
			listProduct.add(new Product(5553, "Sách sinh học",

					295000, 285000, "imageLab4/mwc3.jpg"));
			listProduct.add(new Product(5149, "Sách tin học",

					295000, 280000, "imageLab4/mwc4.jpg"));
		}

		return listProduct;
	}

	public Product lookUp(int id, ArrayList<Product> list) {
		for (Product p : list) {
			if (id == p.getId()) {
				return p;
			}
		}
		return null;

	}

	@Override
	public boolean add(int id, String name, double price, double cost, String link) {
		Product p = lookUp(id, listProduct);
		if (p == null) {
			listProduct.add(new Product(id, name, price, cost, link));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(int id) {
		Product p = lookUp(id, listProduct);
		if (p == null) {

			return false;
		} else {
			listProduct.remove(p);
			return true;
		}

	}

	@Override
	public boolean edit(int id, String name, double price, double cost, String link) {
		Product p = lookUp(id, listProduct);
		if (p != null) {
			p.setId(id);
			p.setName(name);
			p.setCost(cost);
			p.setPrice(price);
			p.setLinkImage(link);
			return true;
		} else {
			return false;
		}
	}

}
