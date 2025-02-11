package org.kuraterut.entities.alives.animals.herbo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Rabbit extends Herbo {
    public Rabbit(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the rabbit:");
        String name = scanner.nextLine();

        out.println("Enter the food per day of the rabbit:");
        int food = scanner.nextInt();
        if(food < 0) throw new RuntimeException("Invalid rabbit food per day");

        out.println("Enter the health level of the rabbit(0-10):");
        int health = scanner.nextInt();
        if(health < 0 || health > 10) throw new RuntimeException("Invalid rabbit health level");

        out.println("Enter the kindness level of the rabbit(0-10):");
        int kindness = scanner.nextInt();
        if(kindness < 0 || kindness > 10) throw new RuntimeException("Invalid rabbit kindness level");

        this.setName(name);
        this.setFood(food);
        this.setHealth(health);
        this.setKindness(kindness);
    }

    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + " Я кролик \"" + this.getName() + "\". Я ем " + this.getFood() + "кг еды в день");
    }
}
