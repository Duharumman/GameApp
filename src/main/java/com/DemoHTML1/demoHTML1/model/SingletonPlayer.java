package com.DemoHTML1.demoHTML1.model;


import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.src.Maze.Direction;
import com.DemoHTML1.demoHTML1.model.src.Maze.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonPlayer  {

    //public Direction direction;
    private String name;
    private boolean win;
    protected HashMap<Item, Integer>playerList=new HashMap<Item, Integer>();
    protected HashMap<Item,Integer>SellerList=new HashMap<>();
    protected List<Room> rooms = new ArrayList<Room>();
    public Direction direction=new Direction("NORTH");
    private Item item;
    private  int score;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Item, Integer> getPlayerList() {
        return playerList;
    }


    public void setWin(boolean win) {
        this.win = win;
    }

    public void resetPlayerList(HashMap<Item, Integer> gameList) {
        for (Map.Entry<Item, Integer> entry : gameList.entrySet()) {
            if (!this.playerList.containsKey(entry.getKey())) {
                this.playerList.put(entry.getKey(), entry.getValue());
            }
        }
    }
    public void setPlayerList(HashMap<Item, Integer> playerList) {
        this.playerList = playerList;
    }

    public HashMap<Item, Integer> getSellerList() {
        return SellerList;
    }

    public void setSellerList(HashMap<Item, Integer> sellerList) {
        SellerList = sellerList;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private static SingletonPlayer player;

    public static synchronized SingletonPlayer getInstance(){
        if (player==null ){
            player =new SingletonPlayer();
        }
        return player;
    }


    public void addItem( Item item){
        for (Map.Entry<Item,Integer> map:playerList.entrySet()) {
            if (playerList.containsKey(item)) {
                playerList.put(map.getKey(), playerList.get(map.getValue()+ 1));
            }
            else {
                playerList.put(map.getKey(),map.getValue());
            }
        }
    }


    public boolean isWin() {
        return this.win;
    }

    public void setWin() {
        this.win = true;
    }

    public Direction getDirection() {
        return direction;
    }

    public void printListOfPlayer (){
        playerList.forEach((k, v) -> {
            System.out.println("Item: "+ k + "value:" + v);
        });
    }


}
