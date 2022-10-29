package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            Hospital wr = new Hospital();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyHospital() {
        try {
            Hospital hospital = new Hospital();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyHospital.json");
            writer.open();
            writer.write(hospital);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyHospital.json");
            hospital = reader.read();
            assertEquals(0, hospital.getMedication().size());
            assertEquals(0, hospital.getPatients().size());
            assertEquals(0, hospital.getNurses().size());
            assertEquals(0, hospital.getPhysicians().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testReaderOneItemHospital() {
        JsonReader reader = new JsonReader("./data/testReaderOneItemHospital.json");
        try {
            Hospital hospital = reader.read();
            List<Physician> physicians = hospital.getPhysicianDatabase();
            assertEquals(1, physicians.size());
            checkPhysician(1234, "Danny", physicians.get(0));

            List<Nurse> nurses = hospital.getNurseDatabase();
            assertEquals(1, nurses.size());
            checkNurse(4444, "Lena", nurses.get(0));

            List<Patient> patients = hospital.getPatientDatabase();
            assertEquals(1, patients.size());
            checkPatient("Ella", 20, 234111, true, 1, patients.get(0));

            List<Medication> medication = hospital.getMedicationDatabase();
            assertEquals(1, medication.size());
            checkMedication("Acetaminophen", 123456, "Kirkland", medication.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }

    }

    @Test
    void testReaderGeneralHospital() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralHospital.json");
        try {
            Hospital hospital = reader.read();
            List<Physician> physicians = hospital.getPhysicianDatabase();
            assertEquals(4, physicians.size());
            checkPhysician(7890, "Sara", physicians.get(2));

            List<Nurse> nurses = hospital.getNurseDatabase();
            assertEquals(3, nurses.size());
            checkNurse(3331, "Miya", nurses.get(2));

            List<Patient> patients = hospital.getPatientDatabase();
            assertEquals(3, patients.size());
            checkPatient("Sam", 36, 818181, false, 3, patients.get(2));

            List<Medication> medication = hospital.getMedicationDatabase();
            assertEquals(3, medication.size());
            checkMedication("Levothyroxine", 456789, "Synthyroid", medication.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }

    }
}
