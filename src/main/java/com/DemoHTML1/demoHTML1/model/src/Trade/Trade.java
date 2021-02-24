package com.DemoHTML1.demoHTML1.model.src.Trade;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.src.Items.NumberOfGold;

import java.util.HashMap;
import java.util.Map;

public abstract class Trade {
    private boolean buyItem=false;
    private int cost=0,gold = 0;
    private Item goldItem = null;
    ListOfSellerItems listOfSellerItems =new ListOfSellerItems();
    HashMap<Item,Integer>listOfItemSeller=new HashMap<>(),listOfPlayer=new HashMap<>();
    Item item=new NumberOfGold(0);

    public final void doSteps()  {
         ListOfSellerItems();
         Buy( listOfItemSeller , listOfPlayer,item);
         FinishTrade();
    }

    public void ListOfSellerItems(){
        listOfSellerItems.printDetails();
    }
    public  boolean Buy(HashMap<Item,Integer> listOfItemSeller , HashMap<Item,Integer>listOfPlayer, Item item) {
        for (Map.Entry<Item, Integer> entry : listOfItemSeller.entrySet()) {
            Item k = entry.getKey();
            Integer v = entry.getValue();
            if (k.toString().equalsIgnoreCase(item.toString())) {
                cost = v;
            }
        }
        for (Map.Entry<Item, Integer> entry : listOfPlayer.entrySet()) {
            Item k = entry.getKey();
            Integer v = entry.getValue();
            if (k.toString().equalsIgnoreCase(" numberOfGold")) {
                gold = v;
                goldItem=k;
            }
            if (k.toString().equalsIgnoreCase(item.toString()))
            {
                int temp=v;
                if (gold>=cost) {
                    temp++;
                    gold -= cost;
                    listOfPlayer.replace(k, v);
                    listOfPlayer.replace(goldItem,gold);
                    buyItem=true;
                }

            }
        }
        return  buyItem;
    }
    public void FinishTrade(){
        if(this.buyItem==true){
            System.out.println("new Item add to your list ");
        }else {
            System.out.println("you haven't enough golds to buy ):");
        }
    }
}
