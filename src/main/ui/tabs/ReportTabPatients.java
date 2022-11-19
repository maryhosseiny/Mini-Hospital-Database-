package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportTabPatients extends Tab {
    JButton viewPatientButton;
    JButton addPatientButton;
    JButton removePatientButton;
    JButton viewDischargedPatientButton;
    JButton returnButton;
    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    //EFFECTS: constructs a patient tab with buttons to add/remove a patient and to view all/discharged patients
    //         along with a text area to view the list of patients
    public ReportTabPatients(SmartHospital controller) {
        super(controller);
        buttonSetUp();
        setLayout(new GridLayout(0, 1));
        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(controller.WIDTH - (controller.WIDTH / 5),
                controller.HEIGHT - (controller.HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);

        patientActionButton();
        patientAddActionButton();
        patientRemoveActionButton();
        patientDisActionButton();
        returnButton();
        revalidate();

    }

    //EFFECTS: constructs view patients and discharge patients button and add/remove button
    public void buttonSetUp() {
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
    }

    //EFFECTS: constructs a return button and places it in the frame
    public void returnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        statusBlock.add(returnButton, BorderLayout.EAST);

        this.add(statusBlock);
        returnActionButton();
    }

    //EFFECTS: constructs a return button that switches to the settings tab on the console
    private void returnActionButton() {

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

    //EFFECTS: displays a list of discharged patients in the database the view discharged patients button is pressed
    public void patientActionButton() {
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

    //EFFECTS: switches to remove patient tab when add remove patient button is clicked
    public void patientRemoveActionButton() {
        removePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Remove Patient")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_PATS_REMOVE);
                }
            }
        });
    }

    //EFFECTS: switches to the remove patient tab when add patient button is clicked
    public void patientAddActionButton() {
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add Patient")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_PATS_REMOVE);
                }
            }
        });
    }

    //EFFECTS: displays a list of discharged patients in the database the view discharged patients button is pressed
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
