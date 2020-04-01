package model;

import model_Account.LoginDAO;

public class LoginAccount extends Login {
	private String userName;
	private String password;

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean login(String userName, String password) {
		if (LoginDAO.checkInfo(userName, password)) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		String username = "ttdien";
		String password = "dien1998";
		if(LoginAccount.login(username, password)) {
			System.out.println("Thành công");
		} else {
			System.out.println("Thất bại");
		}
	}

}
