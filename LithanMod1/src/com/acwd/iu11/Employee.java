package com.acwd.iu11;

/**
 * @author danielseah
 * @version 0.1
 * created basic structure for abstract class and extended class
 * @version 0.2
 * updated abstract class Employee and added a setMangager method
 * @since 2019-04-10
 *
 * An abstract class implementing IEmployee.
 * This class lays out the basic necessary variable needed in all employees
 */
public abstract class Employee implements IEmployee {
    private String name;
    public double baseSalary;
    private int employeeID;
    //the one responsible for id generation
    static int idGenerator = 100;
    private String employeeStatus;
    //@todo Link manager with Employee
    private Employee manager;

    /**
     * Employee constructor taking in a String name and double baseSalary
     * @param name
     * @param baseSalary
     */
    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID = idGenerator;
        idGenerator++;
        employeeStatus = "Employee";
        manager = null;
    }
    //getters and setters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public int getEmployeeID() {
        return employeeID;
    }

    //overridden toString method
    @Override
    public String toString(){
        return this.employeeID + " " + this.name;
    }

    public boolean equals(Employee other) {
        return (this.employeeID ==other.employeeID) ? true : false; //ternary operator
    }
    public Employee getManager(){
        return manager;
    }
    public abstract String employeeStatus();
    public void setManager(Employee manager){
        this.manager = manager;
    }
    public void setEmployeeStatus(String employeeStatus){
        this.employeeStatus = employeeStatus;
    }
}
