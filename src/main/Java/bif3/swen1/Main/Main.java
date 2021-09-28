package bif3.swen1.Main;

import bif3.swen1.Classes.GameManager;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();

        System.out.println("Noblesse Oblige - RH \n You want to be a Mesiah and save our World? \n");
        System.out.println("Register (R/r) or login (L/l):");
        char input = scanner.nextLine().charAt(0);
        if(input == 'R' || input == 'r'){
            System.out.println("Welcome! What's your name?\nUsername:");
            String username = scanner.next();
            System.out.println("If that is what you want me to call you. What is your Passphrase?\nPassword:");
            String password = scanner.nextLine();
            gameManager.register(username, password);
        }else if (scanner.next().charAt(0) == 'L' || scanner.next().charAt(0) == 'l'){
            System.out.println("Welcome back! What's your name? \n Username: \n");
            String username = scanner.nextLine();
            System.out.println("Password: \n");
            gameManager.login(username, scanner.nextLine());
        }else{
            System.out.println("Keine gültige Eingabe...");
        }

    }
}
