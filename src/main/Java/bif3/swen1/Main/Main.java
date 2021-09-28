package bif3.swen1.Main;

import bif3.swen1.Classes.GameManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();

        System.out.println("Noblesse Oblige - RH");
        System.out.println("Register (R/r) or login (L/l): \n");
        if(scanner.nextLine() == "R" | scanner.nextLine() == "r"){
            System.out.println("Welcome! What's your name? \n Username: \n");
            String username = scanner.nextLine();
            System.out.println("Password: \n");
            gameManager.register(username, scanner.nextLine());
        }else if (scanner.next() == "L" | scanner.next() == "l"){
            System.out.println("Welcome back! What's your name? \n Username: \n");
            String username = scanner.nextLine();
            System.out.println("Password: \n");
            gameManager.login(username, scanner.nextLine());
        }else{
            System.out.println("Keine gültige Eingabe...");
            System.out.println("Register (R/r) or login (L/l):");
        }

    }
}
