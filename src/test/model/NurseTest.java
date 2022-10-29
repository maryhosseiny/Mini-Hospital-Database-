package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NurseTest {
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
        testNurseThree = new Nurse(3434, "Tim");
        testPatientOne = new Patient("Ella", 20, 234111, true, 1);
        testPatientTwo = new Patient("Bam", 45, 111999, false, 2);
        testPatientThree = new Patient("Sam", 36, 818181, false, 3);
    }

    @Test
    public void testConstructor() {
        testNurseOne.addPatient(testPatientOne);
        assertEquals(testNurseOne.getPatientListSize(), 1);
        testNurseOne.addPatient(testPatientTwo);
        testNurseThree.addPatient(testPatientThree);
        assertEquals(testNurseOne.getPatientListSize(), 2);
        assertEquals(testNurseThree.getPatientListSize(), 1);
    }

    @Test
    public void testToJson() {
        JSONObject json = testNurseOne.toJson();
        assertEquals(json.get("employeeName"), testNurseOne.getEmployeeName());
        assertEquals(json.get("employeeID"), testNurseOne.getEmployeeId());
    }

    @Test
    public void testAddPatient() {
        testNurseOne.addPatient(testPatientOne);
        assertEquals(testNurseOne.getPatientListSize(),1);
        testNurseOne.addPatient(testPatientTwo);
        testNurseThree.addPatient(testPatientThree);
        assertEquals(testNurseOne.getPatientListSize(),2);
        assertEquals(testNurseThree.getPatientListSize(),1);

    }

    @Test
    public void testRemovePatient() {
        testNurseOne.addPatient(testPatientOne);
        testNurseOne.addPatient(testPatientTwo);
        testNurseOne.removePatient(testPatientOne);
        assertEquals(testNurseOne.getPatientListSize(), 1);
        testNurseOne.removePatient(testPatientTwo);
        assertEquals(testNurseOne.getPatientListSize(), 0);
    }

    @Test
    public void testGetEmployeeId() {
        assertEquals(testNurseOne.getEmployeeId(), 4444);
        assertEquals(testNurseThree.getEmployeeId(), 3434);
        assertEquals(testNurseTwo.getEmployeeId(), 3333);
    }

    @Test
    public void testGetEmployeeName() {
        assertEquals(testNurseOne.getEmployeeName(), "Lena");
        assertEquals(testNurseThree.getEmployeeName(), "Tim");
        assertEquals(testNurseTwo.getEmployeeName(), "Maya");
    }

    @Test
    public void testGetPatientListSize() {
        testNurseOne.addPatient(testPatientOne);
        testNurseOne.addPatient(testPatientTwo);
        testNurseThree.addPatient(testPatientThree);
        assertEquals(testNurseOne.getPatientListSize(), 2);
        assertEquals(testNurseTwo.getPatientListSize(), 0);
        assertEquals(testNurseThree.getPatientListSize(), 1);
    }

    @Test
    public void testGetPatientList() {
        testNurseOne.addPatient(testPatientOne);
        testNurseOne.addPatient(testPatientTwo);
        testNurseThree.addPatient(testPatientThree);
        assertTrue(testNurseOne.getPatientList().contains(testPatientOne));
        assertTrue(testNurseOne.getPatientList().contains(testPatientTwo));
        assertTrue(testNurseThree.getPatientList().contains(testPatientThree));
    }
}
