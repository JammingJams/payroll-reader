package com.pluralsight;

import java.io.*;
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

                try {
                    employee.setEmployeeId(Integer.parseInt(tempArray[0]));
                    employee.setName(tempArray[1]);
                    employee.setHoursWorked(Double.parseDouble(tempArray[2]));
                    employee.setPayRate(Double.parseDouble(tempArray[3]));
                }
                catch (NumberFormatException e) {
                    System.out.println("Numbers are formatted incorrectly: Try checking the information you put in!");
                }
                //This code stores our object into our array with the .add
                employeeList.add(employee);
            }
            bufReader.close();

        }

        //This captures the Input and Output
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/payroll-sept-2023.cvs");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            String text;
            for(int i = 1; i < employeeList.toArray().length; i++) {
                text = String.format("%d|%s|$%.2f\n", employeeList.get(i).getEmployeeId(), employeeList.get(i).getName(), employeeList.get(i).getGrossPay());
                bufWriter.write(text);
            }
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }

        //This code prints out all of the employee's information
        for (int i = 1; i < employeeList.toArray().length; i++) {
            System.out.printf("Employee %d is %s and made $%.2f this week!\n",employeeList.get(i).getEmployeeId(), employeeList.get(i).getName(), employeeList.get(i).getGrossPay());
        }




    }


}
