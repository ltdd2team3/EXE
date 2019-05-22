package com.example.myapplication.model;

public class Thongke {
private String mSanPham;
private int mDoanhso;
private int mDoanhthu;


public Thongke(String mSanPham, int mDoanhso, int mDoanhthu) {
	super();
	this.mSanPham = mSanPham;
	this.mDoanhso = mDoanhso;
	this.mDoanhthu = mDoanhthu;
}
public String getmSanPham() {
	return mSanPham;
}
public void setmSanPham(String mSanPham) {
	this.mSanPham = mSanPham;
}
public int getmDoanhso() {
	return mDoanhso;
}
public void setmDoanhso(int mDoanhso) {
	this.mDoanhso = mDoanhso;
}
public int getmDoanhthu() {
	return mDoanhthu;
}
public void setmDoanhthu(int mDoanhthu) {
	this.mDoanhthu = mDoanhthu;
}


}
