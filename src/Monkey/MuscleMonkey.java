package Monkey;

import logic.game.GameSystem;

public class MuscleMonkey extends BaseMonkey{
    private final int powerUp;
    public MuscleMonkey(int hp,int atk , int def){
        super(hp,atk,def);
        this.powerUp = 2;
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        buff();
    }

    public void buff() {
        setAtk(getAtk()+powerUp);
        setDef(getDef()+powerUp);
    }


}
