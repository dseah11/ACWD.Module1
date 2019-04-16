package com.acwd.iu11;

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    public SoftwareEngineer(String name){
       super(name);

       codeAccess = false;
   }

    @Override
    public Employee getManager() {
        return null;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess) {
        this.codeAccess = codeAccess;
    }
    public int getSuccessfulCheckIns(){
        return getCheckIn();
    }
    public boolean checkInCode(){
        TechnicalLead manager =(TechnicalLead) getManager();
        if(manager.approveCheckIn(this)){
            doCheckIn();
            return true;
        }
        return false;
    }
}
