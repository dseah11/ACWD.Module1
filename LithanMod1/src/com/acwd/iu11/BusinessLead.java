package com.acwd.iu11;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    private String name;
    private int headCount;
    private ArrayList<Accountant> report;

    public BusinessLead(String name){
        super(name);
        super.baseSalary = getBaseSalary() * 2;
        headCount = 10;
        report = new ArrayList<Accountant>();
    }
    public boolean hasHeadCount(){
        if(report.size() < headCount){
            return true;
        }
        return false;
    }
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if(report.size() <= headCount){
            report.add(e);
            e.setManager(this);
            updateBonusBudget((e.getBaseSalary() * 1.1));
            e.supportTeam(supportTeam);
            return true;
        }
        return false;
    }
    public boolean requestBonus(Employee e,double bonus){
        double currentBonus = getBonusBudget();
        if(bonus < currentBonus){
            updateBonusBudget(currentBonus - bonus);
            return true;
        }
        return false;
    }
    public boolean approveBonus(Employee e, double bonus){

        if(e.getManager() != null){
            Employee leader = e.getManager();
            for(int i=0; i < report.size(); i++){
                if(leader.equals(report.get(i).getTeamSupported())){
                   double currBudget =  report.get(i).getBonusBudget();
                   if(currBudget - bonus >= 0){
                       return true;
                   }
                   break;
                }
            }
        }else{
            for(int i=0; i<report.size();i++){
                if(e.equals(report.get(i).getTeamSupported())){
                    double currBudget =  report.get(i).getBonusBudget();
                    if(currBudget - bonus >= 0){
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
    public String getTeamStatus() {

            if(report.size() > 0 && report.size() <= 10){
                String status = getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget() +
                        " is supporting :\n";
                for (int i = 0; i < report.size(); i++) {
                    status += report.get(i).employeeStatus() + "\n";
                }
                return status;
            }
                return getEmployeeID() + " " + getName() + " with a budget of " + getBonusBudget() +
                        " and no direct reports yet";

    }
}
