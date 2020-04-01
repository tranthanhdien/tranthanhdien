package test;
import model_LoginAccount.LoginDAO;

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

}
