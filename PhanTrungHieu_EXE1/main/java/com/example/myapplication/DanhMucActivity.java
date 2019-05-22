package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.DanhMucAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.DanhMuc;

import android.app.Activity;
import android.app.ListActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DanhMucActivity extends Activity {
	
ImageButton btnThemDM, btnBack;
//SimpleCursorAdapter adapter;
Cursor cursor;
ArrayList<DanhMuc> arrDM = new ArrayList<DanhMuc>();
DanhMucAdapter adapter;
ListView lv;
	int i =0 ;

DBManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danh_muc);
		btnThemDM = (ImageButton)findViewById(R.id.ibtnAddDM);
		btnBack = (ImageButton)findViewById(R.id.ibtnBacksp);
		lv = (ListView)findViewById(R.id.lv_SP);
		dbManager = new DBManager(this);
		display();
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(), SanPhamActivity.class);
			startActivity(i);
			}
		});
		btnThemDM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),ThemDanhMucActivity.class);
			startActivity(i);

			}
		});

		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // xoa
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, final int i, long id) {

				AlertDialog.Builder dialog =	new AlertDialog.Builder(DanhMucActivity.this);
				dialog.setTitle("XÓA SẢN PHẨM NÀY?");
				dialog.setMessage("Bạn thật sự muốn xóa sản phẩm này?");
				dialog.setPositiveButton("XÓA", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent intentt = new Intent(getApplicationContext(), DanhMucActivity.class);
						startActivity(intentt);

						dbManager.DeleteItem(arrDM.get(i).getmMaDM());
						adapter.notifyDataSetChanged();
						Toast.makeText(DanhMucActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
					}
				}).setNegativeButton("Hủy", null).show();
//			dbManager.DeleteSanPham(i);
//			Intent intentt = new Intent(getApplicationContext(), DanhMucActivity.class);
//			startActivity(intentt);
//			Toast.makeText(DanhMucActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();

				return false;
			}
		});
	
	}
	public void display(){
		cursor = dbManager.SELECT_ALL_DANHMUC();
		/*
		String[] from = new String[]{dbManager.ID,dbManager.TEN_DANHMUC};
		int[] to  = new int[]{R.id.tv_Id,R.id.tv_tendm};
		adapter = new SimpleCursorAdapter(DanhMucActivity.this, R.layout.item_list_danhmuc, cursor, from, to, 0);
		dbManager.CloseDB();
		*/
		if(adapter==null){
		while (cursor.moveToNext()){
			
			arrDM.add(new DanhMuc(cursor.getInt(0), cursor.getString(1)));
		}
		adapter = new DanhMucAdapter(this, R.layout.item_list_danhmuc, arrDM);
		lv.setAdapter(adapter);
		}else{
		adapter.notifyDataSetChanged();
		}
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danh_muc, menu);
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
