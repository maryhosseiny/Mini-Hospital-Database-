package persistence;

import model.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads the hospital database from JSON data stored in file
// The Majority of the code below is taken and modified JsonSerializationDemo file provided during class
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads a hospital database from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public Hospital read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseHospital(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // MODIFIES: hospital
    // EFFECTS: parses hospital from JSON object and returns it
    private Hospital parseHospital(JSONObject jsonObject) {
        Hospital hospital = new Hospital();
        addPhysicians(hospital, jsonObject);
        addNurses(hospital, jsonObject);
        addPatients(hospital, jsonObject);
        addMedication(hospital, jsonObject);
        return hospital;
    }

    // MODIFIES: hospital
    // EFFECTS: parses physicians from JSON object and adds them to hospital
    private void addPhysicians(Hospital hospital, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("physicians");
        for (Object json : jsonArray) {
            JSONObject nextPhysician = (JSONObject) json;
            addPhysicianProperty(hospital, nextPhysician);
        }
    }

    // MODIFIES: hospital
    // EFFECTS: parses nurses from JSON object and adds them to hospital
    private void addNurses(Hospital hospital, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("nurses");
        for (Object json : jsonArray) {
            JSONObject nextNurse = (JSONObject) json;
            addNurseProperty(hospital, nextNurse);
        }
    }

    // MODIFIES: hospital
    // EFFECTS: parses patients from JSON object and adds them to hospital
    private void addPatients(Hospital hospital, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("patients");
        for (Object json : jsonArray) {
            JSONObject nextPatient = (JSONObject) json;
            addPatientProperty(hospital, nextPatient);
        }
    }

    // MODIFIES: hospital
    // EFFECTS: parses medication from JSON object and adds them to hospital
    private void addMedication(Hospital hospital, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("medication");
        for (Object json : jsonArray) {
            JSONObject nextMedication = (JSONObject) json;
            addMedicationProperty(hospital, nextMedication);
        }
    }


    // MODIFIES: hospital
    // EFFECTS: parses physician properties from JSON object and adds them to hospital
    private void addPhysicianProperty(Hospital hospital, JSONObject jsonObject) {
        int employeeID = jsonObject.getInt("employeeID");
        String employeeName = jsonObject.getString("employeeName");

        Physician physician = new Physician(employeeID, employeeName);
        hospital.addPhysician(physician);
    }

    // MODIFIES: hospital
    // EFFECTS: parses nurse properties from JSON object and adds them to hospital
    private void addNurseProperty(Hospital hospital, JSONObject jsonObject) {
        int employeeID = jsonObject.getInt("employeeID");
        String employeeName = jsonObject.getString("employeeName");

        Nurse nurse = new Nurse(employeeID, employeeName);
        hospital.addNurse(nurse);
    }

    // MODIFIES: hospital
    // EFFECTS: parses patient properties from JSON object and adds them to hospital
    private void addPatientProperty(Hospital hospital, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        int personalHealthNumber = jsonObject.getInt("personalHealthNumber");
        Boolean dischargeStatus = jsonObject.getBoolean("dischargeStatus");
        int roomNum = jsonObject.getInt("roomNum");

        Patient patient = new Patient(name, age, personalHealthNumber, dischargeStatus, roomNum);
        hospital.addPatient(patient);
    }

    // MODIFIES: hospital
    // EFFECTS: parses medication properties from JSON object and adds them to hospital
    private void addMedicationProperty(Hospital hospital, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int serialNum = jsonObject.getInt("serialNum");
        String brand = jsonObject.getString("brand");

        Medication meds = new Medication(name, serialNum, brand);
        hospital.addMedication(meds);
    }
}