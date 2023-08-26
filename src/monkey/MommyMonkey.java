package monkey;
import logic.game.GameSystem;

public class MommyMonkey extends BaseMonkey{

    public MommyMonkey(int hp, int atk, int def) {
        super(hp, atk, def);
    }

   /* @Override
    public void attack(BaseMonkey m) {

    }*/

    public void birth(){
        GameSystem.getInstance().getMonkeyContainer().add(new BaseMonkey());
    }
}
