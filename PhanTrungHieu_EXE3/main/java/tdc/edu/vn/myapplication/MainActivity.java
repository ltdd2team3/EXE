package tdc.edu.vn.myapplication ;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgDenbao, imgTruck, imgPlane, imgSun, imgRose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDenbao = (ImageView) findViewById(R.id.imageViewDenBao);
        imgTruck = (ImageView) findViewById(R.id.imageViewTruck);
        imgPlane = (ImageView) findViewById(R.id.imageViewPlane);
        imgSun = (ImageView) findViewById(R.id.imageViewSun);
        imgRose = (ImageView) findViewById(R.id.imageViewRose);

        final Animation animBlink = AnimationUtils.loadAnimation(this,R.anim.anim_blink);
        final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        final Animation animMove = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        imgDenbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animBlink);
            }
        });
        imgTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTranslate);
            }
        });
        imgPlane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animMove);
            }
        });
        imgSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
            }
        });
        imgRose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animBlink);
            }
        });
    }
}
