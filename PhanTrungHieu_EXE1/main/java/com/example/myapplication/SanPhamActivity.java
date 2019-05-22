package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SanPhamActivity extends Activity {
	Button btnDanhMuc;
	Button btnSanPham;
	Button btnSanphamsaphet;

	ImageButton ibtnback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_san_pham);
		btnDanhMuc = (Button)findViewById(R.id.btnDanhMuc_SanPham);
		btnSanPham = (Button)findViewById(R.id.btnSanPham_SP);
		btnSanphamsaphet = (Button)findViewById(R.id.btnGiamgia);
		ibtnback = (ImageButton)findViewById(R.id.ibtnbacksanpham);

		ibtnback.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Trangquanly.class);
				startActivity(i);
			}
		});
		btnDanhMuc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), DanhMucActivity.class);
				startActivity(i);
			}
		});
		btnSanPham.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), QLSanPhamActivity.class);
				startActivity(i);
			}
		});
		btnSanphamsaphet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent b = new Intent(getApplicationContext(), SPsaphetActivity.class);
			startActivity(b);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.san_pham, menu);
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
