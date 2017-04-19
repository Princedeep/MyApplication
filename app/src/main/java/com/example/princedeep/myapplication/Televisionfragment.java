package com.example.princedeep.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Princedeep on 2017-04-19.
 */

public class Televisionfragment extends Fragment {
    ImageButton ibUp;
    ImageButton ibLeft;
    ImageButton ibEnter;
    ImageButton ibRight;
    ImageButton ibDown;

    TextView tvChannel;
    EditText etInput;
    ImageButton ibMic;
    ImageButton ibBack;
    View view;
ProgressBar bar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View tvView = inflater.inflate(R.layout.televisionfragment, container, false);

        etInput = (EditText) tvView.findViewById(R.id.television_input);
        tvChannel = (TextView) tvView.findViewById(R.id.television_channel);
        tvChannel.setText("Channel: 1");

        // Placeholder OnClickListener for the remote.
        View.OnClickListener tvListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                switch (v.getId()) {
                    case R.id.television_up:
                        Log.d(null, "Up button pressed.");
                        toast = Toast.makeText(v.getContext(), "UP", LENGTH_SHORT);
                        toast.show();

                        bar.setProgress(40);
                        break;
                    case R.id.television_left:
                        Log.d(null, "Left button pressed.");
                        toast = Toast.makeText(v.getContext(), "LEFT", LENGTH_SHORT);
                        toast.show();


                        break;
                    case R.id.television_enter:
                        Log.d(null, "Right button pressed.");
                        tvChannel.setText("Channel: " + etInput.getText());
                        etInput.setText("");
                        break;
                    case R.id.television_right:
                        toast = Toast.makeText(v.getContext(), "RIGHT", LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.television_down:
                        toast = Toast.makeText(v.getContext(), "DOWN", LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.television_back:
                        toast = Toast.makeText(v.getContext(), "BACK", LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.television_mic:
                        toast = Toast.makeText(v.getContext(), "RIGHT", LENGTH_SHORT);
                        toast.show();
                        break;
                }
            }
        };

        ibUp = (ImageButton) tvView.findViewById(R.id.television_up);
        ibUp.setOnClickListener(tvListener);

        ibLeft = (ImageButton) tvView.findViewById(R.id.television_left);
        ibLeft.setOnClickListener(tvListener);

        ibEnter = (ImageButton) tvView.findViewById(R.id.television_enter);
        ibEnter.setOnClickListener(tvListener);

        ibRight = (ImageButton) tvView.findViewById(R.id.television_right);
        ibRight.setOnClickListener(tvListener);

        ibDown = (ImageButton) tvView.findViewById(R.id.television_down);
        ibDown.setOnClickListener(tvListener);

        ibMic = (ImageButton) tvView.findViewById(R.id.television_mic);
        ibMic.setOnClickListener(tvListener);

        ibBack = (ImageButton) tvView.findViewById(R.id.television_back);
        ibBack.setOnClickListener(tvListener);


        return tvView;
    }
}
