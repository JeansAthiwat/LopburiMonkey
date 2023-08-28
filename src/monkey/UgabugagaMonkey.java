package monkey;

public class UgabugagaMonkey extends BaseMonkey {
    private final static int DEBUFF = 1, HEAL = 10;
    public UgabugagaMonkey(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        m.setAtk(m.getAtk()- DEBUFF);
        m.setDef(m.getDef()- DEBUFF);
    }

    public void heal(BaseMonkey m){
        m.setHp(m.getMaxHp()<m.getHp()+ HEAL ?getMaxHp():m.getHp()+ HEAL);
    }
}
