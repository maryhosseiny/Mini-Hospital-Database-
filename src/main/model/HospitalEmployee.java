package model;

import java.util.List;

// Represents a Hospital employee interface template for Nurse and Physician classes
public interface HospitalEmployee {

    // getters
    int getEmployeeId();

    String getEmployeeName();

    List<Patient> getPatientList();
}
