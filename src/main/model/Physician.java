package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.LinkedList;

// Represents a physician with its employee ID, its name and a list of patients assigned
public class Physician implements HospitalEmployee, Writable {
    private int employeeId;
    private String employeeName;
    private LinkedList<Patient> patientList;

    // REQUIRES: employeeID has to be 4 digits long and employeeName cannot be an empty string
    // EFFECTS: creates a physician with its employee ID set to employeeID, its name set to
    //          employeeName alongside with an empty list of assigned to the physician
    public Physician(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.patientList = new LinkedList<>();
    }

    // REQUIRES: the inputted patient must not be present in the patient list
    // MODIFIES: this
    // EFFECTS: adds the inputted patient into a patient list for a physician
    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    // REQUIRES; the inputted patient must be present in the list
    // MODIFIES: this
    // EFFECTS: removes the inputted patient from the physician patient list
    public void removePatient(Patient p) {
        patientList.remove(p);
    }

    // EFFECTS: creates a json object from physician data
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("employeeID", employeeId);
        json.put("employeeName", employeeName);
        json.put("patientList", patientList);
        return json;
    }

    // getters
    public int getPatientListSize() {
        return patientList.size();
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public LinkedList<Patient> getPatientList() {
        return patientList;
    }
}
