package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicationTest {
    private Medication testMedication;


    @BeforeEach
    public void setUp() {
        testMedication = new Medication("Acetaminophen", 12345678, "Kirkland");
    }

    @Test
    public void testGetSerialNumber() {
        assertEquals(testMedication.getSerialNumber(), 12345678);
    }

    @Test
    public void testGetName() {
        assertEquals(testMedication.getName(), "Acetaminophen");
    }

    @Test
    public void testGetBrand() {
        assertEquals(testMedication.getBrand(), "Kirkland");
    }
}
