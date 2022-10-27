package model;

import java.util.List;

public interface HospitalEmployee {

    int getEmployeeId();

    String getEmployeeName();

    List<Patient> getPatientList();
}
