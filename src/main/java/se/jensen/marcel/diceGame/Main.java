package se.jensen.marcel.diceGame;
import se.jensen.marcel.diceGame.models.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameIsRunning = true;

        while(gameIsRunning){
            // INSTANTER //
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            // INSTANTER //

            System.out.println("Player One! Nice to meet you. What is your first name?");
            String playerOneFirstName = scanner.nextLine();
            System.out.println("Wow! " + playerOneFirstName + " is a good name! What is your second name?");
            String playerOneLastName = scanner.nextLine();
            System.out.println("Welcome to the game, " + playerOneFirstName + " " + playerOneLastName + "!");


            System.out.println("Player Two! Your turn! What is your first name?" );
            String playerTwoFirstName = scanner.nextLine();
            System.out.println("Okay, your name isn't that bad either " + playerTwoFirstName + ". What is your last name?") ;
            String playerTwoLastName = scanner.nextLine();
            System.out.println(playerTwoFirstName + " " + playerTwoLastName + " Welcome to the game too!");

            // INSTANTER //
            Player playerOne = new Player(playerOneFirstName, playerOneLastName);
            Player playerTwo = new Player(playerOneFirstName, playerOneLastName);
            // INSTANTER //


            // PLAYER ONE TURN //
            System.out.println("Player One! You go first! Write Play in order to throw - or write Quit in order to shut down the game.");
            String input = scanner.nextLine().toLowerCase();



            switch(input){
                case "play":{

                }
            }

        }
    }



}
