package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a medication with its name, serial number and its brand
public class Medication implements Writable {
    private String name;
    private int serialNumber;
    private String brand;

    // REQUIRES: the serial number has to be 6 digits long
    // EFFECTS: creates a medication object with its name set to name
    //          and its serial number set to serialNumber as well as its
    //          brand set to brand
    public Medication(String name, int serialNumber, String brand) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.brand = brand;
    }

    // EFFECTS: creates a json object from medication data
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("serialNum", serialNumber);
        json.put("brand", brand);
        return json;
    }

    //getters
    public int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
