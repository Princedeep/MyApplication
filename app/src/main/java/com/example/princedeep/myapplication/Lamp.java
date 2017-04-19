package com.example.princedeep.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;

public class Lamp extends AppCompatActivity {

    private SeekBar seekBar ;
    private SeekBar sk;
    private WindowManager.LayoutParams layoutParmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lamp_fragment);

        Button on = (Button) findViewById(R.id.b3);
        Button off = (Button) findViewById(R.id.b2);
        seekBar  = (SeekBar) findViewById(R.id.seekbar_2);
        seekBar.setProgress(50);

         sk=(SeekBar)  findViewById(R.id.blinds_seekbar_3);


        //set seekBar control
        layoutParmas = getWindow().getAttributes();
        layoutParmas.screenBrightness = 50 / 100.0f;
        getWindow().setAttributes(layoutParmas);

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setProgress(100);
                layoutParmas.screenBrightness = 100 / 100.0f;
                getWindow().setAttributes(layoutParmas);
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setProgress(0);
                layoutParmas.screenBrightness = 0 / 100.0f;
                getWindow().setAttributes(layoutParmas);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                layoutParmas.screenBrightness =  i / 100.0f;
                getWindow().setAttributes(layoutParmas);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {} //DO NOTHING

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}  //DO NOTHING
        });
    }
}

