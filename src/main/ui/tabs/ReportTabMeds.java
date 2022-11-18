package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportTabMeds extends Tab {

    JButton viewMedicationButton;
    JButton addMedicationButton;
    JButton removeMedicationButton;
    JButton returnButton;
    JButton saveButton;

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
        this.saveButton = new JButton("Save");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(saveButton, BorderLayout.WEST);

        this.add(statusBlock);
        returnButtonFunction();
        saveButtonFunction();

    }

    //EFFECTS: creates greeting at top of console
    public void saveButtonFunction() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Save")) {
                    getController().saveHospital();
                }

            }
        });
    }

    //EFFECTS: constructs a return button that switches to the settings tab on the console
    private void returnButtonFunction() {

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Return")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.SETTINGS_TAB_INDEX);
                }
            }
        });
    }
}
