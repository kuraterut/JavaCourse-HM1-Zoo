package org.kuraterut.clinicTests;

import org.junit.Assert;
import org.junit.Test;
import org.kuraterut.entities.alives.Animal;
import org.kuraterut.entities.alives.animals.herbo.Monkey;
import org.kuraterut.entities.alives.animals.herbo.Rabbit;
import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;

import java.util.Scanner;


public class VeterinaryClinicTest {
//    private VeterinaryClinic clinic;

    @Test
    public void testVeterinaryClinicCreation() {
        VeterinaryClinic clinic = new VeterinaryClinic("testclinic", 5);
        Assert.assertEquals(5, clinic.getMinHealth());
        Assert.assertEquals("testclinic", clinic.getName());

        clinic.setName("anotherTestclinic");
        Assert.assertEquals("anotherTestclinic", clinic.getName());

        clinic.setMinHealth(2);
        Assert.assertEquals(2, clinic.getMinHealth());
    }

    @Test
    public void testVeterinaryClinicUpdate() {
        VeterinaryClinic clinic = new VeterinaryClinic("testclinic", 5);

        clinic.setName("anotherTestclinic");
        Assert.assertEquals("anotherTestclinic", clinic.getName());

        clinic.setMinHealth(2);
        Assert.assertEquals(2, clinic.getMinHealth());
    }

    @Test
    public void testVeterinaryClinicCheckAnimal() {
        VeterinaryClinic clinic = new VeterinaryClinic("testclinic", 5);
        Scanner scannerMonkey = new Scanner("john\n6\n6\n6");
        Animal monkey = new Monkey(scannerMonkey, System.out);
        Scanner scannerRabbit = new Scanner("john\n3\n3\n3");
        Animal rabbit = new Rabbit(scannerRabbit, System.out);

        boolean checkMonkey = clinic.checkAnimal(monkey);
        boolean checkRabbit = clinic.checkAnimal(rabbit);

        Assert.assertTrue(checkMonkey);
        Assert.assertFalse(checkRabbit);
    }

}
