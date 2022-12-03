package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

// Represents the patients modifier tab that includes buttons to add/remove patients from the
//           database as well as saving the new changes and returning to the setting menu
public class PatientModifierTab extends Tab {
    private JButton returnButton;
    private JButton saveButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton viewPatientButton;

    private JTextField reportTextName;
    private JTextField reportTextAge;
    private JTextField reportTextPhn;
    private JTextField reportTextStatus;
    private JTextField reportTextRoom;

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    private String messageOne = "Click view patients to see all the patients in the database.";
    private String messageTwo = "Enter the information of the patient then choose add or remove.";
    private String messageThree = "Don't forget to save the changes you make to the database.";

    private JLabel pageTitle;
    private JLabel patientNameArea;
    private JLabel patientAgeArea;
    private JLabel patientPhnArea;
    private JLabel patientStatusArea;
    private JLabel patientRoomArea;

    private JPanel reportBlockTitle;
    private JPanel reportBlockPatient;
    private JPanel reportBlockName;
    private JPanel reportBlockAge;
    private JPanel reportBlockPhn;
    private JPanel reportBlockStatus;
    private JPanel reportBlockRoom;

    //EFFECTS: constructs a patient modifier tab with buttons to add/remove a patient and to view the updated
    //         database with a text areas input info change the patient database
    public PatientModifierTab(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(11, 1));
        setUpIntro();
        setPatientNameArea();
        setPatientAgeArea();
        setPatientPhnArea();
        setPatientStatusArea();
        setPatientRoomArea();
        setButtons();
        revalidate();
    }

    //MODIFIES: this (change the appearance of the tab/controller hence this), reportBlockTitle
    //EFFECTS: sets up the into at the top of the page for user direction
    public void setUpIntro() {
        reportBlockTitle = new JPanel(new GridLayout(1, 1));
        reportBlockPatient = new JPanel(new GridLayout(1, 1));
        pageTitle = new JLabel(messageOne + " " + messageTwo + " " + messageThree);
        reportBlockTitle.add(pageTitle);
        add(reportBlockTitle);
    }

    //MODIFIES: this, reportBlockName, reportTextName
    //EFFECTS: sets up a text area along with a text label for patient name for user input
    public void setPatientNameArea() {
        reportBlockName = new JPanel(new GridLayout(3, 1));
        reportBlockName.setSize(WIDTH, HEIGHT);
        patientNameArea = new JLabel("Patient Name");
        reportTextName = new JTextField();
        reportTextName.setVisible(true);
        reportBlockName.add(patientNameArea);
        reportBlockName.add(reportTextName);
        add(reportBlockName);
    }

    //MODIFIES: this, reportBlockAge, reportTextAge
    //EFFECTS: sets up a text area along with a text label for patient age for user input
    public void setPatientAgeArea() {
        reportBlockAge = new JPanel(new GridLayout(3, 1));
        reportBlockAge.setSize(WIDTH, HEIGHT);
        patientAgeArea = new JLabel("Patient Age (Integers only)");
        reportTextAge = new JTextField();
        reportTextAge.setVisible(true);
        reportBlockAge.add(patientAgeArea);
        reportBlockAge.add(reportTextAge);
        add(reportBlockAge);
    }

    //MODIFIES: this, reportBlockPhn, reportTextPhn
    //EFFECTS: sets up a text area along with a text label for patient phn for user input
    public void setPatientPhnArea() {
        reportBlockPhn = new JPanel(new GridLayout(3, 1));
        reportBlockPhn.setSize(WIDTH, HEIGHT);
        patientPhnArea = new JLabel("Patient PHN (Integers only)");
        reportTextPhn = new JTextField();
        reportTextPhn.setVisible(true);
        reportBlockPhn.add(patientPhnArea);
        reportBlockPhn.add(reportTextPhn);
        add(reportBlockPhn);
    }

    //MODIFIES: this, reportBlockStatus, reportTextStatus
    //EFFECTS: sets up a text area along with a text label for patient status for user input
    public void setPatientStatusArea() {
        reportBlockStatus = new JPanel(new GridLayout(3, 1));
        reportBlockStatus.setSize(WIDTH, HEIGHT);
        patientStatusArea = new JLabel("Patient Status");
        reportTextStatus = new JTextField();
        reportTextStatus.setVisible(true);
        reportBlockStatus.add(patientStatusArea);
        reportBlockStatus.add(reportTextStatus);
        add(reportBlockStatus);
    }

    //MODIFIES: this, reportBlockRoom,reportTextRoom
    //EFFECTS: sets up a text area along with a text label for patient room number for user input
    public void setPatientRoomArea() {
        reportBlockRoom = new JPanel(new GridLayout(3, 1));
        reportBlockRoom.setSize(WIDTH, HEIGHT);
        patientRoomArea = new JLabel("Patient Room (Integers only)");
        reportTextRoom = new JTextField();
        reportTextRoom.setVisible(true);
        reportBlockRoom.add(patientRoomArea);
        reportBlockRoom.add(reportTextRoom);
        add(reportBlockRoom);
    }

    //MODIFIES: this, reportText, reportBlock
    //EFFECTS: create a panel to view the updated database and adds functionality to it
    public void setUpViewArea() {
        JPanel reportBlock = new JPanel(new GridLayout(3, 1));
        reportBlock.setSize(WIDTH,HEIGHT);
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(3, 1));
        reportText = new JTextArea("", 3, 1);
        reportText.setVisible(true);
        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);
        setViewFunction();
    }

    //MODIFIES: this, statusBlock, returnButton, saveButton, removeButton, addButton, viewPatientButton
    //EFFECTS: constructs a status panel with five buttons(return, add, remove, save, view) then adds
    //         functionality to them
    public void setButtons() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.saveButton = new JButton("Save");
        this.removeButton = new JButton("Remove");
        this.addButton = new JButton("Add");
        this.viewPatientButton = new JButton("View Patients");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(removeButton, BorderLayout.CENTER);
        statusBlock.add(addButton, BorderLayout.CENTER);
        statusBlock.add(saveButton, BorderLayout.WEST);
        addButton.setForeground(Color.GREEN);
        addButton.setBackground(Color.GRAY);
        removeButton.setForeground(Color.RED);
        removeButton.setBackground(Color.PINK);
        this.add(statusBlock);
        add(viewPatientButton);
        setReturnFunction();
        setSaveFunction();
        setRemoveFunction();
        setAddFunction();
        setUpViewArea();
    }

    //MODIFIES: this (change in the tab), returnButton
    //EFFECTS: constructs a return button that switches to the settings tab
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

    //MODIFIES: SmartHospital (change in the database), saveButton
    //EFFECTS: saves the new hospital status to include the new changes
    public void setSaveFunction() {
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

    //MODIFIES: this (change in the tab), SmartHospital (change in the database), removeButton
    //EFFECTS: removes a patient from the patient database when user inputs info and clicks remove button
    public void setRemoveFunction() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Remove")) {
                    String name = reportTextName.getText();
                    int age = parseInt(reportTextAge.getText());
                    int phn = parseInt(reportTextPhn.getText());
                    Boolean status = parseBoolean(reportTextStatus.getText());
                    int room = parseInt(reportTextRoom.getText());
                    getController().removePatient(name, age, phn, status, room);
                }
            }
        });
    }

    //MODIFIES: this (change in the tab), SmartHospital (change in the database), addButton
    //EFFECTS: adds a patients to the patient database when user inputs patient info and clicks add button
    public void setAddFunction() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add")) {
                    String name = reportTextName.getText();
                    int age = parseInt(reportTextAge.getText());
                    int phn = parseInt(reportTextPhn.getText());
                    Boolean status = parseBoolean(reportTextStatus.getText());
                    int room = parseInt(reportTextRoom.getText());
                    getController().addPatient(name, age, phn, status, room);
                }
            }
        });
    }

    //MODIFIES: this (change in the tab), viewPatientButton, reportPane, reportText
    //EFFECTS: when view patients button is pressed, displays a list of current medication in the database
    public void setViewFunction() {
        viewPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("View Patients")) {
                    String message = "View of all current patients in the system:";
                    reportMessage.setText(message);
                    String patients = getController().retrievePatients();
                    reportText.setText(patients);
                    reportPane.setViewportView(reportText);
                }
            }
        });
    }
}

