package com.example.princedeep.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity_fragment extends Fragment implements View.OnClickListener{


Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //linking layout to view
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        //find button and implement button click listener
        button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v){
        Intent toMain = new Intent(this.getContext(), MainActivity.class);
        getActivity().startActivity(toMain);
    }
}
