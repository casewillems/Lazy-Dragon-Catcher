package com.example.csaper6.lazydragoncatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by csaper6 on 10/5/16.
 */
public class upgrades extends AppCompatActivity{
    private Button snacks, pillow, tv, posters, minifridge, sofa, discoball, xbox;
    private TextView money;
    private SharedPreferences saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        saveData = getSharedPreferences("data",Context.MODE_PRIVATE);

        {
            money = (TextView) findViewById(R.id.text_dragon_number_shop);
            money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
            Log.d("ammount of money:", " " + saveData.getInt("Number Of Dragon Dollars", 0) );
            snacks = (Button) findViewById(R.id.button_snacks);
            pillow = (Button) findViewById(R.id.button_pillows);
            tv = (Button) findViewById(R.id.button_tv);
            posters = (Button) findViewById(R.id.button_poster);
            minifridge = (Button) findViewById(R.id.button_fridge);
            sofa = (Button) findViewById(R.id.button_sofa);
            discoball = (Button) findViewById(R.id.button_disco);
            xbox = (Button) findViewById(R.id.button_xbox);
        }
        snacks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasSnacks",false) && spendMoney(2)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(1);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasSnacks",true);
                    editor.commit();
                }


            }

        });
        pillow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasPillow",false) && spendMoney(10)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(1);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasPillow",true);
                    editor.commit();

                }


            }

        });
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasTv",false) && spendMoney(199)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(7);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasTv",true);
                    editor.commit();
                }


            }

        });
        posters.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasPosters",false) && spendMoney(35)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(3);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasPosters",true);
                    editor.commit();
                }


            }

        });
        minifridge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasFridge",false) && spendMoney(350)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(9);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasFridge",true);
                    editor.commit();
                }


            }

        });
        sofa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasSofa",false) && spendMoney(80)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(4);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasSofa",true);
                    editor.commit();
                }


            }

        });
        discoball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasDisco",false) && spendMoney(425)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(13);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasDisco",true);
                    editor.commit();
                }


            }

        });
        xbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!saveData.getBoolean("hasXbox",false) && spendMoney(499)){
                    money.setText("" + saveData.getInt("Number Of Dragon Dollars",0));
                    getDragonsFaster(15);
                    SharedPreferences.Editor editor = saveData.edit();
                    editor.putBoolean("hasXbox",true);
                    editor.commit();
                }


            }

        });

    }
    public boolean spendMoney(int money){
        SharedPreferences.Editor editor = saveData.edit();
        if(money <= saveData.getInt("Number Of Dragon Dollars",0)) {
            editor.putInt("Number Of Dragon Dollars", (saveData.getInt("Number Of Dragon Dollars", 0) - money));
            editor.commit();
            Log.d("money spent: ", "" + money);
            Log.d("money: ", "" + saveData.getInt("Number Of Dragon Dollars", 0));
            return true;
        }
        else{
            return false;
        }
    }

    public void getDragonsFaster(int time) {
        SharedPreferences.Editor editor = saveData.edit();
        editor.putInt("Rate Of Dragons",saveData.getInt("Rate Of Dragons", 1) + time);
        Log.d("speed dragons", "current speed: " + (saveData.getInt("Rate Of Dragons", 1) + time) + "increase: " + time);
        editor.commit();
    }
}
