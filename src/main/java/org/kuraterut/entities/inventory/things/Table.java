package org.kuraterut.entities.inventory.things;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Table extends Thing{
    public Table(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the table:");
        String name = scanner.nextLine();

        this.setName(name);
    }


    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + " Я стол \"" + this.getName() + "\"");
    }
}
