package org.kuraterut.zooItemTests.animals.herbo;

import org.junit.Assert;
import org.junit.Test;
import org.kuraterut.entities.alives.animals.herbo.Monkey;

import java.util.Scanner;

public class MonkeyTest {

    @Test
    public void testMonkeyCreation() {
        Scanner scanner = new Scanner("john\n3\n4\n5");
        Monkey monkey = new Monkey(scanner, System.out);


        String name = monkey.getName();
        int food = monkey.getFood();
        int health = monkey.getHealth();
        int kindness = monkey.getKindness();

        Assert.assertEquals("john", name);
        Assert.assertEquals(3, food);
        Assert.assertEquals(4, health);
        Assert.assertEquals(5, kindness);
    }

    @Test
    public void testMonkeyUpdate() {
        Scanner scanner = new Scanner("john\n3\n4\n5");

        Monkey monkey = new Monkey(scanner, System.out);

        monkey.setName("greg");
        monkey.setFood(19);
        monkey.setHealth(8);
        monkey.setKindness(10);

        String name = monkey.getName();
        int food = monkey.getFood();
        int health = monkey.getHealth();
        int kindness = monkey.getKindness();

        Assert.assertEquals("greg", name);
        Assert.assertEquals(19, food);
        Assert.assertEquals(8, health);
        Assert.assertEquals(10, kindness);
    }

    @Test
    public void testMonkeyCreationFailed() {
        Scanner scannerIllegalFood = new Scanner("john\n-1\n4\n5");
        Scanner scannerIllegalHealthLess = new Scanner("john\n2\n-1\n5");
        Scanner scannerIllegalHealthMore = new Scanner("john\n2\n11\n5");
        Scanner scannerIllegalKindnessLess = new Scanner("john\n2\n6\n-2");
        Scanner scannerIllegalKindnessMore = new Scanner("john\n2\n9\n12");


        Assert.assertThrows(IllegalArgumentException.class, ()->{Monkey monkey=new Monkey(scannerIllegalFood, System.out);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{Monkey monkey=new Monkey(scannerIllegalHealthLess, System.out);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{Monkey monkey=new Monkey(scannerIllegalHealthMore, System.out);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{Monkey monkey=new Monkey(scannerIllegalKindnessLess, System.out);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{Monkey monkey=new Monkey(scannerIllegalKindnessMore, System.out);});
    }

    @Test
    public void testMonkeyUpdateFailed() {
        Scanner scanner = new Scanner("john\n3\n4\n5");
        Monkey monkey = new Monkey(scanner, System.out);

        Assert.assertThrows(IllegalArgumentException.class, ()->{monkey.setFood(-2);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{monkey.setHealth(-2);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{monkey.setHealth(12);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{monkey.setKindness(-2);});
        Assert.assertThrows(IllegalArgumentException.class, ()->{monkey.setKindness(12);});
    }
}
