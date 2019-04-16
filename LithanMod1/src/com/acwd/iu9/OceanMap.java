package com.acwd.iu9;

import java.util.Random;

/**
 *
 * @author dseah
 * @version 1.0
 * @since 2019-04-05
 */
public class OceanMap {
    private int[][] map;

    public OceanMap() {
        map = new int[10][10];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
    }

    /**
     *
     * Prints out the map according to the int values found
     *Value 0 = Empty (" ")
     * Value 1 = Player ship exist ("@")
     * Value 2 = Computer Ship exist (" ")
     * Value 3= Empty, player shot at ("-")
     * Value 4= empty, computer shot at (" ")
     * value 5 = empty, both shot at ("-")
     * value 8= comp ship sunk ("!")
     * value 9 = player ship sunk ("x")
     */
    public void printMap() {
        printHeader();
        for (int i = 0; i < this.map.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < this.map[i].length; j++) {

            }
            System.out.print("| " + i);
            System.out.println();
        }
        printHeader();
    }

    /**
     * checks if ship exist at coord x,y before adding
     * @param x
     * @param y
     * @return
     */
    public boolean addShip(int x, int y) {
        if(!isValid(x,y)){
            return false;
        }
        if (!isEmpty(x, y)) {
            return false;
        }
        this.map[x][y] = 1;
        return true;
    }
    //Similar to user-added ships
    public void addComShip() {
        int counter = 0;
        Random rand = new Random();
        while (counter < 5) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if (isEmpty(x, y)) {
                this.map[x][y] = 2;
                counter++;
                System.out.println("Ship " + counter + " deployed.");
            }
        }
    }


    /**
     * Updates the values of arrays when either the player or computer attempts to hit a coordinate
     *Value 0 = Empty, not shot at
     * Value 1 = Player ship exist
     * Value 2 = Computer Ship exist
     * Value 3= Empty, player shot at
     * Value 4= empty, computer shot at
     * value 5 = empty, both shot at
     * value 8= comp ship sunk
     * value 9 = player ship sunk
     *
     * @param x
     * @param y
     *
     */
    public boolean updateMap(int x, int y){
        if(!isValid(x,y)){
            System.out.println("Invalid coordinate!");
            return false;
        }
        switch(map[x][y]){
            case 0:
                map[x][y] = 3;
                System.out.println("You missed");
                break;
            case 1:
                map[x][y] = 9;
                System.out.println("!@#$!@#$! You hit your own ship! Horrible Commander");
                break;
            case 2:
                map[x][y] = 8;
                System.out.println("Boom! You've hit your target! Good job Commander!");
                break;
            case 4:
                map[x][y] = 5;
                System.out.println("You missed");
                break;
            case 3:
            case 5:
            case 8:
                System.out.println("You shot here before remember?!");
                return false;
            case 9:
                System.out.println("You cant shoot here!");
                return false;
        }
        return true;
    }
    public boolean updateMap(){
        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
//        System.out.println(x + "," + y); //Testing code left here to show comp coordinates
        switch(map[x][y]){
            case 0:
                map[x][y] = 4;
                System.out.println("Enemy missed");
                System.out.println();
                break;
            case 1:
                map[x][y] = 9;
                System.out.println("Your ship has been hit!");
                System.out.println();
                break;
            case 2:
                map[x][y] = 8;
                System.out.println("The enemy hits their own ship!");
                System.out.println();
                break;
            case 3:
                map[x][y] = 5;
                System.out.println("Enemy missed");
                System.out.println();
                break;
            default:
                // Testing code to ensure repeat coordinates are not used
//                System.out.println("Repeat found: " + x + "," + y);

                return false;
        }
        return true;
    }

    public int scanMap(boolean player){
        int check = 0;
        if(player){
            for(int i = 0 ; i <map.length;i++){
                for(int j = 0; j < map[i].length; j++){
                    if (map[i][j] == 1)
                        check++;
                }
            }
        }else{
            for(int i = 0 ; i <map.length;i++){
                for(int j = 0; j < map[i].length; j++){
                    if (map[i][j] == 2)
                        check++;
                }
            }
        }
        return check;
    }

    //Private methods
    private boolean isEmpty(int x, int y) {
        if (this.map[x][y] == 0) {
            return true;
        }
        return false;
    }

    private void printHeader() {
        int spaces = 3;
        for(int i= 0; i < spaces; i++){
            System.out.print(" ");
        }
        for (int i = 0; i < this.map.length; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
    private boolean isValid(int x, int y){
        if((x>=0 && x <= 9) && (y>=0 && y <= 9)){
            return true;
        }
        return false;
    }

    //Getters setterrs
    public int[][] getMap() {
        return map;
    }
}