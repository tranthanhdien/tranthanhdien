package ttdien.rmi.model;

public class Product {
	private String idsp;
	private String name;
	private int count;
	private double price;

	public Product() {
		super();
	}

	public Product(String idsp, String name, int count, double price) {
		super();
		this.idsp = idsp;
		this.name = name;
		this.count = count;
		this.price = price;
	}

	public String getIdsp() {
		return idsp;
	}

	public void setIdsp(String idsp) {
		this.idsp = idsp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return idsp + "\t" + name + "\t" + count + "\t" + price + "\n";
	}

}
