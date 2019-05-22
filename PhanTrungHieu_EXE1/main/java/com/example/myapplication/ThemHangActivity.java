package com.example.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.data.DBManager;

public class ThemHangActivity extends Activity {
	
	DBManager db;
	Spinner spn;
	ImageButton ibnCam;
	ImageButton ibnFol;
	ImageView imgHinh;
	String danhmucchon;
	Button btnSave;
	EditText edtSoluong;
	EditText edtGiaca;
	EditText edtTenSP;
	int REQUEST_CODE_CAMERA = 123;
	int REQUEST_CODE_FOLDER = 456;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_them_hang);
		imgHinh = (ImageView)findViewById(R.id.imgHinh);
		btnSave = (Button)findViewById(R.id.btnLuu_ThemSP);
		spn = (Spinner)findViewById(R.id.spinnerDM);
		ibnCam = (ImageButton)findViewById(R.id.ibnCamera);
		ibnFol = (ImageButton)findViewById(R.id.ibnFolder);
		edtSoluong = (EditText)findViewById(R.id.txtSoluong_ThemSP);
		edtTenSP = (EditText)findViewById(R.id.txtTenSP_ThemSP);
		edtGiaca = (EditText)findViewById(R.id.txtGiaca_ThemSP);
		db = new DBManager(this);
		loadSpinner();
	danhmucchon = spn.getSelectedItem().toString().trim();
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
//				if (edtSoluong.length() == 0 )
//				{
////					Toast.makeText(ThemHangActivity.this, "Không Để Trống", Toast.LENGTH_SHORT).show();
//					edtSoluong.setError("Không Để Trống");
//
//
//				}
//				else  {
					// TODO Auto-generated method stub
					db.ThemSanPham(edtTenSP.getText().toString(), danhmucchon, Integer.parseInt(edtSoluong.getText().toString()), Integer.parseInt(edtGiaca.getText().toString()), ConverttoArrayByte(imgHinh));
					Toast.makeText(ThemHangActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
					Intent i = new Intent(getApplicationContext(), QLSanPhamActivity.class);
					startActivity(i);
//				}
			}
			
		});
		
		ibnCam.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, REQUEST_CODE_CAMERA);
				
			}
		});
		ibnFol.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(Intent.ACTION_PICK);
				in.setType("image/*");
				startActivityForResult(in, REQUEST_CODE_FOLDER);
			}
		});
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode==REQUEST_CODE_CAMERA&&resultCode==RESULT_OK & data!=null){
			Bitmap bitmap = (Bitmap) data.getExtras().get("data");
			imgHinh.setImageBitmap(bitmap);
			
		}
		if (requestCode==REQUEST_CODE_FOLDER&&resultCode==RESULT_OK & data!=null){
			Uri uri = data.getData();
			try {
				InputStream ipstream = getContentResolver().openInputStream(uri);
				Bitmap bitmap = BitmapFactory.decodeStream(ipstream);
				imgHinh.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	public void loadSpinner(){
		
		List<String> danhmuc  = db.getAllDanhMuc();
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, danhmuc);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		
		spn.setAdapter(dataAdapter);
	}
	public byte[] ConverttoArrayByte(ImageView img){
		BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
		Bitmap bitmap = bitmapDrawable.getBitmap();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
		return stream.toByteArray();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.them_hang, menu);
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
