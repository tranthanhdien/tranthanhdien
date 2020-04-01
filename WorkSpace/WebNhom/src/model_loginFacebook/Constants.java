package model_loginFacebook;

//dung de khai bao id, secret, redirect_url cua ung dung 
public class Constants {
	public static String FACEBOOK_APP_ID = "1517204811748325";
	public static String FACEBOOK_APP_SECRET = "b4da85ddc0c2bc543452b36b9620cd2c";
	public static String FACEBOOK_REDIRECT_URL = "https://localhost:8080/WebProject_Backup/LoginFacebook";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
