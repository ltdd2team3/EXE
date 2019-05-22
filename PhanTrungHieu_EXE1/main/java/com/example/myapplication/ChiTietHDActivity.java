package com.example.myapplication;

import java.util.ArrayList;

import com.example.myapplication.adapter.CTHoaDonAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.ChiTietHoaDon;
import com.example.myapplication.model.HoaDon;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class ChiTietHDActivity extends Activity {
	ArrayList<ChiTietHoaDon> arrCTHD = new ArrayList<ChiTietHoaDon>();
	CTHoaDonAdapter adapter;
	Cursor cursor;
	DBManager db;
	ListView lv;
	String mhd;
HoaDon hoadon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chi_tiet_hd);
		lv = (ListView)findViewById(R.id.lv_cthd);
		
		db = new DBManager(this);
		getData();
		display();
		
		
	}
	public void getData(){
		if (getIntent().getExtras()!=null){
			hoadon = (HoaDon) getIntent().getSerializableExtra("CTHD");
			mhd = String.valueOf(hoadon.getmMaHD());
		}
	}
	public void display(){
		
		cursor = db.getAllCTHoaDon(mhd);
		if (adapter==null){
			while (cursor.moveToNext()){
				arrCTHD.add(new ChiTietHoaDon(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
			}
			adapter = new CTHoaDonAdapter(this, R.layout.item_list_cthoadon, arrCTHD);
			lv.setAdapter(adapter);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chi_tiet_hd, menu);
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
