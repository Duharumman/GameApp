package com.DemoHTML1.demoHTML1.model.src.Background;

import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.SingletonPlayer;

import java.util.HashMap;

public class Painting  implements Checkable,Background{

    private Item item;
    private Painting painting;

    public String Check(HashMap<Item,Integer> gameList) {
        gameList.put(item,100);
        String str =new String();
        str=this.item.toString();
        return str;
        //printDetails();
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String look() {
        return "Painting";
    }

    public Painting(Item item){
        this.item=item;
    }


    public void CollectItems(SingletonPlayer player) {
        player.addItem(this.item);
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
