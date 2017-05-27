package com.bignerdranch.android.fram;


import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

;import com.google.gson.Gson;

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

public class MainActivity extends FragmentActivity{

    private String host = "tcp://192.168.56.1:1883";
    private Handler handler;
    private MqttClient client;
    private static String myTopic = "myTopic";
    private MqttConnectOptions options;
    private ScheduledExecutorService scheduler;
    private MyApplication applic;

    private Class[] fragment = new Class[]{FrontPageFragment.class,MonitorFragment.class,
            ControlFragment.class,DataFragment.class};
    private int[] imgSelector = new int[]{
            R.drawable.frontpage,
            R.drawable.monitoring,
            R.drawable.control,
            R.drawable.data,
    };
    private String[] name = new String[]{
            "首页",
            "监控",
            "控制",
            "数据",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applic = (MyApplication)getApplication();

        init();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1) {
                    //System.out.println("6444444444"+"_______"+applic.getMQTjson().getId());

                } else if(msg.what == 2) {
                    Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                    try {
                        applic.setTopic("01");
                        client.subscribe(applic.getMyTopic(), 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if(msg.what == 3) {
                    Toast.makeText(MainActivity.this, "连接失败，系统正在重连", Toast.LENGTH_SHORT).show();
                }
            }
        };
        startReconnect();






        FragmentTabHost tabHost = (FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);

        for(int i=0;i<fragment.length;i++){

            View inflater = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_img = (ImageView) inflater.findViewById(R.id.iv);
            TextView tab_text = (TextView) inflater.findViewById(R.id.tv);

            tab_img.setImageResource(imgSelector[i]);
            tab_text.setText(name[i]);


            tabHost.addTab(tabHost.newTabSpec(""+ i).setIndicator("tab1").setIndicator(inflater),fragment[i],null);
        }
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
                    Gson gson = new Gson();
                    Json son = new Json();
                    son = gson.fromJson(message.toString(),Json.class);
                    applic = (MyApplication) getApplication();
                    applic.setMQTjson(son);
                    //son.toshow();
                    System.out.println("messageArrived----------");
                    Message msg = new Message();
                    msg.what = 1;
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
