package com.acwd.IU6;

import java.util.*;

/**
 * @author dseah
 * @version 1.1
 * Changed time equation
 * @version 1.0
 * Created program
 * @since 2019-04-02
 *
 * This is a console-based program that lets the user play a game called "Odds and Even" against a computer-AI.
 * The user chooses either odds or even (denoted by O and E) and choose a number from 1-5.
 * The computer likewise chooses a number.
 * The user wins when the sum of both choices equates to the choice of odds or even.
 *
 *
 */
public class OddsAndEvens {
    private static Scanner input = new Scanner(System.in);

    /**
     * The main method that holds the logic and the printouts for the game "Odds and Even"
     * @param args
     */
    public static void main(String[] args){
        //Welcome and user Choice made
        System.out.println("Lets play a game called \"Odds and Evens \"");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.print("Welcome " + name + ". Please choose (O)dds or (E)ven! ");
        String choice = input.next();
        if(choice.equalsIgnoreCase("O")){
            System.out.println(name + " has picked odds. " + "Computer shall choose evens.");
        }else{
            System.out.println(name + " has picked evens. " + "Computer shall choose odds.");
        }
        printDash();


        //Play the game
        System.out.print("How many \"fingers\" will you put out (0-5)?");
        int fingers = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("Computer plays " + computer + " \"fingers\"!");
        printDash();

        //Calculating results...
        int result = fingers + computer;
        boolean oddOrEven = result % 2 == 0;
        System.out.print(fingers + " + " + computer + " = " + result + "...");
        if(oddOrEven) {
            System.out.println("even!\n");
        }else{
            System.out.print("odd!\n");
        }
        printDash();

        //Deciding the winner...
        if(choice.equalsIgnoreCase("e") && oddOrEven == true){
            System.out.println("Congratulations! You won!");
        }else if(choice.equalsIgnoreCase("o") && oddOrEven ==false){
            System.out.println("Congratulations! You won!");
        }else{
            System.out.println("Aww! You lost! Better luck next time.");
        }
        printDash();
    }

    /**
     * This is a method that helps to segment each section of the game
     */
    public static void printDash(){
        for(int i = 0; i <= 20; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}