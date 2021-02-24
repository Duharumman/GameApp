package com.DemoHTML1.demoHTML1.model.src.Background;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.src.Items.KeyControl;

import java.util.HashMap;


public class Chest extends KeyControl implements Checkable ,Background{

    private HashMap<Item,Integer>listOfItems;
    private Item item;
    private Chest chest;
    private boolean open;

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }

    public String look() {
        return "Chest";
    }


    public String Check(HashMap<Item,Integer> gameList) {
        String str =new String();
        if (this.isLock()) {
            return "The chest is closed  you need a Silver key to unlock" ;
        }else{
            listOfItems.forEach((k, v) -> {
                int num=gameList.get(k);
              gameList.put(k,(num+v));
            });

            for (HashMap.Entry<Item, Integer> e : listOfItems.entrySet())
                str+=e.getValue();

            // printDetails();
        }
        return str;
    }

    public Chest( HashMap<Item,Integer>listOfItems ,boolean open){

        this.listOfItems=listOfItems;
        this.open=open;
    }

//    public String printDetails(){
//        String str =new String();
//        for (HashMap.Entry<Item, Integer> e : listOfItems.entrySet())
//            str+=e.getValue();
//        return str;
//    }



    public void open(){
        if (this.isLock()){

            System.out.println("use goldKey to unlock");
        }
        else if (!this.isLock() && isOpen())
            System.out.println("nothing happened");
        else
            setOpen(true);
    }

    public String toString() {
        return ("Chest");
    }

}
