package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class SmartHospital extends JFrame {
    public static final int homeTabIndex = 0;
    public static final int settingsTabIndex = 1;
    public static final int staffTabIndex = 2;
    public static final int medicationTabIndex = 3;
    public static final int patientTabIndex = 4;
    public static final int patientModifierTabIndex = 5;
    public static final int medicationModifierTabIndex = 6;
    private static int max = 100;
    private static int min = 4;

    private static final String JSON_STORE = "./data/hospital.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private JTabbedPane sidebar;
    private Hospital hospital;

    private Physician physicianOne = new Physician(1234, "Danny");
    private Physician physicianTwo = new Physician(4567, "Tana");
    private Physician physicianThree = new Physician(7890, "Sara");
    private Physician physicianFour = new Physician(1212, "Peppa");
    private Patient patOne = new Patient("Ella", 20, 234111,false, 1);
    private Patient patTwo = new Patient("Bam", 45, 111999, false,2);
    private Patient patThree = new Patient("Sam", 36, 818181, false, 3);
    private Nurse nurseOne = new Nurse(4444, "Lena");
    private Nurse nurseTwo = new Nurse(3333, "Maya");
    private Nurse nurseThree = new Nurse(3330, "Miya");
    private Medication medicationOne = new Medication("Acetaminophen", 123456, "Kirkland");
    private Medication medicationTwo = new Medication("Amoxicillin", 123678, "Trimox");
    private Medication medicationThree = new Medication("Levothyroxine", 456789, "Synthyroid");

    //MODIFIES: this
    //EFFECTS: creates SmartHospital, loads Hospital, displays sidebar and tabs
    public SmartHospital() throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("SmartHospital Console");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        frame.add(sidebar);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.hospital = new Hospital();
        init();
        loadTabs();
    }

    // MODIFIES: this
    // EFFECTS: initializes hospital
    public void init() {
        hospital.addPatient(patOne);
        hospital.addPatient(patTwo);
        hospital.addPatient(patThree);
        hospital.addNurse(nurseOne);
        hospital.addNurse(nurseTwo);
        hospital.addNurse(nurseThree);
        hospital.addMedication(medicationOne);
        hospital.addMedication(medicationTwo);
        hospital.addMedication(medicationThree);
        hospital.addPhysician(physicianOne);
        hospital.addPhysician(physicianTwo);
        hospital.addPhysician(physicianThree);
        hospital.addPhysician(physicianFour);
        patOne.patientDischarged();
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tabs to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel settingsTab = new SettingsTab(this);
        JPanel staffTab = new ReportTabStaff(this);
        JPanel medTab = new ReportTabMeds(this);
        JPanel patTab = new ReportTabPatients(this);
        JPanel patRemoveTab = new PatientModifierTab(this);
        JPanel medRemoveTab = new MedicationModifierTab(this);

        sidebar.add(homeTab, homeTabIndex);
        sidebar.setTitleAt(homeTabIndex, "Greetings");
        sidebar.add(settingsTab, settingsTabIndex);
        sidebar.setTitleAt(settingsTabIndex, "Main Menu");
        sidebar.add(staffTab, staffTabIndex);
        sidebar.setTitleAt(staffTabIndex, "Staff Menu");
        sidebar.add(medTab, medicationTabIndex);
        sidebar.setTitleAt(medicationTabIndex, "Medication Menu");
        sidebar.add(patTab, patientTabIndex);
        sidebar.setTitleAt(patientTabIndex, "Patients Menu");
        sidebar.add(patRemoveTab, patientModifierTabIndex);
        sidebar.setTitleAt(patientModifierTabIndex, "Patient List Modifier");
        sidebar.add(medRemoveTab, medicationModifierTabIndex);
        sidebar.setTitleAt(medicationModifierTabIndex, "Medication List Modifier");
    }

    //EFFECTS: returns SmartHospital object controlled by this UI
    public Hospital getSmartHospital() {
        return hospital;
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

    // EFFECTS: saves the database to file
    public void saveHospital() {
        try {
            jsonWriter.open();
            jsonWriter.write(hospital);
            jsonWriter.close();
            System.out.println("The hospital database is saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads database from file
    public void loadHospital() {
        try {
            hospital = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // REQUIRES: the inputted patient must not be in the hospital database
    // MODIFIES: this
    // EFFECTS: adds a patient to the hospital patient database
    public void addPatient(String name, int age, int phn, Boolean dischargeStatus, int roomNum) {
        Patient newPatient = new Patient(name, age, phn, dischargeStatus, roomNum);
        hospital.addPatient(newPatient);
    }

    // REQUIRES: the inputted patient must be in the hospital database
    // MODIFIES: this
    // EFFECTS: removes a patient from the hospital patient database
    public void removePatient(String name, int age, int phn, Boolean dischargeStatus, int roomNum) {
        LinkedList<Patient> patients = hospital.getPatients();
        for (Patient p: patients) {
            Boolean conditionOne = ((p.getName().equals(name)) && (p.getAge() == age) && (p.getPHN() == phn));
            Boolean conditionTwo = ((p.getStatus() == dischargeStatus) && (p.getRoom() == roomNum));
            if (conditionOne && conditionTwo) {
                hospital.removePatient(p);
            }
        }
    }

    // REQUIRES: the inputted medication must not be in the hospital database
    // MODIFIES: this
    // EFFECTS: adds a medication to the hospital medication database
    public void addMedication(String name, int serialNum, String brand) {
        Medication newMed = new Medication(name, serialNum, brand);
        hospital.addMedication(newMed);
    }

    // REQUIRES: the inputted medication must be in the hospital database
    // MODIFIES: this
    // EFFECTS: removes a medication form the hospital medication database
    public void removeMedication(String name, String brand, int serialNum) {
        LinkedList<Medication> medicationList = hospital.getMedication();
        for (Medication m: medicationList) {
            Boolean conditionOne = (m.getName().equals(name) && m.getBrand().equals(brand));
            Boolean conditionTwo = (m.getSerialNumber() == serialNum);
            if (conditionOne && conditionTwo) {
                hospital.removeMedication(m);
            }
        }
    }

    // EFFECTS: prints the names and employee IDs of all physicians in the database
    //          if the list is empty, returns an empty string
    public String retrievePhysicians() {
        String listPhysicians = "";
        for (Physician p: hospital.getPhysicians()) {
            listPhysicians += "{" + p.getEmployeeName() + ", " + p.getEmployeeId() +  "}" + " ";
        }
        return listPhysicians;
    }

    // EFFECTS: prints the name, age, PHN and room number of all patients in the database
    //          if the list is empty, returns an empty string
    public String retrievePatients() {
        String listPatients = "";
        for (Patient p: hospital.getPatients()) {
            String nameAndAge = (p.getName() + "," + p.getAge() + ",");
            listPatients += "{" + nameAndAge + p.getPHN() + "," + p.getStatus() + "," + p.getRoom() + "}" + " ";
        }
        return listPatients;
    }

    // EFFECTS: prints the names and employee IDs of all nurses in the database
    //          if the list is empty, returns an empty string
    public String retrieveNurses() {
        String listNurses = "";
        for (Nurse n: hospital.getNurses()) {
            listNurses += "{" + n.getEmployeeName() + "," + n.getEmployeeId() + "}" + " ";
        }
        return listNurses;
    }

    // EFFECTS: prints the names, serial number and brand of all medications in the database
    //          if the list is empty, returns an empty string
    public String retrieveMedication() {
        String listMedicationName = "";
        for (Medication m: hospital.getMedication()) {
            listMedicationName += "{" + m.getName() + "," + m.getSerialNumber() + "," + m.getBrand() + "}" + " ";
        }
        return listMedicationName;
    }

    // EFFECTS: prints the name, age, PHN and room number of all discharged patients in the database
    //          if the list is empty, returns an empty string
    public String retrieveDischarged() {
        String listDischarged = "";
        for (Patient p: hospital.getDischargedPatients()) {
            listDischarged += "{" + p.getName() + "," + p.getAge() + "," + p.getPHN() + "," + p.getRoom() + "}" + " ";
        }
        return listDischarged;
    }
}
