package application;

import Monkey.*;
import logic.game.GameSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static int playerTurnState; // 0 = showMonkey, 1 = showAction, 2 = attack, 3 = skill
    private static GameSystem gs = GameSystem.getInstance();
    private static int sp = gs.getSp();

    //TODO: check input for every input loop to prevent error
    //TODO: add More Text to discribe each action in terminal
    public static void main(String[] args) {
        System.out.println("Welcome To Lopburi...The monkey needs your help defeating the Apes!");
        sc = new Scanner(System.in);
        //!gs.isGameEnd()
        while (true) {
            System.out.println("<0> Select Monkeys for your team");
            System.out.println("<1> START GAME");

            int choice = inputCheck(0, 1);
            if (choice == 0) {
                for (int i = 0; i < 3; i++) {
                    selectMonkeyFlow();
                }

                System.out.print("Our Army:\n");
                for (BaseMonkey m : gs.getMonkeyContainer()) {
                    System.out.println(m.getType());
                }
            } else if (choice == 1) {
                System.out.println("<1> START GAME");
                startGameFlow();
            }
        }
    }

    public static void selectMonkeyFlow() {
        System.out.println("<0> BaseMonkey");
        System.out.println("<1> MuscleMonkey");
        System.out.println("<2> MommyMonkey");
        System.out.println("<3> UgabugagaMonkey");

        int choice = inputCheck(0, 3);

        switch (choice) {
            case 0 -> gs.getMonkeyContainer().add(new BaseMonkey(100, 15, 10));
            case 1 -> gs.getMonkeyContainer().add(new MuscleMonkey(200, 20, 10));
            case 2 -> gs.getMonkeyContainer().add(new MommyMonkey(80, 0, 10));
            case 3 -> gs.getMonkeyContainer().add(new UgabugagaMonkey(80, 10, 15));
        }
    }

    public static void startGameFlow() {
        while (!gs.isGameEnd()) {
            //playerTurn
            sp = 5;
            BaseMonkey ChosenMonkey = new BaseMonkey();
            while (sp > 0) {
                switch (playerTurnState) {
                    case 0 -> ChosenMonkey = showSelectedMonkey();
                    // showAction
                    case 1 -> showAction(ChosenMonkey);
                    // show enemy list input enemy to hit then perform BaseMonkey.attack()
                    case 2 -> attackFlow(ChosenMonkey);
                    // show skill flow for each MonkeyType
                    case 3 -> skillFlow(ChosenMonkey);

                }
                //removeDeadApe
                gs.removeDeadEntity(gs.getApeContainer());

            }

            //enemyTurn (loop Through each Ape and randomly attack the Monkey)
            for (BaseMonkey ape : gs.getApeContainer()) {

                int randomIndex = (int) (Math.random() * ((gs.getMonkeyContainer().size())));
                BaseMonkey targetMonkey = gs.getMonkeyContainer().get(randomIndex);
                double skillChance = Math.random() * 100;
                if (skillChance < 30) { // a 30% chance to use spacial attack AOE attack
                    ((Ape) ape).attackAOE();
                } else {
                    ape.attack(targetMonkey);
                }
                gs.removeDeadEntity(gs.getMonkeyContainer());

                if (gs.getMonkeyContainer().isEmpty()) {
                    gs.setGameEnd(true);
                }
            }

        }

    }

    public static BaseMonkey showSelectedMonkey() {
        System.out.println("Select your monkey to do action.");
        System.out.println("SP :" + sp);
        ArrayList<BaseMonkey> monkeys = gs.getMonkeyContainer();
        for (int i = 0; i < monkeys.size(); i++) {
//            System.out.println("<" + i + "> " + monkeys.get(i).getType());
            System.out.println("<" + i + "> " + monkeys.get(i));
        }
        System.out.println("<" + monkeys.size() + ">End turn.");
        int choice = inputCheck(0, monkeys.size());
        if (choice == monkeys.size()) {
            sp = 0;
            return null;
        } else {
            playerTurnState = 1;
        }
        return gs.getMonkeyContainer().get(choice);
    }

    public static void showAction(BaseMonkey monkey) { //state 1
        System.out.println("<0>Attack.");
        System.out.println("<1>Special skill.");
        System.out.println("<2>go back.");
        int choice = inputCheck(0,2);
        if (choice == 0) {
            playerTurnState = 2;
        } else if (choice == 1) {
            if (monkey.getType().equals("BaseMonkey")) {
                System.out.println("Normal monkey doesn't have special skill!");
            } else {
                playerTurnState = 3;
            }
        } else if (choice == 2) {
            playerTurnState = 0;
        }
    }

    public static void attackFlow(BaseMonkey m) {
        ArrayList<BaseMonkey> apeContainer = gs.getApeContainer();
        for (int i = 0; i < apeContainer.size(); i++)
            System.out.println("<" + i + ">" + apeContainer.get(i));

        int choice = inputCheck(0,apeContainer.size()-1);
        BaseMonkey ape = apeContainer.get(choice);
        m.attack(ape);
        sp--;
        System.out.println(m.getType() + " has attacked <" + choice + "> " + ape.getType());
        playerTurnState = 0;
    }

    public static void skillFlow(BaseMonkey m) {
        if (m instanceof MuscleMonkey) {
            ((MuscleMonkey) m).buff();
            System.out.println("MuscleMonkey has buffed himself.");
        } else if (m instanceof MommyMonkey) {
            ((MommyMonkey) m).birth();
            System.out.println("MommyMonkey has given birth.");
            System.out.println("BaseMonkey is ready to fight.");
        } else if (m instanceof UgabugagaMonkey) {
            System.out.println("Choose our monkey to heal");
            ArrayList<BaseMonkey> monkeyContainer = gs.getMonkeyContainer();
            for (int i = 0; i < monkeyContainer.size(); i++)
                System.out.println("<" + i + ">" + monkeyContainer.get(i));

            int choice = inputCheck(0,monkeyContainer.size()-1);
            BaseMonkey healedMonkey = monkeyContainer.get(choice);
            ((UgabugagaMonkey) m).heal(healedMonkey);

            System.out.println("UgabugagaMonkey has healed <" + choice + "> " + healedMonkey.getType());
        }
        sp -= 2;
        playerTurnState = 0;
    }

    public static int inputCheck(int lowestInput, int highestInput) {
        int choice = sc.nextInt();
        while (choice < lowestInput || choice > highestInput) {
            System.out.println("Invalid input");
            choice = sc.nextInt();
        }
        return choice;
    }
}