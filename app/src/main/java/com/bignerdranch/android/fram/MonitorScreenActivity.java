package com.bignerdranch.android.fram;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MonitorScreenActivity extends AppCompatActivity {
    private static String rtspUrl;
    Button palyButton;
    Button stopButton;
    VideoView mVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_screen);


        palyButton = (Button)this.findViewById(R.id.button_start);
        stopButton = (Button)this.findViewById(R.id.button_stop);
        ButtonHandler();
        mVideoView = (VideoView)this.findViewById(R.id.videoView);

    }
    public static Intent newIntent(Context packageContext,String rtsp){
        Intent i = new Intent(packageContext,MonitorScreenActivity.class);
        rtspUrl = rtsp;
        return i;
    }

    private void ButtonHandler() {
        palyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayRtspStream(rtspUrl);
                Toast.makeText(getApplicationContext(),"666",Toast.LENGTH_SHORT).show();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mVideoView.isPlaying()){
                    mVideoView.pause();
                }else{
                    PlayRtspStream(rtspUrl);
                }
            }
        });
    }


    private void PlayRtspStream(String rtspUrl){
        mVideoView.setVideoURI(Uri.parse(rtspUrl));
        mVideoView.requestFocus();
        mVideoView.start();
    }

}
