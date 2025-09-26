package se.jensen.marcel.diceGame.models;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    boolean gameIsRunning = true;

    public String askForName(String message){
        String name = "";
        boolean isValid = false;

        while(!isValid){
            System.out.println(message);
            name = scanner.nextLine();
            try{
                if(name.trim().isEmpty()){
                    throw new Exception("Name can not be empty, please write again.");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    public void run(){

        String playerOneFirstName = askForName("Welcome player ONE. What is your first name?:");
        String playerOneLastName = askForName("Nice!. What is your last name?:");
        String playerTwoFirstName = askForName("Welcome player TWO. What is your first name?:");
        String playerTwoLastName = askForName("Nice!. What is your last name?:");


        // INSTANTER //
        Player playerOne = new Player();
        Player playerTwo = new Player();
        // INSTANTER //

        playerOne.setFirstName(playerOneFirstName);
        playerOne.setLastName(playerOneLastName);

        playerTwo.setFirstName(playerTwoFirstName);
        playerTwo.setLastName(playerTwoLastName);

        while(gameIsRunning){            // INSTANTER //


            boolean playTurn = true;

            while(playTurn){

                // PLAYER ONE TURN //
                System.out.println("Player One! You go first! Write Play in order to throw - or write Quit in order to shut down the game.");
                String input = scanner.nextLine().toLowerCase();


                // First player turn
                int playerOneResults = 0;
                switch(input){
                    case "play":{
                        int playerOneFirstThrow = Dice.throwDice();
                        System.out.println("First throw! " + playerOneFirstThrow + " points!") ;
                        int playerOneSecondThrow = Dice.throwDice();
                        System.out.println("Second throw! " + playerOneSecondThrow + " points!") ;
                        playerOne.addPoints(playerOneFirstThrow + playerOneSecondThrow) ;
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
                        int playerTwoFirstThrow = Dice.throwDice();
                        System.out.println("First throw! " + playerTwoFirstThrow + " points!") ;
                        int playerTwoSecondThrow = Dice.throwDice();
                        System.out.println("Second throw! " + playerTwoSecondThrow + " points!") ;
                        playerTwoResults = playerTwoFirstThrow + playerTwoSecondThrow;
                        playerTwo.addPoints(playerTwoResults);
                        System.out.println("Player two has " + playerTwoResults  + " point/s") ;

                        if(playerOneResults > playerTwoResults ){
                            System.out.println("The winner is " + playerOne.getFullName());
                        }
                        else if(playerTwoResults > playerOneResults){
                            System.out.println("The winner is " + playerTwo.getFullName());
                        }
                        else System.out.println("It's a tie!");



                        System.out.println("-----ROUND RESULTS-----");
                        System.out.println(playerOne.getFullName() + " got " + playerOneResults + " point/s this round");
                        System.out.println(playerTwo.getFullName() + " got " + playerTwoResults + " point/s this round");
                        System.out.println("-----GAME RESULTS------");
                        System.out.println(playerOne.getFullName() + " has a total of " + playerOne.getPoints() + " point/s in this game");
                        System.out.println(playerTwo.getFullName() + " has a total of " + playerTwo.getPoints() + " point/s in this game");
                        System.out.println("-----------------------");
                        System.out.println("Do you want to play a new round? y/n");
                        input = scanner.nextLine().toLowerCase();
                        if(input.equals("y") || input.equals("yes")){
                            break;
                        }
                        else if(input.equals("n") || input.equals("no")){
                            playTurn = false;
                            gameIsRunning = false;
                            System.out.println("Shutting game...");
                        }
                        break;
                    }
                    case "quit":{
                        System.out.println("Quitting game...");
                        playerOne.resetPoints();
                        playerTwo.resetPoints();
                        gameIsRunning = false;
                        break;
                    }
                }
            }

            }


        scanner.close();
    }
}
