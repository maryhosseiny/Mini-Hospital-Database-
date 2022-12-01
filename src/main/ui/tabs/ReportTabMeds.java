package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a medication viewing tab where the user can view the current medication in the system, as well
//           as accessing buttons where the user can return to the settings page, saving the state of the
//           database and accessing add/removing medication tab
public class ReportTabMeds extends Tab {

    private JButton viewMedicationButton;
    private JButton addMedicationButton;
    private JButton removeMedicationButton;
    private JButton returnButton;
    private JButton saveButton;

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    //EFFECTS: constructs a modifier tab for with 5 buttons (save, add, remove, return, view medication) and
    //         a text field for viewing medication
    public ReportTabMeds(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(7, 1));
        setUpMedButtons();
        JPanel reportBlock = new JPanel(new GridLayout(0, 1));
        reportBlock.setSize(WIDTH - (WIDTH / 5),HEIGHT - (HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);

        quitAndReturnButton();
    }

    //MODIFIES: this, viewMedicationButton, addMedicationButton, removeMedicationButton
    //EFFECTS: constructs add/remove medication button as well as a view medication button and adds functionality
    public void setUpMedButtons() {
        this.viewMedicationButton = new JButton("View Medication");
        this.addMedicationButton = new JButton("Add Medication");
        this.removeMedicationButton = new JButton("Remove Medication");

        viewMedicationButton.setSize(WIDTH, HEIGHT / 2);
        addMedicationButton.setSize(WIDTH, HEIGHT / 2);
        removeMedicationButton.setSize(WIDTH, HEIGHT / 2);

        this.add(viewMedicationButton);
        this.add(addMedicationButton);
        this.add(removeMedicationButton);
        setViewFunction();
        setAddFunction();
        setRemoveFunction();
    }

    //MODIFIES: this, statusBlock
    //EFFECTS: constructs a save and return button then adds functionality to them
    public void quitAndReturnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        this.saveButton = new JButton("Save");
        statusBlock.add(returnButton, BorderLayout.EAST);
        statusBlock.add(saveButton, BorderLayout.WEST);

        this.add(statusBlock);
        setReturnFunction();
        setSaveFunction();
    }

    //MODIFIES: SmartHospital (saving changes in the database)
    //EFFECTS: when save button is clicked, saves the changes in the database
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

    //MODIFIES: this, reportPane, reportText, viewMedicationButton
    //EFFECTS: when view button is clicked, display the all medication in the database in the text area
    public void setViewFunction() {
        viewMedicationButton.addActionListener(new ActionListener() {
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

    //MODIFIES: removeMedicationButton
    //EFFECTS: when remove button is clicked, switch tabs to the medication modifier page
    public void setRemoveFunction() {
        removeMedicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Remove Medication")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.medicationModifierTabIndex);
                }
            }
        });
    }

    //MODIFIES: addMedicationButton
    //EFFECTS: when add button is clicked, switch tabs to the medication modifier page
    public void setAddFunction() {
        addMedicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Add Medication")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.medicationModifierTabIndex);
                }
            }
        });
    }

    //MODIFIES: returnButton
    //EFFECTS: when return button is pressed, returns to the settings page
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
}
