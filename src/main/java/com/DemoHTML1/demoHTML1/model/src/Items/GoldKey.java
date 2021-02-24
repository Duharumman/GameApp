package com.DemoHTML1.demoHTML1.model.src.Items;


import com.DemoHTML1.demoHTML1.model.src.NewGame.ErrorException;

public class GoldKey implements Item ,Key{
    private int goldKey;

    private String name="goldKey";

    public GoldKey( int num ) {
        this.goldKey=num;
    }

    public String toString() {
        return name;
    }

    public int getGolds( String key) {
        return goldKey;
    }

    public  void  collectKey(int  golds ){
        if(golds<0)
            throw new ErrorException("There is no key to collect");
        else{
            this.goldKey+=golds;
        }
    }


}
/*
    public void withdrawCoin(int amountOfCoin) {
        if (amountOfCoin>amountCoinsOfGold )
            throw new IllegalArgumentException("you not have enough gold");
        amountCoinsOfGold-=amountOfCoin;
   }*/


