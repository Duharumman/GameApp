package com.DemoHTML1.demoHTML1.model.src.Background;



import com.DemoHTML1.demoHTML1.model.src.Items.Item;
import com.DemoHTML1.demoHTML1.model.src.Items.KeyControl;
import com.DemoHTML1.demoHTML1.model.src.Maze.MapSite;
import com.DemoHTML1.demoHTML1.model.src.Maze.Maze;
import com.DemoHTML1.demoHTML1.model.src.Maze.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Door extends KeyControl implements Background, MapSite {

    private Room room1;
    private Room room2;
    private List<Integer> toRoom=new ArrayList<Integer>();
    private Item item;

    public List<Integer> getToRoom() {
        return toRoom;
    }

    public void setToRoom(List<Integer> toRoom) {
        this.toRoom = toRoom;
    }


    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    public String look() {
        return "DOOR";
    }


    public void open(){
        if (this.isLock()) {
            System.out.println("use goldKey to unlock");
        }else if (this.isOpen())
            System.out.println("nothing happened");
    }

    public void enter(Maze maze) {
        if (!this.isOpen())
            System.out.println("");
        else {
            System.out.println("Please Choose Room To Enter");
            System.out.println(toRoom);
            Scanner scan = new Scanner(System.in);
            int temproom = scan.nextInt();
            if (toRoom.indexOf((Integer) temproom) >= 0 && toRoom.indexOf((Integer) temproom) < toRoom.size())
                maze.setCurRoom(temproom);
        }
    }
}
