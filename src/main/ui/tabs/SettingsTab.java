package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsTab extends Tab {
    JButton viewPatientsButton;
    JButton viewMedicationButton;
    JButton viewStaffButton;
    JButton quitButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public SettingsTab(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        this.viewPatientsButton = new JButton("Patient Database");
        this.viewMedicationButton = new JButton("Medication Database");
        this.viewStaffButton = new JButton("Staff Database");

        viewPatientsButton.setSize(WIDTH, HEIGHT / 2);
        viewMedicationButton.setSize(WIDTH, HEIGHT / 2);
        viewStaffButton.setSize(WIDTH, HEIGHT / 2);

        this.add(viewPatientsButton);
        this.add(viewMedicationButton);
        this.add(viewStaffButton);


        patientDataBaseButton();
        medicationDataBaseButton();
        staffDataBaseButton();
        quitAndReturnButton();
    }

    //EFFECTS: constructs a status button that switches to the settings tab on the console
    private void patientDataBaseButton() {

        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Patient Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_PATS);
                }
            }
        });

        this.add(viewPatientsButton);
    }

    //EFFECTS: constructs a status button that switches to the settings tab on the console
    private void medicationDataBaseButton() {

        viewMedicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Medication Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_MEDS);
                }
            }
        });

        this.add(viewMedicationButton);
    }

    //EFFECTS: switches to the staff database tab on the console when the staff database button is clicked
    private void staffDataBaseButton() {

        viewStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Staff Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_STAFF);
                }
            }
        });

        this.add(viewStaffButton);
    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void quitAndReturnButton() {
        JPanel statusBlock = new JPanel();

        this.quitButton = new JButton("Quit");
        statusBlock.add(quitButton, BorderLayout.WEST);

        this.add(statusBlock);
        //TODO: add functionality for quit
    }
}
