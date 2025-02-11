package org.kuraterut.entities.alives;

import org.kuraterut.entities.ZooItem;

public interface IAlive extends ZooItem {
    int getFood();

    void setFood(int food);
}
