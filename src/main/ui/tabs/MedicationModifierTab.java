package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class MedicationModifierTab extends Tab {
    private JButton returnButton;
    private JButton saveButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton viewMedsButton;

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    private JTextField reportTextName;
    private JTextField reportTextSerialNum;
    private JTextField reportTextBrand;

    private String messageOne = "Click view medication to see all the medication in the database.";
    private String messageTwo = "Enter the information of the medication then choose add or remove.";

    private JLabel pageTitle;
    private JLabel medicationName;
    private JLabel medicationSerialNum;
    private JLabel medicationBrandArea;

    private JPanel reportBlockTitle;
    private JPanel reportBlockPatient;
    private JPanel reportBlockName;
    private JPanel reportBlockSerialNum;
    private JPanel reportBlockBrand;

    //EFFECTS: constructs a medication modifier tab with buttons to add/remove a medication and to view the updated
    //         database with a text areas input info change the medication database
    public MedicationModifierTab(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(8, 8));
        setIntro();
        setMedNameArea();
        setSerialNumArea();
        setMedBrandArea();
        setButtons();
        revalidate();
    }

    //MODIFIES: this
    //EFFECTS: sets up the into at the top of the page for user direction
    public void setIntro() {
        reportBlockTitle = new JPanel(new GridLayout(1, 1));
        reportBlockPatient = new JPanel(new GridLayout(1, 1));
        pageTitle = new JLabel(messageOne + " " + messageTwo);
        reportBlockTitle.add(pageTitle);
        add(reportBlockTitle);
    }

    //MODIFIES: this
    //EFFECTS: constructs a status panel with four buttons (return, add, remove, save) and adds functionality to them
    public void setButtons() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.saveButton = new JButton("Save");
        this.removeButton = new JButton("Remove");
        this.addButton = new JButton("Add");
        this.viewMedsButton = new JButton("View Medication");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(removeButton, BorderLayout.CENTER);
        statusBlock.add(addButton, BorderLayout.CENTER);
        statusBlock.add(saveButton, BorderLayout.WEST);
        addButton.setForeground(Color.GREEN);
        addButton.setBackground(Color.GRAY);
        removeButton.setForeground(Color.RED);
        removeButton.setBackground(Color.PINK);
        this.add(statusBlock);
        this.add(viewMedsButton);
        setReturnFunction();
        setSaveFunction();
        setRemoveFunction();
        addButtonFunction();
        setUpViewArea();
    }

    //MODIFIES: this
    //EFFECTS: sets up a text area along with a text label for medication name for user input
    public void setMedNameArea() {
        reportBlockName = new JPanel(new GridLayout(2, 4));
        reportBlockName.setSize(WIDTH, HEIGHT);
        medicationName = new JLabel("Medication Name");
        reportTextName = new JTextField();
        reportTextName.setVisible(true);
        reportBlockName.add(medicationName);
        reportBlockName.add(reportTextName);
        add(reportBlockName);
    }

    //MODIFIES: this
    //EFFECTS: sets up a text area along with a text label for medication serial number for user input
    public void setSerialNumArea() {
        reportBlockSerialNum = new JPanel(new GridLayout(2, 3));
        reportBlockSerialNum.setSize(WIDTH, HEIGHT);
        medicationSerialNum = new JLabel("Medication Serial Number");
        reportTextSerialNum = new JTextField();
        reportTextSerialNum.setVisible(true);
        reportBlockSerialNum.add(medicationSerialNum);
        reportBlockSerialNum.add(reportTextSerialNum);
        add(reportBlockSerialNum);
    }

    //MODIFIES: this
    //EFFECTS: sets up a text area along with a text label for medication brand name for user input
    public void setMedBrandArea() {
        reportBlockBrand = new JPanel(new GridLayout(2, 2));
        reportBlockBrand.setSize(WIDTH, HEIGHT);
        medicationBrandArea = new JLabel("Medication Brand Name");
        reportTextBrand = new JTextField();
        reportTextBrand.setVisible(true);
        reportBlockBrand.add(medicationBrandArea);
        reportBlockBrand.add(reportTextBrand);
        add(reportBlockBrand);
    }

    //EFFECTS: create a panel to view the updated database and adds functionality for it
    public void setUpViewArea() {
        JPanel reportBlock = new JPanel(new GridLayout(0, 1));
        reportBlock.setSize(WIDTH - (WIDTH / 5),HEIGHT - (HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);
        setViewFunction();
    }

    //EFFECTS: when return button is clicked, switches to the settings tab on the console
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

    //MODIFIES: this
    //EFFECTS: when save button is clicked, it saves the new hospital status to include the new changes
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

    //MODIFIES: this
    //EFFECTS: when remove button is clicked, removes a medication from the medication database from user inputs
    public void setRemoveFunction() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Remove")) {
                    String name = reportTextName.getText();
                    int serialNum = parseInt(reportTextSerialNum.getText());
                    String brand = reportTextBrand.getText();
                    getController().removeMedication(name, brand, serialNum);
                }
            }
        });
    }

    //MODIFIES: this
    //EFFECTS: when add button is clicked, adds a medication from the medication database from user inputs
    public void addButtonFunction() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add")) {
                    String name = reportTextName.getText();
                    int serialNum = parseInt(reportTextSerialNum.getText());
                    String brand = reportTextBrand.getText();
                    getController().addMedication(name, serialNum, brand);
                }
            }
        });
    }

    //EFFECTS: when view medication button is pressed, displays a list of current medication in the database
    public void setViewFunction() {
        viewMedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("View Medication")) {
                    String message = "View of all current medication in the system:";
                    reportMessage.setText(message);
                    String meds = getController().retrieveMedication();
                    reportText.setText(meds);
                    reportPane.setViewportView(reportText);
                }

            }
        });
    }
}
