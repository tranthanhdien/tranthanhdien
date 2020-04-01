package model_product;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private int soLuongTrongKho;
	private String type;
	private String nhom;
	private String linkHA1;
	private String linkHA2;
	private String linkHA3;
	private Double congSuat;
	private String dienAp;
	private int baoHanh;

	public Product(int id, String name, double price, double discount, String linkHA1) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.linkHA1 = linkHA1;
	}

	public Product(int id, String name, String description, double price, double discount, int soLuongTrongKho,
			String type, String nhom, String linkHA1, String linkHA2, String linkHA3, Double congSuat, String dienAp,
			int baoHanh) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.soLuongTrongKho = soLuongTrongKho;
		this.type = type;
		this.nhom = nhom;
		this.linkHA1 = linkHA1;
		this.linkHA2 = linkHA2;
		this.linkHA3 = linkHA3;
		this.congSuat = congSuat;
		this.dienAp = dienAp;
		this.baoHanh = baoHanh;
	}
// mã, tên, giá bán, hình ảnh, mô tả
	public Product(int id, String name, double price, String linkHA1, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.linkHA1 = linkHA1;
		this.description = description;
	}

	public String getNhom() {
		return nhom;
	}

	public void setNhom(String nhom) {
		this.nhom = nhom;
	}

	public void setCongSuat(Double congSuat) {
		this.congSuat = congSuat;
	}

	// khong co HA
	public Product(int id, String name, String description, double price, double discount, int soLuongTrongKho,
			String type, double congSuat, String dienAp, int baoHanh) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.soLuongTrongKho = soLuongTrongKho;
		this.type = type;
		this.congSuat = congSuat;
		this.dienAp = dienAp;
		this.baoHanh = baoHanh;

	}

	public Product(int id, String name, String description, double price, double discount, int soLuongTrongKho,
			String type, String linkHA1, double congSuat, String dienAp, int baoHanh) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.soLuongTrongKho = soLuongTrongKho;

		this.type = type;
		this.linkHA1 = linkHA1;
		this.congSuat = congSuat;
		this.dienAp = dienAp;
		this.baoHanh = baoHanh;

	}

	public Product(int id, String name, String description, double price, double discount, int soLuongTrongKho,
			String type, String linkHA1, String linkHA2, double congSuat, String dienAp, int baoHanh) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.soLuongTrongKho = soLuongTrongKho;

		this.type = type;
		this.linkHA1 = linkHA1;
		this.linkHA2 = linkHA2;
		this.congSuat = congSuat;
		this.dienAp = dienAp;
		this.baoHanh = baoHanh;

	}

	public Product(int id, String name, String description, double price, double discount, int soLuongTrongKho,
			String type, String linkHA1, String linkHA2, String linkHA3, double congSuat, String dienAp, int baoHanh) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.soLuongTrongKho = soLuongTrongKho;

		this.type = type;
		this.linkHA1 = linkHA1;
		this.linkHA2 = linkHA2;
		this.linkHA3 = linkHA3;
		this.congSuat = congSuat;
		this.dienAp = dienAp;
		this.baoHanh = baoHanh;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getSoLuongTrongKho() {
		return soLuongTrongKho;
	}

	public void setSoLuongTrongKho(int soLuongTrongKho) {
		this.soLuongTrongKho = soLuongTrongKho;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLinkHA1() {
		return linkHA1;
	}

	public void setLinkHA1(String linkHA1) {
		this.linkHA1 = linkHA1;
	}

	public String getLinkHA2() {
		return linkHA2;
	}

	public void setLinkHA2(String linkHA2) {
		this.linkHA2 = linkHA2;
	}

	public String getLinkHA3() {
		return linkHA3;
	}

	public void setLinkHA3(String linkHA3) {
		this.linkHA3 = linkHA3;
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		this.congSuat = congSuat;
	}

	public String getDienAp() {
		return dienAp;
	}

	public void setDienAp(String dienAp) {
		this.dienAp = dienAp;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	// phuong thuc tinh:
	// 1. so phan tram giam gia
	public int phanTramGiamGia() {
		return 100 - ((int) (this.price * 100 / this.discount));

	}

	public double soTienGiamGia() {
		return this.discount - this.price;
	}

}
