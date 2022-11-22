package ui.tabs;

import ui.SmartHospital;
import ui.TextChangesDocumentListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class RemovePatientTab extends Tab {
    private JButton returnButton;
    private JButton saveButton;
    private JButton removeButton;
    private JButton addButton;

    private JTextField reportTextName;
    private JTextField reportTextAge;
    private JTextField reportTextPhn;
    private JTextField reportTextStatus;
    private JTextField reportTextRoom;

    private JScrollPane reportPaneName;
    private JScrollPane reportPaneAge;
    private JScrollPane reportPanePhn;
    private JScrollPane reportPaneStatus;
    private JScrollPane reportPaneRoom;

    private String messageOne = "Here is a list of all patients in the database.";
    private String messageTwo = "Enter the information of the patient. Choose add or remove.";

    private JLabel pageTitle;
    private JLabel patients;
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


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public RemovePatientTab(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(8, 8));
        setUpIntro();
        setPatientNameArea();
        setPatientAgeArea();
        setPatientPhnArea();
        setPatientStatusArea();
        setPatientRoomArea();
        reportTextNameListen();
        reportTextAgeListen();
        reportTextPhnListen();
        reportTextStatListen();
        reportTextRoomListen();
        buttonsMethod();
        revalidate();
    }

    public void setUpIntro() {
        reportBlockTitle = new JPanel(new GridLayout(1, 1));
        reportBlockPatient = new JPanel(new GridLayout(1, 1));
        pageTitle = new JLabel(messageOne + " " + messageTwo);
        patients = new JLabel(getController().retrievePatients());
        reportBlockTitle.add(pageTitle);
        reportBlockTitle.add(patients);
        add(reportBlockTitle);
        add(reportBlockTitle);
    }

    public void setPatientNameArea() {
        reportBlockName = new JPanel(new GridLayout(2, 4));
        reportBlockName.setSize(controller.WIDTH, controller.HEIGHT);
        patientNameArea = new JLabel("Patient Name");
        reportTextName = new JTextField();
        reportTextName.setVisible(true);
        reportBlockName.add(patientNameArea);
        reportBlockName.add(reportTextName);
        add(reportBlockName);
    }

    public void setPatientAgeArea() {
        reportBlockAge = new JPanel(new GridLayout(2, 3));
        reportBlockAge.setSize(controller.WIDTH, controller.HEIGHT);
        patientAgeArea = new JLabel("Patient Age");
        reportTextAge = new JTextField();
        reportTextAge.setVisible(true);
        reportBlockAge.add(patientAgeArea);
        reportBlockAge.add(reportTextAge);
        add(reportBlockAge);
    }

    public void setPatientPhnArea() {
        reportBlockPhn = new JPanel(new GridLayout(2, 2));
        reportBlockPhn.setSize(controller.WIDTH, controller.HEIGHT);
        patientPhnArea = new JLabel("Patient PHN");
        reportTextPhn = new JTextField();
        reportTextPhn.setVisible(true);
        reportBlockPhn.add(patientPhnArea);
        reportBlockPhn.add(reportTextPhn);
        add(reportBlockPhn);
    }

    public void setPatientStatusArea() {
        reportBlockStatus = new JPanel(new GridLayout(2, 1));
        reportBlockStatus.setSize(controller.WIDTH, controller.HEIGHT);
        patientStatusArea = new JLabel("Patient Status");
        reportTextStatus = new JTextField();
        reportTextStatus.setVisible(true);
        reportBlockStatus.add(patientStatusArea);
        reportBlockStatus.add(reportTextStatus);
        add(reportBlockStatus);
    }

    public void setPatientRoomArea() {
        reportBlockRoom = new JPanel(new GridLayout(2, 1));
        reportBlockRoom.setSize(controller.WIDTH, controller.HEIGHT);
        patientRoomArea = new JLabel("Patient Room");
        reportTextRoom = new JTextField();
        reportTextRoom.setVisible(true);
        reportBlockRoom.add(patientRoomArea);
        reportBlockRoom.add(reportTextRoom);
        add(reportBlockRoom);
    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void buttonsMethod() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.saveButton = new JButton("Save");
        this.removeButton = new JButton("Remove");
        this.addButton = new JButton("Add");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(removeButton, BorderLayout.CENTER);
        statusBlock.add(addButton, BorderLayout.CENTER);
        statusBlock.add(saveButton, BorderLayout.WEST);

        this.add(statusBlock);
        returnButtonFunction();
        saveButtonFunction();
        removeButtonFunction();
        addButtonFunction();
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

    public void removeButtonFunction() {
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

    //MODIFIES: this
    //EFFECTS: add a patients from the patient database when user inputs patient info and clicks add button
    public void addButtonFunction() {
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

    //MODIFIES: this
    //EFFECTS: removes a patients from the patient database when user inputs patient info and clicks remove button
    public void reportTextNameListen() {
        reportTextRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                reportTextRoom.getText();
            }
        });
    }

    public void reportTextAgeListen() {
        reportTextAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                parseInt(reportTextAge.getText());
            }
        });
    }

    public void reportTextPhnListen() {
        reportTextPhn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                parseInt(reportTextPhn.getText());
            }
        });
    }

    public void reportTextStatListen() {
        reportTextStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                parseBoolean(reportTextStatus.getText());
            }
        });
    }

    public void reportTextRoomListen() {
        reportTextRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                parseInt(reportTextRoom.getText());
            }
        });
    }
}

