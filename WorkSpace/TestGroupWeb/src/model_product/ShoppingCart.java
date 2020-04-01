package model_product;

import java.util.ArrayList;
import java.util.List;

import model_user.Customer;

//cai nay la cai gio hang
public class ShoppingCart {

	// gồm khach hang + cai gio hang da chon

	private Customer customer;
	private List<ItemCart> listItemcart; // list các sản phẩm

	public ShoppingCart(Customer customer) {
		super();
		this.customer = customer;
		this.listItemcart = new ArrayList<>();
	}

	// xu li cac phuong thuc Add, update xoa
	public List<ItemCart> getListCart() {
		return listItemcart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	// ************************cac phuong thuc thuc hien truy suat trong gio hang

	// them san pham vao gio hang
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

	// tang so luong product trong gio hang
	public void tangQuantity(int index) {

		// lay item cart tai vi tri index
		ItemCart item = listItemcart.get(index);

		int quantity = item.getQuantity();

		item.setQuantity(quantity + 1);

	}

	public void giamQuantity(int index) {

		// lay item cart tai vi tri index
		ItemCart item = listItemcart.get(index);
		int quantity = item.getQuantity();

		if (quantity <= 1) {
			item.setQuantity(1);
		} else {
			item.setQuantity(quantity - 1);
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

}
