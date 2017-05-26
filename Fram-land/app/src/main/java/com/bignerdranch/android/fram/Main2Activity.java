package com.bignerdranch.android.fram;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    Handler mHandler = new Handler();
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if(isFirst){
                    intent.setClass(Main2Activity.this,MainActivity.class);
                    startActivity(intent);

                    //动画
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    finish();
                }
            }
        },2000);
    }
}
