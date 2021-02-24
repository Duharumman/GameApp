package com.DemoHTML1.demoHTML1.model.src.Maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private int curRoom = 0;
    private List<Room> rooms = new ArrayList<Room>();

    public int getCurRoom() {
        return curRoom;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setCurRoom(int curRoom) {
        this.curRoom=curRoom;
    }

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }

    public Room findRoom(int roomNumber) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = (Room) rooms.get(i);
            if (roomNumber == room.getRoomNumber()) {
                return room;
            }
        }
        return null;
    }


}
