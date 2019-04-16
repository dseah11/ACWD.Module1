package com.acwd.IU6;

import java.util.*;

public class TripPlanner {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        showGreeting();
        showDuration();
        showTime();
        showArea();
    }


    public static void showGreeting() {
        System.out.println("Welcome to the Vacation Planner");
        System.out.print("What is your name?");
        String name = input.nextLine();

        System.out.print("Greetings, " + name + " , where would you like to go?");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great place to visit.");

        System.out.println("**************");
        System.out.println();
    }

    public static void showDuration() {
        //Taking in user input...
        System.out.print("How many days are you going to spend?");
        int days = input.nextInt();
        System.out.print("How much money (in USD) will you be planning to spend on this trip?");
        double totalSpending = input.nextDouble();
        System.out.print("What is your currency symbol for your destination?");
        String symbol = input.next();
        System.out.print("What is the conversion rate from USD to " + symbol + " ?");
        double rate = input.nextDouble();
        System.out.println();

        //Process data such as time spent in hours, minutes and seconds and budget per day with the cost of it
        int travelHours = days * 24;
        int travelMinutes = days * 1440;
        long travelSeconds = days * 86400;


        double moneyPerDay = totalSpending / days;
        moneyPerDay = (int) (moneyPerDay * 100);
        moneyPerDay /= 100.0;
        double moneyConvert = totalSpending * rate;
        moneyConvert = (int) (moneyConvert * 100);
        moneyConvert /= 100.0;
        double convertPerDay = moneyConvert / days;
        convertPerDay = (int) (convertPerDay * 100);
        convertPerDay /= 100.0;

        System.out.println("If you are travelling for " + days + ", that will be the same as " + travelHours
                + " hours, or " + travelMinutes + " minutes or, " + travelSeconds + " seconds!");

        System.out.println("If you are planning to spend USD$" + totalSpending + ", then you'd be able to" +
                " spend USD$" + moneyPerDay + " each day.");
        System.out.println("The total budget in " + symbol + " is " + moneyConvert + ", or " + symbol + convertPerDay
                + " per day.");
        System.out.println("**************");
        System.out.println();
    }

    public static void showTime() {
        System.out.print("What is the time difference between your home and your destination?");
        int timeDifference = input.nextInt();
        timeDifference += 24; //Adds difference to Midnight
        int timeAtMidnight = timeDifference % 24; //Converts time difference into 24hr format
        int timeAtNoon = (timeDifference + 12) % 24;

        System.out.println("This means that when it's midnight at home, it will be " + timeAtMidnight + ":00" +
                " at your destination and when its noon at home it will be " + timeAtNoon + ":00");
        System.out.println("**************");
        System.out.println();
    }

    public static void showArea() {
        System.out.print("What is the Square area of your destination country in Km^2?");
        //processing and rounding off input in miles2
        double kmArea = input.nextDouble();
        double mileArea = kmArea * 0.386102;
        mileArea = (int) (mileArea * 100);
        mileArea /= 100.0;

        System.out.println("In miles^2, that equates to " + mileArea);
        System.out.println("**************");
        System.out.println();
    }
}
