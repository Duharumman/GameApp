package com.DemoHTML1.demoHTML1.model.src.Items;



import com.DemoHTML1.demoHTML1.model.src.NewGame.ErrorException;

public class FlashLight implements Item {

    private int Flash;

    public FlashLight(int num) {
        this.Flash=num;
    }

    public String toString() {
        return "FlashLight";
    }

    public int getFlashLight( String flash) {
        return Flash;
    }

    public  void  collectFlashLight(int  flash ){
        if(flash==0)
            throw new ErrorException("There is no key to collect");
        else{
            this.Flash+=flash;
        }
    }
}
