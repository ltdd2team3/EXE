package com.example.myapplication.model;

public class Users {
	private int mID;
	private String mUsername;
	private String mPassword;
	private int mPermission;

	public Users(String mUsername, String mPassword, int mPermission) {
		super();
		this.mUsername = mUsername;
		this.mPassword = mPassword;
		this.mPermission = mPermission;
	}

	public Users(int mID, String mUsername, String mPassword, int mPermission) {
		super();
		this.mID = mID;
		this.mUsername = mUsername;
		this.mPassword = mPassword;
		this.mPermission = mPermission;
	}
	public Users(String mUsername, String mPassword) {
		super();
		this.mUsername = mUsername;
		this.mPassword = mPassword;
		
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public int getmPermission() {
		return mPermission;
	}

	public void setmPermission(int mPermission) {
		this.mPermission = mPermission;
	}

}
