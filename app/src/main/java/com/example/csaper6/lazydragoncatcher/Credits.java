package com.example.csaper6.lazydragoncatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by csaper6 on 10/5/16.
 */
public class Credits extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
        TextView q = (TextView) findViewById(R.id.textView1);
        TextView a = (TextView) findViewById(R.id.textView2);
        TextView x = (TextView) findViewById(R.id.textView3);
        TextView w = (TextView) findViewById(R.id.textView4);
        TextView s = (TextView) findViewById(R.id.textView5);
        Intent i = getIntent();
        String z = i.getStringExtra(Settings.T);
        q.setText(z);
        a.setText(R.string.setting);
        x.setText(R.string.credit);
        w.setText(R.string.main);
        s.setText(R.string.upgrades);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

    }
}
