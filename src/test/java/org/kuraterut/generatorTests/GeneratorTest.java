package org.kuraterut.generatorTests;

import org.junit.Assert;
import org.junit.Test;
import org.kuraterut.entities.ZooItem;
import org.kuraterut.entities.alives.animals.herbo.Monkey;
import org.kuraterut.entities.alives.animals.herbo.Rabbit;
import org.kuraterut.entities.alives.humans.Employee;
import org.kuraterut.entities.alives.animals.predator.Tiger;
import org.kuraterut.entities.alives.animals.predator.Wolf;
import org.kuraterut.entities.inventory.things.Computer;
import org.kuraterut.entities.inventory.things.Table;
import org.kuraterut.generator.Generator;

import java.util.Scanner;

public class GeneratorTest {
    Generator generator = new Generator();
    @Test
    public void testGenerationMonkey() {
        Scanner scanner = new Scanner("john\n3\n4\n5");
        try{
            ZooItem zooItem = generator.generate("monkey", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Monkey);
            Monkey monkey = (Monkey)zooItem;
            Assert.assertEquals("john", monkey.getName());
            Assert.assertEquals(3, monkey.getFood());
            Assert.assertEquals(4, monkey.getHealth());
            Assert.assertEquals(5, monkey.getKindness());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationRabbit() {
        Scanner scanner = new Scanner("greg\n3\n4\n5");
        try{
            ZooItem zooItem = generator.generate("rabbit", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Rabbit);
            Rabbit rabbit = (Rabbit)zooItem;
            Assert.assertEquals("greg", rabbit.getName());
            Assert.assertEquals(3, rabbit.getFood());
            Assert.assertEquals(4, rabbit.getHealth());
            Assert.assertEquals(5, rabbit.getKindness());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationTiger() {
        Scanner scanner = new Scanner("greg\n3\n4");
        try{
            ZooItem zooItem = generator.generate("tiger", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Tiger);
            Tiger tiger = (Tiger)zooItem;
            Assert.assertEquals("greg", tiger.getName());
            Assert.assertEquals(3, tiger.getFood());
            Assert.assertEquals(4, tiger.getHealth());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationWolf() {
        Scanner scanner = new Scanner("greg\n3\n4");
        try{
            ZooItem zooItem = generator.generate("wolf", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Wolf);
            Wolf wolf = (Wolf)zooItem;
            Assert.assertEquals("greg", wolf.getName());
            Assert.assertEquals(3, wolf.getFood());
            Assert.assertEquals(4, wolf.getHealth());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationEmployee() {
        Scanner scanner = new Scanner("greg\n25\ndirector");
        try{
            ZooItem zooItem = generator.generate("employee", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Employee);
            Employee employee = (Employee)zooItem;
            Assert.assertEquals("greg", employee.getName());
            Assert.assertEquals(25, employee.getAge());
            Assert.assertEquals("director", employee.getRole());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationComputer() {
        Scanner scanner = new Scanner("standard");
        try{
            ZooItem zooItem = generator.generate("computer", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Computer);
            Computer computer = (Computer)zooItem;
            Assert.assertEquals("standard", computer.getName());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationTable() {
        Scanner scanner = new Scanner("standard");
        try{
            ZooItem zooItem = generator.generate("table", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Table);
            Table table = (Table)zooItem;
            Assert.assertEquals("standard", table.getName());
        }
        catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void testGenerationNotAZooItem() {
        Scanner scanner = new Scanner("standard");
        try{
            ZooItem zooItem = generator.generate("notAnItem", scanner, System.out);
            Assert.assertTrue(zooItem instanceof Table);
            Table table = (Table)zooItem;
            Assert.assertEquals("standard", table.getName());
        }
        catch (IllegalArgumentException e){
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
