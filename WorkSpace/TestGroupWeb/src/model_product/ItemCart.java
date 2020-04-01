package model_product;

public class ItemCart {

	private Product p;
	private int quantity;

	public ItemCart(Product p, int quantity) {
		super();
		this.p = p;
		this.quantity = quantity;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return this.quantity * this.p.getPrice();
	}

}
