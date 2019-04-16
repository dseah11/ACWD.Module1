package com.acwd.iu11;

import java.util.ArrayList;

public class Accountant extends BusinessEmployee{
    private TechnicalLead teamSupported;
    private double budget;
    public Accountant(String name){
        super(name);
        teamSupported = null;
        budget = 0;
    }
    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }
    public void supportTeam(TechnicalLead leader){
        this.teamSupported = leader;
        ArrayList<SoftwareEngineer> report = leader.getReport();
        for(SoftwareEngineer e: report){
            budget += e.getBaseSalary() + (e.getBaseSalary() * 0.1);
        }
        updateBonusBudget(budget);
    }
    public boolean approveBonus(double bonus){
        if((budget - bonus) >= 0) {
            return true;
        }
        return false;
    }
    public String employeeStatus(){
        return getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget() +
                " is supporting " + getTeamSupported();
    }
}
