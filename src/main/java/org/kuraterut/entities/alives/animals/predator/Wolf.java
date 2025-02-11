package org.kuraterut.entities.alives.animals.predator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Wolf extends Predator {
    public Wolf(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the wolf:");
        String name = scanner.nextLine();

        out.println("Enter the food per day of the wolf:");
        int food = scanner.nextInt();
        if(food < 0) throw new RuntimeException("Invalid wolf food per day");

        out.println("Enter the health level of the wolf(0-10):");
        int health = scanner.nextInt();
        if(health < 0 || health > 10) throw new RuntimeException("Invalid wolf health level");

        this.setName(name);
        this.setFood(food);
        this.setHealth(health);
    }

    public Wolf(String name, int food, int health) {
        this.setFood(food);
        this.setName(name);
        this.setHealth(health);
    }

    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + "Я волк \"" + this.getName() + "\". Я ем " + this.getFood() + "кг еды в день");
    }
}
