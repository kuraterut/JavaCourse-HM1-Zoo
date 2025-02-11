package org.kuraterut.entities.inventory.things;

import org.kuraterut.entities.inventory.IInventory;


public abstract class Thing implements IInventory {
    private int number;
    private String name;

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
}
