package com.example.myapplication.model;

import java.io.Serializable;

public class HoaDon implements Serializable {
private int mMaHD;
private String mNgay;
private int mThanhtien;
public int getmMaHD() {
	return mMaHD;
	
	
}
public HoaDon() {
	super();
}
public HoaDon(String mNgay, int mThanhtien) {
	super();
	this.mNgay = mNgay;
	this.mThanhtien = mThanhtien;
}
public HoaDon(int mMaHD, String mNgay, int mThanhtien) {
	super();
	this.mMaHD = mMaHD;
	this.mNgay = mNgay;
	this.mThanhtien = mThanhtien;
}
public void setmMaHD(int mMaHD) {
	this.mMaHD = mMaHD;
}
public String getmNgay() {
	return mNgay;
}
public void setmNgay(String mNgay) {
	this.mNgay = mNgay;
}
public int getmThanhtien() {
	return mThanhtien;
}
public void setmThanhtien(int mThanhtien) {
	this.mThanhtien = mThanhtien;
}



}
