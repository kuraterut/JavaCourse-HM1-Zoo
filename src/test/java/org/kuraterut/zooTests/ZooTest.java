package org.kuraterut.zooTests;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuraterut.controller.Controller;
import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;
import org.kuraterut.entities.Zoo;
import org.kuraterut.entities.ZooItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooTest extends TestCase {

    VeterinaryClinic clinic = new VeterinaryClinic("clinic", 5);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUp() {
        // Перенаправляем System.out в outputStream
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        // Восстанавливаем оригинальный System.out
        System.setOut(originalOut);
    }

    public String commandsArrayToString(List<String> commands) {
        String result = "";
        for(String command : commands) {
            result += command + System.lineSeparator();
        }
        return result;
    }

    @Test
    public void testZooCreation() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        String name = zoo.getName();
        String clinicName = zoo.getClinic().getName();

        Assert.assertEquals("standard zoo", name);
        Assert.assertEquals("clinic", clinicName);
    }

    @Test
    public void testZooItemAddingToZoo() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("add monkey");
        commandsArr.add("john");
        commandsArr.add("5");
        commandsArr.add("5");
        commandsArr.add("5");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Enter the name of the monkey:");
        expectedArr.add("Enter the food per day of the monkey:");
        expectedArr.add("Enter the health level of the monkey(0-10):");
        expectedArr.add("Enter the kindness level of the monkey(0-10):");
        expectedArr.add("zoo item added");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemAddingToZooFailed() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("add monkey");
        commandsArr.add("john");
        commandsArr.add("5");
        commandsArr.add("4");
        commandsArr.add("5");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Enter the name of the monkey:");
        expectedArr.add("Enter the food per day of the monkey:");
        expectedArr.add("Enter the health level of the monkey(0-10):");
        expectedArr.add("Enter the kindness level of the monkey(0-10):");
        expectedArr.add("zoo item not added because of zoo rules");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfo() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Animals list:");
        expectedArr.add("Contact animals list:");
        expectedArr.add("Total Food: 0");
        expectedArr.add("Inventory list:");
        expectedArr.add("Employees list:");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfoAnimals() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info animals");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Animals list:");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfoContact() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info contact");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Contact animals list:");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfoInventory() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info inventory");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Inventory list:");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfoFood() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info food");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Total Food: 0");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInfoEmployees() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("info employees");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Employees list:");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testZooItemPrintInvalid() {
        Zoo zoo = new Zoo("standard zoo", clinic, System.out);

        List<String> commandsArr = new ArrayList<>();

        commandsArr.add("invalid");

        String commands = commandsArrayToString(commandsArr);
        Scanner scanner = new Scanner(commands);

        Controller controller = new Controller(zoo, scanner, System.out);
        controller.execute();

        List<String> expectedArr = new ArrayList<>();
        expectedArr.add("Invalid syntax");

        String expectedOutput = commandsArrayToString(expectedArr);
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }
}