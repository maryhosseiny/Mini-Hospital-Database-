package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Represents a hospital database application
public class HospitalApp {
    private static final String JSON_STORE = "./data/hospital.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Hospital hospital;
    private Scanner input;
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
    private static int max = 100;
    private static int min = 4;


    // EFFECTS: runs the hospital application
    public HospitalApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        hospital = new Hospital();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runHospital();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    // taken and modified from the TellerApp code provided in class
    private void runHospital() {
        boolean keepGoing = true;
        String command = null;

        init();
        displayMenu();
        while (keepGoing) {

            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nThank you for visiting the hospital data base!");
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    // taken and modified from the TellerApp code provided in class
    private void init() {
        hospital = new Hospital();
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
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    // taken and modified from the TellerApp code provided in class
    private void processCommand(String command) {
        if (command.equals("staff")) {
            displayMenuStaff();
        } else if (command.equals("patient")) {
            displayMenuPatient();
        } else if (command.equals("physicians")) {
            viewPhysicians();
        } else if (command.equals("nurses")) {
            viewNurses();
        } else if (command.equals("medication")) {
            displayMenuMedication();
        } else if (command.equals("medications")) {
            viewMedication();
        } else if (command.equals("add med")) {
            addMedication();
        } else if (command.equals("remove med")) {
            removeMedication();
        } else if (command.equals("patients")) {
            viewPatients();
        } else if (command.equals("discharged")) {
            viewDischarged();
        } else if (command.equals("add")) {
            addPatient();
        } else if (command.equals("remove")) {
            removePatient();
        } else if (command.equals("save")) {
            saveHospital();
        } else if (command.equals("load")) {
            loadHospital();
        } else if (command.equals("return")) {
            displayMenu();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: saves the database to file
    private void saveHospital() {
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
    private void loadHospital() {
        try {
            hospital = jsonReader.read();
            System.out.println("Loaded the previous hospital database from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to the Student Hospital Database.");
        System.out.println("You can select the following options to explore the database further.");
        System.out.println("Remember to enter 'return' if you would like to return to the main menu!");
        System.out.println("Remember to enter 'save' if you would like to save your work!");
        System.out.println("\nSelect from:");
        System.out.println("\tstaff -> staff database");
        System.out.println("\tpatient -> patient database");
        System.out.println("\tmedication -> medication database");
        System.out.println("\tsave -> save changes in the hospital database to file");
        System.out.println("\tload -> load previous hospital database from file");
        System.out.println("\tquit -> to quit");

    }

    // EFFECTS: displays staff menu of options to user
    private void displayMenuStaff() {
        System.out.println("\nSelect from:");
        System.out.println("\tphysicians -> view physicians");
        System.out.println("\tnurses -> view nurses");
        System.out.println("\treturn -> to return back to original menu");
        System.out.println("\tquit -> to quit the program");
    }

    // EFFECTS: displays medication menu of options to user
    private void displayMenuMedication() {
        System.out.println("\nSelect from:");
        System.out.println("\tmedications -> view medications");
        System.out.println("\tadd med -> to add a new medication to the data base");
        System.out.println("\tremove med -> to remove a medication from the database");
        System.out.println("\treturn -> to return back to original menu");
        System.out.println("\tquit -> to quit the program");
    }

    // EFFECTS: displays patient menu of options to user
    private void displayMenuPatient() {
        System.out.println("\nSelect from:");
        System.out.println("\tpatients -> view all patients");
        System.out.println("\tdischarged -> view discharged patients");
        System.out.println("\tadd -> to add a new patient to the database");
        System.out.println("\tremove -> to remove a patient from the database");
        System.out.println("\treturn -> to return back to original menu");
        System.out.println("\tquit -> to quit the program");
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
        String name = userInput.nextLine();
        int age = userInput.nextInt();
        int phn = userInput.nextInt();
        int roomNum = userInput.nextInt();
        Boolean dischargeStatus = userInput.nextBoolean();
        Patient newPatient = new Patient(name, age, phn, dischargeStatus, roomNum);
        hospital.removePatient(newPatient);
        System.out.println("The patient is now added to our system. Please press 'return' to go back to the main menu");
    }

    // REQUIRES: the inputted medication must not be in the hospital database
    // MODIFIES: this
    // EFFECTS: adds a medication to the hospital medication database
    public void addMedication() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the medication's name, serial number, and brand.");
        String name = userInput.nextLine();
        int serialNum = userInput.nextInt();
        String brand = userInput.nextLine();
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
        System.out.println("Please enter the medication's name, serial number, and brand to be removed.");
        String name = userInput.nextLine();
        int serialNum = userInput.nextInt();
        String brand = userInput.nextLine();
        Medication newMed = new Medication(name, serialNum, brand);
        hospital.removeMedication(newMed);
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
    private void viewPhysicians() {
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
