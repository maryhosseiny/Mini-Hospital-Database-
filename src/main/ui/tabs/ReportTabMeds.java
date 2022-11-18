package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;

public class ReportTabMeds extends Tab {

    JButton viewMedicationButton;
    JButton addMedicationButton;
    JButton removeMedicationButton;
    JButton returnButton;
    JButton quitButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public ReportTabMeds(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        this.viewMedicationButton = new JButton("View Medication");
        this.addMedicationButton = new JButton("Add Medication");
        this.removeMedicationButton = new JButton("Remove Medication");

        viewMedicationButton.setSize(WIDTH, HEIGHT / 2);
        addMedicationButton.setSize(WIDTH, HEIGHT / 2);
        removeMedicationButton.setSize(WIDTH, HEIGHT / 2);

        this.add(viewMedicationButton);
        this.add(addMedicationButton);
        this.add(removeMedicationButton);

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
