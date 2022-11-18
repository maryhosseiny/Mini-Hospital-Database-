package ui.tabs;

import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportTabStaff extends Tab {

    private static final String physicianButton = "View physicians";
    private static final String nurseButton = "View nurses";

    private JScrollPane reportPane;
    private JTextArea reportText;
    private JLabel reportMessage;

    JButton nursesButton;
    JButton physiciansButton;
    JButton returnButton;
    JButton saveButton;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public ReportTabStaff(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));
        this.nursesButton = new JButton("Nurses");
        this.physiciansButton = new JButton("Physicians");

        nursesButton.setSize(WIDTH, HEIGHT / 2);
        physiciansButton.setSize(WIDTH, HEIGHT / 2);
        this.add(nursesButton);
        this.add(physiciansButton);
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

        quitAndReturnButton();
        physicianActionButton();
        nursesActionButton();

    }

    //EFFECTS: creates greeting at top of console
    public void physicianActionButton() {
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

    //EFFECTS: creates greeting at top of console
    public void nursesActionButton() {
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

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void quitAndReturnButton() {
        JPanel statusBlock = new JPanel();
        this.returnButton = new JButton("Return");
        statusBlock.add(returnButton, BorderLayout.EAST);

        this.add(statusBlock);
        returnButtonFunction();
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
