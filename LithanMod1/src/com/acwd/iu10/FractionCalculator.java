package com.acwd.iu10;

import java.util.Scanner;

/**
 * @author dseah
 * @version 1.0
 * Created Fractional calculator
 * @version 1.1
 * Detected errors on arthimatic functions. Changed logic for the following methods
 * @since 2019-04-08
 */
public class FractionCalculator {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Welcome to Daniel's personal Fraction Calculator v1.1");
        System.out.println();
        getOperation();
        System.out.println("Thank you for using Daniel's personal Fraction Caluclator v1.1");
    }
    public static void getOperation(){
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String choice = input.next();
        Fraction first;
        Fraction second;
        Fraction result;

        //Repeats while choice is not Q
        while(!choice.equalsIgnoreCase("Q")){
            try{
                System.out.println(choice);
                switch(choice){
                    //Creates 2 Fraction objects and add them together. Result is printed
                    case "+":
                        first = getFractions();
                        second = getFractions();
                        result = first.add(second);
                        System.out.println(first + " + " + second + " = " + result);
                        printBreak();;
                        break;
                    //Creates 2 Fraction objects and subtract. Result is printed
                    case "-":
                        first = getFractions();
                        second = getFractions();
                        result = first.subtract(second);
                        System.out.println(first + " - " + second + " = " + result);
                        printBreak();;
                        break;
                    //Creates 2 Fraction objects and divide. Result is printed
                    case "/":
                        first = getFractions();
                        second = getFractions();
                        result = first.divide(second);
                        System.out.println(first + " / " + second + " = " + result);
                        printBreak();
                        break;
                    //Creates 2 Fraction objects and multiply. Result is printed
                    case "*":
                        first = getFractions();
                        second = getFractions();
                        result = first.multiply(second);
                        System.out.println(first + " * " + second + " = " + result);
                        printBreak();;
                        break;
                    //Creates 2 Fractions and checks if both fractions are equal
                    case "=":
                        first = getFractions();
                        second = getFractions();
                        String frac1 = first.toString();
                        String frac2 = second.toString();
                        first.toLowestTerm();
                        boolean check = first.equals(second);
                        System.out.println(frac1 + " = " + frac2 + " is " + check);
                        printBreak();;
                        break;
                    //Deals with invalid input
                    default:
                        System.out.print("Invalid input. ");
                        break;
                }
                System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
                choice = input.next();
            }catch (IllegalArgumentException e1){
                System.out.println("Invalid arguments parsed in! Backtracking...");
            }catch (IllegalAccessException e2){
                System.out.println("Value 0 detected! Backtracking...");
            }

        }

    }
    public static boolean validFraction(String sample){

        if(sample.contains("/")){
            int i = sample.indexOf('/');
            String num = sample.substring(0, i);
            String den = sample.substring(i+1, sample.length());
            if(isNumber(num)){
                if(isNumber(den)){
                    if(Integer.parseInt(den) > 0) {
                        return true;
                    }
                }
            }
        }else if(isNumber(sample)){
            if(Integer.parseInt(sample) != 0) {
                return true;
            }
        }
        return false;
    }
    private static boolean isNumber(String sample){
        //Check if string is empty
        if(sample == null || sample.equals("")){
            return false;
        }
        //Check if the string only contains number
        for(int i =0;i< sample.length(); i++){
            char check = sample.charAt(i);
            if(i == 0 && check == '-') {
                continue;
            }
            if(check < '0' || check > '9'){
                return false;
            }
        }
        return true;
    }
    public static Fraction getFractions() throws IllegalAccessException {
        System.out.print("Please enter (a/b) or (a) where a and b are  integers and b is not zero: ");
        String sample = input.next();
        System.out.println(sample);
        //Checks if input is a whole number
        if(isNumber(sample)){
            Integer wholeNum = Integer.parseInt(sample);
            return new Fraction(wholeNum);
        }else{
            while(!validFraction(sample)){
                System.out.print("Invalid input. ");
                System.out.print("Please enter (a/b) or (a) where a and b are  integers and b is not zero: ");
                sample = input.next();
            }
            //creating num and den as numbers
            int i = sample.indexOf('/');
            Integer num = Integer.parseInt(sample.substring(0, i));
            Integer den = Integer.parseInt(sample.substring(i+1, sample.length()));

            //Returns new Fraction object
            return new Fraction(num,den);
        }
    }
    private static String printBreak(){
        return "----------------------------------------------------------------------";
    }
}
