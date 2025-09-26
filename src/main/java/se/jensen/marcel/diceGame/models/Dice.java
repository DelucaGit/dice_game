package se.jensen.marcel.diceGame.models;

import java.util.Random;

public class Dice {

    static Random random = new Random();

    public static int throwDice(){
        int randomNumber = random.nextInt(1,7);
        return randomNumber;
    }

}