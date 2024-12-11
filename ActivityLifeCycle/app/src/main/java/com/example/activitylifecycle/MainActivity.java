package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Life Cycle","Check Life Cycle Activity - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life Cycle","Check Life Cycle Activity - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life Cycle","Check Life Cycle Activity - onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle","Check Life Cycle Activity - onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life Cycle","Check Life Cycle Activity - onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life Cycle","Check Life Cycle Activity - onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life Cycle","Check Life Cycle Activity - onStop()");
    }
}