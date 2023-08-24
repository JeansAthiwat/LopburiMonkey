package Monkey;

public class MuscleMonkey extends BaseMonkey{
    private final int powerUp;
    public MuscleMonkey(int hp,int atk , int def){
        super(hp,atk,def);
        this.powerUp = 4;
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        super.attack(m);
    }

    public void buff() {
        setAtk(getAtk()+powerUp);
        setDef(getDef()+powerUp);
    }


}
