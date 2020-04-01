package model;

public class Product {
	private int id;
	private String name;
	private String imgUrl;
	private int price;
	private double perSale;

	public Product() {
		super();
	}

	public Product(int id, String name, String imgUrl, int price, double perSale) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.perSale = perSale;
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}

	public String getUrl() {
		return imgUrl;
	}
	public double getPerSale() {
		return perSale;
	}

	public void setPerSale(double perSale) {
		this.perSale = perSale;
	}

}
