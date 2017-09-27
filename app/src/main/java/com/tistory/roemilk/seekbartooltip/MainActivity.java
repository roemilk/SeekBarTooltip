package com.tistory.roemilk.seekbartooltip;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import redpig.utility.UI.UIConvertUtils;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private final static String TAG = "MainActivity";

    private SeekBar mSeekBar = null;
    private ImageView mImageView  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mSeekBar = (SeekBar)findViewById(R.id.seekBar);
        mImageView = (ImageView) findViewById(R.id.seekbar_imageView);
        mSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int width = (int) UIConvertUtils.convertDpToPixel(160, this);
        int height = (int)UIConvertUtils.convertDpToPixel(90, this);

        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(width, height);
        p.addRule(RelativeLayout.ABOVE, seekBar.getId());
        Rect thumbRect = mSeekBar.getThumb().getBounds();


        int leftMargin = (thumbRect.centerX() - (width / 2)) + (thumbRect.width() / 2);
        leftMargin += mSeekBar.getLeft();

        p.setMargins(leftMargin,0, 0, 0);
        mImageView.setLayoutParams(p);

        mImageView.setImageResource(R.drawable.rain);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
