package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {
    private Hospital testHospital;
    private Physician testPhysicianOne;
    private Physician testPhysicianTwo;
    private Physician testPhysicianThree;
    private Physician testPhysicianFour;
    private Patient testPatientOne;
    private Patient testPatientTwo;
    private Patient testPatientThree;
    private Nurse testNurseOne;
    private Nurse testNurseTwo;
    private Nurse testNurseThree;
    private Medication testMedicationOne;
    private Medication testMedicationTwo;
    private Medication testMedicationThree;

    @BeforeEach
    public void setUp() {
        testHospital = new Hospital();
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
        testPatientOne = new Patient("Ella", 20, 234111, 1);
        testPatientTwo = new Patient("Bam", 45, 111999, 2 );
        testPatientThree = new Patient("Sam", 36, 818181, 3);
    }

    @Test
    public void testConstructor() {
        assertEquals(testHospital.getPhysicians().size(), 0);
        assertEquals(testHospital.getPatients().size(), 0);
        assertEquals(testHospital.getNurses().size(), 0);
        assertEquals(testHospital.getMedication().size(), 0);
    }

    @Test
    public void testAddPhysician() {
        assertEquals(testHospital.getPhysicians().size(), 0);
        testHospital.addPhysician(testPhysicianFour);
        assertEquals(testHospital.getPhysicians().size(), 1);
        testHospital.addPhysician(testPhysicianThree);
        testHospital.addPhysician(testPhysicianTwo);
        assertEquals(testHospital.getPhysicians().size(), 3);
    }

    @Test
    public void testAddPatient() {
        assertEquals(testHospital.getPatients().size(), 0);
        testHospital.addPatient(testPatientOne);
        assertEquals(testHospital.getPatients().size(), 1);
        testHospital.addPatient(testPatientTwo);
        testHospital.addPatient(testPatientThree);
        assertEquals(testHospital.getPatients().size(), 3);
    }

    @Test
    public void addNurse() {
        assertEquals(testHospital.getNurses().size(), 0);
        testHospital.addNurse(testNurseTwo);
        assertEquals(testHospital.getNurses().size(), 1);
        testHospital.addNurse(testNurseOne);
        testHospital.addNurse(testNurseThree);
        assertEquals(testHospital.getNurses().size(), 3);
    }

    @Test
    public void addMedication( ) {
        assertEquals(testHospital.getMedication().size(), 0);
        testHospital.addMedication(testMedicationOne);
        assertEquals(testHospital.getMedication().size(), 1);
        testHospital.addMedication(testMedicationThree);
        testHospital.addMedication(testMedicationTwo);
        assertEquals(testHospital.getMedication().size(), 3);
    }

    @Test
    public void removePhysician() {
        testHospital.addPhysician(testPhysicianThree);
        testHospital.addPhysician(testPhysicianTwo);
        assertEquals(testHospital.getPhysicians().size(), 2);
        testHospital.removePhysician(testPhysicianThree);
        assertEquals(testHospital.getPhysicians().size(), 1);
        testHospital.removePhysician(testPhysicianTwo);
        assertEquals(testHospital.getPhysicians().size(), 0);
    }

    @Test
    public void removePatient() {
        testHospital.addPatient(testPatientTwo);
        testHospital.addPatient(testPatientThree);
        assertEquals(testHospital.getPatients().size(), 2);
        testHospital.removePatient(testPatientThree);
        assertEquals(testHospital.getPatients().size(), 1);
        testHospital.removePatient(testPatientTwo);
        assertEquals(testHospital.getPatients().size(), 0);
    }

    @Test
    public void removeNurse() {
        testHospital.addNurse(testNurseTwo);
        testHospital.addNurse(testNurseOne);
        assertEquals(testHospital.getNurses().size(), 2);
        testHospital.removeNurse(testNurseOne);
        assertEquals(testHospital.getNurses().size(), 1);
        testHospital.removeNurse(testNurseTwo);
        assertEquals(testHospital.getNurses().size(), 0);
    }

    @Test
    public void testGetDischargedPatients() {
        testPatientOne.patientDischarged();
        testHospital.addPatient(testPatientOne);
        testHospital.addPatient(testPatientTwo);
        assertEquals(testHospital.getDischargedPatients().size(), 1);
        testPatientTwo.patientDischarged();
        testHospital.addPatient(testPatientThree);
        assertEquals(testHospital.getDischargedPatients().size(), 2);
    }

    @Test
    public void removeMedication() {
        testHospital.addMedication(testMedicationThree);
        testHospital.addMedication(testMedicationTwo);
        assertEquals(testHospital.getMedication().size(), 2);
        testHospital.removeMedication(testMedicationTwo);
        assertEquals(testHospital.getMedication().size(), 1);
        testHospital.removeMedication(testMedicationThree);
        assertEquals(testHospital.getMedication().size(), 0);
    }
}
