package model;

public class Medication {
    private String name;
    private int serialNumber;
    private String brand;

    public Medication(String name, int serialNumber, String brand) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.brand = brand;
    }

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
