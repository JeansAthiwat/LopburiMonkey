package application;

import Monkey.*;
import logic.game.GameSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static int playerTurnState; // 0 = showMonkey, 1 = showAction, 2 = attack, 3 = skill

    public static ArrayList<BaseMonkey> getMonkeyContainer() {
        return monkeyContainer;
    }

    public static ArrayList<BaseMonkey> monkeyContainer;

    public static void main(String[] args) {
        System.out.println("Welcome To Lopburi...The monkey needs your help defeating the Apes!");
        sc = new Scanner(System.in);
        while (true) { // !GameSystem.getInstance().isGameEnd()
            System.out.println("<0> Select Monkeys for your team");
//        System.out.println("<1> Create new monkey");
            System.out.println("<2> START GAME");
            //GameSystem.getInstance().printCompetitorsStatus();

            int choice = sc.nextInt();
            while (choice < 0 || choice > 2) {
                System.out.println("Invalid input");
                choice = sc.nextInt();
            }
            if (choice == 0) {
                for (int i = 0; i < 3; i++) {
                    selectMonkeyFlow();
                }

                System.out.print("Our Army:");
                for (BaseMonkey m : GameSystem.getInstance().getMonkeyContainer()) {
                    System.out.println(m.getType());
                }
            }
//            else if(choice == 1) {
//                System.out.println("<1> Create new monkey");
//                createNewMonkeyFlow(); //GameSystem.getInstance().getAllCompetitors()
//            }
            else if (choice == 2) {
                System.out.println("<2> START GAME");
                startGameFlow();
            }
        }
    }

    public static void selectMonkeyFlow() {
        System.out.println("<0> BaseMonkey");
        System.out.println("<1> MuscleMonkey");
        System.out.println("<2> MommyMonkey");
        System.out.println("<3> UgabugagaMonkey");

        int choice = sc.nextInt();

        while (choice < 0 || choice > 4) {
            System.out.println("Invalid Input");
            choice = sc.nextInt();
        }

        switch (choice) {
            case 0 -> GameSystem.getInstance().getMonkeyContainer().add(new BaseMonkey(100, 15, 10));
            case 1 -> GameSystem.getInstance().getMonkeyContainer().add(new MuscleMonkey(200, 20, 10));
            case 2 -> GameSystem.getInstance().getMonkeyContainer().add(new MommyMonkey(80, 0, 10));
            case 3 -> GameSystem.getInstance().getMonkeyContainer().add(new UgabugagaMonkey(80, 10, 15));
        }
    }

//    public static void createNewMonkeyFlow(){
//
//    }

    public static void startGameFlow() {
        while (GameSystem.getInstance().isGameEnd()) {
            //playerTurn
            while (GameSystem.getInstance().getSp() > 0) {
                BaseMonkey ChosenMonkey = null;
                switch (playerTurnState) {
                    case 0:
                        ChosenMonkey = showSelectedMonkey();
                        break;
                    case 1:
                        showAction(ChosenMonkey);
                        break;
                    case 2:
                        attackFlow(ChosenMonkey);// show enemy list input enemy to hit then perform BaseMonkey.attack()
                        break;
                    case 3:
                        skillFlow(ChosenMonkey);
                        break;
                }
            }

            //enemyTurn
            //loop Through each Ape and randomly attack the Monkey
            for (BaseMonkey ape : GameSystem.getInstance().getApeContainer()) {
                int randomIndex = random.nextInt(GameSystem.getInstance().getApeContainer().size()) + 1;
                int feralChance = random.nextInt(100);
                if(skillChance > 70){
                    ((Ape) ape).attack
                }
                ape.attack(GameSystem.getInstance().getApeContainer().size().get(randomIndex));
                GameSystem.getInstance().removeDeadCompetitors();
                if (GameSystem.getInstance().getMonkeyContainer().isEmpty()) {

                }
            }


        }

    }

    //showSelectedMonkey();


    public static BaseMonkey showSelectedMonkey() {
        System.out.println("Select your monkey to do action.");
        ArrayList<BaseMonkey> monkeys = getMonkeyContainer();
        for (int i = 0; i < monkeys.size(); i++) {
            System.out.println("<" + i + "> " + monkeys.get(i).getType());
        }
        System.out.println("<3>End turn.");
        int choice = sc.nextInt();
        if (choice != 3) {
            GameSystem.getInstance().setSp(0);
        } else {
            playerTurnState = 1;
        }
        return GameSystem.getInstance().getMonkeyContainer().get(choice);
    }

    public static void showAction(BaseMonkey monkey) { //state 1
        System.out.println("<0>Attack.");
        System.out.println("<1>Special skill.");
        System.out.println("<2>go back.");
        int choice = sc.nextInt();
        if (choice == 0) {
            playerTurnState = 2;
        } else if (choice == 1) {
            if (monkey.getType().equals("BaseMonkey")) {
                System.out.println("Normal monkey doesn't have special skill!");
            } else {
                playerTurnState = 3;
            }
        }

    }


}

/*
while(sp != 0){
    BaseMonkey
    switch(gamestate){
        int index
        state0: showMONKE show monkeyinteam and get "index" for the selectedMonkey change GameSTATE to 1showAction
        state1: showAction show all action avalable if(back)-> setGameStateTo state0 else setGameSTate To state2 or state 3)
        state2: attack show all APE to attack
        state3: skill(BaseMonkey Monkey) continue to each Classes skill.
                */
