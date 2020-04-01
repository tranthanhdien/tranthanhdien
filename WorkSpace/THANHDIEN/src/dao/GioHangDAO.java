package dao;

import java.util.ArrayList;

import model.Product;

public class GioHangDAO {
	public static ArrayList<Product> listProducts = new ArrayList<>();
	public static ArrayList<Product> listCart = new ArrayList<>();

	public GioHangDAO() {
		listProducts.removeAll(listProducts);
		Product p1 = new Product(1, "LAPTOP DELL", "imagelab5/dell.jpg", 1000000, 1);
		Product p2 = new Product(2, "LAPTOP ASUS", "imagelab5/asus.jpg", 1200000, 1);
		Product p3 = new Product(3, "LAPTOP HP", "imagelab5/hp.jpg", 1500000, 1);
		Product p4 = new Product(4, "LAPTOP ACER", "imagelab5/acer.jpg", 1100000, 1);
		Product p5 = new Product(5, "LAPTOP APPLE", "imagelab5/apple.jpg", 1300000, 1);
		Product p6 = new Product(6, "LAPTOP ATTITUDE", "imagelab5/attitude.jpg", 1500000, 1);
		Product p7 = new Product(7, "LAPTOP VAIO", "imagelab5/vaio.jpg", 1100000, 1);
		Product p8 = new Product(8, "LAPTOP SONY", "imagelab5/sony.jpg", 1300000, 1);
		listProducts.add(p1);
		listProducts.add(p2);
		listProducts.add(p3);
		listProducts.add(p4);
		listProducts.add(p5);
		listProducts.add(p6);
		listProducts.add(p7);
		listProducts.add(p8);
	}
	public static ArrayList<Product> getListBooks() {
		return listProducts;
	}

	public static ArrayList<Product> getListCart() {
		return listCart;
	}
	public boolean addProduct(int id) {
		boolean check = checkDuplicateId(id);
		for (int i = 0; i < listProducts.size(); i++) {
			if (listProducts.get(i).getId() == id && check == false) {
				listCart.add(listProducts.get(i));
				return true;
			}
		}
		if (check == true) { // đã có sản phẩm trong giỏ thì set lại số lượng
			for (int i = 0; i < listCart.size(); i++) {
				if (listCart.get(i).getId() == id) {
					listCart.get(i).setQuantity(listCart.get(i).getQuantity() + 1);
				}
			}
		}
		return false;

	}

	public boolean deleteProduct(int id) {

		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getId() == id) {
				int count = listCart.get(i).getQuantity();
				if (count > 1) {
					listCart.get(i).setQuantity(listCart.get(i).getQuantity()-1);
					// listCart.remove(listCart.get(i));
				} else {
					listCart.remove(listCart.get(i));
					return true;
				}

			}
		}

		return false;
	}
	// ktra sach co trong gio hang chua
	public boolean checkDuplicateId(int id) {
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

}
