package org.kuraterut.controller;

import org.kuraterut.entities.Zoo;
import org.kuraterut.generator.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Controller {
    private Zoo zoo;
    private InputStream in;
    private PrintStream out;

    public Controller(Zoo zoo, InputStream in, PrintStream out) {
        this.zoo = zoo;
        this.in = in;
        this.out = out;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public void execute() {
        Scanner scanner = new Scanner(in);

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            if (inputArr.length == 0) {
                continue;
            } else if (inputArr[0].equalsIgnoreCase("end")) {
                return;
            } else if (inputArr[0].equalsIgnoreCase("info")) {
                if (inputArr.length == 1) zoo.printAllInfo();
                else if (inputArr[1].equalsIgnoreCase("animals")) zoo.printAnimals();
                else if (inputArr[1].equalsIgnoreCase("contact")) zoo.printContactAnimals();
                else if (inputArr[1].equalsIgnoreCase("inventory")) zoo.printInventory();
                else if (inputArr[1].equalsIgnoreCase("employees")) zoo.printEmployees();
                else if (inputArr[1].equalsIgnoreCase("food")) zoo.printTotalFood();
                else {
                    out.println("Invalid syntax");
                }

            } else if (inputArr[0].equalsIgnoreCase("add")) {
                String zooItemStr = inputArr[1].toLowerCase();
                Generator generator = new Generator();
                try {
                    boolean wasAdded = zoo.addZooItem(generator.generate(zooItemStr, scanner, out));
                    if (wasAdded) {
                        out.println("zoo item added");
                    } else {
                        out.println("zoo item not added because of zoo rules");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (inputArr[0].equalsIgnoreCase("")) {
                continue;
            } else {
                out.println("Invalid syntax");
            }
        }
    }
}
