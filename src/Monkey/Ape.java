package Monkey;

import logic.game.GameSystem;

import java.util.ArrayList;

public class Ape extends BaseMonkey{

    public Ape(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
    }

    public void attackAOE() {
        ArrayList<BaseMonkey> monkeyContainer = GameSystem.getInstance().getMonkeyContainer();
        for(BaseMonkey m:monkeyContainer){
            m.setHp(m.getHp()-getAtk());
        }
    }
}
