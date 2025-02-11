package org.kuraterut.zooTests;

import junit.framework.TestCase;
import org.junit.Test;
import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;
import org.kuraterut.entities.Zoo;
import org.kuraterut.entities.ZooItem;

import java.util.ArrayList;

public class ZooTest extends TestCase {

    public String commandsArrayToString(ArrayList<String> commands) {
        String result = "";
        for(String command : commands) {
            result += command + "\n";
        }
        return result;
    }

    @Test
    public void testZoo() {
        VeterinaryClinic clinic = new VeterinaryClinic("clinic", 5);
        Zoo zoo = new Zoo("zoo", clinic, System.out);
        ArrayList<String> commands = new ArrayList<>();
        commands.add("add monkey");
        commands.add("John");
        commands.add("5");
        commands.add("5");
        commands.add("5");

        ArrayList<ZooItem> zooItems = zoo.getZooItems();
    }
}