package com.example.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.data.DBManager;
import com.example.myapplication.model.SanPham;

public class EditSPActivity extends Activity {
SanPham sanpham;
EditText edtten, edtsoluong, edtgia;
ImageView imgAvatar;
DBManager db;
Spinner spn;
String danhmucchon;
ImageButton btncamera, btnfolder, ibtnback;
Button btnedit, btndel;
int i;
int REQUEST_CODE_CAMERA = 454;
int REQUEST_CODE_FOLDER = 352;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_sp);
		edtten = (EditText)findViewById(R.id.txtTenSP_EditSP);
		edtsoluong = (EditText)findViewById(R.id.txtSoluong_ThemSP_EditSP);
		edtgia = (EditText)findViewById(R.id.txtGiaca_ThemSP_EditSP);
		spn = (Spinner)findViewById(R.id.spinnerDM_EditSP);
		btncamera = (ImageButton)findViewById(R.id.ibnCamera_EditSP);
		btnfolder = (ImageButton)findViewById(R.id.ibnFolder_EditSP);
		btnedit = (Button)findViewById(R.id.btnEdit_ThemSP_EditSP);
		btndel = (Button)findViewById(R.id.btnDelete_EditSP);
		ibtnback = (ImageButton)findViewById(R.id.ibtnBack3);
		imgAvatar = (ImageView)findViewById(R.id.imgHinh_EditSP);
		db = new DBManager(this);
		getData();
		loadSpinner();
		ibtnback.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),QLSanPhamActivity.class);
				startActivity(i);
			}
		});
		btnedit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				danhmucchon = spn.getSelectedItem().toString().trim();
				db.EditSanPham(i, edtten.getText().toString(), danhmucchon, Integer.parseInt(edtsoluong.getText().toString()), Integer.parseInt(edtgia.getText().toString()), ConverttoArrayByte(imgAvatar));
				Intent inten = new Intent(getApplicationContext(), QLSanPhamActivity.class);
				startActivity(inten);
				Toast.makeText(EditSPActivity.this, "Sửa hàng thành công!", Toast.LENGTH_SHORT).show();
			}
		});
		btndel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dialog =	new AlertDialog.Builder(EditSPActivity.this);
				dialog.setTitle("XÓA SẢN PHẨM NÀY?");
				dialog.setMessage("Bạn thật sự muốn xóa sản phẩm này?");
					dialog.setPositiveButton("XÓA", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							Intent intentt = new Intent(getApplicationContext(), QLSanPhamActivity.class);
							startActivity(intentt);
							db.DeleteSanPham(i);
							
							Toast.makeText(EditSPActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
						}
					}).setNegativeButton("Hủy", null).show();
//			db.DeleteSanPham(a);
//			Intent intentt = new Intent(getApplicationContext(), QLSanPhamActivity.class);
//			startActivity(intentt);
//			Toast.makeText(EditSPActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
			}
		});
		
		btncamera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i, REQUEST_CODE_CAMERA);
			}
		});
		btnfolder.setOnClickListener(new View.OnClickListener() {
			
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
			imgAvatar.setImageBitmap(bitmap);
			
		}
		if (requestCode==REQUEST_CODE_FOLDER&&resultCode==RESULT_OK & data!=null){
			Uri uri = data.getData();
			try {
				InputStream ipstream = getContentResolver().openInputStream(uri);
				Bitmap bitmap = BitmapFactory.decodeStream(ipstream);
				imgAvatar.setImageBitmap(bitmap);
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
	public void getData(){
		if (getIntent().getExtras()!=null){
			sanpham = (SanPham) getIntent().getSerializableExtra("Edit");
			i = sanpham.getmMaSP();
			byte[] hinhanh = sanpham.getmAnh();
			Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh, 0, hinhanh.length);
			imgAvatar.setImageBitmap(bitmap);
			edtten.setText(sanpham.getmTenSP().toString());
			edtsoluong.setText(String.valueOf(sanpham.getmSoLuong()));
			edtgia.setText(String.valueOf(sanpham.getmGiaban()));
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_s, menu);
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
