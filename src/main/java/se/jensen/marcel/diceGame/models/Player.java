package se.jensen.marcel.diceGame.models;

import java.util.Scanner;

public class Player {
    String firstName;
    String lastName;
    int points = 0;

    Scanner scanner = new Scanner(System.in);


    public void setFirstName() {
        String name = "";
        boolean isValid = false;
        while(!isValid){
            System.out.println("Welcome. What is your first name?:");
            name = scanner.nextLine();
            try{
                if(name.trim().isEmpty()){
                    throw new IllegalArgumentException("Name can not be empty, please write again.");
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.firstName = name;
    }

    public void setLastName() {
        String name = "";
        boolean isValid = false;
        while(!isValid){
            System.out.println("Nice name!. What is your last name?:");
            name = scanner.nextLine();
            try{
                if(name.trim().isEmpty()){
                    throw new IllegalArgumentException("Name can not be empty, please write again.");
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.lastName = name;    }

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
