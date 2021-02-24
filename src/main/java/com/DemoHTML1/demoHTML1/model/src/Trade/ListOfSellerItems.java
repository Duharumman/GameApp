package com.DemoHTML1.demoHTML1.model.src.Trade;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;

import java.util.HashMap;

public class ListOfSellerItems extends Trade {
    HashMap<Item,Integer>SellerList;

    public HashMap<Item, Integer> getSellerList() {
        return SellerList;
    }

    public void setSellerList(HashMap<Item, Integer> sellerList) {
        SellerList = sellerList;
    }

    public void printDetails(){
        System.out.println(this.SellerList);
    }

}
