package com.bignerdranch.android.fram;

import java.util.List;

/**
 * Created by gy on 17/5/27.
 */

public class Json {
    private String id;

    private List<Sensors> sensors ;

    private List<Controls> controls ;

    public String defaultval = "default";

    public void setId(String id){
        if (id == null){
            id = defaultval;
        }
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
            private String ph;
            private String id;
            private String lux;
            private String c;

            public void setPh(String ph){
                if (ph == null){
                    ph = defaultval;
                }this.ph = ph;
            }
            public String getPh(){
                return this.ph;
            }
            public void setId(String id){
                if (id == null){
                    ph = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setLux(String lux){
                if (lux == null){
                    lux = defaultval;
                }this.lux = lux;
            }
            public String getLux(){
                return this.lux;
            }
            public void setC(String c){
                if (c == null){
                    c = defaultval;
                }this.c = c;
            }
            public String getC(){
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
            private String ph;
            private String id;
            private String co2;
            private String c;

            public void setPh(String ph){
                if (ph == null){
                    ph = defaultval;
                }this.ph = ph;
            }
            public String getPh(){
                return this.ph;
            }
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setCo2(String co2){
                if (co2 == null){
                    co2 = defaultval;
                }this.co2 = co2;
            }
            public String getCo2(){
                return this.co2;
            }
            public void setC(String c){
                if (c == null){
                    c = defaultval;
                }this.c = c;
            }
            public String getC(){
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
            private String pe;
            private String id;
            private String c;

            public void setPe(String pe){
                if (pe == null){
                    pe = defaultval;
                }this.pe = pe;
            }
            public String getPe(){
                return this.pe;
            }
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setC(String c){
                if (c == null){
                    c = defaultval;
                }this.c = c;
            }
            public String getC(){
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
            private String us;
            private String id;
            private String mg;

            public void setUs(String us){
                if (us == null){
                    us = defaultval;
                }this.us = us;
            }
            public String getUs(){
                return this.us;
            }
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setMg(String mg){
                if (mg == null){
                    mg = defaultval;
                }this.mg = mg;
            }
            public String getMg(){
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
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
                return this.value;
            }

        }
        private List<Lamp> lamp;
        public void setLamp (List<Lamp> lamp){
            this.lamp = lamp;
        }
        public List<Lamp> getLamp(){
            return this.lamp;
        }
        public class Lamp{
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
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
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
                return this.value;
            }

        }
        private List<Nmembrane> nmembrane;
        public void setNmembrane(List<Nmembrane> nmembrane){
            this.nmembrane = nmembrane;
        }
        public List<Nmembrane> getNmembrane(){
            return this.nmembrane;
        }
        public class Nmembrane{
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
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
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
                return this.value;
            }

        }
        private List<Tmembrane> tmembrane;
        public void setTmembrane(List<Tmembrane> tmembrane){
            this.tmembrane = tmembrane;
        }
        public List<Tmembrane> getTmembrane(){
            return this.tmembrane;
        }
        public class Tmembrane{
            private String id;
            private String value;
            public void setId(String id){
                if (id == null){
                    id = defaultval;
                }this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setValue(String value){
                if (value == null){
                    value = defaultval;
                }this.value = value;
            }
            public String getValue(){
                return this.value;
            }
        }
    }
    public void toshow(){
        for (int i = 0 ; i < sensors.get(0).getLight().size();i++){
            System.out.println(sensors.get(0).getLight().get(i).getId());
            System.out.println(sensors.get(0).getLight().get(i).getC());
            System.out.println(sensors.get(0).getLight().get(i).getLux());
            System.out.println(sensors.get(0).getLight().get(i).getPh());
        }
        for (int i = 0 ; i < sensors.get(1).getCo2().size();i++){
            System.out.println(sensors.get(1).getCo2().get(i).getId());
            System.out.println(sensors.get(1).getCo2().get(i).getC());
            System.out.println(sensors.get(1).getCo2().get(i).getCo2());
            System.out.println(sensors.get(1).getCo2().get(i).getPh());
        }
        for (int i = 0 ; i < sensors.get(2).getWater().size();i++){
            System.out.println(sensors.get(2).getWater().get(i).getId());
            System.out.println(sensors.get(2).getWater().get(i).getC());
            System.out.println(sensors.get(2).getWater().get(i).getPe());
        }
        for (int i = 0 ; i < sensors.get(3).getSalt().size();i++){
            System.out.println(sensors.get(3).getSalt().get(i).getId());
            System.out.println(sensors.get(3).getSalt().get(i).getMg());
            System.out.println(sensors.get(3).getSalt().get(i).getUs());
        }
        for (int i = 0 ; i < controls.get(1).getLamp().size();i++){
            System.out.println(controls.get(1).getLamp().get(i).getId());
            System.out.println(controls.get(1).getLamp().get(i).getValue());
        }
        for (int i = 0 ; i < controls.get(3).getNmembrane().size();i++){
            System.out.println(controls.get(3).getNmembrane().get(i).getId());
            System.out.println(controls.get(3).getNmembrane().get(i).getValue());
        }
        for (int i = 0 ; i < controls.get(0).getBlower().size();i++){
            System.out.println(controls.get(0).getBlower().get(i).getId());
            System.out.println(controls.get(0).getBlower().get(i).getValue());
        }
        for (int i = 0 ; i < controls.get(2).getWeb().size();i++){
            System.out.println(controls.get(2).getWeb().get(i).getId());
            System.out.println(controls.get(2).getWeb().get(i).getValue());
        }
        for (int i = 0 ; i < controls.get(5).getPump().size();i++){
            System.out.println(controls.get(5).getPump().get(i).getId());
            System.out.println(controls.get(5).getPump().get(i).getValue());
        }
        for (int i = 0 ; i < controls.get(4).getTmembrane().size();i++){
            System.out.println(controls.get(4).getTmembrane().get(i).getId());
            System.out.println(controls.get(4).getTmembrane().get(i).getValue());
        }
    }
}
