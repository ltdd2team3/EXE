package tdc.edu.vn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText ed1, ed2;
    Button bt1;
    String value, value1;
    RecyclerView rc;
    RecyclerView.LayoutManager rclm;
    Adapter ad;
    ArrayList<ThongTin> data = new ArrayList<>();
    String h;
    RadioButton rd1,rd2,rd3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        setEvent();
    }

    private void setEvent() {

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTra()) return;

                value1 = ed1.getText().toString();
                value = ed2.getText().toString();
                ThongTin pt = new ThongTin();
                pt.setTxtSo1("Họ Tên" + value1);
                pt.setTxtSo2(value);


                Toast.makeText(getApplicationContext(), "Đã lưu thành công ! ", Toast.LENGTH_LONG).show();
               if(rd1.isChecked()){
                   pt.setAnh(R.drawable.nam);
                   pt.setTxtPhepTinh("Nam");
               }
               else if(rd2.isChecked()){
                   pt.setAnh(R.drawable.nu);
                   pt.setTxtPhepTinh("Nữ");
               }
               else if(rd3.isChecked()){
                   pt.setAnh(R.drawable.ic_wc_black_24dp);
                   pt.setTxtPhepTinh("Khác ");
               }
                data.add(pt);
                ad.notifyDataSetChanged();

            }
        });


    }

    private void setControl() {


        ed1 = findViewById(R.id.hoten);
        ed2 = findViewById(R.id.thongtin);
        bt1 = findViewById(R.id.bt1);

        rd1 = findViewById(R.id.rdnam);
        rd2 = findViewById(R.id.rdnu);
        rd3 = findViewById(R.id.rdkhac);
    }

    public boolean kiemTra() {
        if (ed1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập thông tin !!! ", Toast.LENGTH_LONG).show();
            ed1.requestFocus();
            return true;
        }
        if (ed2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập thông tin !!! ", Toast.LENGTH_LONG).show();
            ed2.requestFocus();
            return true;
        }

        return false;
    }

    void setAdapter(){
        rc = findViewById(R.id.rv1);
        rclm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rc.setLayoutManager(rclm);
        ad = new Adapter(this,data,R.layout.listviewitem);
        rc.setAdapter(ad);

    }



}
