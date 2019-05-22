package com.example.myapplication;

import java.util.ArrayList;



import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.myapplication.adapter.ThongkeAdapter;
import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.Thongke;

public class ThongkeActivity extends Activity {
	Button btnngay, btnok;
	EditText edtngay;
	DBManager db;
	ArrayList<Thongke> arrayAdapter = new ArrayList<Thongke>();
	ThongkeAdapter adapter;
	Cursor cursor;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thongke);
		btnngay = (Button)findViewById(R.id.btnChonngay);
		edtngay = (EditText)findViewById(R.id.txtNgay);
		btnok = (Button)findViewById(R.id.btnthongke);
		lv = (ListView)findViewById(R.id.lis_thongkesp);
		db = new DBManager(this);
		edtngay.setText(db.ngay());
		btnngay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDatePicker();
			}
		});
		btnok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				display();
			}
		});
	}
	public void display(){
		arrayAdapter.clear();
cursor = db.Thongke(edtngay.getText().toString().trim());
while (cursor.moveToNext()){
	arrayAdapter.add(new Thongke(cursor.getString(0), cursor.getInt(1), cursor.getInt(2)));
}
adapter = new ThongkeAdapter(this, R.layout.list_item_thongke, arrayAdapter);
adapter.notifyDataSetChanged();
lv.setAdapter(adapter);
	}
public void showDatePicker(){
	OnDateSetListener callback = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			if(arg3<=9&&arg2<=8){edtngay.setText("0"+ arg3 + "/" + "0"+ (arg2 + 1) + "/" + arg1);};
			if(arg3<=9&&arg2>8){edtngay.setText("0"+ arg3 + "/" + (arg2 + 1) + "/" + arg1);};
			if(arg3>9&&arg2>8){edtngay.setText(arg3 + "/" + (arg2 + 1) + "/" + arg1);};
			if(arg3>9&&arg2<=8){edtngay.setText(arg3 + "/"  + "0" + (arg2 + 1) + "/" + arg1);};
			
			//edtngay.setText(arg3 + "/" + (arg2 + 1) + "/" + arg1);
		}
	};
	String s=edtngay.getText().toString().trim();
	 String strArrtmp[]=s.split("/");
	 int ngay=Integer.parseInt(strArrtmp[0]);
	 int thang=Integer.parseInt(strArrtmp[1])-1;
	 int nam=Integer.parseInt(strArrtmp[2]);
	DatePickerDialog pic = new DatePickerDialog(this, callback, nam, thang, ngay);
	pic.setTitle("Chọn ngày cần thống kê");
	 pic.show();
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thongke, menu);
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
