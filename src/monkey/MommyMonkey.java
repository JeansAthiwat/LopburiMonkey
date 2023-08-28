package monkey;

import logic.game.GameSystem;

public class MommyMonkey extends BaseMonkey {

    public MommyMonkey(int maxHp, int atk, int def) {
        super(maxHp, atk, def);
    }

    @Override
    public void attack(BaseMonkey m) {}

    public void birth() {
        GameSystem.getInstance().getMonkeyContainer().add(new BaseMonkey());
    }
}
