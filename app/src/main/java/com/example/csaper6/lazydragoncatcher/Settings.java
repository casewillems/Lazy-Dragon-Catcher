package com.example.csaper6.lazydragoncatcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity{
    private Button button1, button2;
    public static final int j = 0;
    public static final String T = "wwwww";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button1.requestFocus();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("nlkhkjljkjkljkjlkjkl", "onClick: reset");
                SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = saveData.edit();
                editor.putInt("Number Of Dragons",0);
                editor.putInt("Number Of Dragon Dollars", 0);
                editor.putInt("Rate Of Dragons", 1);
                editor.putBoolean("hasSnacks",false);
                editor.putBoolean("hasPillow",false);
                editor.putBoolean("hasTv",false);
                editor.putBoolean("hasPosters",false);
                editor.putBoolean("hasFridge",false);
                editor.putBoolean("hasSofa",false);
                editor.putBoolean("hasDisco",false);
                editor.putBoolean("hasXbox",false);

                editor.commit();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Settings.this, Credits.class);
                i.putExtra(T, "Wait... People actually look at credits?");
                startActivity(i);
            }
        });
    }





}
