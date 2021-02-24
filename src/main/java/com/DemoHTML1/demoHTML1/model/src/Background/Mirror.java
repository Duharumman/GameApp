package com.DemoHTML1.demoHTML1.model.src.Background;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.SingletonPlayer;

import java.util.HashMap;

public class Mirror implements Checkable,Background {

    private Item item;
    private Mirror mirror;

    public String look() {
        return  "You see a silhouette of you ^_^ ";
    }

    public Mirror(Item item){
        this.item=item;
    }

    public String Check(HashMap<Item,Integer> gameList) {
        gameList.put(item,1);
        return this.item.toString();
        //printDetails();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void CollectItems(SingletonPlayer player) {
        player.addItem(this.item);
    }

}
