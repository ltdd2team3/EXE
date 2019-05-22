package com.example.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.HoaDon;

public class HoaDonAdapter extends ArrayAdapter<HoaDon> {
	Context context;
	int resource;
	List<HoaDon> objects = null;
	public HoaDonAdapter(Context context, int resource, List<HoaDon> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub	
	View view = convertView;
	if (view==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item_list_hoadon, null);
	}
	HoaDon hoadon = getItem(position);
	if(hoadon!=null){
		TextView txtID= (TextView)view.findViewById(R.id.tv_idhd);
		TextView txtNgay= (TextView)view.findViewById(R.id.tv_ngayhd);
		TextView txtThanhtien= (TextView)view.findViewById(R.id.tv_thanhtienhd);
		txtID.setText(String.valueOf(hoadon.getmMaHD()));
		txtNgay.setText(hoadon.getmNgay());
		txtThanhtien.setText(String.valueOf(hoadon.getmThanhtien()));
		
	}
	return view;
}
}
