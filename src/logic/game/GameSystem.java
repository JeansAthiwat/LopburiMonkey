package logic.game;

import Monkey.BaseMonkey;
import java.util.*;
public class GameSystem {
    private ArrayList<BaseMonkey> monkeyContainer;
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

//    public void printCompetitorsStatus() {
//        for(int i=0;i<allCompetitors.size();i++) {
//            BaseCompetitor temp=allCompetitors.get(i);
//            System.out.println(temp.getType()+" "+temp.getName()+" hp: "+temp.getHp()+" power: "+temp.getPower());
//        }
//    }
//    public void removeDeadCompetitors() {
//        for(int j=allCompetitors.size()-1;j>=0;j--) {
//            if(allCompetitors.get(j).getHp()<=0) {
//                allCompetitors.remove(j);
//            }
//        }
//    }
}
