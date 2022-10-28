package model;

import java.util.LinkedList;

// Represents a nurse with its employee ID number, name and a list of patients assigned
public class Nurse implements HospitalEmployee {
    private int employeeID;
    private String employeeName;
    private LinkedList<Patient> patientList;

    // REQUIRES: employeeID must be 4 digits long and employeeName cannot be empty
    // EFFECTS: creates a nurses with it's employee ID set to employeeID,
    //          its name set to employeeName alongside with an empty list of patient assigned
    public Nurse(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        patientList = new LinkedList<>();;
    }

    // REQUIRES: the inputted patient must not be present in the patient list
    // MODIFIES: this
    // EFFECTS: adds the inputted patient into a patient list for a nurse
    public void addPatient(Patient p) {
        patientList.add(p);
    }

    // REQUIRES; the inputted patient must be present in the list
    // MODIFIES: this
    // EFFECTS: removes the inputted patient from the nurse patient list
    public void removePatient(Patient p) {
        patientList.remove(p);
    }

    // getters
    public int getPatientListSize() {
        return patientList.size();
    }

    @Override
    public int getEmployeeId() {
        return employeeID;
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

