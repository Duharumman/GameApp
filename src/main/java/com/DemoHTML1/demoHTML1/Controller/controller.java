   package com.DemoHTML1.demoHTML1.Controller;

    import com.DemoHTML1.demoHTML1.model.Player;
    import com.DemoHTML1.demoHTML1.model.src.Background.Checkable;
    import com.DemoHTML1.demoHTML1.model.src.Background.Chest;
    import com.DemoHTML1.demoHTML1.model.src.Background.Door;
    import com.DemoHTML1.demoHTML1.model.src.Commands;
    import com.DemoHTML1.demoHTML1.model.src.Items.*;
    import com.DemoHTML1.demoHTML1.model.src.Maze.Maze;
    import com.DemoHTML1.demoHTML1.model.src.Maze.MazeFactory;
    import com.DemoHTML1.demoHTML1.model.src.Maze.MazeGameAbstractFactory;
    import com.DemoHTML1.demoHTML1.model.src.NewGame.Help;
    import com.DemoHTML1.demoHTML1.model.SingletonPlayer;
    import com.DemoHTML1.demoHTML1.model.src.NewGame.Stop;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.ModelAndView;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import java.util.Date;


import java.util.HashMap;

@WebServlet
@Controller
public class controller extends HttpServlet {

    @RequestMapping("/hello")
    public ModelAndView display(){
        ModelAndView mav= new ModelAndView("hello");
        Player player=new Player();
        mav.addObject("player",player);
        return mav;
    }

    @RequestMapping("/createGame")
    public ModelAndView createGame(@ModelAttribute Player player){
        ModelAndView mav= new ModelAndView("join");
        return mav;
    }

    @RequestMapping("/SavePlayers")
    public ModelAndView savePlayer(@ModelAttribute Player player){
        ModelAndView mav= new ModelAndView("Result");
        Commands command =new Commands();
        command.setPlayerCommands("");
        command.setReturnStatus("");
        mav.addObject("command",command);
        return mav;
    }

    @RequestMapping(value="/execute")
    public String add(@ModelAttribute("command")  Commands command, Model model ){
        //Stop stop = new Stop();
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
        HashMap<String,Integer> GameList =new HashMap<>();
        System.out.println("Are you ready to start game ?!");
        System.out.println("press H anytime to help  ");

        String result=new String();

        long start =System.currentTimeMillis();
        long end =start+60*1000;

        model.addAttribute("player", player);
        if(command.getPlayerCommands().equalsIgnoreCase("H")) {
                help.print();
            }else if (command.getPlayerCommands().equalsIgnoreCase("quit")) {
                command.setReturnStatus("GAME OVER ! ");
            }else if (command.getPlayerCommands().equalsIgnoreCase("check")) {

                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Checkable) {
                        command.setReturnStatus(((Checkable) mazeGame.getRooms().get(mazeGame.getCurRoom()).getCurrentSide(player.direction.getOrdinal())).Check(gameList));
                        GameList.put((((Checkable) mazeGame.getRooms().get(mazeGame.getCurRoom()).getCurrentSide(player.direction.getOrdinal())).Check(gameList)),1);
                    }
            }else if (command.getPlayerCommands().equalsIgnoreCase("look")) {
                command.setReturnStatus(mazeGame.getRooms().get(mazeGame.getCurRoom()).getCurrentSide(player.direction.getOrdinal()).look());
            }else if (command.getPlayerCommands().equalsIgnoreCase("collectKey")) {
                silverKey.collectKey();
                gameList.put(silverKey, silverKey.getSilverKey());
            }else if (command.getPlayerCommands().equalsIgnoreCase("backward")) {
                player.getDirection().Backward();
                command.setReturnStatus(player.direction.getOrdinalStr());
            } else if (command.getPlayerCommands().equalsIgnoreCase("forward")) {
                player.getDirection().Forward();
                command.setReturnStatus(player.direction.getOrdinalStr());
            }else if (command.getPlayerCommands().equalsIgnoreCase("open")){
                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof KeyControl){
                    if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Door){
                        if(((Door) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isOpen()){
                            command.setReturnStatus("The Door is open");
                        }else if(((Door) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isLock()){
                            command.setReturnStatus("Use goldKey to unlock");
                        }
                    }else if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Chest) {
                        if (((Chest) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isOpen()) {
                            command.setReturnStatus("The chest is open");
                        } else if (((Chest) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isLock()) {
                            command.setReturnStatus("use silverKey to unlock");
                        }
                    }
                }else {
                 command.setReturnStatus("no thing to open ");
                }
            }else if (command.getPlayerCommands().equalsIgnoreCase("enter")) {
                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Door) {
                    if (((Door) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isOpen()) {
                        ((Door) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).enter(mazeGame);
                        command.setReturnStatus(" You have passed ");
                    } else {
                        command.setReturnStatus("The door is closed");
                    }
                }else {
                    command.setReturnStatus("There is no door here ");
                }
            }else if (command.getPlayerCommands().equalsIgnoreCase("useGoldKey")) {
                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Door){
                    ((KeyControl)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).useKey(gameList);
                    if(((Door) mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).isOpen()){
                        command.setReturnStatus("The door is open ");
                    }else {
                        command.setReturnStatus("there is no key to use ");
                    }
                }else {
                    command.setReturnStatus("you can not use the key here");
                }
            }else if (command.getPlayerCommands().equalsIgnoreCase("useSilverKey")) {
                if (mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()] instanceof Chest)
                    ((KeyControl)mazeGame.getRooms().get(mazeGame.getCurRoom()).getSides()[player.getDirection().getOrdinal()]).useKey(gameList);
            }else if (command.getPlayerCommands().equalsIgnoreCase("printList")) {
                String str ="123456";
                for (HashMap.Entry<String, Integer> entry : GameList.entrySet()){
                   str += entry.getKey();
                }
                command.setReturnStatus(str);
            }
        return "Result";
    }
}
