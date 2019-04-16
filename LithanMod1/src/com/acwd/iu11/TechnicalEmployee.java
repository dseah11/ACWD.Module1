package com.acwd.iu11;

public class TechnicalEmployee extends Employee {
    private int checkIn;
    public TechnicalEmployee(String name){
        super(name, 75000);
        checkIn = 0;
    }
    public void doCheckIn(){
        ++checkIn;
    }

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + getName() + " has " + checkIn + " successful check ins";
    }
    public int getCheckIn(){
        return checkIn;
    }
}
