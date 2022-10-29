package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    public Physician testPhysicianOne;
    public Physician testPhysicianTwo;
    public Physician testPhysicianThree;
    public Physician testPhysicianFour;
    public Patient testPatientOne;
    public Patient testPatientTwo;
    public Patient testPatientThree;
    public Nurse testNurseOne;
    public Nurse testNurseTwo;
    public Nurse testNurseThree;
    public Medication testMedicationOne;
    public Medication testMedicationTwo;
    public Medication testMedicationThree;

    @BeforeEach
    public void setUp() {
        testMedicationOne = new Medication("Acetaminophen", 123456, "Kirkland");
        testMedicationTwo = new Medication("Amoxicillin", 123678, "Trimox");
        testMedicationThree = new Medication("Levothyroxine", 456789, "Synthyroid");
        testPhysicianOne = new Physician(1234, "Danny");
        testPhysicianTwo = new Physician(4567, "Tana");
        testPhysicianThree = new Physician(7890, "Sara");
        testPhysicianFour = new Physician(1212, "Peppa");
        testNurseOne = new Nurse( 4444, "Lena");
        testNurseTwo = new Nurse(3333, "Maya");
        testNurseThree = new Nurse(3333, "Maya");
        testPatientOne = new Patient("Ella", 20, 234111, true, 1);
        testPatientTwo = new Patient("Bam", 45, 111999, false, 2);
        testPatientThree = new Patient("Sam", 36, 818181, false, 3);
    }

    @Test
    public void testConstructor() {
        assertTrue(testPatientOne.getStatus());
        assertEquals(testPatientOne.getName(), "Ella");
        assertEquals(testPatientOne.getAge(), 20);
        assertEquals(testPatientOne.getPHN(), 234111);
        assertEquals(testPatientOne.getRoom(), 1);


    }

    @Test
    public void testPatientDischarged() {
        assertFalse(testPatientTwo.getStatus());
        testPatientTwo.patientDischarged();
        assertTrue(testPatientTwo.getStatus());
    }

    @Test
    public void testGetName() {
        assertEquals(testPatientOne.getName(), "Ella");
        assertEquals(testPatientTwo.getName(), "Bam");
        assertEquals(testPatientThree.getName(), "Sam");

    }

    @Test
    public void testGetAge() {
        assertEquals(testPatientOne.getAge(), 20);
        assertEquals(testPatientTwo.getAge(), 45);
        assertEquals(testPatientThree.getAge(), 36);
    }

    @Test
    public void testGetPersonalHealthNumber() {
        assertEquals(testPatientOne.getPHN(), 234111);
        assertEquals(testPatientTwo.getPHN(), 111999);
        assertEquals(testPatientThree.getPHN(), 818181);

    }

    @Test
    public void testIsDischargeStatus() {
        assertTrue(testPatientOne.getStatus());
        assertFalse(testPatientTwo.getStatus());
        assertFalse(testPatientThree.getStatus());

    }

    @Test
    public void testGetRoomNum() {
        assertEquals(testPatientOne.getRoom(), 1);
        assertEquals(testPatientTwo.getRoom(), 2);
        assertEquals(testPatientThree.getRoom(), 3);

    }
}
