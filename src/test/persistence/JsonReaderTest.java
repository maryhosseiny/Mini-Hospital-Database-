package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Hospital hospital = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyHospital() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyHospital.json");
        try {
            Hospital hospital = reader.read();
            assertEquals(0, hospital.getMedication().size());
            assertEquals(0, hospital.getPatients().size());
            assertEquals(0, hospital.getNurses().size());
            assertEquals(0, hospital.getPhysicians().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderOneItemHospital() {
        JsonReader reader = new JsonReader("./data/testReaderOneItemHospital.json");
        try {
            Hospital hospital = reader.read();
            assertEquals(1, hospital.getMedication().size());
            assertEquals(1, hospital.getPatients().size());
            assertEquals(1, hospital.getNurses().size());
            assertEquals(1, hospital.getPhysicians().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralHospital.json");
        try {
            Hospital hospital = reader.read();
            List<Physician> physicians = hospital.getPhysicianDatabase();
            List<Nurse> nurses = hospital.getNurseDatabase();
            List<Patient> patients = hospital.getPatientDatabase();
            List<Medication> medications = hospital.getMedicationDatabase();
            assertEquals(4, physicians.size());
            assertEquals(3, nurses.size());
            assertEquals(3, patients.size());
            assertEquals(3, medications.size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}