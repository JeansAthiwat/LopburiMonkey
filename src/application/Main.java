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
                // sysout menu to choose between each character (+end Turn )
            /*
                Choose
                SP Left : 5
                1 BaseMK hp:1 atk:2 def:3
                2 MOMMYMk hp:6 atk:4 def:5
                3 UhabugagaMOnkey hp:5 atk:1 def:2
                4.End TURN
                INPUT: _
             */

            /*
                BaseMK hp:1 atk:2 def:3
                1) attack
                2) back
                --------------------------
               MOMMYMk hp:6 atk:4 def:5
               1) attack -- call fn attack(BaseMonkey) ->
               2) perform skill
               3) back

             */

                // while(sp != 0 && notENDTURN)
                //
                while(GameSystem.get){

                }
                //monkeyattackFlow



            //enemy turn

        }

        System.out.println("the MONKE has lost to the ape...It is over");



    }



}

