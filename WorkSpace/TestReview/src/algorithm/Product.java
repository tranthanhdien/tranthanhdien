package algorithm;

public class Product implements Comparable<Product>{
	private String idProduct;
	private String nameProduct;
	private int price;
	private int quantity;
	public Product(String idProduct, String nameProduct, int price, int quantity) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.price = price;
		this.quantity = quantity;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int compareTo(Product p) {
		return this.idProduct.compareTo(p.idProduct);
	}
	@Override
	public String toString() {
		return idProduct + "\t" + nameProduct + "\t" + price + "\t" + quantity;
	}
	

}
