
package com.DemoHTML1.demoHTML1.model.src.Maze;


import com.DemoHTML1.demoHTML1.model.src.NewGame.ErrorException;

public class Direction {

    public static final Direction NORTH = new Direction("North");
    public static final Direction EAST  = new Direction("East");
    public static final Direction SOUTH = new Direction("South");
    public static final Direction WEST  = new Direction("West");

    private static int nextOrdinal = 0;
    private  String name;
    private  int ordinal = nextOrdinal++;

    private static final Direction[] values = { NORTH, EAST, SOUTH, WEST };

    public Direction(String name) {
        this.name = name;
    }

    public String toString()
    {
        return name;
    }

    public int getOrdinal() {
        return ordinal;

    }
    public String getOrdinalStr(){
        return values[ordinal].toString();
    }

    public static int directionName(Direction var0){

        if ("NORTH".equals(var0)) {
            return 3;
        }else if ("EAST".equals(var0)){
            return 0;
        }else if ("WEST".equals(var0)){
            return 2;
        }else if("SOUTH".equals(var0)){
            return 1;
        }
        return 1;
    }

    public  Direction first(){
        return values[0];
    }

    public Direction next(){
        if (ordinal < values.length - 1) {
            return values[ordinal + 1];
        } else {
            throw new ErrorException("There is no more rooms  ");
        }
    }

    public Direction opposite() {
        return values[(ordinal + 2) % 4];
    }

    public Direction Forward() {
        if(ordinal==3)
            ordinal=0;
        else
            ordinal++;
        return values[ordinal];
    }

    public Direction Backward() {
           ordinal=(ordinal+4-1)%4;
        System.out.println(ordinal);
            return values[ordinal];

    }

    public Direction move(String command) {
        if (command == null) {
            throw new ErrorException("Is not valid command");
        } else if (command.equalsIgnoreCase("Forward")) {
            return Forward();
        } else if (command.equalsIgnoreCase("Backward")) {
            return Backward();
        }
        return null;
    }
}
