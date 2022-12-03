package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a settings tab with three buttons for the user to press to take them to the medication, staff
//           or patients part of the database as well as buttons to quit the program and load the previous
//           database
public class SettingsTab extends Tab {
    private JButton viewPatientsButton;
    private JButton viewMedicationButton;
    private JButton viewStaffButton;
    private JButton loadButton;
    private JPanel statusBlock;


    //MODIFIES: this
    //EFFECTS: constructs a setting tab for console with 3 menu buttons and 2 buttons for loading or quit the program
    public SettingsTab(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(7, 7));
        setButtons();
        setLoadButton();
    }

    //MODIFIES: this, viewStaffButton, viewPatientsButton, viewMedicationButton
    //EFFECTS: constructs the patient, medication and staff database buttons and adds functionality to them
    public void setButtons() {
        viewPatientsButton = new JButton("Patient Database");
        viewMedicationButton = new JButton("Medication Database");
        viewStaffButton = new JButton("Staff Database");
        viewStaffButton.setSize(WIDTH, HEIGHT / 4);
        viewPatientsButton.setSize(WIDTH, HEIGHT / 4);
        viewMedicationButton.setSize(WIDTH, HEIGHT / 4);
        add(viewStaffButton);
        add(viewPatientsButton);
        add(viewMedicationButton);
        setStaffButton();
        setPatientButton();
        setMedicationButton();
    }

    //MODIFIES: viewPatientsButton
    //EFFECTS: switches to patients database tab when patient button is pressed
    private void setPatientButton() {
        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Patient Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.patientTabIndex);
                }
            }
        });
    }

    //MODIFIES: viewMedicationButton
    //EFFECTS: switches to medication database tab when medication button is pressed
    private void setMedicationButton() {
        viewMedicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Medication Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.medicationTabIndex);
                }
            }
        });
    }

    //MODIFIES: viewStaffButton
    //EFFECTS: switches to the staff database tab when the staff database button is clicked
    private void setStaffButton() {
        viewStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Staff Database")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.staffTabIndex);
                }
            }
        });
    }

    //MODIFIES: this, statusBlock
    //EFFECTS: constructs a quit and load buttons and adds functionality to them
    private void setLoadButton() {
        statusBlock = new JPanel();
        loadButton = new JButton("Load");
        statusBlock.add(loadButton, BorderLayout.EAST);
        this.add(statusBlock);
        setLoadFunction();
    }

    //MODIFIES: loadButton
    //EFFECTS: when load button is pressed, loads the previous file onto the database
    private void setLoadFunction() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Load")) {
                    getController().loadHospital();
                }
            }
        });
    }
}
