package com.acwd.iu11;

public interface IEmployee {


    public double getBaseSalary();
    public String getName();
    public int getEmployeeID();
    public Employee getManager();
    public boolean equals(Employee other);
    public String toString();
    public String employeeStatus();

}
