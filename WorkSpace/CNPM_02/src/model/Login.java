package model;

public abstract class Login {
	protected String id;
	protected String secret;
	protected String token;
	protected String url_Redirect;
	
	public abstract String getToken();
	public abstract boolean login(); 
}
