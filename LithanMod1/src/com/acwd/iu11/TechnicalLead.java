package com.acwd.iu11;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee{
    private int headCount;
    private ArrayList<SoftwareEngineer> report;
    private TechnicalLead manager;

    public TechnicalLead(String name){
        super(name);
        setEmployeeStatus("Manager");
        super.baseSalary = getBaseSalary() * 1.3;
        headCount = 4;
        report = new ArrayList<SoftwareEngineer>();
    }

    public boolean hasHeadCount(){
        if(report.size() < headCount){
            return true;
        }
        return false;
    }
    public boolean addReport(SoftwareEngineer e){
        if(report.size() <= headCount){
            report.add(e);
            e.setManager(this);
        }
        return false;
    }
    public boolean approveCheckIn(SoftwareEngineer e){
        if(e.getManager().equals(this) && e.getCodeAccess() == true){
            return true;
        }
        return false;
    }
    public String getTeamStatus(){
        switch(report.size()){
            case 1:
            case 2:
            case 3:
            case 4:
                String status =  getEmployeeID() + " " + getName() + " has " + getCheckIn() + " successful check ins " +
                    " and is managing:\n";
                for(int i = 0; i < report.size(); i++){
                    status +=  report.get(i).employeeStatus() + "\n";
                }
                return status;
            default:
                return getEmployeeID() + " " + getName() + " has " + getCheckIn() + " successful check ins " +
                    " and no direct reports yet";
        }
    }

    public ArrayList<SoftwareEngineer> getReport() {
        return report;
    }
}
