package monkey;

public class BaseMonkey {

    private int maxHp;
    private int atk;
    private int hp;
    private int def;

    public BaseMonkey() {
        this.maxHp = 30;
        setHp(getMaxHp());
        setAtk(20);
        setDef(5);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = (maxHp>0?maxHp:0);
    }

    public BaseMonkey(int maxHp, int atk, int def) {
        setMaxHp(maxHp);
        setHp(maxHp);
        setAtk(atk);
        setDef(def);
    }

    public void attack(BaseMonkey m) {
        if (getAtk() > m.getDef()) {
            int dmg = getAtk() - m.getDef();
            m.setHp(m.getHp() - dmg);
        }
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getType() + " hp=" + hp + ", atk=" + atk + ", def=" + def;
    }

    public int getMaxHp() {
        return maxHp;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > maxHp) this.hp = maxHp;
        else if (hp < 0) this.hp = 0;
        else this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = (atk > 0 ? atk : 0);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = (def > 0 ? def : 0);
    }


}
