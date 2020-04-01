package test;

public class Product {
	private int id;
	private String name;
	private int price;
	private double perSale;

	public Product() {
		super();
	}

	public Product(int id, String name, int price, double perSale) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.perSale = perSale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getPerSale() {
		return perSale;
	}

	public void setPerSale(double perSale) {
		this.perSale = perSale;
	}
	
	

}
