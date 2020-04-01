package model_DAO;

public class Data {
	private int idUser;
	private int idInvoice;
	private String username;
	private String password;
	private String address;
	private String email;
	private String date;
	private String amount;

	public Data() {
		super();
	}

	public Data(int idUser, int idInvoice, String username, String password, String address, String email, String date,
			String amount) {
		super();
		this.idUser = idUser;
		this.idInvoice = idInvoice;
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.date = date;
		this.amount = amount;
	}

	public int getIdUser() {
		return idUser;
	}

	public int getIdInvoice() {
		return idInvoice;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}

	public String getAmount() {
		return amount;
	}
	

}
