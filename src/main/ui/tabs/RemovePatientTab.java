package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemovePatientTab extends Tab {
    private JButton returnButton;
    private JButton saveButton;
    private JButton submitButton;

    private JScrollPane reportPaneName;
    private JTextArea reportTextName;
    private JScrollPane reportPaneAge;
    private JTextArea reportTextAge;
    private JScrollPane reportPanePhn;
    private JTextArea reportTextPhn;
    private JScrollPane reportPaneStatus;
    private JTextArea reportTextStatus;
    private JScrollPane reportPaneRoom;
    private JTextArea reportTextRoom;

    private JLabel pageTitle;
    private JLabel patients;
    private JLabel patientNameArea;
    private JLabel patientAgeArea;
    private JLabel patientPHNArea;
    private JLabel patientStatusArea;
    private JLabel patientRoomArea;


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public RemovePatientTab(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(8, 5));
        JPanel p = new JPanel();
        JPanel reportBlockTitle = new JPanel(new GridLayout(1, 1));
        JPanel reportBlockPatient = new JPanel(new GridLayout(1, 1));
        JPanel reportBlockName = new JPanel(new GridLayout(2, 1));
        JPanel reportBlockAge = new JPanel(new GridLayout(2, 1));
        JPanel reportBlockPhn = new JPanel(new GridLayout(2, 1));
        JPanel reportBlockStatus = new JPanel(new GridLayout(2, 1));
        JPanel reportBlockRoom = new JPanel(new GridLayout(2, 1));

        reportBlockName.setSize(controller.WIDTH,
                controller.HEIGHT);
        reportBlockAge.setSize(controller.WIDTH,
                controller.HEIGHT);
        reportBlockPhn.setSize(controller.WIDTH,
                controller.HEIGHT);
        reportBlockStatus.setSize(controller.WIDTH,
                controller.HEIGHT);
        reportBlockRoom.setSize(controller.WIDTH,
                controller.HEIGHT);
        pageTitle = new JLabel("Here is a list of all patients in the database. Enter the information of the you would like removed.");
        patients = new JLabel(getController().retrievePatients());

        patientNameArea = new JLabel("Patient Name");
        patientAgeArea = new JLabel("Patient Age");
        patientPHNArea = new JLabel("Patient PHN");
        patientStatusArea = new JLabel("Patient Status");
        patientRoomArea = new JLabel("Patient Room");

        reportPaneName = new JScrollPane(new JTextArea(6, 20));
        reportTextName = new JTextArea("", 6, 20);
        reportTextName.setVisible(true);

        reportPaneAge = new JScrollPane(new JTextArea(6, 20));
        reportTextAge = new JTextArea("", 6, 20);
        reportTextAge.setVisible(true);

        reportPanePhn = new JScrollPane(new JTextArea(6, 20));
        reportTextPhn = new JTextArea("", 6, 20);
        reportTextPhn.setVisible(true);

        reportPaneStatus = new JScrollPane(new JTextArea(6, 20));
        reportTextStatus = new JTextArea("", 6, 20);
        reportTextStatus.setVisible(true);

        reportPaneRoom = new JScrollPane(new JTextArea(6, 20));
        reportTextRoom = new JTextArea("", 6, 20);
        reportTextRoom.setVisible(true);

        reportBlockName.add(patientNameArea);
        reportBlockAge.add(patientAgeArea);
        reportBlockPhn.add(patientPHNArea);
        reportBlockStatus.add(patientStatusArea);
        reportBlockRoom.add(patientRoomArea);

        reportBlockName.add(reportPaneName);
        reportBlockAge.add(reportPaneAge);
        reportBlockPhn.add(reportPanePhn);
        reportBlockStatus.add(reportPaneStatus);
        reportBlockRoom.add(reportPaneRoom);

        reportBlockTitle.add(pageTitle);
        reportBlockTitle.add(patients);
        add(reportBlockTitle);
        add(reportBlockTitle);
        add(reportBlockName);
        add(reportBlockAge);
        add(reportBlockPhn);
        add(reportBlockStatus);
        add(reportBlockRoom);


//        // Adding buttons and textfield to panel
//        // using add() method
//        p.add(b);
//        p.add(b1);
//        p.add(b2);
//        p.add(l);

        buttonsMethod();

    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void buttonsMethod() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.saveButton = new JButton("Save");
        this.submitButton = new JButton("Submit");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(submitButton, BorderLayout.CENTER);
        statusBlock.add(saveButton, BorderLayout.WEST);

        this.add(statusBlock);
        returnButtonFunction();
        saveButtonFunction();
        submitButtonFunction();
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

    public void submitButtonFunction() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Submit")) {
                    getController().saveHospital();
                }
            }
        });
    }
}
