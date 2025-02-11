package org.kuraterut.entities.inventory.things;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Computer extends Thing {
    public Computer(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the computer:");
        String name = scanner.nextLine();

        this.setName(name);
    }

    public Computer(String name) {
        this.setName(name);
    }

    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + " Я компьютер \"" + this.getName() + "\"");
    }
}
