package com.DemoHTML1.demoHTML1.model.src.Items;


import com.DemoHTML1.demoHTML1.model.src.NewGame.ErrorException;

public class NumberOfGold implements Item {
    private  int golds;
    private String name="numberOfGold";

    public  NumberOfGold(int golds) {
         this.golds=golds;
    }

    public String toString() {
        return name;
    }

    public int getGolds() {
        return golds;
    }

    public  void  collectGolds(int golds){
        if(golds<0)
            throw new ErrorException("There are no golds to collect");
        else{
            this.golds+=golds;
        }
    }


}
