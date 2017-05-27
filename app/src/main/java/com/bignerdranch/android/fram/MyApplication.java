package com.bignerdranch.android.fram;

import android.app.Application;

/**
 * Created by gy on 17/5/27.
 */

public class MyApplication extends Application {
    private Json MQTjson;
    private String MyTopic;
    @Override
    public void onCreate(){
        super.onCreate();
        setMQTjson(new Json());
        setTopic("myTopic");

    }
    public void setTopic(String topic){
        this.MyTopic = topic;
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
