package model;

public class Patient {

    private String name;
    private int age;
    private int personalHealthNumber;
    private boolean dischargeStatus;
    private int roomNum;

    public Patient(String name, int age, int personalHealthNumber, int roomNum) {
        this.name = name;
        this.age = age;
        this.personalHealthNumber = personalHealthNumber;
        dischargeStatus = false;
        this.roomNum = roomNum;

    }

    public void patientDischarged() {
        this.dischargeStatus = true;
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

    public boolean getDischargeStatus() {
        return dischargeStatus;
    }

    public int getRoom() {
        return roomNum;
    }
}
