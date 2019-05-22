package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Trangquanly extends Activity {
Button btnMathang;
Button btnDonhang;
Button btnHoadon;
	ViewFlipper viewFliper;
	ArrayList<Integer> listImages;
	Animation in, out;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trangquanly);
		btnDonhang = (Button)findViewById(R.id.btnCall_Donhang);
		btnMathang = (Button)findViewById(R.id.btnCall_Mathang);
		btnHoadon = (Button)findViewById(R.id.btnCall_Hoadon);
		viewFliper = findViewById(R.id.viewFliper);
		btnMathang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), SanPhamActivity.class);
				startActivity(i);
			}
		});
		btnDonhang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent (getApplicationContext(), TaoDonHangActivity.class);
			startActivity(i);
			}
		});
		btnHoadon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent (getApplicationContext(), HoaDonActivity.class);
				startActivity(i);
			}
		});

		//slide view fliper
		slideViewFlipper();
	}


	public Bitmap loadLagreImage(int imageID, int targetHeight, int targetWidth){
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(getResources(),imageID,options);
		final int originalHeight = options.outHeight;
		final int originalWidth = options.outWidth;
		int inSampleSize = 1;
		while (originalHeight / (inSampleSize*2) > targetHeight && (originalWidth / (inSampleSize*2) > targetWidth)){
			inSampleSize *= 2;
		}
		options.inSampleSize = inSampleSize;
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(getResources(),imageID,options);

	}

	private void slideViewFlipper() {
		listImages = new ArrayList<Integer>();
		listImages.add(R.drawable.hinhone);
		listImages.add(R.drawable.hinhtwo);
		listImages.add(R.drawable.hinhthree);

		for (int i = 0; i < listImages.size(); i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageBitmap(loadLagreImage(listImages.get(i),200,200));
			viewFliper.addView(imageView);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		}

		viewFliper.setFlipInterval(2000);
		viewFliper.setAutoStart(true);
		in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		out = AnimationUtils.loadAnimation(this, R.anim.fade_out);
		viewFliper.setInAnimation(in);
		viewFliper.setOutAnimation(out);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trangquanly, menu);
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
