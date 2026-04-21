package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayRollCalcApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //This code creates a new array for objects
        List<Employee> employeeList = new ArrayList<>();

        //This code reads through the file and creates new instances for employees!
        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String temp;

            //This bufReader reads through each line until there is no more lines IE 0 lines = null
            while((temp = bufReader.readLine()) != null) {

                //This code splits each line into seperate parts in an array
                String[] tempArray = temp.split("\\|");
                //This code creates a new object
                Employee employee = new Employee();
                //This code parses our string into doubles/ints
                try {employee.setEmployeeId(Integer.parseInt(tempArray[0]));}
                catch (NumberFormatException e) {employee.setEmployeeId(0);}
                employee.setName(tempArray[1]);
                try {employee.setHoursWorked(Double.parseDouble(tempArray[2]));}
                catch (NumberFormatException e) {employee.setHoursWorked(0);}
                try {employee.setPayRate(Double.parseDouble(tempArray[3]));}
                catch (NumberFormatException e) {employee.setPayRate(0);}
                //This code stores our object into our array with the .add
                employeeList.add(employee);
            }

        }
        //This captures the Input and Output
        catch (IOException e) {
            e.printStackTrace();
        }

        //This code prints out all of the employee's information
        for (int i = 1; i < employeeList.toArray().length; i++) {
            System.out.printf("Employee %d is %s and made $%.2f this week!\n",employeeList.get(i).getEmployeeId(), employeeList.get(i).getName(), employeeList.get(i).getGrossPay());
        }




    }


}
