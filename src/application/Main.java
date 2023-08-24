package application;

import Monkey.BaseMonkey;
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
        System.out.println("<1> Create new monkey");
        System.out.println("<2> START GAME");
            //GameSystem.getInstance().printCompetitorsStatus();

            int choice = sc.nextInt();
            while(choice<0||choice>2) {
                System.out.println("Invalid input");
                choice = sc.nextInt();
            }
            if(choice == 0) {
                System.out.println("<0> Select Monkeys for your team");
                selectMonkeyFlow();
            }
            else if(choice == 1) {
                System.out.println("<1> Create new monkey");
                createNewMonkeyFlow(); //GameSystem.getInstance().getAllCompetitors()
            }
            else if(choice==2){
                System.out.println("<2> START GAME");
                startGameFlow();
            }
        }
    }

    public static void selectMonkeyFlow(){
        System.out.println("<0> BaseMonkey");
        System.out.println("<1> BaseMonkey");
        System.out.println("<2> BaseMonkey");
        System.out.println("<3> BaseMonkey");
    }

    public static void createNewMonkeyFlow(){

    }

    public static void startGameFlow(){

        while(!GameSystem.getInstance().isGameEnd()){

            //player turn
                while(GameSystem.get){

                }
                //monkeyattackFlow
            //enemy turn

        }

        System.out.println("the MONKE has lost to the ape...It is over");



    }



}

