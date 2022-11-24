package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportTabPatients extends Tab {
    private JButton viewPatientButton;
    private JButton addPatientButton;
    private JButton removePatientButton;
    private JButton viewDischargedPatientButton;
    private JButton returnButton;
    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    //EFFECTS: constructs a patient tab with buttons to add/remove a patient and to view all/discharged patients
    //         along with a text area to view the list of patients
    public ReportTabPatients(SmartHospital controller) {
        super(controller);
        setButtons();
        setLayout(new GridLayout(7, 1));
        JPanel reportBlock = new JPanel(new GridLayout(0, 1));
        reportBlock.setSize(WIDTH - (WIDTH / 5),HEIGHT - (HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);

        setReturnButton();
    }

    //EFFECTS: constructs view patients and discharge patients button and add/remove button then adds functionality
    //         for them
    public void setButtons() {
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

        setViewPatFunction();
        patientAddActionButton();
        patientRemoveActionButton();
        patientDisActionButton();
    }

    //EFFECTS: constructs a return button and places it in the frame then adds functionality to it
    public void setReturnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        statusBlock.add(returnButton, BorderLayout.EAST);

        this.add(statusBlock);
        setReturnFunction();
    }

    //EFFECTS: when return button is pressed, switches the frame to the settings tab
    private void setReturnFunction() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Return")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.settingsTabIndex);
                }
            }
        });
    }

    //EFFECTS: when view patients button is pressed, a list of patients in the database
    public void setViewPatFunction() {
        viewPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("View Patients")) {
                    String message = "View of all current patients in the system:";
                    reportMessage.setText(message);
                    String physicians = getController().retrievePatients();
                    reportText.setText(physicians);
                    reportPane.setViewportView(reportText);
                }

            }
        });
    }

    //EFFECTS: when remove patient button is clicked, switches to patient modifier tab
    public void patientRemoveActionButton() {
        removePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Remove Patient")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.patientModifierTabIndex);
                }
            }
        });
    }

    //EFFECTS: when add patient button is clicked, switches to patient modifier tab
    public void patientAddActionButton() {
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add Patient")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.patientModifierTabIndex);
                }
            }
        });
    }

    //EFFECTS: when view discharged patients button is pressed, displays a list of discharged patients in the database
    public void patientDisActionButton() {
        viewDischargedPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("View Discharged Patients")) {
                    String message = "View of all discharged patients in the system:";
                    reportMessage.setText(message);
                    String physicians = getController().retrieveDischarged();
                    reportText.setText(physicians);
                    reportPane.setViewportView(reportText);
                }
            }
        });
    }
}
