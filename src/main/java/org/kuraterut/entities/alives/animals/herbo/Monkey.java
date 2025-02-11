package org.kuraterut.entities.alives.animals.herbo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Monkey extends Herbo {

    public Monkey(Scanner scanner, PrintStream out) {
//        Scanner scanner = new Scanner(in);
        out.println("Enter the name of the monkey:");
        String name = scanner.nextLine();

        out.println("Enter the food per day of the monkey:");
        int food = scanner.nextInt();
        if(food < 0) throw new IllegalArgumentException("Invalid monkey food per day");

        out.println("Enter the health level of the monkey(0-10):");
        int health = scanner.nextInt();
        if(health < 0 || health > 10) throw new IllegalArgumentException("Invalid monkey health level");

        out.println("Enter the kindness level of the monkey(0-10):");
        int kindness = scanner.nextInt();
        if(kindness < 0 || kindness > 10) throw new IllegalArgumentException("Invalid monkey kindness level");

        this.setName(name);
        this.setFood(food);
        this.setHealth(health);
        this.setKindness(kindness);
    }



    @Override
    public void print(PrintStream out) {
        out.println("№" + this.getNumber() + " Я мартышка \"" + this.getName() + "\". Я ем " + this.getFood() + "кг еды в день");
    }
}
