package com.example.myapplication.model;

public class GiamGia {
	private int mID;
	private String mTengiamgia;
	private int mGiatri;
	
	
	public GiamGia(String mTengiamgia, int mGiatri) {
		super();
		this.mTengiamgia = mTengiamgia;
		this.mGiatri = mGiatri;
	}
	public GiamGia(int mID, String mTengiamgia, int mGiatri) {
		super();
		this.mID = mID;
		this.mTengiamgia = mTengiamgia;
		this.mGiatri = mGiatri;
	}
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmTengiamgia() {
		return mTengiamgia;
	}
	public void setmTengiamgia(String mTengiamgia) {
		this.mTengiamgia = mTengiamgia;
	}
	public int getmGiatri() {
		return mGiatri;
	}
	public void setmGiatri(int mGiatri) {
		this.mGiatri = mGiatri;
	}

	
}
