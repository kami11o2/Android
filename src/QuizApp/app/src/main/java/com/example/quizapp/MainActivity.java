package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlay, btnGuide, btnGuideShowOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(a);
            }
        });
        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dl = new Dialog(MainActivity.this);
                dl.setContentView(R.layout.layout_guide);
                dl.setTitle("Guide");

                btnGuideShowOk = (Button) dl.findViewById(R.id.btnOk);

                btnGuideShowOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dl.cancel();
                    }
                });
                dl.show();
            }
        });
    }

    private void mapping(){
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnGuide = (Button) findViewById(R.id.btnGuide);
    }
}
