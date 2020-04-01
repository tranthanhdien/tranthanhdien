package model_shoppingcart;



import java.util.Date;

import model_shoppingcart.ShoppingCart;
import model_user.Customer;

public class Invoice {

	private int numberInvoice;
	private Customer user;
	private Date today;
	private ShoppingCart shop;//danh sach cac san pham + so luong
	private boolean isProcess;

	
	public Invoice() {
		super();
	}

	public Invoice(int numberInvoice, Customer user, Date today, ShoppingCart shop, boolean isProcess) {
		super();
		this.numberInvoice = numberInvoice;
		this.user = user;
		this.today = today;
		this.shop = shop;
		this.isProcess = isProcess;
	}

	public boolean isProcess() {
		return isProcess;
	}

	public void setProcess(boolean isProcess) {
		this.isProcess = isProcess;
	}

	public int getNumberInvoice() {
		return numberInvoice;
	}

	public void setNumberInvoice(int numberInvoice) {
		this.numberInvoice = numberInvoice;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public ShoppingCart getShop() {
		return shop;
	}

	public void setShop(ShoppingCart shop) {
		this.shop = shop;
	}

}
