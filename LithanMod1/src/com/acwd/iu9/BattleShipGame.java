package com.acwd.iu9;

import java.util.Scanner;

/**
 * @author dseah
 * @version 0.4
 * Did OceanMap class, started printing method,adding of ships and validation
 * @version 1.0
 * Edited the printing method, edited validations and removed some irrelevent methods
 * Created battleship
 * @since 2019-04-05
 */
public class BattleShipGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playerCounter = 0;
        int x, y;
        boolean end =false;
        OceanMap map = new OceanMap();

        printIntro();
        map.printMap();

        //Initialising player ships May need to
        //@todo a better method here
        System.out.println("Place your ships...");

        while(playerCounter < 5){
            System.out.print("Enter X coordinate for your ship " + (playerCounter + 1) + " :");
            x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship " + (playerCounter + 1) + " :");
            y = input.nextInt();

            if(map.addShip(x,y)){
                playerCounter++;
            }else{
                System.out.println("Cannot place ship at (" + x + "," + y+ ")");
                System.out.println("Try again.");
            }
        }

        //Deploying opponent ships
        System.out.println("Enemy is deploying ships....");
        map.addComShip();
        System.out.println();
        map.printMap();
        System.out.println();

        //Play the game!
        int playerShip, comShip;
        while(!end){
            System.out.println("Your Turn");
            System.out.print("Enter X Coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y Coordinate: ");
            y = input.nextInt();
            while(!map.updateMap(x,y)){
                System.out.println("Try again!");
                System.out.print("Enter X Coordinate: ");
                x = input.nextInt();
                System.out.print("Enter Y Coordinate: ");
                y = input.nextInt();
            }

            System.out.println("Enemy's Turn");
            while(!map.updateMap()){

            }

            playerShip = map.scanMap(true);
            comShip = map.scanMap(false);

            if(playerShip == 0){
                System.out.println("Your Ships: " + playerShip + " |" + "Enemy Ships: " + comShip);
                System.out.println("You Lose!");
                end = true;
            }else if(comShip == 0){
                System.out.println("Your Ships: " + playerShip + " |" + "Enemy Ships: " + comShip);
                System.out.println("You won the battle!");
                end = true;
            }else{
                System.out.println("Your Ships: " + playerShip + " |" + "Enemy Ships: " + comShip);
                System.out.println("-------------------------------------------------------");
                System.out.println();
                map.printMap();
            }

        }
    }
    private static void printIntro(){
        String header = "";
        for(int i = 0; i <=18; i++){
            if(i == 9)
                header += "Encoded Message:020434";
            header += "*";
        }
        System.out.println(header);
        System.out.println("Warning Message:");
        System.out.println("Commander! Our patrols have detected hostiles!");
        System.out.println("Five enemy ship has been found charging into our territory.");
        System.out.println("Use our 5 ships available to you to remove this threat.");
        System.out.println("Good Fortune!");
        System.out.println();
        System.out.println("Right now, the map is empty");
    }
}
