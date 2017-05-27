package com.bignerdranch.android.fram;

import android.content.Context;
import android.content.Intent;
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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShouYeListActivity extends AppCompatActivity {

    private String host = "tcp://192.168.56.1:1883";
    private Handler handler;
    private MqttClient client;
    private static String myTopic;
    private MqttConnectOptions options;
    private ScheduledExecutorService scheduler;

    private Intent i;
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
    private String[] value_List = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye_list);

        init();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1) {
                    String value = msg.obj.toString().split("--split--")[1];
                    //resultTv.setText((String) msg.obj);
                    Gson gson = new Gson();
                    Json son = new Json();
                    son = gson.fromJson(value,Json.class);
                    son.show();
                    /*try{
                        int wd = son.getSensors().get(0).getLight().get(0).getC();
                        if(!wd){

                        }
                        int kqsd = son.getSensors().get(0).getLight().get(0).getPh();
                        int co2 = son.getSensors().get(1).getCo2().get(0).getCo2();
                        int trsd = son.getSensors().get(2).getWater().get(0).getPe();
                        int ddl = son.getSensors().get(3).getSalt().get(0).getUs();
                        int yf = son.getSensors().get(3).getSalt().get(0).getMg();
                        value_List[1] = ""+kqsd;
                        value_List[2] = ""+co2;
                        value_List[3] = ""+trsd;
                        value_List[4] = ""+ddl;
                        value_List[5] = ""+yf;
                        value_List[0] = ""+wd;
                    }catch (Exception e){
                        e.printStackTrace();
                    }*/
                    /*switch (title){
                        case "温度":resultTv.setText((String) msg.obj);break;
                        case "湿度":resultTv1.setText((String) msg.obj);break;
                        case "酸碱度":resultTv2.setText((String) msg.obj);break;
                    }*/



                    System.out.println("-----------------------------");
                } else if(msg.what == 2) {
                    Toast.makeText(ShouYeListActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    try {
                        client.subscribe(myTopic, 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if(msg.what == 3) {
                    Toast.makeText(ShouYeListActivity.this, "连接失败，系统正在重连", Toast.LENGTH_SHORT).show();
                }
            }
        };
        startReconnect();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.status_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ShouYeListAdapter());
    }

    private class ShouYeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mItemTextView;
        private TextView mItemTextView2;

        public ShouYeListHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.status_control_item,container,false));

            mImageView = (ImageView)itemView.findViewById(R.id.status_control_item_img);
            mItemTextView = (TextView) itemView.findViewById(R.id.status_control_item_text1);
            mItemTextView2 = (TextView)itemView.findViewById(R.id.status_control_item_text2);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.status_control_item_layout);
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


    private class ShouYeListAdapter extends RecyclerView.Adapter<ShouYeListHolder>{

        @Override
        public ShouYeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(ShouYeListActivity.this);
            return new ShouYeListHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ShouYeListHolder holder, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.a);
            Drawable drawable2 = getResources().getDrawable(R.drawable.b);
            switch (position){
                case 0:holder.mImageView.setImageDrawable(drawable1);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 1:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 2:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 3:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 4:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
                case 5:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    //holder.mItemTextView2.setText(value_List[position]);
                    break;
            }

        }


        @Override
        public int getItemCount() {
            return 6;
        }
    }
    public static Intent newIntent(Context packageContext,String listId){
        Intent i = new Intent(packageContext,ShouYeListActivity.class);
        myTopic = listId;
        return i;
    }

    private void init() {
        try {
            //host为主机名，test为clientid即连接MQTT的客户端id，id为内存保存形式
            client = new MqttClient(host, "test", new MemoryPersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session
            options.setCleanSession(true);
            // 设置超时时间
            options.setConnectionTimeout(10);
            // 设置会话心跳时间
            options.setKeepAliveInterval(20);
            client.setCallback(new MqttCallback() {

                @Override
                public void connectionLost(Throwable cause) {
                    //连接丢失后，重连
                    System.out.println("connectionLost----------");
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    //publish
                    System.out.println("deliveryComplete---------"
                            + token.isComplete());
                }

                @Override
                public void messageArrived(String topicName, MqttMessage message)
                        throws Exception {
                    //subscribe
                    System.out.println("messageArrived----------");
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = topicName+"--split--"+message.toString();
                    handler.sendMessage(msg);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startReconnect() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                if(!client.isConnected()) {
                    connect();
                }
            }
        }, 0 * 1000, 1 * 1000, TimeUnit.MILLISECONDS);
    }
    private void connect() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    client.connect(options);
                    Message msg = new Message();
                    msg.what = 2;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msg = new Message();
                    msg.what = 3;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(client != null && keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                client.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            scheduler.shutdown();
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    public String MQTValueToString(int value){

        return new String();
    }
}
