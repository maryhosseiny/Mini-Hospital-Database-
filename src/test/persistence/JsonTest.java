package persistence;

import model.*;
import model.Physician;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkHospital(LinkedList<Physician> physicians, LinkedList<Nurse> nurses,
                                 LinkedList<Patient> patients, LinkedList<Medication> medication,
                                 Hospital hospital) {
        assertEquals(physicians, hospital.getPhysicians());
        assertEquals(nurses, hospital.getNurses());
        assertEquals(patients, hospital.getPatients());
        assertEquals(medication, hospital.getMedication());
    }

    protected void checkPhysician(int employeeID, String employeeName, Physician physician) {
        assertEquals(employeeID, physician.getEmployeeId());
        assertEquals(employeeName, physician.getEmployeeName());
    }

    protected void checkNurse(int employeeID, String employeeName, Nurse nurse) {
        assertEquals(employeeID, nurse.getEmployeeId());
        assertEquals(employeeName, nurse.getEmployeeName());
    }

    protected void checkPatient(String name, int age, int personalHealthNumber, boolean dischargeStatus,
                                int roomNum, Patient patient) {
        assertEquals(name, patient.getName());
        assertEquals(age, patient.getAge());
        assertEquals(personalHealthNumber, patient.getPHN());
        assertEquals(dischargeStatus, patient.getStatus());
        assertEquals(roomNum, patient.getRoom());
    }

    protected void checkMedication(String name, int serialNum, String brand, Medication medication) {
        assertEquals(name, medication.getName());
        assertEquals(serialNum, medication.getSerialNumber());
        assertEquals(brand, medication.getBrand());
    }
}