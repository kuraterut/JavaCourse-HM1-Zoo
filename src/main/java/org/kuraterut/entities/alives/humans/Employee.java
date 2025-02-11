package org.kuraterut.entities.alives.humans;

import org.kuraterut.entities.alives.IAlive;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Employee implements IAlive {
    private String name;
    private int age;
    private String role;

    public Employee(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the employee:");
        String name = scanner.nextLine();

        out.println("Enter age of the employee(14-150):");
        int age = scanner.nextInt();
        if(age < 14 || age > 150) throw new RuntimeException("Invalid employee age");
        scanner.nextLine();
        out.println("Enter the role of the employee:");
        String role = scanner.nextLine();

        this.setName(name);
        this.setRole(role);
        this.setAge(age);
    }

    @Override
    public int getFood(){
        return 0;
    }

    @Override
    public void setFood(int food) {
        return;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void print(PrintStream out) {
        out.println("Я сотрудник зоопарка. Меня зовут " + this.getName());
    }
}
