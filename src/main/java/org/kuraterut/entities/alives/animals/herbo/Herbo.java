package org.kuraterut.entities.alives.animals.herbo;

import org.kuraterut.entities.alives.Animal;

public abstract class Herbo extends Animal {
    int kindness;

    public int getKindness() {
        return kindness;
    }

    public void setKindness(int kindness) {
        if(kindness < 0 || kindness > 10) throw new IllegalArgumentException("Kindness must be between 0 and 10");
        else this.kindness = kindness;
    }

    public boolean canCommunicate(){
        if(this.kindness > 5){
            return true;
        }
        return false;
    }
}
