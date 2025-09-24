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
            Player playerTwo = new Player(playerTwoFirstName, playerTwoLastName);
            // INSTANTER //


            // PLAYER ONE TURN //
            System.out.println("Player One! You go first! Write Play in order to throw - or write Quit in order to shut down the game.");
            String input = scanner.nextLine().toLowerCase();


            // First player turn
            int playerOneResults = 0;
            switch(input){
                case "play":{
                     int playerOneFirstThrow = throwDice(1,7);
                    System.out.println("First throw! " + playerOneFirstThrow + " points!") ;
                      int playerOneSecondThrow = throwDice(1,7);
                    System.out.println("Second throw! " + playerOneSecondThrow + " points!") ;
                    playerOneResults = playerOneFirstThrow + playerOneSecondThrow;
                    System.out.println("Player one has " + playerOneResults + " point/s");
                    break;
                }
                case "quit":{
                    System.out.println("Quitting game...");
                    gameIsRunning = false;
                    break;
                }
            }

            // Second player turn
            System.out.println("Player two! Write play in order to throw - or write quit in order to shut down the game (but you'll lose)");
            input = scanner.nextLine().toLowerCase();


            int playerTwoResults = 0;
            switch(input){
                case "play":{
                    int playerTwoFirstThrow = throwDice(1,7);
                    System.out.println("First throw! " + playerTwoFirstThrow + " points!") ;
                    int playerTwoSecondThrow = throwDice(1,7);
                    System.out.println("Second throw! " + playerTwoSecondThrow + " points!") ;
                    playerTwoResults = playerTwoFirstThrow + playerTwoSecondThrow;
                    System.out.println("Player two has " + playerTwoResults  + " point/s") ;

                    if(playerOneResults > playerTwoResults ){
                        System.out.println("The winner is " + playerOne.getFullName());
                    }
                    else if(playerTwoResults > playerOneResults){
                        System.out.println("The winner is " + playerTwo.getFullName());
                    }
                    else System.out.println("It's a tie!");
                    gameIsRunning = false;
                }
                case "quit":{
                    System.out.println("Quitting game...");
                    gameIsRunning = false;
                    break;
                }
            }
        }
    }

    static Random random = new Random();

    public static int throwDice(int minimum, int maximum){
        int dice = random.nextInt(minimum,maximum);
        return dice;
    }

}
