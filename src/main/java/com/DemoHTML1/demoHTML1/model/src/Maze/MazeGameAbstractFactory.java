package com.DemoHTML1.demoHTML1.model.src.Maze;


import com.DemoHTML1.demoHTML1.model.src.Background.Door;
import com.DemoHTML1.demoHTML1.model.src.Items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MazeGameAbstractFactory {

    public  Maze createMaze(MazeFactory factory) {

        HashMap<Item,Integer> sellerList1= new HashMap<>(),chestList2=new HashMap<>(),chestList1=new HashMap<>();

        sellerList1.put(new FlashLight(1),1);
        sellerList1.put(new GoldKey(1),1);
        chestList1.put(new NumberOfGold(200),1);
        chestList2.put(new GoldKey(1),3);



        Maze maze = factory.makeMaze();

        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Room room3 = factory.makeRoom(3);
        Room room4 = factory.makeRoom(4);
        Room room5 = factory.makeRoom(5);
        Room room6 = factory.makeRoom(6);
        Room room7 = factory.makeRoom(7);
        Room room8 = factory.makeRoom(8);
        Room room9 = factory.makeRoom(9);


        Door door1 = factory.makeDoor(room1, room2);
        Door door2 = factory.makeDoor(room2, room3);
        Door door3 = factory.makeDoor(room4, room5);
        Door door4 = factory.makeDoor(room5, room6);
        Door door5 = factory.makeDoor(room5, room8);
        Door door6 = factory.makeDoor(room6, room9);
        Door door7 = factory.makeDoor(room7, room8);
        Door door8 = factory.makeDoor(room3, room6);

        door1.setOpen(false);
        door2.setOpen(false);
        door3.setOpen(false);
        door4.setOpen(false);
        door5.setOpen(false);
        door6.setOpen(false);
        door7.setOpen(false);
        door8.setOpen(false);

        List<Integer> listOfDoor1=new ArrayList<>();
        List<Integer> listOfDoor2=new ArrayList<>();
        List<Integer> listOfDoor3=new ArrayList<>();
        List<Integer> listOfDoor4=new ArrayList<>();
        List<Integer> listOfDoor5=new ArrayList<>();
        List<Integer> listOfDoor6=new ArrayList<>();
        List<Integer> listOfDoor7=new ArrayList<>();
        List<Integer> listOfDoor8=new ArrayList<>();
        List<Integer> listOfDoor9=new ArrayList<>();


        listOfDoor1.add(1);
        door1.setToRoom(listOfDoor1);


        listOfDoor2.add(2);
        door1.setToRoom(listOfDoor2);
        door2.setToRoom(listOfDoor2);

        listOfDoor3.add(3);
        door2.setToRoom(listOfDoor3);
        door8.setToRoom(listOfDoor3);

        listOfDoor4.add(4);
        door3.setToRoom(listOfDoor4);

        listOfDoor5.add(5);
        door3.setToRoom(listOfDoor5);
        door4.setToRoom(listOfDoor5);

        listOfDoor6.add(6);
        door4.setToRoom(listOfDoor6);
        door6.setToRoom(listOfDoor6);

        listOfDoor7.add(7);
        door7.setToRoom(listOfDoor7);

        listOfDoor8.add(8);
        door7.setToRoom(listOfDoor8);
        door5.setToRoom(listOfDoor8);

        listOfDoor9.add(9);
        door6.setToRoom(listOfDoor9);



        room1.setSide(Direction.NORTH, factory.makePaining(new SilverKey(1)));
        room1.setSide(Direction.EAST, factory.makeChest(chestList2,false));
        room1.setSide(Direction.SOUTH, factory.makeMirror(new GoldKey(1)));
        room1.setSide(Direction.WEST, door1);

        room2.setSide(Direction.NORTH, factory.makeMirror(new GoldKey(1)));
        room2.setSide(Direction.EAST, door1);
        room2.setSide(Direction.SOUTH, factory.makeSeller(sellerList1));
        room2.setSide(Direction.WEST, door2);

        room3.setSide(Direction.NORTH, door8);
        room3.setSide(Direction.EAST, door2);
        room3.setSide(Direction.SOUTH, factory.makeMirror(new SilverKey(1)));
        room3.setSide(Direction.WEST, factory.makeWall());

        room4.setSide(Direction.NORTH, factory.makeWall());
        room4.setSide(Direction.EAST, factory.makePaining(new GoldKey(1)));
        room4.setSide(Direction.SOUTH, factory.makeWall());
        room4.setSide(Direction.WEST, door3);

        room5.setSide(Direction.NORTH, door5);
        room5.setSide(Direction.EAST,  door3);
        room5.setSide(Direction.SOUTH, factory.makeMirror(new GoldKey(1)));
        room5.setSide(Direction.WEST,  door4);

        room6.setSide(Direction.NORTH, door6);
        room6.setSide(Direction.EAST,  door4);
        room6.setSide(Direction.SOUTH, door8);
        room6.setSide(Direction.WEST,  factory.makeChest(chestList2,false));


        room7.setSide(Direction.NORTH, factory.makeWall());
        room7.setSide(Direction.EAST,  factory.makeWall());
        room7.setSide(Direction.SOUTH, factory.makeWall());
        room7.setSide(Direction.WEST,  door7);

        room8.setSide(Direction.NORTH, factory.makeWall());
        room8.setSide(Direction.EAST,  door7);
        room8.setSide(Direction.SOUTH, door5);
        room8.setSide(Direction.WEST,  factory.makeWall());

        room9.setSide(Direction.NORTH, factory.makeWall());
        room9.setSide(Direction.EAST, factory.makeWall());
        room9.setSide(Direction.SOUTH, door6);
        room9.setSide(Direction.WEST, factory.makeWall());


        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);
        maze.addRoom(room7);
        maze.addRoom(room8);
        maze.addRoom(room9);

        return maze;
    }

}
