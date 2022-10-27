package model;

import java.util.LinkedList;

public class Hospital {
    private LinkedList<Physician> physicians;
    private LinkedList<Nurse> nurses;
    private LinkedList<Patient> patients;
    private LinkedList<Medication> medications;

    public Hospital() {
        physicians = new LinkedList<>();
        nurses = new LinkedList<>();
        patients = new LinkedList<>();
        medications = new LinkedList<>();
    }

    public void addPhysician(Physician doctor) {
        physicians.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removePhysician(Physician doctor) {
        physicians.remove(doctor);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void removeNurse(Nurse nurse) {
        nurses.remove(nurse);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public LinkedList<Physician> getPhysicians() {
        return physicians;
    }

    public LinkedList<Patient> getPatients() {
        return patients;
    }

    public LinkedList<Nurse> getNurses() {
        return nurses;
    }

    public LinkedList<Patient> getDischargedPatients() {
        LinkedList<Patient> dischargedPatient = new LinkedList<>();
        for (Patient p: patients) {
            if (p.getDischargeStatus()) {
                dischargedPatient.add(p);
            }
        }
        return dischargedPatient;

    }

    public LinkedList<Medication> getMedication() {
        return medications;
    }
}
