package model;

import java.util.LinkedList;

public class Nurse implements HospitalEmployee {
    private int employeeID;
    private String employeeName;
    private LinkedList<Patient> patientList;

    public Nurse(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        patientList = new LinkedList<>();;
    }

    public void addPatient(Patient p) {
        patientList.add(p);
    }

    public void removePatient(Patient p) {
        patientList.remove(p);
    }

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

