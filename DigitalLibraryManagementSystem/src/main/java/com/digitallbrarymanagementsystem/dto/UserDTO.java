package com.digitallbrarymanagementsystem.dto;

public class UserDTO {
	
	private long uID;
	private String userName;
	private boolean isAdmin;
	
	
	public UserDTO(long uID, String userName, boolean isAdmin) {
		this.uID = uID;
		this.userName = userName;
		this.isAdmin = isAdmin;
	}
	public long getuID() {
		return uID;
	}
	public void setuID(long uID) {
		this.uID = uID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
	
	
	

}
