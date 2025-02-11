package org.kuraterut.entities.alives;

import org.kuraterut.entities.inventory.IInventory;

public abstract class Animal implements IAlive, IInventory {
    private int food;
    private int number;
    private String name;
    private int health;

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setFood(int food) {
        if(food < 0) throw new IllegalArgumentException("health must be more then 0");
        this.food = food;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0 || health > 10) throw new IllegalArgumentException("health must be between 0 and 10");
        this.health = health;
    }
}
