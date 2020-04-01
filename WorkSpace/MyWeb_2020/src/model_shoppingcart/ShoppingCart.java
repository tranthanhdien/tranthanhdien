package model_shoppingcart;

import java.util.ArrayList;
import java.util.List;

import model_product.Product;
import model_product.ProductDAO;

//cai nay la cai gio hang 
public class ShoppingCart {
	private List<ItemCart> listItemcart;

	public ShoppingCart() {
		super();
		this.listItemcart = new ArrayList<>();
	}

	public List<ItemCart> getListCart() {
		return listItemcart;
	}

	public List<ItemCart> getListItemcart() {
		return listItemcart;
	}

	public void setListItemcart(List<ItemCart> listItemcart) {
		this.listItemcart = listItemcart;
	}

	public void setListCart(List<ItemCart> listCart) {
		this.listItemcart = listCart;
	}

	// các phương thức truy xuất trong giỏ hàng

	// thêm sản phẩm vào giỏ
	public void addProduct(ItemCart item) {
		listItemcart.add(item);
	}

	// tim kiem san pham da ton tai trong gio hang chua
	public ItemCart lookup(int code) {
		for (int i = 0; i < listItemcart.size(); i++) {
			ItemCart item = listItemcart.get(i);
			if (code == item.getP().getId())
				return item;

		}
		return null;

	}

	//
	public static ItemCart lookupA(int code, ArrayList<ItemCart> list) {
		for (int i = 0; i < list.size(); i++) {
			ItemCart item = list.get(i);
			if (code == item.getP().getId())
				return item;
		}
		return null;

	}

	// xoa san pham trong gio hang
	public void removeItemCart(int code) {
		for (ItemCart itemCart : listItemcart) {
			if (itemCart.getP().getId() == code) {
				listItemcart.remove(itemCart);
			}
		}
	}

	public int sizeCart() {
		return listItemcart.size();
	}
	// sua 1 san pham trong gio hang

	// Tăng số lượng sản phẩm trong giỏ hàng
	public boolean tangQuantity(int index) {
		// lay item cart tai vi tri index
		ItemCart item = listItemcart.get(index);
		int quantity = item.getQuantity();
		// tim san pham co ma ID trong DB
		Product p = new ProductDAO().lookUp(item.getP().getId());
		int soLuongTrongKho = p.getSoLuongTrongKho();
		int newQuantity = quantity + 1;
		if (soLuongTrongKho >= newQuantity) {
			item.setQuantity(quantity + 1);
			return true;
		} else {
			item.setQuantity(quantity);
			return false;
		}

	}

	// giam toi 1 thi ngung
	public boolean giamQuantity(int index) {
		// lay item cart tai vi tri index
		ItemCart item = listItemcart.get(index);
		int quantity = item.getQuantity();
		if (quantity <= 1) {
			item.setQuantity(1);
			return false;
		} else {
			item.setQuantity(quantity - 1);
			return true;
		}

	}

	// tinh tong tien thanh toan
	public double totalPrice() {
		double result = 0.0;
		for (ItemCart itemCart : listItemcart) {
			result += itemCart.getQuantity() * itemCart.getP().getPrice();
		}
		return result;
	}

	// cap nhat lai so luong san pham trong kho sau khi dat hang thanh cong
	public void updateQuantityProduct(List<ItemCart> list) {
		for (ItemCart i : list) {
			Product p = i.getP();
			// b1: lay quantity khach hang mua
			int quatity = i.getQuantity();
			// b2: lay quantity cua Product duoi DB
			Product pDB = new ProductDAO().lookUp(p.getId());
			int quantityNew = pDB.getSoLuongTrongKho() - quatity;
			new ProductDAO().updateQuatity(p.getId(), quantityNew);

		}

	}

	// phuong thuc tinh so luong san pham thuc te
	public int numberProduct() {
		int number = 0;
		for (ItemCart item : listItemcart) {
			number += item.getQuantity();
		}
		return number;
	}

}
