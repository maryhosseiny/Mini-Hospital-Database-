package model;

import java.util.LinkedList;

// Represents a hospital with a list of physicians, nurses, patients and medications
public class Hospital {
    private LinkedList<Physician> physicians;
    private LinkedList<Nurse> nurses;
    private LinkedList<Patient> patients;
    private LinkedList<Medication> medications;

    // EFFECTS: creates a Hospital with 4 empty lists to represent its
    //          physicians, nurses, patients and medications
    public Hospital() {
        physicians = new LinkedList<>();
        nurses = new LinkedList<>();
        patients = new LinkedList<>();
        medications = new LinkedList<>();
    }

    // REQUIRES: inputted physician must not be present in the list of physicians
    // MODIFIES: this
    // EFFECTS: adds a physician to the list of physicians
    public void addPhysician(Physician doctor) {
        physicians.add(doctor);
    }

    // REQUIRES: inputted patient must not be present in the list of patients
    // MODIFIES: this
    // EFFECTS: adds a patient to the list of patients
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // REQUIRES: inputted nurse must not be present in the list of nurses
    // MODIFIES: this
    // EFFECTS: adds a nurse to the list of nurses
    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    // REQUIRES: inputted medication must not be present in the list of medications
    // MODIFIES: this
    // EFFECTS: adds a medication to the list of medications
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // REQUIRES: inputted physician must be present in the list of physicians
    // MODIFIES: this
    // EFFECTS: removes a physician to the list of physicians
    public void removePhysician(Physician doctor) {
        physicians.remove(doctor);
    }

    // REQUIRES: inputted patient must be present in the list of patients
    // MODIFIES: this
    // EFFECTS: removes a patient to the list of patients
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // REQUIRES: inputted nurse must be present in the list of nurses
    // MODIFIES: this
    // EFFECTS: removes a nurse to the list of nurses
    public void removeNurse(Nurse nurse) {
        nurses.remove(nurse);
    }

    // REQUIRES: inputted medication must be present in the list of medications
    // MODIFIES: this
    // EFFECTS: removes a medication to the list of medications
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    // getters
    public LinkedList<Physician> getPhysicians() {
        return physicians;
    }

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public LinkedList<Nurse> getNurses() {
        return nurses;
    }

    public LinkedList<Medication> getMedication() {
        return medications;
    }

    // EFFECTS: gets a list of discharged list of patients
    public LinkedList<Patient> getDischargedPatients() {
        LinkedList<Patient> dischargedPatient = new LinkedList<>();
        for (Patient p: patients) {
            if (p.getDischargeStatus()) {
                dischargedPatient.add(p);
            }
        }
        return dischargedPatient;

    }

}
