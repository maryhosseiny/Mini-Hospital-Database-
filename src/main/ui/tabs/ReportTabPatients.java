package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;

public class ReportTabPatients extends Tab {
    JButton viewPatientButton;
    JButton addPatientButton;
    JButton removePatientButton;
    JButton viewDischargedPatientButton;
    JButton returnButton;
    JButton quitButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public ReportTabPatients(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        this.viewPatientButton = new JButton("View Patients");
        this.addPatientButton = new JButton("Add Patient");
        this.removePatientButton = new JButton("Remove Patient");
        this.viewDischargedPatientButton = new JButton("View Discharged Patients");

        viewPatientButton.setSize(WIDTH, HEIGHT / 2);
        addPatientButton.setSize(WIDTH, HEIGHT / 2);
        removePatientButton.setSize(WIDTH, HEIGHT / 2);
        viewDischargedPatientButton.setSize(WIDTH, HEIGHT / 2);


        this.add(viewPatientButton);
        this.add(addPatientButton);
        this.add(removePatientButton);
        this.add(viewDischargedPatientButton);


        quitAndReturnButton();
    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void quitAndReturnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.quitButton = new JButton("Quit");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(quitButton, BorderLayout.WEST);

        this.add(statusBlock);
        //TODO: add functionality for quit and return
    }
}
