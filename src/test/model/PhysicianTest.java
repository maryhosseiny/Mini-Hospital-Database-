package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhysicianTest {
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


    @BeforeEach
    public void setUp() {
        testPhysicianOne = new Physician(1234, "Danny");
        testPhysicianTwo = new Physician(4567, "Tana");
        testPhysicianThree = new Physician(7890, "Sara");
        testPhysicianFour = new Physician(1212, "Peppa");
        testNurseOne = new Nurse( 4444, "Lena");
        testNurseTwo = new Nurse(3333, "Maya");
        testNurseThree = new Nurse(3333, "Maya");
        testPatientOne = new Patient("Ella", 20, 234111, true, 1);
        testPatientTwo = new Patient("Bam", 45, 111999, false, 2);
        testPatientThree = new Patient("Sam", 36, 818181, true ,3);
    }

    @Test
    public void testConstructor() {
        testPhysicianFour.addPatient(testPatientOne);
        assertEquals(testPhysicianFour.getPatientListSize(), 1);
        testPhysicianFour.addPatient(testPatientTwo);
        testPhysicianOne.addPatient(testPatientThree);
        assertEquals(testPhysicianFour.getPatientListSize(), 2);
        assertEquals(testPhysicianOne.getPatientListSize(), 1);
    }

    @Test
    public void testAddPatient() {
        testPhysicianFour.addPatient(testPatientOne);
        assertEquals(testPhysicianFour.getPatientListSize(),1);
        testPhysicianFour.addPatient(testPatientTwo);
        testPhysicianOne.addPatient(testPatientThree);
        assertEquals(testPhysicianFour.getPatientListSize(),2);
        assertEquals(testPhysicianOne.getPatientListSize(),1);

    }

    @Test
    public void testRemovePatient() {
        testPhysicianFour.addPatient(testPatientOne);
        testPhysicianFour.addPatient(testPatientTwo);
        testPhysicianFour.removePatient(testPatientOne);
        assertEquals(testPhysicianFour.getPatientListSize(), 1);
        testPhysicianFour.removePatient(testPatientTwo);
        assertEquals(testPhysicianFour.getPatientListSize(), 0);
    }

    @Test
    public void testGetEmployeeId() {
        assertEquals(testPhysicianFour.getEmployeeId(), 1212);
        assertEquals(testPhysicianThree.getEmployeeId(), 7890);
        assertEquals(testPhysicianOne.getEmployeeId(), 1234);
        assertEquals(testPhysicianTwo.getEmployeeId(), 4567);
    }

    @Test
    public void testGetEmployeeName() {
        assertEquals(testPhysicianFour.getEmployeeName(), "Peppa");
        assertEquals(testPhysicianThree.getEmployeeName(), "Sara");
        assertEquals(testPhysicianOne.getEmployeeName(), "Danny");
        assertEquals(testPhysicianTwo.getEmployeeName(), "Tana");
    }

    @Test
    public void testGetPatientListSize() {
        testPhysicianFour.addPatient(testPatientOne);
        testPhysicianFour.addPatient(testPatientTwo);
        testPhysicianOne.addPatient(testPatientThree);
        assertEquals(testPhysicianFour.getPatientListSize(), 2);
        assertEquals(testPhysicianThree.getPatientListSize(), 0);
        assertEquals(testPhysicianOne.getPatientListSize(), 1);
    }

    @Test
    public void testGetPatientList() {
        testPhysicianFour.addPatient(testPatientOne);
        testPhysicianFour.addPatient(testPatientTwo);
        testPhysicianOne.addPatient(testPatientThree);
        assertTrue(testPhysicianFour.getPatientList().contains(testPatientOne));
        assertTrue(testPhysicianFour.getPatientList().contains(testPatientTwo));
        assertTrue(testPhysicianOne.getPatientList().contains(testPatientThree));
    }
}
