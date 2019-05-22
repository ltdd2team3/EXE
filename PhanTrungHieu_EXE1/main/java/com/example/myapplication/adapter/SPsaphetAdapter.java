package com.example.myapplication.adapter;

import java.util.List;

import com.example.myapplication.R;
import com.example.myapplication.model.SanPham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SPsaphetAdapter extends ArrayAdapter<SanPham>{

	public SPsaphetAdapter(Context context, int resource, List<SanPham> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	
	View view = convertView;
	if (view==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item_list_spsh, null);
	}
	SanPham sanpham = getItem(position);
	if (sanpham!=null){
		TextView txtTen = (TextView)view.findViewById(R.id.tv_shten);
		TextView txtSoluong = (TextView)view.findViewById(R.id.tv_shsl);
		txtTen.setText(sanpham.getmTenSP());
		txtSoluong.setText(String.valueOf(sanpham.getmSoLuong()));
	}
	return view;
}
}
