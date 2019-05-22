package com.example.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.R;
import com.example.myapplication.model.ChiTietHoaDon;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CTHoaDonAdapter extends ArrayAdapter<ChiTietHoaDon> {
	Context context;
	int resource;
	List<ChiTietHoaDon> objects = null;
	
public CTHoaDonAdapter(Context context, int resource,
			List<ChiTietHoaDon> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	View view = convertView;
	
	if (view==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item_list_cthoadon, null);

	}
	ChiTietHoaDon cthoadon = getItem(position);
	if (cthoadon!=null){
		TextView txtSanpham = (TextView)view.findViewById(R.id.tv_ctsp);
		TextView txtSL = (TextView)view.findViewById(R.id.ctsl);
		TextView txtDongia = (TextView)view.findViewById(R.id.ctdongia);
		TextView txtTien = (TextView)view.findViewById(R.id.tv_cttien);
		txtSanpham.setText(cthoadon.getSanPham());
		txtSL.setText(String.valueOf(cthoadon.getmSoLuong()));
		txtDongia.setText(String.valueOf(cthoadon.getmDonGia()));
		txtTien.setText(String.valueOf(cthoadon.getmTien()));
	}
	return view;
}
}
