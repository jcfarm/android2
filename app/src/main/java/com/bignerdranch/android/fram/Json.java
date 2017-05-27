package com.bignerdranch.android.fram;

import java.util.List;

/**
 * Created by gy on 17/5/27.
 */

public class Json {
    private String id;

    private List<Sensors> sensors ;

    private List<Controls> controls ;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setSensors(List<Sensors> sensors){
        this.sensors = sensors;
    }
    public List<Sensors> getSensors(){
        return this.sensors;
    }
    public void setControls(List<Controls> controls){
        this.controls = controls;
    }
    public List<Controls> getControls(){
        return this.controls;
    }
    public class Sensors {

        private List<Light> light ;

        public void setLight(List<Light> light){
            this.light = light;
        }
        public List<Light> getLight(){
            return this.light;
        }
        public class Light {
            private int ph;
            private int id;
            private int lux;
            private int c;

            public void setPh(int ph){
                this.ph = ph;
            }
            public int getPh(){
                return this.ph;
            }
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setLux(int lux){
                this.lux = lux;
            }
            public int getLux(){
                return this.lux;
            }
            public void setC(int c){
                this.c = c;
            }
            public int getC(){
                return this.c;
            }

        }
        private List<Co2> co2 ;

        public void setCo2(List<Co2> co2){
            this.light = light;
        }
        public List<Co2> getCo2(){
            return this.co2;
        }
        public class Co2 {
            private int ph;
            private int id;
            private int co2;
            private int c;

            public void setPh(int ph){
                this.ph = ph;
            }
            public int getPh(){
                return this.ph;
            }
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setCo2(int co2){
                this.co2 = co2;
            }
            public int getCo2(){
                return this.co2;
            }
            public void setC(int c){
                this.c = c;
            }
            public int getC(){
                return this.c;
            }

        }
        private List<Water> water ;

        public void setWater(List<Water> water){
            this.water = water;
        }
        public List<Water> getWater(){
            return this.water;
        }
        public class Water {
            private int pe;
            private int id;
            private int c;

            public void setPe(int pe){
                this.pe = pe;
            }
            public int getPe(){
                return this.pe;
            }
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setC(int c){
                this.c = c;
            }
            public int getC(){
                return this.c;
            }

        }
        private List<Salt> salt ;

        public void setSalt(List<Salt> salt){
            this.salt = salt;
        }
        public List<Salt> getSalt(){
            return this.salt;
        }
        public class Salt {
            private int us;
            private int id;
            private int mg;

            public void setUs(int us){
                this.us = us;
            }
            public int getUs(){
                return this.us;
            }
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setMg(int mg){
                this.mg = mg;
            }
            public int getMg(){
                return this.mg;
            }

        }
    }
    public class Controls {
        private List<Blower> blower ;
        public void setBlower(List<Blower> blower){
            this.blower = blower;
        }
        public List<Blower> getBlower(){
            return this.blower;
        }
        public class Blower {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
        private List<Lamp> lamp ;
        public void setLamp(List<Lamp> lamp){
            this.lamp = lamp;
        }
        public List<Lamp> getLamp(){
            return this.lamp;
        }
        public class Lamp {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
        private List<Web> web ;
        public void setWeb(List<Web> web){
            this.web = web;
        }
        public List<Web> getWeb(){
            return this.web;
        }
        public class Web {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
        private List<Nmembrane> nmembrane ;
        public void setNmembrane(List<Nmembrane> nmembrane){
            this.nmembrane = nmembrane;
        }
        public List<Nmembrane> getNmembrane(){
            return this.nmembrane;
        }
        public class Nmembrane {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
        private List<Tmembrance> tmembrance ;
        public void setTmembrance(List<Tmembrance> tmembrance){
            this.tmembrance = tmembrance;
        }
        public List<Tmembrance> getTmembrance(){
            return this.tmembrance;
        }
        public class Tmembrance {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
        private List<Pump> pump ;
        public void setPump(List<Pump> pump){
            this.pump = pump;
        }
        public List<Pump> getPump(){
            return this.pump;
        }
        public class Pump {
            private int id;
            private float value;
            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setValue(float value){
                this.value = value;
            }
            public float getValue(){
                return this.value;
            }

        }
    }


    public void show(){

        System.out.println(id);
        for (int i = 0;i<sensors.get(0).light.size();i++){
            System.out.println(sensors.get(0).light.get(i).id);
            System.out.println(sensors.get(0).light.get(i).ph);
            System.out.println(sensors.get(0).light.get(i).c);
            System.out.println(sensors.get(0).light.get(i).lux);
        }
        for (int i = 0;i<sensors.get(1).co2.size();i++){
            System.out.println(sensors.get(1).co2.get(i).id);
            System.out.println(sensors.get(1).co2.get(i).ph);
            System.out.println(sensors.get(1).co2.get(i).c);
            System.out.println(sensors.get(1).co2.get(i).co2);
        }
        for (int i = 0;i<sensors.get(2).water.size();i++){
            System.out.println(sensors.get(2).water.get(i).id);
            System.out.println(sensors.get(2).water.get(i).pe);
            System.out.println(sensors.get(2).water.get(i).c);
        }
        for (int i = 0;i<sensors.get(3).salt.size();i++){
            System.out.println(sensors.get(3).salt.get(i).id);
            System.out.println(sensors.get(3).salt.get(i).us);
            System.out.println(sensors.get(3).salt.get(i).mg);
        }

        for (int i = 0;i<controls.get(0).blower.size();i++){
            System.out.println(controls.get(0).blower.get(i).id);
            System.out.println(controls.get(0).blower.get(i).value);
        }
        for (int i = 0;i<controls.get(0).lamp.size();i++){
            System.out.println(controls.get(0).lamp.get(i).id);
            System.out.println(controls.get(0).lamp.get(i).value);
        }
        for (int i = 0;i<controls.get(0).web.size();i++){
            System.out.println(controls.get(0).web.get(i).id);
            System.out.println(controls.get(0).web.get(i).value);
        }
        for (int i = 0;i<controls.get(0).nmembrane.size();i++){
            System.out.println(controls.get(0).nmembrane.get(i).id);
            System.out.println(controls.get(0).nmembrane.get(i).value);
        }
        for (int i = 0;i<controls.get(0).tmembrance.size();i++){
            System.out.println(controls.get(0).tmembrance.get(i).id);
            System.out.println(controls.get(0).tmembrance.get(i).value);
        }
        for (int i = 0;i<controls.get(0).pump.size();i++){
            System.out.println(controls.get(0).pump.get(i).id);
            System.out.println(controls.get(0).pump.get(i).value);
        }
        for (int i = 0;i<controls.get(0).blower.size();i++){
            System.out.println(controls.get(0).blower.get(i).id);
            System.out.println(controls.get(0).blower.get(i).value);
        }

    }
}
