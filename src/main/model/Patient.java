package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a patient with its name, age, personal health number, whether he/she
//            has be discharged from the hospital and the patient's room number
public class Patient implements Writable {

    private String name;
    private int age;
    private int personalHealthNumber;
    private boolean dischargeStatus;
    private int roomNum;

    // REQUIRES: personalHealthNumber must be 6 digits long, name cannot be an empty string
    // EFFECTS: creates a patient with its name set to name, age set to age, its personal
    //          health number set to personalHealthNumber, discharge status being false,
    //          and the patient room number set to roomNum
    public Patient(String name, int age, int personalHealthNumber, boolean dischargeStatus, int roomNum) {
        this.name = name;
        this.age = age;
        this.personalHealthNumber = personalHealthNumber;
        this.dischargeStatus = dischargeStatus;
        this.roomNum = roomNum;
    }

    // MODIFIES: this
    // EFFECTS: updates a patient's discharged status to discharged(true)
    public void patientDischarged() {
        this.dischargeStatus = true;
    }

    // EFFECTS: creates a json object from patient data
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("personalHealthNumber", personalHealthNumber);
        json.put("dischargeStatus", dischargeStatus);
        json.put("roomNum", roomNum);
        return json;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPHN() {
        return personalHealthNumber;
    }

    public boolean getStatus() {
        return dischargeStatus;
    }

    public int getRoom() {
        return roomNum;
    }
}
