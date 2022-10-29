package model;

import org.json.JSONArray;
import org.json.JSONObject;
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
        testPatientOne = new Patient("Ella", 20, 234111, true, 1);
        testPatientTwo = new Patient("Bam", 45, 111999, false, 2 );
        testPatientThree = new Patient("Sam", 36, 818181, false, 3);
    }

    @Test
    public void testConstructor() {
        assertEquals(testHospital.getPhysicians().size(), 0);
        assertEquals(testHospital.getPatients().size(), 0);
        assertEquals(testHospital.getNurses().size(), 0);
        assertEquals(testHospital.getMedication().size(), 0);
    }

    @Test
    public void testPatientsToJson() {
        testHospital.addPatient(testPatientOne);
        testHospital.addPatient(testPatientThree);
        JSONObject patient1 = (JSONObject) testHospital.patientsToJson().get(0);
        assertEquals(testPatientOne.toJson().get("name"), patient1.get("name"));
        assertEquals(testPatientOne.toJson().get("age"), patient1.get("age"));
        assertEquals(testPatientOne.toJson().get("personalHealthNumber"), patient1.get("personalHealthNumber"));
        assertEquals(testPatientOne.toJson().get("roomNum"), patient1.get("roomNum"));
        assertEquals(testPatientOne.toJson().get("dischargeStatus"), patient1.get("dischargeStatus"));
        JSONObject patient2 = (JSONObject) testHospital.patientsToJson().get(1);
        assertEquals(testPatientThree.toJson().get("name"), patient2.get("name"));
        assertEquals(testPatientThree.toJson().get("age"), patient2.get("age"));
        assertEquals(testPatientThree.toJson().get("personalHealthNumber"), patient2.get("personalHealthNumber"));
        assertEquals(testPatientThree.toJson().get("roomNum"), patient2.get("roomNum"));
        assertEquals(testPatientThree.toJson().get("dischargeStatus"), patient2.get("dischargeStatus"));
    }

    @Test
    public void testNursesToJson() {
        testHospital.addNurse(testNurseOne);
        testHospital.addNurse(testNurseTwo);
        JSONObject nurse1 = (JSONObject) testHospital.nursesToJson().get(0);
        assertEquals(testNurseOne.toJson().get("employeeID"), nurse1.get("employeeID"));
        assertEquals(testNurseOne.toJson().get("employeeName"), nurse1.get("employeeName"));
        JSONObject nurse2 = (JSONObject) testHospital.nursesToJson().get(1);
        assertEquals(testNurseTwo.toJson().get("employeeID"), nurse2.get("employeeID"));
        assertEquals(testNurseTwo.toJson().get("employeeName"), nurse2.get("employeeName"));
    }

    @Test
    public void testPhysiciansToJson() {
        testHospital.addPhysician(testPhysicianOne);
        testHospital.addPhysician(testPhysicianTwo);
        testHospital.addPhysician(testPhysicianFour);
        JSONObject phys1 = (JSONObject) testHospital.physiciansToJson().get(0);
        assertEquals(testPhysicianOne.toJson().get("employeeID"), phys1.get("employeeID"));
        assertEquals(testPhysicianOne.toJson().get("employeeName"), phys1.get("employeeName"));
        JSONObject phys2 = (JSONObject) testHospital.physiciansToJson().get(1);
        assertEquals(testPhysicianTwo.toJson().get("employeeID"), phys2.get("employeeID"));
        assertEquals(testPhysicianTwo.toJson().get("employeeName"), phys2.get("employeeName"));
    }

    @Test
    public void testMedicationToJson() {
        testHospital.addMedication(testMedicationOne);
        testHospital.addMedication(testMedicationTwo);
        JSONObject med1 = (JSONObject) testHospital.medicationsToJson().get(0);
        assertEquals(testMedicationOne.toJson().get("name"), med1.get("name"));
        assertEquals(testMedicationOne.toJson().get("serialNum"), med1.get("serialNum"));
        assertEquals(testMedicationOne.toJson().get("brand"), med1.get("brand"));
        JSONObject med2 = (JSONObject) testHospital.medicationsToJson().get(1);
        assertEquals(testMedicationTwo.toJson().get("name"), med2.get("name"));
        assertEquals(testMedicationTwo.toJson().get("serialNum"), med2.get("serialNum"));
        assertEquals(testMedicationTwo.toJson().get("brand"), med2.get("brand"));
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
