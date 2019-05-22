package com.example.myapplication.adapter;

import java.util.List;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham>{

	public SanPhamAdapter(Context context, int resource, List<SanPham> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	View view = convertView;
	if (view ==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item_list_sanpham, null);
	}
	SanPham sanpham = getItem(position);
	if (sanpham!=null){
		ImageView imgHinhdaidien = (ImageView)view.findViewById(R.id.imgAnhSP);
		TextView txtTen = (TextView)view.findViewById(R.id.tv_tensp_list);
		TextView txtSoluong = (TextView)view.findViewById(R.id.lv_Soluong);
		TextView txtGia = (TextView)view.findViewById(R.id.tv_giasp_list);
		TextView txtDanhmuc = (TextView)view.findViewById(R.id.lv_Danhmuc);
		byte[] hinhAnh = sanpham.getmAnh();
		Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
		imgHinhdaidien.setImageBitmap(bitmap);
		txtTen.setText(sanpham.getmTenSP());
		
		txtSoluong.setText(String.valueOf(sanpham.getmSoLuong()));
		txtGia.setText(String.valueOf(sanpham.getmGiaban()));
		txtDanhmuc.setText(sanpham.getmDanhMuc());
	}
	return view;
}
}
