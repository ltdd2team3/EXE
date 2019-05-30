package tdc.edu.vn.test;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imPre, imPlay, imStop, imNext;
    private SeekBar seekBar;
    private TextView tenBaiHat, txtTimeDau, txtTimeCuoi, total;
    ArrayList<Song> arrayList;
    ListView listView;
    Song_Adapter adapter;
    private MediaPlayer mediaPlayer;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        khoiTao();
        setEvent();
    }

    public void setControl(){
        imageView = (ImageView)findViewById(R.id.TitleImage);
        imPre = (ImageView)findViewById(R.id.btnPrevious);
        imPlay = (ImageView)findViewById(R.id.btnPlay);
        imStop = (ImageView)findViewById(R.id.btnStop);
        imNext = (ImageView)findViewById(R.id.btnNext);
        tenBaiHat = (TextView)findViewById(R.id.tvbaihat);
//        tenBaiHat = (TextView)findViewById(R.id.tenbaihat);
        total = (TextView)findViewById(R.id.total);
        txtTimeDau = (TextView)findViewById(R.id.tvdau);
        txtTimeCuoi = (TextView)findViewById(R.id.tvcuoi);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        listView = (ListView)findViewById(R.id.lv);
    }

    private void khoiTao(){
        arrayList = new ArrayList<>();
        arrayList.add(new Song("Ex's Hate Me ", "B Ray, Masew, AMee", R.raw.het, R.drawable.exx));
        arrayList.add(new Song("Anh Nhớ Nhé", "Anh nhớ nhé", R.raw.b2, R.drawable.anhnhonhe));
        arrayList.add(new Song("Đời Là Thế Thôi", "Phú Lê", R.raw.b3, R.drawable.dltt));
        arrayList.add(new Song("Anh Có Tài Mà", "Xuân Nghị", R.raw.b4, R.drawable.actm));
        arrayList.add(new Song("Ta Đi Tìm Em", "Đàm Vĩnh Hưng",R.raw.b5, R.drawable.tdte));
        arrayList.add(new Song("Con Trai Cưng", "B Ray",R.raw.b4, R.drawable.tdte));
        arrayList.add(new Song("Thu cuối", "TT",R.raw.b5, R.drawable.tt));
        arrayList.add(new Song("Thương Nhiều Hơn Nói", "Đạt G, B Ray, Masew",R.raw.b5, R.drawable.tdte));
        arrayList.add(new Song("Xin", " Đạt G, Masew, B Ray",R.raw.b5, R.drawable.dd));
    }

    private void setMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
        tenBaiHat.setText(arrayList.get(position).getTenBaiHat());
        imageView.setImageResource(arrayList.get(position).getHinh());

        //mediaPlayer = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.b1));
        //mediaPlayer.start();
    }

    private void setEvent(){
        total.setText("Tổng: " + arrayList.size() + "");
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.quay);
        //khoiTao();
        adapter = new Song_Adapter(this, R.layout.listmusic, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.startAnimation(animation);
                tenBaiHat.setText(arrayList.get(position).getTenBaiHat());
                //Toast.makeText(MainActivity.this, arrayList.get(position).getTenBaiHat(), Toast.LENGTH_SHORT).show();
                imageView.setImageResource(arrayList.get(position).getHinh());
                mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
               // setMediaPlayer();
                mediaPlayer.start();
                imPlay.setImageResource(R.drawable.ic_pause1);
                setTimeTotal();
                updateTime();
            }

        });

        setMediaPlayer();


        imPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imPlay.setImageResource(R.drawable.ic_play1);
                    imageView.clearAnimation();
                }
                else{
                    imageView.startAnimation(animation);
                    mediaPlayer.start();
                    imPlay.setImageResource(R.drawable.ic_pause1);
                }
                setTimeTotal();
                updateTime();
            }
        });

        imStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                imPlay.setImageResource(R.drawable.ic_play1);
                setMediaPlayer();
                setTimeTotal();
                updateTime();
                imageView.clearAnimation();
            }
        });

        imNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position > arrayList.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                imageView.startAnimation(animation);
                setMediaPlayer();
                mediaPlayer.start();
                imPlay.setImageResource(R.drawable.ic_pause1);
                setTimeTotal();
                updateTime();
            }
        });

        imPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < 0){
                    position = arrayList.size() - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                imageView.startAnimation(animation);
                setMediaPlayer();
                mediaPlayer.start();
                imPlay.setImageResource(R.drawable.ic_pause1);
                setTimeTotal();
                updateTime();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


    }

    public void ngauNhien(){
        int ra = 0 + (int)(Math.random() * (arrayList.size() - 0) + 1);
    }

    public void setTimeTotal(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        txtTimeCuoi.setText(dateFormat.format(mediaPlayer.getDuration()) + "");
        seekBar.setMax(mediaPlayer.getDuration());
    }

    public void updateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                txtTimeDau.setText(dateFormat.format(mediaPlayer.getCurrentPosition()) + "/");
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener((new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if (position > arrayList.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }

                        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
                        tenBaiHat.setText(arrayList.get(position).getTenBaiHat());
                        imageView.setImageResource(arrayList.get(position).getHinh());
                        mediaPlayer.start();
                        imPlay.setImageResource(R.drawable.ic_pause1);
                        setTimeTotal();
                        updateTime();
                    }
                }));
                handler.postDelayed(this, 500);
            }
        }, 100);
    }


}
