package org.kuraterut.entities.alives.animals.predator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Tiger extends Predator {
    public Tiger(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the tiger:");
        String name = scanner.nextLine();

        out.println("Enter the food per day of the tiger:");
        int food = scanner.nextInt();
        if(food < 0) throw new RuntimeException("Invalid tiger food per day");

        out.println("Enter the health level of the tiger(0-10):");
        int health = scanner.nextInt();
        if(health < 0 || health > 10) throw new RuntimeException("Invalid tiger health level");

        this.setName(name);
        this.setFood(food);
        this.setHealth(health);
    }


    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + "Я тигр \"" + this.getName() + "\". Я ем " + this.getFood() + "кг еды в день");
    }
}
