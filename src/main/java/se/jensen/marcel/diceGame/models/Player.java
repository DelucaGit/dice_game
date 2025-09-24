package se.jensen.marcel.diceGame.models;

public class Player {
    String firstName;
    String lastName;
    int points = 0;

    public Player(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }



    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void addPoints(){
        this.points++;
    }

    public int getPoints(){
        return this.points;
    }
}
