package com.DemoHTML1.demoHTML1.model.src.Items;
import com.DemoHTML1.demoHTML1.model.src.Background.Chest;
import com.DemoHTML1.demoHTML1.model.src.Background.Door;
import java.util.HashMap;

public class KeyControl implements Item {

    private boolean open=false;
    private boolean lock=true;
    private Item GoldKey=new GoldKey(0);

    public void open(){}

    public boolean isLock() {
        return lock;
    }
    public void setLock(boolean lock)
    {
        this.lock = lock;
    }


    public void UseKey(Key key,KeyControl keyControl){
        if (key instanceof GoldKey && keyControl instanceof Door)
            lock=false;
        if (key instanceof SilverKey && keyControl instanceof Chest)
            lock=false;

    }



    public void close (){
        this.open=false;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public boolean isOpen() {
        return open;
    }



    public void useKey(HashMap<Item,Integer> gameList){
        gameList.put(new GoldKey(1),1);
        gameList.forEach((k, v) ->{
        if (k instanceof GoldKey) {
            int num=0;
            if (gameList.get(k) >= 0 && this instanceof Door) {
                this.lock = false;
                this.open=true;
                num = v;
                num--;
                gameList.put(k, num);
            }
        } else  if (k instanceof SilverKey) {
            int num=0;
            if (gameList.get(k) >= 0 && this instanceof Chest) {
                this.lock = false;
                this.open=true;
                num = v;
                System.out.println(num);
                num--;
                gameList.put(k, num);
                        }
                    }
            }
        );
    }
    

}
