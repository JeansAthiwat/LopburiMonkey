package application;

import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Welcome To Lopburi! The monkey needs your help defeating the Apes");
        System.out.println("<0> Select Monkeys for your team");
        System.out.println("<1> Create new monkey");
        System.out.println("<2> START GAME");
        int choice =sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("You chose option 1");
                break;
            case 1:
                System.out.println("You chose option 2");
                break;
            case 2:
                System.out.println("You chose option 3");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

}

