package test.grader;

import logic.game.GameSystem;
import monkey.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameSystemTest {

    @Test
    void addApeTest() {
        ArrayList<BaseMonkey> apeContainer = GameSystem.getInstance().getApeContainer();
        apeContainer.clear();

        GameSystem.getInstance().addApe();
        assertEquals(3, apeContainer.size());

        for (int i = 0; i < 3; i++) {
            assertEquals(200, apeContainer.get(i).getMaxHp());
            assertEquals(30, apeContainer.get(i).getAtk());
            assertEquals(10, apeContainer.get(i).getDef());
        }
    }

    @Test
    void removeDeadEntityTest() {
        ArrayList<BaseMonkey> apeContainer = GameSystem.getInstance().getApeContainer();
        apeContainer.clear();
        GameSystem.getInstance().addApe();

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getApeContainer());
        assertEquals(3, GameSystem.getInstance().getApeContainer().size());

        apeContainer.get(0).setHp(0);
        apeContainer.get(1).setHp(0);

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getApeContainer());
        assertEquals(1, GameSystem.getInstance().getApeContainer().size());

        ArrayList<BaseMonkey> monkeyContainer = GameSystem.getInstance().getMonkeyContainer();
        monkeyContainer.clear();
        BaseMonkey m1 = new BaseMonkey(100, 15, 10);
        MuscleMonkey m2 = new MuscleMonkey(200, 20, 10);
        MommyMonkey m3 = new MommyMonkey(80, 0, 10);
        UgabugagaMonkey m4 = new UgabugagaMonkey(80, 10, 15);

        monkeyContainer.add(m1);
        monkeyContainer.add(m2);
        monkeyContainer.add(m3);
        monkeyContainer.add(m4);

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getMonkeyContainer());
        assertEquals(4, GameSystem.getInstance().getMonkeyContainer().size());

        monkeyContainer.get(0).setHp(0);
        monkeyContainer.get(1).setHp(0);

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getMonkeyContainer());
        assertEquals(1, GameSystem.getInstance().getApeContainer().size());


        GameSystem.getInstance().getMonkeyContainer().clear();
    }
}