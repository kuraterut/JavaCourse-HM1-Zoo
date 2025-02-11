package org.kuraterut.generator;

import org.kuraterut.entities.ZooItem;
import org.kuraterut.entities.alives.humans.Employee;
import org.kuraterut.entities.alives.animals.herbo.Monkey;
import org.kuraterut.entities.alives.animals.herbo.Rabbit;
import org.kuraterut.entities.alives.animals.predator.Tiger;
import org.kuraterut.entities.alives.animals.predator.Wolf;
import org.kuraterut.entities.inventory.things.Computer;
import org.kuraterut.entities.inventory.things.Table;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Generator {
    private Map<String, BiFunction<Scanner, PrintStream, ZooItem>> suppliers = new HashMap<>();
    {
        suppliers.put("monkey", Monkey::new);
        suppliers.put("rabbit", Rabbit::new);
        suppliers.put("tiger", Tiger::new);
        suppliers.put("wolf", Wolf::new);
        suppliers.put("table", Table::new);
        suppliers.put("computer", Computer::new);
        suppliers.put("employee", Employee::new);
    }
    public ZooItem generate(String zooItem, Scanner scanner, PrintStream out) throws IOException {
        BiFunction<Scanner, PrintStream, ZooItem> constructor = suppliers.get(zooItem);
        if(constructor != null){
            return constructor.apply(scanner, out);
        }
        throw new IllegalArgumentException("Zoo item '" + zooItem + "' not found");
    }

}
