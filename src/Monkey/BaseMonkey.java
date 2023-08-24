package Monkey;

public class BaseMonkey {

    private int maxHp ,hp, atk , def;

    public BaseMonkey(int maxHp, int atk , int def){
        this.maxHp = maxHp;
        setHp(maxHp);
        setAtk(atk);
        setDef(def);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public BaseMonkey(){
        setHp(6);
        setAtk(2);
        setDef(1);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = (hp>0?hp:10);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = (atk>0?atk:2);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = (def>0?def:3);
    }

    public void attack(BaseMonkey m){
        if (getAtk()>m.getDef()){
            int dmg = getAtk()-m.getDef();
            m.setHp(m.getHp()-dmg);
        }
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getType() + " hp=" + hp + ", atk=" + atk + ", def=" + def ;
    }
}
