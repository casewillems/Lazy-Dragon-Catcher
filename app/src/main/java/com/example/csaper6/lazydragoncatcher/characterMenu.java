package com.example.csaper6.lazydragoncatcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class characterMenu extends AppCompatActivity {
    private Button upgrade, settings;
    private TextView dragonScore;
    private GameData saveFile = new GameData();
    private boolean isCounting = false;
    private ImageView snacks;
    private ImageView pillow;
    private ImageView tv;
    private ImageView poster;
    private ImageView minifridge;
    private ImageView sofa;
    private ImageView discoball;
    private ImageView xbox;
    private CountDownTimer toNextDragon2;
    private CountDownTimer toNextDragon; //= new CountDownTimer(saveFile.getTimeToNextDragon(), 100) {
//        @Override
//        public void onTick(long l) {
//        }
//
//        @Override
//        public void onFinish() {
//            SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
//            saveFile.setNumberOfDragons(saveFile.getNumberOfDragons()+1);
//            saveFile.setDragonDollars(saveFile.getDragonDollars()+1);
//            saveFile.setTimeToNextDragon(10000 - (saveData.getInt("Rate Of Dragons",1)*100));
//            dragonScore.setText("" + saveFile.getNumberOfDragons());
//            toNextDragon.start();
//
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_menu);
        SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
        saveFile.setDragonDollars(saveData.getInt("Number Of Dragon Dollars", 0));
        saveFile.setNumberOfDragons(saveData.getInt("Number Of Dragons", 0));
        upgrade = (Button) findViewById(R.id.button_upgrades);
        settings = (Button) findViewById(R.id.button_settings);
        snacks = (ImageView) findViewById(R.id.snacks);
        pillow = (ImageView) findViewById(R.id.pillow);
        tv = (ImageView) findViewById(R.id.tv);
        poster = (ImageView) findViewById(R.id.poster);
        minifridge = (ImageView) findViewById(R.id.minifridge);
        sofa = (ImageView) findViewById(R.id.sofa);
        discoball = (ImageView) findViewById(R.id.discoball);
        xbox = (ImageView) findViewById(R.id.xbox);

        dragonScore = (TextView) findViewById(R.id.text_dragon_number);
        dragonScore.setText("" + saveData.getInt("Number Of Dragons",0));
        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(characterMenu.this, upgrades.class);
                startActivity(i);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(characterMenu.this, Settings.class);
                startActivity(i);
            }
        });
        toNextDragon = new CountDownTimer(10000/saveData.getInt("Rate Of Dragons",1), 100) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
                saveFile.setNumberOfDragons(saveFile.getNumberOfDragons()+1);
                saveFile.setDragonDollars(saveFile.getDragonDollars()+1);
                saveFile.setTimeToNextDragon(10000/saveData.getInt("Rate Of Dragons",1));

                Log.d("money in gameData","" + saveFile.getDragonDollars());
                Log.d("money in prefs","" + saveData.getInt("Rate Of Dragons",0));
                dragonScore.setText("" + saveFile.getNumberOfDragons());

                toNextDragon.start();

            }
        };
        if(!isCounting) {
            toNextDragon.start();
            isCounting = true;
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveData.edit();
        editor.putInt("Number Of Dragons",saveFile.getNumberOfDragons());
        editor.putInt("Number Of Dragon Dollars", saveFile.getDragonDollars());
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences saveData = getSharedPreferences("data", Context.MODE_PRIVATE);
        if(saveData.getBoolean("hasSnacks", false))
        {
            snacks.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasPillow", false))
        {
            pillow.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasTv", false))
        {
            tv.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasPosters", false))
        {
            poster.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasFridge", false))
        {
            minifridge.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasSofa", false))
        {
            sofa.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasDisco", false))
        {
            discoball.setVisibility(View.VISIBLE);
        }
        if(saveData.getBoolean("hasXbox", false))
        {
            xbox.setVisibility(View.VISIBLE);
        }

    }







}
