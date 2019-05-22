package tdc.edu.vn.test;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton imPre, imPlay, imStop, imNext;
    private SeekBar seekBar;
    private TextView tenBaiHat, txtTimeDau, txtTimeCuoi;
    ArrayList<Song> arrayList;
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
        imPre = (ImageButton)findViewById(R.id.btnPrevious);
        imPlay = (ImageButton)findViewById(R.id.btnPlay);
        imStop = (ImageButton)findViewById(R.id.btnStop);
        imNext = (ImageButton)findViewById(R.id.btnNext);
        tenBaiHat = (TextView)findViewById(R.id.tvbaihat);
        txtTimeDau = (TextView)findViewById(R.id.tvdau);
        txtTimeCuoi = (TextView)findViewById(R.id.tvcuoi);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
    }

    private void khoiTao(){
        arrayList = new ArrayList<>();
        arrayList.add(new Song("Anh chẳng sao mà", R.drawable.khangviet, R.raw.b1));
        arrayList.add(new Song("Anh nhớ nhé", R.drawable.anhnhonhe, R.raw.b2));
        arrayList.add(new Song("Đời là thế thôi", R.drawable.phule, R.raw.b3));
        arrayList.add(new Song("Anh có tài mà", R.drawable.anhcotaima, R.raw.b4));
        arrayList.add(new Song("Ta đi tìm em", R.drawable.taditimem, R.raw.b5));
    }

    private void setMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList.get(position).getFile());
        tenBaiHat.setText(arrayList.get(position).getTenBaiHat());
        imageView.setImageResource(arrayList.get(position).getHinhAnh());
    }

    private void setEvent(){
        setMediaPlayer();
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.quay);
        imageView.startAnimation(animation);
        imPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imPlay.setImageResource(R.drawable.ic_play);
                }
                else{
                    mediaPlayer.start();
                    imPlay.setImageResource(R.drawable.ic_pause);
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
                imPlay.setImageResource(R.drawable.ic_play);
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

                setMediaPlayer();
                mediaPlayer.start();
                imPlay.setImageResource(R.drawable.ic_play);
                setTimeTotal();
                updateTime();
            }
        });

        imPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < arrayList.size() - 1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                setMediaPlayer();
                mediaPlayer.start();
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
                txtTimeDau.setText(dateFormat.format(mediaPlayer.getCurrentPosition()) + "");
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
                        mediaPlayer.start();
                        imPlay.setImageResource(R.drawable.ic_pause);
                        setTimeTotal();
                        updateTime();
                    }
                }));
                handler.postDelayed(this, 500);
            }
        }, 100);
    }


}
