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
    JButton loadButton;


    //EFFECTS: constructs a setting tab for console with 3 menu buttons and 2 buttons for loading or quit the program
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
        revalidate();
    }

    //EFFECTS: switches to patients database when patient button is pressed
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

    //EFFECTS: switches to medication database when medication button is pressed
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

    //EFFECTS: switches to the staff database tab when the staff database button is clicked
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

    //EFFECTS: constructs a quit and load buttons
    public void quitAndReturnButton() {
        JPanel statusBlock = new JPanel();
        this.loadButton = new JButton("Load");
        this.quitButton = new JButton("Quit");
        statusBlock.add(quitButton, BorderLayout.WEST);
        statusBlock.add(loadButton, BorderLayout.EAST);
        this.add(statusBlock);
        setLoadButton();
        setQuitButton();
    }

    //EFFECTS: loads the previous file onto the database
    private void setLoadButton() {

        viewStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Load")) {
                    getController().loadHospital();
                }
            }
        });

        this.add(viewStaffButton);
    }

    //EFFECTS: when quit button is pressed, it will save the file and quit the program
    private void setQuitButton() {

        viewStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Quit")) {
                    getController().saveHospital();
                    System.exit(0);
                }
            }
        });

        this.add(viewStaffButton);
    }
}
