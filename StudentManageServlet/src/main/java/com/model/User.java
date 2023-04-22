package com.model;

public class User {
	private String _username;
	private String _password;
	
	public User(String username, String password) {
		_username = username;
		_password = password;
	}
	
	public String getUsername()
	{
		return this._username;
	}
	
	public String getPassword()
	{
		return this._password;
	}
	
	public boolean checkLogin()
	{
		if(_username.compareTo("21120577") == 0)
			return true;
		return false;
	}

}
