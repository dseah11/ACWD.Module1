package com.acwd.iu11;

public class BusinessEmployee extends Employee{
    private double bonusBudget;

    public BusinessEmployee(String name){
        super(name, 50000);
        bonusBudget = 0;
    }
    public double getBonusBudget(){
        return bonusBudget;
    }
    public String employeeStatus(){
        return getEmployeeID() + " " + getName() + " with a budget of " + this.bonusBudget;
    }
    public void updateBonusBudget(double newBonusBudget){
        this.bonusBudget = newBonusBudget;
    }
}
