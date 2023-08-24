package logic.game;

import Monkey.BaseMonkey;
import Monkey.MommyMonkey;
import Monkey.MuscleMonkey;
import Monkey.UgabugagaMonkey;

import java.util.*;
public class GameSystem {
    private final ArrayList<BaseMonkey> monkeyContainer;
    private int sp = 5;


    private boolean gameEnd;
    private static GameSystem instance = null;

    public static GameSystem getInstance() {
        if(instance == null) {
            instance = new GameSystem();
        }
        return instance;
    }
    private GameSystem() {
        monkeyContainer = new ArrayList<BaseMonkey>();
        addMonkey();
    }

    public void addMonkey(){
        BaseMonkey m1 = new BaseMonkey(100,15,10);
        MuscleMonkey m2 = new MuscleMonkey(200,20,10);
        MommyMonkey m3 = new MommyMonkey(80,0,10);
        UgabugagaMonkey m4 = new UgabugagaMonkey(80,10,15);

        getMonkeyContainer().add(m1);
        getMonkeyContainer().add(m2);
        getMonkeyContainer().add(m3);
        getMonkeyContainer().add(m4);
    }
    public ArrayList<BaseMonkey> getMonkeyContainer() {
        return monkeyContainer;
    }

    public boolean isGameEnd() {
        if(monkeyContainer.size()<=1) {
            gameEnd=true;
        }
        return gameEnd;
    }
    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void printMonkeyStatus() {
        for(int i=0;i<monkeyContainer.size();i++) {
            BaseMonkey temp=getMonkeyContainer().get(i);
            System.out.println(temp.getType() + " hp : " +temp.getHp() + " atk : " +temp.getAtk());
        }
    }
    public void removeDeadCompetitors() {
        for(int j=getMonkeyContainer().size()-1;j>=0;j--) {
            if(getMonkeyContainer().get(j).getHp()<=0) {
                getMonkeyContainer().remove(j);
            }
        }
    }
}
