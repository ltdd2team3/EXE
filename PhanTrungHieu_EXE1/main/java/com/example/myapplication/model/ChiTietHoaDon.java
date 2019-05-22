package com.example.myapplication.model;

import java.io.Serializable;

public class ChiTietHoaDon {
private int mMaCTHD;
private String mMaHD;
private String SanPham;
private int mSoLuong;
private int mDonGia;
private int mTien;

public ChiTietHoaDon() {
	super();
}
public ChiTietHoaDon(String mMaHD, String sanPham, int mSoLuong, int mDonGia,
		int mTien) {
	super();
	this.mMaHD = mMaHD;
	SanPham = sanPham;
	this.mSoLuong = mSoLuong;
	this.mDonGia = mDonGia;
	this.mTien = mTien;
}
public ChiTietHoaDon(int mMaCTHD, String mMaHD, String sanPham, int mSoLuong,
		int mDonGia, int mTien) {
	super();
	this.mMaCTHD = mMaCTHD;
	this.mMaHD = mMaHD;
	SanPham = sanPham;
	this.mSoLuong = mSoLuong;
	this.mDonGia = mDonGia;
	this.mTien = mTien;
}
public int getmMaCTHD() {
	return mMaCTHD;
}
public void setmMaCTHD(int mMaCTHD) {
	this.mMaCTHD = mMaCTHD;
}
public String getmMaHD() {
	return mMaHD;
}
public void setmMaHD(String mMaHD) {
	this.mMaHD = mMaHD;
}
public String getSanPham() {
	return SanPham;
}
public void setSanPham(String sanPham) {
	SanPham = sanPham;
}
public int getmSoLuong() {
	return mSoLuong;
}
public void setmSoLuong(int mSoLuong) {
	this.mSoLuong = mSoLuong;
}
public int getmDonGia() {
	return mDonGia;
}
public void setmDonGia(int mDonGia) {
	this.mDonGia = mDonGia;
}
public int getmTien() {
	return mTien;
}
public void setmTien(int mTien) {
	this.mTien = mTien;
}

}
