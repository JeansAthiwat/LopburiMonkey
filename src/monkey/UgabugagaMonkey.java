package monkey;

public class UgabugagaMonkey extends BaseMonkey {
    private final int debuff,heal;
    public UgabugagaMonkey(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
        this.debuff = 1;
        this.heal = 10;
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        m.setAtk(m.getAtk()-debuff);
        m.setDef(m.getDef()-debuff);
    }

    public void heal(BaseMonkey m){
        m.setHp(m.getMaxHp()<m.getHp()+heal?getMaxHp():m.getHp()+heal);
    }
}
