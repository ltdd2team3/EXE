package com.example.myapplication;

import java.util.ArrayList;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.SanPham;

public class QLSanPhamActivity extends Activity {
	ImageButton ibtAddnewSP, ibtnback;
	ArrayList<SanPham> arraySanpham = new ArrayList<SanPham>();
	SanPhamAdapter adapter;
	Cursor cursor;
	DBManager dbmanager;
	ListView lv;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qlsan_pham);
		lv = (ListView)findViewById(R.id.lv_SP);
		ibtAddnewSP = (ImageButton)findViewById(R.id.ibnThemHang);
		ibtnback=(ImageButton)findViewById(R.id.ibtnQlspback);
		dbmanager = new DBManager(this);
		displaySP();
		ibtnback.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), SanPhamActivity.class);
				startActivity(i);	
			}
		});
		ibtAddnewSP.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ThemHangActivity.class);
				startActivityForResult(i, 0);
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(QLSanPhamActivity.this, EditSPActivity.class);
				intent.putExtra("Edit", adapter.getItem(arg2));
				startActivity(intent);
			}
		});

		
	}
	public void displaySP(){
		cursor = dbmanager.getAllSanPham();
		while (cursor.moveToNext()){
			arraySanpham.add(new SanPham(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getBlob(5)));
		}
	adapter = new SanPhamAdapter(this, R.layout.item_list_sanpham, arraySanpham);		
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qlsan_pham, menu);
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
