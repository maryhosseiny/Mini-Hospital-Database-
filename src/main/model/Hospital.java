package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Represents a hospital with a list of physicians, nurses, patients and medications
public class Hospital implements Writable {
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

    // EFFECTS: creates a json object from hospital database
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("physicians", physiciansToJson());
        json.put("nurses", nursesToJson());
        json.put("patients", patientsToJson());
        json.put("medication", medicationsToJson());
        return json;
    }

    // EFFECTS: returns physicians in this workroom as a JSON array
    public JSONArray physiciansToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Physician p : physicians) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns nurses in hospital as a JSON array
    public JSONArray nursesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Nurse n : nurses) {
            jsonArray.put(n.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns patients in hospital as a JSON array
    public JSONArray patientsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Patient p : patients) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns medication in hospital as a JSON array
    public JSONArray medicationsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Medication m : medications) {
            jsonArray.put(m.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns an unmodifiable list of nurses in the hospital
    public List<Nurse> getNurseDatabase() {
        return Collections.unmodifiableList(nurses);
    }

    // EFFECTS: returns an unmodifiable list of nurses in the hospital
    public List<Patient> getPatientDatabase() {
        return Collections.unmodifiableList(patients);
    }

    // EFFECTS: returns an unmodifiable list of nurses in the hospital
    public List<Physician> getPhysicianDatabase() {
        return Collections.unmodifiableList(physicians);
    }

    // EFFECTS: returns an unmodifiable list of nurses in the hospital
    public List<Medication> getMedicationDatabase() {
        return Collections.unmodifiableList(medications);
    }

    // REQUIRES: inputted physician must not be present in the list of physicians
    // MODIFIES: this, physicians
    // EFFECTS: adds a physician to the list of physicians
    public void addPhysician(Physician doctor) {
        physicians.add(doctor);
        EventLog.getInstance().logEvent(new Event("New physician added."));
    }

    // REQUIRES: inputted patient must not be present in the list of patients
    // MODIFIES: this, patients
    // EFFECTS: adds a patient to the list of patients
    public void addPatient(Patient patient) {
        patients.add(patient);
        EventLog.getInstance().logEvent(new Event("New patient added."));
    }

    // REQUIRES: inputted nurse must not be present in the list of nurses
    // MODIFIES: this, nurses
    // EFFECTS: adds a nurse to the list of nurses
    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
        EventLog.getInstance().logEvent(new Event("New nurse added."));
    }

    // REQUIRES: inputted medication must not be present in the list of medications
    // MODIFIES: this, medications
    // EFFECTS: adds a medication to the list of medications
    public void addMedication(Medication medication) {
        medications.add(medication);
        EventLog.getInstance().logEvent(new Event("New medication added."));
    }

    // REQUIRES: inputted physician must be present in the list of physicians
    // MODIFIES: this, physicians
    // EFFECTS: removes a physician to the list of physicians
    public void removePhysician(Physician doctor) {
        physicians.remove(doctor);
        EventLog.getInstance().logEvent(new Event("Inputted physician removed."));
    }

    // REQUIRES: inputted patient must be present in the list of patients
    // MODIFIES: this, patients
    // EFFECTS: removes a patient to the list of patients
    public void removePatient(Patient patient) {
        patients.remove(patient);
        EventLog.getInstance().logEvent(new Event("Inputted patient removed."));
    }

    // REQUIRES: inputted nurse must be present in the list of nurses
    // MODIFIES: this, nurses
    // EFFECTS: removes a nurse to the list of nurses
    public void removeNurse(Nurse nurse) {
        nurses.remove(nurse);
        EventLog.getInstance().logEvent(new Event("Inputted nurse removed."));
    }

    // REQUIRES: inputted medication must be present in the list of medications
    // MODIFIES: this, medications
    // EFFECTS: removes a medication to the list of medications
    public void removeMedication(Medication medication) {
        medications.remove(medication);
        EventLog.getInstance().logEvent(new Event("Inputted physician removed."));
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
            if (p.getStatus()) {
                dischargedPatient.add(p);
            }
        }
        return dischargedPatient;

    }

}
