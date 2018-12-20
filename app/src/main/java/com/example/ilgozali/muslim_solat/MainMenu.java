package com.example.ilgozali.muslim_solat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
Button qiblat, jdw, tuntun, About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        qiblat = (Button) findViewById(R.id.kib);
        jdw = (Button) findViewById(R.id.jadwal);
        tuntun = (Button) findViewById(R.id.petunjuk);
        About = (Button) findViewById(R.id.about);

        jdw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jad = new Intent(MainMenu.this, JadwalSalat.class);
                startActivity(jad);
            }
        });
        qiblat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arah = new Intent(MainMenu.this, Kiblat.class);
                startActivity(arah);
            }
        });

        tuntun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ts = new Intent(MainMenu.this,TuntunanSolat.class);
                startActivity(ts);
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenu.this,Pop_About.class));
            }
        });

    }
}
