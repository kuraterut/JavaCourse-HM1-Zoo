package org.kuraterut;

import junit.framework.TestCase;
import org.junit.Test;
import org.kuraterut.entities.Zoo;
import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;

public class ZooTest extends TestCase {
    @Test
    public void testZoo() {
        VeterinaryClinic clinic = new VeterinaryClinic("clinic", 5);
        Zoo zoo = new Zoo("zoo", clinic, System.out);
    }
}