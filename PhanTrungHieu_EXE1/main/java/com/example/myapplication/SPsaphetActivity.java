package com.example.myapplication;

import java.util.ArrayList;



import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.myapplication.adapter.SPsaphetAdapter;
import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.SanPham;

public class SPsaphetActivity extends Activity {
	ArrayList<SanPham> arraySanpham = new ArrayList<SanPham>();
	SPsaphetAdapter adapter;
	Cursor cursor;
	DBManager dbmanager;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spsaphet);
		lv = (ListView)findViewById(R.id.lv_sphh);
		dbmanager = new DBManager(this);
		displaySP();
		
	}
	public void displaySP(){
		cursor = dbmanager.Saphethang();
		while (cursor.moveToNext()){
			arraySanpham.add(new SanPham(cursor.getString(0), cursor.getInt(1)));
		}
	adapter = new SPsaphetAdapter(this, R.layout.item_list_sanpham, arraySanpham);
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spsaphet, menu);
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
