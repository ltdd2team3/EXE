package tdc.edu.vn.sensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThresshold = 0;
    LinearLayout view;
    ImageView imgHinh;
  TextView txtname;
  TextView txttitle;
    private float lastX, lastY, lastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setSensor();
    }

    private void setSensor() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            SensorEventListener listener;
            sensorManager.registerListener(this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);
            vibrateThresshold = accelerometer.getMaximumRange() / 2;
        }
    }

    private void setControl() {
        view = (LinearLayout) findViewById(R.id.view);
        txtname=(TextView) findViewById(R.id.hoa);
        txttitle=(TextView) findViewById(R.id.title) ;
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            doiHinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
            public void doiHinh(SensorEvent Event) {
                float deltaX = Math.abs(lastX - Event.values[0]);
                float deltaY = Math.abs(lastY - Event.values[1]);
                float deltaZ = Math.abs(lastZ - Event.values[2]);
                if (deltaX > vibrateThresshold/*rung*/){
                    txttitle.setText("Man Hinh 1");
                    txtname.setText("Trong hạt sen có chứa nhiều chất chống oxy hóa, ngăn ngừa tác động có hại của các gốc tự do trong cơ thể. Đặc biệt hạt sen còn có tác dụng hàn gắn, phục hồi protein trong cơ thể người bị tổn thương, giúp cho làn da luôn trẻ trung.");
                    imgHinh.setImageResource(R.drawable.sen);
                    view.setBackgroundColor(Color.WHITE);

                }

                if (deltaY > vibrateThresshold){
                    txttitle.setText("Man Hinh 2");
                   txtname.setText("Cách trồng lan rừng không chỉ cần chú trọng đến giống cây, môi trường sống mà còn phải chuẩn bị giá thể, chế độ tưới tiêu, chăm sóc “đúng bài” thì cây mới nhanh cho hoa đẹp trang trí nhà");
                    imgHinh.setImageResource(R.drawable.lan);
                    view.setBackgroundColor(Color.YELLOW);

                }

                if (deltaZ > vibrateThresshold){
                    txttitle.setText("Man Hinh 3");
                  txtname.setText("Lá cây thường dai, rất nhẵn và 2 mặt đều có màu nhạt. Cây mọc dại hoặc được trồng khắp nơi trên cả nước. Bộ phận được thu hoạch dùng làm thuốc chủ yếu là từ vỏ thân cây bằng lăng tía, vỏ cây có thể thu hoạch quanh năm nhưng tốt nhất vẫn là ở mùa thu.");
                    imgHinh.setImageResource(R.drawable.banglang);
                    view.setBackgroundColor(Color.GREEN);
                }
                lastX = Event.values[0];
                lastY = Event.values[1];
                lastZ = Event.values[2];
            }
}
