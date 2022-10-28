package model;

// Represents a medication with it's name, serial number and its brand
public class Medication {
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
