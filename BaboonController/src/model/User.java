package model;

public class User {
	public String username;
	public String password;
	public String role;
	
	public User() {
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}	
}