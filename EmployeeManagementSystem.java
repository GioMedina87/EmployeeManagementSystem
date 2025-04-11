// ------------------------------------------------------------------------------
// Eduardo G. Medina
// Project - Employee Management System
// Language: Java
// Filename: EmployeeManagementSystem.java
// Description: A console-based application for managing employee records.
//              Allows listing, adding, and removing employees using an ArrayList.
// ------------------------------------------------------------------------------

package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeManagementSystem app = new EmployeeManagementSystem();
        app.run();
    }

    private void run() {
        printTitle();
        String command;
        do {
            System.out.println("\nCommand Menu:");
            System.out.println("list - List all the employees");
            System.out.println("add - Add an employee");
            System.out.println("remove - Remove an employee");
            System.out.println("exit - Exit the application\n");
            System.out.print("Command: ");
            command = scanner.nextLine().trim();
            switch (command) {
                case "list":
                    list();
                    break;
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "exit":
                    System.out.println("\nSystem terminated.");
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        } while (!command.equals("exit"));
    }

    private void printTitle() {
        System.out.println("Employees Management System\n");
    }

    private void list() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the list.");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }

    private void add() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Income: ");
        double income = Double.parseDouble(scanner.nextLine());
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(name, income, id);
        employees.add(employee);
        System.out.println(name + " is added.");
    }

    private void remove() {
        if (employees.isEmpty()) {
            System.out.println("No employees to remove.");
            return;
        }
        list();
        System.out.print("Index: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= employees.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Employee removed = employees.remove(index);
        System.out.println(removed.getName() + " is removed.");
    }
}

class Employee {
    private String name;
    private double income;
    private int id;

    public Employee(String name, double income, int id) {
        this.name = name;
        this.income = income;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + ", " + income + ", " + id;
    }
}

