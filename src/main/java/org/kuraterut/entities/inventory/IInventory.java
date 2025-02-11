package org.kuraterut.entities.inventory;

import org.kuraterut.entities.ZooItem;

public interface IInventory extends ZooItem {
    int getNumber();

    void setNumber(int number);
}
