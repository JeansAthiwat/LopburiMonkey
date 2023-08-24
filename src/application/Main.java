package application;

import Monkey.BaseMonkey;
import Monkey.MommyMonkey;
import Monkey.MuscleMonkey;
import Monkey.UgabugagaMonkey;
import logic.game.GameSystem;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static ArrayList<BaseMonkey> getMonkeyContainer() {
        return monkeyContainer;
    }

    public static ArrayList<BaseMonkey> monkeyContainer;

    public static void main(String[] args) {
        System.out.println("Welcome To Lopburi...The monkey needs your help defeating the Apes!");
        sc = new Scanner(System.in);
        while(true) { // !GameSystem.getInstance().isGameEnd()
        System.out.println("<0> Select Monkeys for your team");
//        System.out.println("<1> Create new monkey");
        System.out.println("<2> START GAME");
            //GameSystem.getInstance().printCompetitorsStatus();

            int choice = sc.nextInt();
            while(choice<0||choice>2) {
                System.out.println("Invalid input");
                choice = sc.nextInt();
            }
            if(choice == 0) {
                for (int i = 0; i < 3; i++){
                    selectMonkeyFlow();
                }

                System.out.print("Our Army:");
                for (BaseMonkey m:GameSystem.getInstance().getMonkeyContainer()){
                    System.out.println(m.getType());
                }
            }
//            else if(choice == 1) {
//                System.out.println("<1> Create new monkey");
//                createNewMonkeyFlow(); //GameSystem.getInstance().getAllCompetitors()
//            }
            else if(choice==2){
                System.out.println("<2> START GAME");
                startGameFlow();
            }
        }
    }

    public static void selectMonkeyFlow(){
        System.out.println("<0> BaseMonkey");
        System.out.println("<1> MuscleMonkey");
        System.out.println("<2> MommyMonkey");
        System.out.println("<3> UgabugagaMonkey");

        int choice = sc.nextInt();

        while(choice<0 || choice>4){
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

    public static void startGameFlow(){
    }

    showSelectedMonkey();

}

