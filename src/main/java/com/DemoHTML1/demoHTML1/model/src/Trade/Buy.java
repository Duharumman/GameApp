package com.DemoHTML1.demoHTML1.model.src.Trade;


import com.DemoHTML1.demoHTML1.model.src.Background.Background;
import com.DemoHTML1.demoHTML1.model.src.Items.Item;

import java.util.HashMap;

public class Buy extends Trade implements Background {

    @Override
    public String look() {
        return "buy";
    }

    public  boolean buy(HashMap<Item,Integer>listOfItemSeller , HashMap<Item,Integer>listOfPlayer, Item item) {
        return false;
    }

}
