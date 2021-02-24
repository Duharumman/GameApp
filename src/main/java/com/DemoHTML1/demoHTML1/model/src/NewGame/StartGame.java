package com.DemoHTML1.demoHTML1.model.src.NewGame;


import com.DemoHTML1.demoHTML1.model.SingletonPlayer;
import com.DemoHTML1.demoHTML1.model.src.Background.Checkable;
import com.DemoHTML1.demoHTML1.model.src.Background.Chest;
import com.DemoHTML1.demoHTML1.model.src.Background.Door;
import com.DemoHTML1.demoHTML1.model.src.Items.*;
import com.DemoHTML1.demoHTML1.model.src.Maze.Maze;
import com.DemoHTML1.demoHTML1.model.src.Maze.MazeFactory;
import com.DemoHTML1.demoHTML1.model.src.Maze.MazeGameAbstractFactory;

import java.util.HashMap;
import java.util.Scanner;

public class StartGame {

    static Scanner sc=new Scanner(System.in);

    public static void main(String args) {

        Stop stop = new Stop();
        Help help = new Help();
        MazeFactory maze = new MazeFactory();
        MazeGameAbstractFactory game = new MazeGameAbstractFactory();
        Maze mazeGame = game.createMaze(maze);
        SingletonPlayer player = SingletonPlayer.getInstance();


        SilverKey silverKey = new SilverKey(0);
        GoldKey goldKey = new GoldKey(0);
        FlashLight flashLight = new FlashLight(0);
        NumberOfGold numberOfGold = new NumberOfGold(100);

        HashMap<Item, Integer> gameList = new HashMap<>();

        System.out.println("Are you ready to start game ?!");
        System.out.println("press H anytime to help  ");

       String commands ;
        while (true) {
            commands =sc.next();


           if(commands.equalsIgnoreCase("H")) {
               help.print();
            }else if (commands.equalsIgnoreCase("quit")) {
                stop.quit();
            } else if (commands.equalsIgnoreCase("check")) {
               if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Checkable)
                ((Checkable) mazeGame.getRooms().get(mazeGame.getCurRoom()).getCurrentSide(player.direction.getOrdinal())).Check(gameList);
            } else if (commands.equalsIgnoreCase("look")) {
                mazeGame.getRooms().get(mazeGame.getCurRoom()).getCurrentSide(player.direction.getOrdinal()).look();
            } else if (commands.equalsIgnoreCase("collectKey")) {
                silverKey.collectKey();
                gameList.put(silverKey, silverKey.getSilverKey());
                System.out.println(gameList);
            } else if (commands.equalsIgnoreCase("backward")) {
                player.getDirection().Backward();
                System.out.println(mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]);

            } else if (commands.equalsIgnoreCase("forward")) {
                player.getDirection().Forward();
                System.out.println(mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]);
            }else if (commands.equalsIgnoreCase("open")){
              // if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof KeyControl)
                   //((KeyControl)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).open();
            }
            else if (commands.equalsIgnoreCase("enter"))
            {
                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]instanceof Door)
                    ((Door)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).enter(mazeGame);//mazeGame.changeRoom(true,player.direction.getOrdinal());
            }
           else if (commands.equalsIgnoreCase("useGoldKey")) {
               if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Door)
                   ((KeyControl)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).useKey(gameList);
           }
           else if (commands.equalsIgnoreCase("useSilverKey")) {
               if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Chest)
                   ((KeyControl)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).useKey(gameList);


           }
           else if (commands.equalsIgnoreCase("printList")){
               System.out.println(gameList);

           }

            if (player.isWin()) {
                System.out.println("Good job  ");
                System.exit(1);
            } else {
                System.out.println("Game Over ");
            }
        }

    }
}
