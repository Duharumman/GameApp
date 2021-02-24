package com.DemoHTML1.demoHTML1.model.src.Items;


public class SilverKey implements Item, Key{
    private int silverKey;
    private String name="silverKey";

    public SilverKey(int num) {
        this.silverKey+=num;
    }


    public String toString() {
        return name;
    }

    public int getSilverKey() {
        return silverKey ;
    }

    public  void  collectKey( ){
        silverKey++;
    }


}
