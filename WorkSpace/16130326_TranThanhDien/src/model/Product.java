package model;

public class Product {
	int id;
	String name;
	double price;
	double cost;
	String linkImage;
	public Product(int id, String name, double price, double cost, String linkImage) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.linkImage = linkImage;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getLinkImage() {
		return linkImage;
	}
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	
	
}
