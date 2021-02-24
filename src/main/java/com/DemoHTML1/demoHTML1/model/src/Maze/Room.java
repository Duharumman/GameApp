package com.DemoHTML1.demoHTML1.model.src.Maze;


import com.DemoHTML1.demoHTML1.model.src.Background.Background;
import com.DemoHTML1.demoHTML1.model.src.Items.Item;

public class Room  {
    private Item item;
    private int roomNumber = 0;
    private boolean inRoom = false;

    public Background getCurrentSide(int dir ){
        return sides[dir];
    }

    public Background[] getSides() {
        return sides;
    }

    public void setSides(Background[] sides) {
        this.sides = sides;
    }

    protected Background[] sides = new Background[4];

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomNumber(int roomNumber, Maze maze) {
        this.roomNumber = roomNumber;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isInRoom() {
        return inRoom;
    }

    public void setInRoom(boolean inRoom) {
        this.inRoom = inRoom;
    }

    public void setSide(Direction dir, Background background) {
        if (dir != null) {
            sides[dir.getOrdinal()] = background;

        }
    }

}

