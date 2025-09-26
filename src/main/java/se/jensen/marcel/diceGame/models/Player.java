package se.jensen.marcel.diceGame.models;

public class Player {
    String firstName;
    String lastName;
    int points = 0;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public void resetPoints(){
        this.points = 0;
    }

    public int getPoints(){
        return this.points;
    }
}
