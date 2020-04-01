package DAO;

import java.util.HashMap;
import java.util.Map;

public class NgonNguDAO {
	public static Map<String, String> getEnglishLanguage() {
		Map<String, String> result = new HashMap<>();
		result.put("title", "Login with Social Media or Manually");
		result.put("facebook", "Login with facebook");
		result.put("twitter", "Login with Twitter");
		result.put("google", "Login with Google+");
		result.put("signup", "Sign Up");
		
		result.put("username", "Username");
		result.put("password", "Password");
		result.put("login", "Login");
		result.put("forgot", "Forgot password?");
		
		
		return result;
	}
	public static Map<String, String> getVietnameseLanguage() {
		Map<String, String> result = new HashMap<>();
		result.put("title", "Đăng nhập với mạng xã hội");
		result.put("facebook", "Đăng nhập với Facebook");
		result.put("twitter", "Đăng nhập với Twitter");
		result.put("google", "Đăng nhập với Google+");
		result.put("signup", "Đăng kí");
		
		result.put("username", "Tên đăng nhập");
		result.put("password", "Mật khẩu");
		result.put("login", "Đăng nhập");
		result.put("forgot", "Quên mật khẩu?");
		
		
		return result;
	}

}
