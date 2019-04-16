package com.acwd.iu10;

/**
 * @author danielseah
 * @version 1.0
 * created basic methods and contstructors for FractionCalculator
 * @version 1.1
 * found errors in  the edited arithmatic methods. Removed setters
 * Added temp variables to prevent unintended object changes.
 *
 * @since 2019-04-08
 *
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws IllegalAccessException{
        if(validFraction(denominator)){
            //only denominator is negative
            if(numerator > 0 && denominator < 0){
                numerator *= -1;
                denominator *= -1;
                //both numbers are negative
            }else if (numerator < 0 && denominator < 0){
                numerator *= -1;
                denominator *= -1;
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }else{
            throw new IllegalAccessException("Invalid Denominator");
        }

    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }
    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    public double toDouble(){
        return (double) this.numerator/this.denominator;
    }
    //Change numbers to common denominator before adding
    public Fraction add(Fraction other)throws IllegalAccessException{
        if(this.denominator != other.getDenominator()){
            int tempDen = this.denominator * other.getDenominator();
            int tempNum = this.numerator * other.getDenominator();
            int otherNum = other.getNumerator() * this.denominator;
            tempNum += otherNum;

            return new Fraction(tempNum, tempDen);
        }else{
            int tempNum =this.numerator + other.getNumerator();
            return new Fraction(tempNum, other.getDenominator());
        }
    }
    //Change numbers to common demoniator before subtracts
    public Fraction subtract(Fraction other)throws IllegalAccessException{
        if(this.denominator != other.getDenominator()){
            int tempDen = this.denominator * other.getDenominator();
            int tempNum = this.numerator * other.getDenominator();
            int otherNum = other.getNumerator() * this.denominator;
            tempNum += otherNum;

            return new Fraction(tempNum, tempDen);
        }else{
            int tempNum =this.numerator + other.getNumerator();
            return new Fraction(tempNum, other.getDenominator());
        }
    }
    //Direct multiplication
    public Fraction multiply(Fraction other)throws IllegalAccessException{
        int tempNum = this.numerator;
        int tempDen = this.denominator;
        tempNum *= other.getNumerator();
        tempDen *= other.getDenominator();

        return new Fraction(tempNum, tempDen);
    }
    //Swaps num and denom of Fraction other and send results to multiply method
    public Fraction divide(Fraction other) throws IllegalArgumentException, IllegalAccessException{
        if(other.getNumerator() == 0){
            throw new IllegalArgumentException("Divide by 0 detected");
        }
        int tempNum = other.getNumerator();
        int tempDen = other.getDenominator();

        return multiply(new Fraction(tempDen,tempNum));
    }
    public static int gcd(int num, int den){
        int temp;
        while(num != 0 && den !=0){
            temp = den;
            den = num%den;
            num = temp;
        }
        return num;
    }
    //calls gcd method to determine gcd, divide num and dem by gcd
    public void toLowestTerm(){
        int gcd = gcd(this.numerator,this.denominator);


        this.numerator /= gcd;
        this.denominator /= gcd;
    }
    public boolean equals(Object other){

        if (other instanceof Fraction){
            other = ((Fraction) other);
            ((Fraction) other).toLowestTerm();
            if(((Fraction) other).getNumerator() == this.numerator &&
                ((Fraction) other).getDenominator() == this.denominator){
                return true;
            }
        }
        return false;
    }

    private boolean validFraction(int denominator){
        if(denominator == 0){
            return false;
        }
        return true;
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

}
