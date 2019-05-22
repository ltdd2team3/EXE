package com.example.myapplication.adapter;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Thongke;

public class ThongkeAdapter extends ArrayAdapter<Thongke> {

	
public ThongkeAdapter(Context context, int resource, List<Thongke> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
View view = convertView;
	
	if (view==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.list_item_thongke, null);
	}
	Thongke thongke = getItem(position);
	if (thongke!=null){
		TextView txtTen = (TextView)view.findViewById(R.id.txtSP_thongke);
		TextView txtDoanhso = (TextView)view.findViewById(R.id.txtdoanhso_thongke);
		TextView txtDoanhthu = (TextView)view.findViewById(R.id.txtdoanhthu_thongke);
		txtTen.setText(thongke.getmSanPham());
		txtDoanhso.setText(String.valueOf(thongke.getmDoanhso()));
		txtDoanhthu.setText(String.valueOf(thongke.getmDoanhthu()));
	}
	// TODO Auto-generated method stub
	return view;
}
}
