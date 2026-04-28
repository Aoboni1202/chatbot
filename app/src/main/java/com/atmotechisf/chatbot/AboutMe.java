package com.atmotechisf.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class AboutMe extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        chipNavigationBar = findViewById(R.id.bottomNavigationBarAtt);
        chipNavigationBar.setItemSelected(R.id.aboutmeBtn, true);
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            Intent intent = null;

            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.homeBtn:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        break;
                    case R.id.aboutmeBtn:
                        intent = new Intent(getApplicationContext(), AboutMe.class);
                        break;
                }

                if (intent != null) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                            finish();
                        }
                    }, 500);
                }
            }
        });
    }
}