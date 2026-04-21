package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double  hoursWorked;
    private double payRate;

    //This initializes these instances variables
    public Employee() {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }
    //These are the getters!
    public int getEmployeeId() {return employeeId;}
    public String getName() {return name;}
    public double getHoursWorked() {return hoursWorked;}
    public double getPayRate() {return payRate;}

    //These are the setters!
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}
    public void setName(String name) {this.name = name;}
    public void setHoursWorked(double hoursWorked) {this.hoursWorked = hoursWorked;}
    public void setPayRate(double payRate) {this.payRate = payRate;}

    public void parametirzedConstructor() {

    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    public double checkParse() {
        return 0;
    }


}
