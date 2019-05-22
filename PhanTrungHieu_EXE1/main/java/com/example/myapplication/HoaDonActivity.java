package com.example.myapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.adapter.HoaDonAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.HoaDon;

public class HoaDonActivity extends Activity {
	ArrayList<HoaDon> arrayHoadon = new ArrayList<HoaDon>();
	HoaDonAdapter adapter;
	Cursor cursor;

	DBManager db;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hoa_don);
		lv = (ListView)findViewById(R.id.lv_hd);
		db = new DBManager(this);
		display();
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent in = new Intent(HoaDonActivity.this, ChiTietHDActivity.class);
				in.putExtra("CTHD", adapter.getItem(arg2));
				startActivity(in);
			}
		});
	}
public void display(){
	
	cursor = db.getAllHoaDon();
	if (adapter==null){
	while (cursor.moveToNext()){
		arrayHoadon.add(new HoaDon(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
	}
adapter = new HoaDonAdapter(this, R.layout.item_list_hoadon, arrayHoadon);
lv.setAdapter(adapter);
	}else {
adapter.notifyDataSetChanged();
	}
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hoa_don, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
