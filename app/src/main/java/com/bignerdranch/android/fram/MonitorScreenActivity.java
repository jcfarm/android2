package com.bignerdranch.android.fram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MonitorScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_screen);
    }
    public static Intent newIntent(Context packageContext){
        Intent i = new Intent(packageContext,MonitorScreenActivity.class);
        return i;
    }
}
