package ui;

import model.Event;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

// Represents a SmartHospital database with patient, medication and staff databases where the user can access
//            six different tabs to modify/view these databases
public class SmartHospital extends JFrame {
    public static final int homeTabIndex = 0;
    public static final int settingsTabIndex = 1;
    public static final int staffTabIndex = 2;
    public static final int medicationTabIndex = 3;
    public static final int patientTabIndex = 4;
    public static final int patientModifierTabIndex = 5;
    public static final int medicationModifierTabIndex = 6;

    private static final String JSON_STORE = "./data/hospital.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private JTabbedPane sidebar;
    private Hospital hospital;
    private JFrame frame;

    private final Physician physicianOne = new Physician(1234, "Danny");
    private final Physician physicianTwo = new Physician(4567, "Tana");
    private final Physician physicianThree = new Physician(7890, "Sara");
    private final Physician physicianFour = new Physician(1212, "Peppa");
    private final Patient patOne = new Patient("Ella", 20, 234111,false, 1);
    private final Patient patTwo = new Patient("Bam", 45, 111999, false,2);
    private final Patient patThree = new Patient("Sam", 36, 818181, false, 3);
    private final Nurse nurseOne = new Nurse(4444, "Lena");
    private final Nurse nurseTwo = new Nurse(3333, "Maya");
    private final Nurse nurseThree = new Nurse(3330, "Miya");
    private final Medication medOne = new Medication("Acetaminophen", 123456, "Kirkland");
    private final Medication medTwo = new Medication("Amoxicillin", 123678, "Trimox");
    private final Medication medThree = new Medication("Levothyroxine", 456789, "Synthyroid");

    //EFFECTS: creates SmartHospital, loads Hospital, displays sidebar and tabs
    public SmartHospital() throws FileNotFoundException {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("SmartHospital Console");
        frame.setSize(WIDTH, HEIGHT);
        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        frame.add(sidebar);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.hospital = new Hospital();
        init();
        loadTabs();
        printToConsole();
    }

    //MODIFIES: this, frame
    //EFFECTS: once the window is closed, initializes an EventLog to print on console
    //         then exits the system
    public void printToConsole() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printEventToConsole(EventLog.getInstance());
                System.exit(0);
            }
        });
    }

    //EFFECTS: uses a for loop on each event in the EventLog then prints out each event
    public void printEventToConsole(EventLog eventLog) {
        for (Event e : eventLog) {
            System.out.println(e.toString() + "\n");
        }
    }

    // MODIFIES: this, hospital, patOne
    // EFFECTS: initializes hospital
    public void init() {
        hospital.addPatient(patOne);
        hospital.addPatient(patTwo);
        hospital.addPatient(patThree);
        hospital.addNurse(nurseOne);
        hospital.addNurse(nurseTwo);
        hospital.addNurse(nurseThree);
        hospital.addMedication(medOne);
        hospital.addMedication(medTwo);
        hospital.addMedication(medThree);
        hospital.addPhysician(physicianOne);
        hospital.addPhysician(physicianTwo);
        hospital.addPhysician(physicianThree);
        hospital.addPhysician(physicianFour);
        patOne.patientDischarged();
    }

    //MODIFIES: this, sidebar
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

    //MODIFIES: jsonWriter
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

    // EFFECTS: loads database from file
    public void loadHospital() {
        try {
            hospital = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // REQUIRES: the inputted patient must not be in the hospital database
    // MODIFIES: this, Hospital
    // EFFECTS: adds a patient to the hospital patient database
    public void addPatient(String name, int age, int phn, Boolean dischargeStatus, int roomNum) {
        Patient newPatient = new Patient(name, age, phn, dischargeStatus, roomNum);
        hospital.addPatient(newPatient);
    }

    // REQUIRES: the inputted patient must be in the hospital database
    // MODIFIES: this, Hospital
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
    // MODIFIES: this, Hospital
    // EFFECTS: adds a medication to the hospital medication database
    public void addMedication(String name, int serialNum, String brand) {
        Medication newMed = new Medication(name, serialNum, brand);
        hospital.addMedication(newMed);
    }

    // REQUIRES: the inputted medication must be in the hospital database
    // MODIFIES: this, Hospital
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
