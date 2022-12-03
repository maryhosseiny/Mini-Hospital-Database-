package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents staff viewing page where the user can see the physicians and nurses in the database as well as
//            being able to return to the settings page
public class ReportTabStaff extends Tab {

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    private JButton nursesButton;
    private JButton physiciansButton;
    private JButton returnButton;

    //EFFECTS: constructs staff tab with 2 buttons (nurses and physicians) along with a text area
    //         to view the nurses/physicians in the database as well as a return button to go back
    //         to the settings tab
    public ReportTabStaff(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(5, 1));
        setButtons();
        setViewArea();

        setReturnButton();
        setPhysicianFunction();
        setNurseFunction();
    }

    //MODIFIES: this, nursesButton, physiciansButton
    //EFFECTS: constructs two buttons (nurses and physicians)
    public void setButtons() {
        this.nursesButton = new JButton("Nurses");
        this.physiciansButton = new JButton("Physicians");

        nursesButton.setSize(WIDTH, HEIGHT / 2);
        physiciansButton.setSize(WIDTH, HEIGHT / 2);
        this.add(nursesButton);
        this.add(physiciansButton);
    }

    //MODIFIES: this, reportText, reportBlock
    //EFFECTS: create a panel to view the nurses and physicians database
    public void setViewArea() {
        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(WIDTH,HEIGHT);
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(3, 1));
        reportText = new JTextArea("", 3, 1);
        reportText.setVisible(true);
        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);
        add(reportBlock);
    }

    //MODIFIES: this, statusBlock
    //EFFECTS: constructs a return button and adds functionality for it
    public void setReturnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        statusBlock.add(returnButton, BorderLayout.EAST);

        this.add(statusBlock);
        setReturnFunction();
    }

    //MODIFIES: this, physiciansButton, reportText, reportPane
    //EFFECTS: when view physicians button is pressed, displays all the physicians in the database in the text area
    public void setPhysicianFunction() {
        physiciansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Physicians")) {
                    String message = "View of all current physicians in the system:";
                    reportMessage.setText(message);
                    String physicians = getController().retrievePhysicians();
                    reportText.setText(physicians);
                    reportPane.setViewportView(reportText);
                }
            }
        });
    }

    //MODIFIES: this, nursesButton, reportText, reportPane
    //EFFECTS: when view nurses button is pressed, displays all the nurses in the database in the text area
    public void setNurseFunction() {
        nursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Nurses")) {
                    String message = "View of all current nurses in the system:";
                    reportMessage.setText(message);
                    String nurses = getController().retrieveNurses();
                    reportText.setText(nurses);
                    reportPane.setViewportView(reportText);
                }
            }
        });

    }

    //MODIFIES: returnButton
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
}
