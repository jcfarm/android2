package com.bignerdranch.android.fram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShouYeListActivity extends AppCompatActivity {

    private MyApplication application;

    private static String ListID;
    private Intent i;

    final Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    update();
                    break;
            }
            super.handleMessage(msg);
        }
        void update(){
            //Intent intent = new Intent();
            //intent.setClass(ShouYeListActivity.this,ShouYeListActivity.class);
            //ShouYeListActivity.this.startActivity(intent);
            try {
                co2TextView.setText(value_List[2] = application.getMQTjson().getSensors().get(1).getCo2().get(0).getCo2());
                cTextView.setText(value_List[0] = application.getMQTjson().getSensors().get(1).getCo2().get(0).getC());
                ph2TextView.setText(value_List[1] = application.getMQTjson().getSensors().get(0).getLight().get(0).getPh());
                peTextView.setText(value_List[3] = application.getMQTjson().getSensors().get(2).getWater().get(0).getPe());
                usTextView.setText(value_List[4] = application.getMQTjson().getSensors().get(3).getSalt().get(0).getUs());
                mg2TextView.setText(value_List[5] = application.getMQTjson().getSensors().get(3).getSalt().get(0).getMg());

            }catch (Exception e){

            }

        }
    };
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    public TextView ph2TextView;
    public TextView cTextView;
    public TextView peTextView;
    public TextView usTextView;
    public TextView mg2TextView;
    public TextView co2TextView;

    private String[] status_List = new String[]{
            "温度",
            "空气湿度",
            "CO2",
            "土壤湿度",
            "电导率",
            "盐分",
    };
    private String[] control_List = new String[]{
            "电磁阀",
            "环流风机",
            "照明灯",
            "遮阳网",
            "侧卷膜",
            "顶卷膜",
    };
    private String[] value_List = new String[]{
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye_list);
        application = (MyApplication)getApplication();

        try{
            value_List[0] = application.getMQTjson().getSensors().get(1).getCo2().get(0).getC();
            value_List[1] = application.getMQTjson().getSensors().get(0).getLight().get(0).getPh();
            value_List[2] = application.getMQTjson().getSensors().get(1).getCo2().get(0).getCo2();
            value_List[3] = application.getMQTjson().getSensors().get(2).getWater().get(0).getPe();
            value_List[4] = application.getMQTjson().getSensors().get(3).getSalt().get(0).getUs();
            value_List[5] = application.getMQTjson().getSensors().get(3).getSalt().get(0).getMg();
        }catch (Exception e){

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.status_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ShouYeListAdapter());
        timer.schedule(task,1000,1000);

    }


    private class ShouYeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mItemTextView;
        private TextView mItemTextView2;


        public ShouYeListHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.status_control_item, container, false));

            mImageView = (ImageView) itemView.findViewById(R.id.status_control_item_img);
            mItemTextView = (TextView) itemView.findViewById(R.id.status_control_item_text1);
            mItemTextView2 = (TextView) itemView.findViewById(R.id.status_control_item_text2);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.status_control_item_layout);
            mLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*switch (getPosition()){
                case 0:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 1:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 2:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 3:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 4:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 5:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
            }*/
        }
    }


    private class ShouYeListAdapter extends RecyclerView.Adapter<ShouYeListHolder> {

        @Override
        public ShouYeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ShouYeListActivity.this);
            return new ShouYeListHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(ShouYeListHolder holder, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.a);
            Drawable drawable2 = getResources().getDrawable(R.drawable.b);
            switch (position) {
                case 0:
                    holder.mImageView.setImageDrawable(drawable1);
                    holder.mItemTextView.setText(status_List[position]);
                    cTextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 1:
                    holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    ph2TextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 2:
                    holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    co2TextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 3:
                    holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    peTextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 4:
                    holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    usTextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 5:
                    holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    mg2TextView = holder.mItemTextView2;
                    holder.mItemTextView2.setText(value_List[position]);
                    break;
            }

        }


        @Override
        public int getItemCount() {
            return 6;
        }
    }

    public static Intent newIntent(Context packageContext, String listId) {
        Intent i = new Intent(packageContext, ShouYeListActivity.class);
        ListID = listId;
        return i;
    }
    @Override
    protected void onDestroy(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
        super.onDestroy();
    }

}
