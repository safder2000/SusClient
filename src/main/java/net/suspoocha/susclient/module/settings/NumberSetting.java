package net.suspoocha.susclient.module.settings;

import net.suspoocha.susclient.SusClient;

public class NumberSetting extends Setting{

    private  double min,max,increment;
    private  double value;
    public NumberSetting(String name,double min, double max, double defaultvalue, double increment) {
        super(name);
        this .min = min;
        this.max = max;
        this.value = defaultvalue;
        this.increment  =increment;
    }
    public  static  double clamp(double value ,double min , double max){
        value = Math.max(min,value);
        value = Math.min(max,value);
        return  value;
    }

    public double getValue() {
        return value;
    }
    public float getValueFloat(){
        return  (float)value;
    }
    public int getValueInt(){
        return (int)value;
    }
    public double getIncrement() {
        return increment;
    }

    public void setValue(double value) {
        SusClient.logger.info("value send  to setNum : " +value+ "min :" +this.min +", max :"+this.max);
        value = clamp(value,this.min,this.max);
        SusClient.logger.info("value after clamp : " +value);
        value = Math.round(value *(1.0/this.increment))/(1.0/this.increment);
        SusClient.logger.info("value after round : " +value);
        this.value = value;
        SusClient.logger.info("value set to  = " +this.value);
    }
    public void increment(boolean positive){
        if(positive)setValue(getValue()+getIncrement());
        else setValue(getValue()-getIncrement());
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
