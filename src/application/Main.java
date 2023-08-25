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
        while (true) { // !gs.isGameEnd()
            System.out.println("<0> Select Monkeys for your team");
//        System.out.println("<1> Create new monkey");
            System.out.println("<2> START GAME");
            //gs.printCompetitorsStatus();

            int choice = sc.nextInt();
            while (choice < 0 || choice > 2) {
                System.out.println("Invalid input");
                choice = sc.nextInt();
            }
            if (choice == 0) {
                for (int i = 0; i < 3; i++) {
                    selectMonkeyFlow();
                }

                System.out.print("Our Army:\n");
                for (BaseMonkey m : gs.getMonkeyContainer()) {
                    System.out.println(m.getType());
                }
            }
//            else if(choice == 1) {
//                System.out.println("<1> Create new monkey");
//                createNewMonkeyFlow(); //gs.getAllCompetitors()
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
            case 0 -> gs.getMonkeyContainer().add(new BaseMonkey(100, 15, 10));
            case 1 -> gs.getMonkeyContainer().add(new MuscleMonkey(200, 20, 10));
            case 2 -> gs.getMonkeyContainer().add(new MommyMonkey(80, 0, 10));
            case 3 -> gs.getMonkeyContainer().add(new UgabugagaMonkey(80, 10, 15));
        }
    }

//    public static void createNewMonkeyFlow(){
//
//    }

    public static void startGameFlow() {
        while (!gs.isGameEnd()) {
            //playerTurn
            BaseMonkey ChosenMonkey = new BaseMonkey();
            while (sp > 0){
                switch (playerTurnState) {
                    case 0 -> ChosenMonkey = showSelectedMonkey();
                    // showAction
                    case 1 -> showAction(ChosenMonkey);
                    // show enemy list input enemy to hit then perform BaseMonkey.attack()
                    case 2 -> attackFlow(ChosenMonkey);
                    // show skill flow for each MonkeyType
                    case 3 -> skillFlow(ChosenMonkey);

                }

                gs.removeDeadEntity(gs.getApeContainer());

            }
            //removeDeadApe


            //enemyTurn
            //loop Through each Ape and randomly attack the Monkey
            for (BaseMonkey ape : gs.getApeContainer()) {

                int randomIndex = (int) (Math.random() * ((gs.getMonkeyContainer().size())));
                BaseMonkey targetMonkey = gs.getMonkeyContainer().get(randomIndex);
                double skillChance = Math.random()*100;
                if (skillChance > 70) {
                    ((Ape)ape).attackAOE();
                } else {
                    ape.attack(targetMonkey);
                }

                gs.removeDeadEntity(gs.getMonkeyContainer());
                sp = 5;

                if (gs.getMonkeyContainer().isEmpty()) {
                    gs.setGameEnd(true);
                }
            }
        }

    }

    //showSelectedMonkey();


    public static BaseMonkey showSelectedMonkey() {
        System.out.println("Select your monkey to do action.");
        System.out.println("SP :" + sp);
        ArrayList<BaseMonkey> monkeys = gs.getMonkeyContainer();
        for (int i = 0; i < monkeys.size(); i++) {
//            System.out.println("<" + i + "> " + monkeys.get(i).getType());
            System.out.println("<" + i + "> " + monkeys.get(i));

        }
        System.out.println("<"+monkeys.size()+">End turn.");
        int choice = sc.nextInt();
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
        int choice = sc.nextInt();
        if (choice == 0) {
            playerTurnState = 2;
        } else if (choice == 1) {
            if (monkey.getType().equals("BaseMonkey")) {
                System.out.println("Normal monkey doesn't have special skill!");
            } else {
                playerTurnState = 3;
            }
        }else if(choice==2){
            playerTurnState = 0;
        }
    }


    public static void attackFlow(BaseMonkey m){
        ArrayList<BaseMonkey> apeContainer = gs.getApeContainer();
        for (int i = 0; i < apeContainer.size(); i++)
            System.out.println("<"+i+">" + apeContainer.get(i));


        int choice = sc.nextInt();
        while (choice<0 || choice >3){
            choice = sc.nextInt();
        }
        BaseMonkey ape = apeContainer.get(choice);
        m.attack(ape);
        sp--;
        System.out.println(m.getType() + " has attacked <"+choice+"> "+ape.getType());
        playerTurnState = 0;
    }

    public static void skillFlow(BaseMonkey m){
        if (m instanceof MuscleMonkey){
            ((MuscleMonkey) m).buff();
            System.out.println("MuscleMonkey has buffed himself.");
        }
        else if (m instanceof MommyMonkey){
            ((MommyMonkey) m).birth();
            System.out.println("MommyMonkey has given birth.");
            System.out.println("BaseMonkey is ready to fight.");
        } else if (m instanceof UgabugagaMonkey) {
            System.out.println("Choose our monkey to heal");
            ArrayList<BaseMonkey> monkeyContainer = gs.getMonkeyContainer();
            for (int i = 0; i < monkeyContainer.size(); i++)
                System.out.println("<"+i+">" + monkeyContainer.get(i));

            int choice = sc.nextInt();
            while (choice<0 || choice >monkeyContainer.size()){
                choice = sc.nextInt();
            }
            BaseMonkey healedMonkey =monkeyContainer.get(choice);
            ((UgabugagaMonkey) m).heal(healedMonkey);

            System.out.println("UgabugagaMonkey has healed <"+ choice+"> " +healedMonkey.getType());
        }
        sp-=2;
        playerTurnState = 0;
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
