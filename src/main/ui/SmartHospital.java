package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SmartHospital extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int SETTINGS_TAB_INDEX = 1;
    public static final int REPORT_TAB_INDEX_STAFF = 2;
    public static final int REPORT_TAB_INDEX_MEDS = 3;
    public static final int REPORT_TAB_INDEX_PATS = 4;
    public static final int REPORT_TAB_INDEX_PATS_REMOVE = 5;
    private static int max = 100;
    private static int min = 4;

    private static final String JSON_STORE = "./data/hospital.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private Hospital hospital;

    private Physician physicianOne = new Physician(1234, "Danny");
    private Physician physicianTwo = new Physician(4567, "Tana");
    private Physician physicianThree = new Physician(7890, "Sara");
    private Physician physicianFour = new Physician(1212, "Peppa");
    private Patient patientOne = new Patient("Ella", 20, 234111,false, 1);
    private Patient patientTwo = new Patient("Bam", 45, 111999, false,2);
    private Patient patientThree = new Patient("Sam", 36, 818181, false, 3);
    private Nurse nurseOne = new Nurse(4444, "Lena");
    private Nurse nurseTwo = new Nurse(3333, "Maya");
    private Nurse nurseThree = new Nurse(3330, "Miya");
    private Medication medicationOne = new Medication("Acetaminophen", 123456, "Kirkland");
    private Medication medicationTwo = new Medication("Amoxicillin", 123678, "Trimox");
    private Medication medicationThree = new Medication("Levothyroxine", 456789, "Synthyroid");

    //MODIFIES: this
    //EFFECTS: creates SmartHomeUI, loads SmartHome appliances, displays sidebar and tabs
    public SmartHospital() throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("SmartHome Console");
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
    // EFFECTS: initializes accounts
    // taken and modified from the TellerApp code provided in class
    public void init() {
        hospital.addPatient(patientOne);
        hospital.addPatient(patientTwo);
        hospital.addPatient(patientThree);
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
        patientOne.patientDischarged();
    }


    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tabs to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel settingsTab = new SettingsTab(this);
        JPanel staffTab = new ReportTabStaff(this);
        JPanel medTab = new ReportTabMeds(this);
        JPanel patTab = new ReportTabPatients(this);
        JPanel patRemoveTab = new RemovePatientTab(this);


        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Greetings");
        sidebar.add(settingsTab, SETTINGS_TAB_INDEX);
        sidebar.setTitleAt(SETTINGS_TAB_INDEX, "Main Menu");
        sidebar.add(staffTab, REPORT_TAB_INDEX_STAFF);
        sidebar.setTitleAt(REPORT_TAB_INDEX_STAFF, "Staff Menu");
        sidebar.add(medTab, REPORT_TAB_INDEX_MEDS);
        sidebar.setTitleAt(REPORT_TAB_INDEX_MEDS, "Medication Menu");
        sidebar.add(patTab, REPORT_TAB_INDEX_PATS);
        sidebar.setTitleAt(REPORT_TAB_INDEX_PATS, "Patients Menu");
        sidebar.add(patRemoveTab, REPORT_TAB_INDEX_PATS_REMOVE);
        sidebar.setTitleAt(REPORT_TAB_INDEX_PATS_REMOVE, "Remove Patient Menu");
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
            System.out.println("Loaded the previous hospital database from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // REQUIRES: the inputted patient must not be in the hospital database
    // MODIFIES: this
    // EFFECTS: adds a patient to the hospital patient database
    public void addPatient() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the patient's name, age, and Personal Health Number.");
        String name = userInput.nextLine();
        int roomNum = (int)(Math.random() * (max - min));
        int age = userInput.nextInt();
        int phn = userInput.nextInt();
        Boolean dischargeStatus = false;
        Patient newPatient = new Patient(name, age, phn, dischargeStatus, roomNum);
        hospital.addPatient(newPatient);
        System.out.println("The patient is now added to our system. Please press 'return' to go back to the main menu");
    }

    // REQUIRES: the inputted patient must be in the hospital database
    // MODIFIES: this
    // EFFECTS: removes a patient from the hospital patient database
    public void removePatient() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Here is a list of all patients available in the database.");
        viewPatients();
        System.out.println("Enter patient's name, age, PHN, discharge status(true/false) and room number to remove.");
        String n = userInput.nextLine();
        int a = userInput.nextInt();
        int phn = userInput.nextInt();
        Boolean s = userInput.nextBoolean();
        int room = userInput.nextInt();
        LinkedList<Patient> patients = hospital.getPatients();
        for (Patient p: patients) {
            Boolean conditionOne = ((p.getName().equals(n)) && (p.getAge() == a) && (p.getPHN() == phn));
            Boolean conditionTwo = ((p.getStatus() == s) && (p.getRoom() == room));
            if (conditionOne && conditionTwo) {
                hospital.removePatient(p);
            }
        }
        System.out.println("The patient is removed from our system. Please press 'return' to go back to the main menu");
    }

    // REQUIRES: the inputted medication must not be in the hospital database
    // MODIFIES: this
    // EFFECTS: adds a medication to the hospital medication database
    public void addMedication() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the medication's name, brand and serial number.");
        String name = userInput.nextLine();
        String brand = userInput.nextLine();
        int serialNum = userInput.nextInt();
        Medication newMed = new Medication(name, serialNum, brand);
        hospital.addMedication(newMed);
        System.out.println("The medication is now added. Please press 'return' to go back to the main menu");
    }

    // REQUIRES: the inputted medication must be in the hospital database
    // MODIFIES: this
    // EFFECTS: removes a medication form the hospital medication database
    public void removeMedication() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Here is a list of all medications available in the database.");
        viewMedication();
        System.out.println("Please enter the medication's name, brand, and serial number to be removed.");
        String name = userInput.nextLine();
        String brand = userInput.nextLine();
        int serialNum = userInput.nextInt();
        LinkedList<Medication> medicationList = hospital.getMedication();
        for (Medication m: medicationList) {
            Boolean conditionOne = (m.getName().equals(name) && m.getBrand().equals(brand));
            Boolean conditionTwo = (m.getSerialNumber() == serialNum);
            if (conditionOne && conditionTwo) {
                hospital.removeMedication(m);
            }
        }
        System.out.println("The medication is now removed. Please press 'return' to go back to the main menu");
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

    // EFFECTS: prints the names and employee IDs of all physicians as an output
    public void viewPhysicians() {
        System.out.println("All the current physicians and their employee ID include: " + retrievePhysicians());
    }

    // EFFECTS: prints the name, age, PHN and room number of all patients in the database
    //          if the list is empty, returns an empty string
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:SuppressWarnings"})
    public String retrievePatients() {
        String listPatients = "";
        for (Patient p: hospital.getPatients()) {
            listPatients += "{" + p.getName() + "," + p.getAge() + "," + p.getPHN() + "," + p.getStatus() + "," + p.getRoom() + "}" + " ";
        }
        return listPatients;
    }

    // EFFECTS: prints patient information of all patients in the hospital
    private void viewPatients() {
        System.out.println("All the recorded patients and along with their PHN include: " + retrievePatients());
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

    // EFFECTS: prints all nurses information from the database
    private void viewNurses() {
        System.out.println("All the current nurses and their employee ids include: " + retrieveNurses());
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

    // EFFECTS: prints all medication information from the database
    private void viewMedication() {
        System.out.println("All the current medication and their serial number include: " + retrieveMedication());
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

    // EFFECTS: prints patient information of all discharged patients in the hospital
    private void viewDischarged() {
        System.out.println("All the currently discharged patients out the hospital include: " + retrieveDischarged());
    }

}
