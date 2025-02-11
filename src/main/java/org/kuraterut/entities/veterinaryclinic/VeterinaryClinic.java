package org.kuraterut.entities.veterinaryclinic;

import org.kuraterut.entities.alives.Animal;

public class VeterinaryClinic {
    private String name;
    private int minHealth;

    public VeterinaryClinic(String name, int minHealth) {
        this.name = name;
        this.minHealth = minHealth;
    }

    public String getName() {
        return name;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public boolean checkAnimal(Animal animal) {
        if (animal.getHealth() < minHealth) {
            return false;
        }
        return true;
    }
}
