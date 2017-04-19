package com.example.princedeep.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private String [] gadgets = {"Lamp", "Television", "Slider"};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter adapter = new ArrayAdapter<String> (this, R.layout.list_layout, gadgets);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent lampIntent = new Intent(getApplicationContext(), Lamp.class);
                        startActivity(lampIntent);
                        break;

                    case 1:
                        Intent televisionIntent = new Intent(getApplicationContext(), Television.class);
                        startActivity(televisionIntent);
                        break;

                    case 2:
                        Intent windowIntent = new Intent(getApplicationContext(), WindowSlider.class);
                        startActivity(windowIntent);
                        break;
                }
            }
        });

    }

}