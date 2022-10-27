package model;

import java.util.LinkedList;

public class Physician implements HospitalEmployee {
    private int employeeId;
    private String employeeName;
    private LinkedList<Patient> patientList;

    public Physician(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.patientList = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    public void removePatient(Patient p) {
        patientList.remove(p);
    }

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
