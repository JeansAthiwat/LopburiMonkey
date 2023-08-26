package monkey;

public class MuscleMonkey extends BaseMonkey{
    private final int POWER_UP = 4;
    public MuscleMonkey(int maxHp,int atk , int def){
        super(maxHp,atk,def);
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        super.attack(m);
    }

    public void buff() {
        setAtk(getAtk()+POWER_UP);
        setDef(getDef()+POWER_UP);
    }


}
