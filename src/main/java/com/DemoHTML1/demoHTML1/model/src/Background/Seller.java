package com.DemoHTML1.demoHTML1.model.src.Background;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.src.NewGame.ErrorException;

import java.util.HashMap;

public class Seller implements Background {
    protected Item item;
    protected HashMap<Item,Integer>list;


    public Seller(HashMap<Item,Integer>list){
        this.list=list;
    }

    public HashMap<Item, Integer> getItems(){
        return this.list;
    }

    public String look() {
        return "Seller ";
    }

    public String toString() {
        return super.toString();
    }

    public boolean searchItem (String nameItem)  {

        boolean found=false;

        if (nameItem==null)
            throw new ErrorException(" null name item ");

        if(list.containsValue(nameItem))
            found=true;
        /*
        for (Map.Entry<Item, Integer> entry : list.entrySet()) {
            if (entry.getKey().toString().equalsIgnoreCase(nameItem))
                found=true;
        }*/
        return found;
    }
}






