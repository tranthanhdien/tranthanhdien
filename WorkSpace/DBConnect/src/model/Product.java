package model;

public class Product {
	private int id;
	private String name;
	private String dvt;
	private String nsx;
	private double price;

	public Product() {
		super();
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, String name, String dvt, String nsx, double price) {
		super();
		this.id = id;
		this.name = name;
		this.dvt = dvt;
		this.nsx = nsx;
		this.price = price;
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

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public String getNsx() {
		return nsx;
	}

	public void setNsx(String nsx) {
		this.nsx = nsx;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double priice) {
		this.price = priice;
	}

}
