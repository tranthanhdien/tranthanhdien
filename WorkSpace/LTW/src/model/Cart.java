package model;

import java.util.HashMap;
import java.util.Map;

// lớp giỏ hàng
// Thêm sản phẩm vào giỏ hàng, cập nhật giỏ hàng, xóa giỏ hàng, tính tổng số lượng sản phẩm và tổng tiền có trong giỏ hàng.
public class Cart {
	private HashMap<Long, Item> cartItems;

	public Cart() {
		this.cartItems = new HashMap<>();
	}

	public Cart(HashMap<Long, Item> cartItems) {
		this.cartItems = cartItems;
	}

	public HashMap<Long, Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Long, Item> cartItems) {
		this.cartItems = cartItems;
	}

	// thêm 1 sản phẩm vào giỏ hàng
	public void plusToCart(Long key, Item item) {
		boolean check = cartItems.containsKey(key);
		if (check) {
			int quantity_old = item.getQuantity(); // lấy số lượng cũ
			item.setQuantity(quantity_old + 1);
			cartItems.put(item.getProduct().getProductID(), item);
		} else {
			cartItems.put(item.getProduct().getProductID(), item);
		}
	}

	// xoá đi 1 sản phẩm trong giỏ hàng
	public void subToCart(Long key, Item item) {
		boolean check = cartItems.containsKey(key);
		if (check) {
			int quantity_old = item.getQuantity(); // lấy số lượng cũ\
			if (quantity_old <= 1) {
				cartItems.remove(key);
			} else {
				item.setQuantity(quantity_old - 1);
				cartItems.put(item.getProduct().getProductID(), item);
			}
		}
	}

	// xoá sản phẩm ra khỏi giỏ hàng
	public void removeToCart(Long product) {
		boolean check = cartItems.containsKey(product);
		if (check) {
			cartItems.remove(product);
		}
	}

	// tính tổng sản phẩm trong giỏ hàng
	public int countItem() {
		int count = 0;
		count = cartItems.size();
		return count;
	}

	// tính tổng tiền trong giỏ
	public double totalMoney() {
		double total = 0;
		for (Map.Entry<Long, Item> item : cartItems.entrySet()) {
			total += item.getValue().getProduct().getProductPrice() * item.getValue().getQuantity();
		}
		return total;
	}

}
