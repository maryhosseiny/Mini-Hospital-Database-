package ui.tabs;

import ui.Main;
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

    private JLabel initGreeting;
    private JLabel optionGreeting;
    private JLabel returnGreeting;
    private JLabel saveGreeting;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public ReportTabStaff(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        placeGreeting();
        placeStatusButton();

        JPanel reportBlock = new JPanel(new GridLayout(2, 1));
        reportBlock.setSize(SmartHospital.WIDTH - (SmartHospital.WIDTH / 5),
                SmartHospital.HEIGHT - (SmartHospital.HEIGHT / 5));
        reportMessage = new JLabel("");
        reportPane = new JScrollPane(new JTextArea(6, 40));
        reportText = new JTextArea("", 6, 40);
        reportText.setVisible(true);

        reportBlock.add(reportMessage);
        reportBlock.add(reportPane);

        add(reportBlock);
    }

    //EFFECTS: creates greeting at top of console
    public void placeGreeting() {
        JButton nursesButton = new JButton("Nurses");
        JButton physiciansButton = new JButton("Physicians");
        nursesButton.setSize(WIDTH, HEIGHT / 2);
        physiciansButton.setSize(WIDTH, HEIGHT / 2);
        this.add(nursesButton);
        this.add(physiciansButton);

        physiciansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Physicians")) {
                    String message = "View of all current physicians in the system:";
                    reportMessage.setText(message);
                    reportText.setText(getController().getSmartHospital().retrievePhysicians());
                    reportPane.setViewportView(reportText);
                }

            }
        });
        nursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("Nurses")) {
                    String message = "View of all current nurses in the system:";
                    reportMessage.setText(message);
                    String nurses = getController().getSmartHospital().retrieveNurses();
                    reportText.setText(nurses);
                    reportPane.setViewportView(reportText);
                }

            }
        });

    }

    //EFFECTS: constructs a status button that switches to the report tab on the console
    public void placeStatusButton() {
        JPanel statusBlock = new JPanel();
        JButton doctors = new JButton("Return");
        JButton nurses = new JButton("Quit");
        statusBlock.add(doctors, BorderLayout.EAST);
        statusBlock.add(nurses, BorderLayout.WEST);
        //TODO: add functionality for quit and return
        this.add(statusBlock);
    }
}
