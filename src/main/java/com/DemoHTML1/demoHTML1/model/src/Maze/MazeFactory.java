package com.DemoHTML1.demoHTML1.model.src.Maze;


import com.DemoHTML1.demoHTML1.model.src.Background.*;
import com.DemoHTML1.demoHTML1.model.src.Items.Item;

import java.util.HashMap;

public class MazeFactory {

    public Maze makeMaze(){
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Painting makePaining(Item item){
        return  new Painting(item);
    }

    public Chest makeChest(HashMap<Item,Integer> listOfItems,boolean open){
        return  new Chest(listOfItems,open);
    }

    public Seller makeSeller(HashMap<Item,Integer> listOfItems){
        return new Seller(listOfItems);
    }

    public Mirror makeMirror(Item item){
        return  new Mirror(item);
    }

    public Room makeRoom(int roomNumber) {
        return new Room(roomNumber);
    }

    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

}
