package model;

public class Category { // lớp loại sản phẩm
	private long categoryID; // id của loại sản phẩm
	private String categoryName; // tên của loại sản phẩm

	public Category() {
		super();
	}

	public Category(long categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
