package com.bignerdranch.android.fram;

import android.app.Application;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by gy on 17/5/27.
 */

public class MyApplication extends Application {
    private Json MQTjson;
    private String MyTopic = "";
    private MqttClient client;
    private String lastTopic;
    @Override
    public void onCreate(){
        super.onCreate();
        setMQTjson(new Json());
    }
    public void setClient(MqttClient client){
        this.client = client;
    }
    public void setTopic(String topic){
        this.MyTopic = topic;
        if( MyTopic != "" ){
            try {
                client.subscribe(MyTopic, 1);
            } catch (MqttException e) {
                e.printStackTrace();
            }
            lastTopic = MyTopic;
        }else {
            try {
                client.unsubscribe(lastTopic);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }
    public String getMyTopic(){
        return this.MyTopic;
    }

    public void setMQTjson(Json son){
        this.MQTjson = son;
    }
    public Json getMQTjson(){
        return this.MQTjson;
    }
}
