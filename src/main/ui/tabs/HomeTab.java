package ui.tabs;

import ui.Main;
import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTab extends Tab {

    private static final String INIT_GREETING = "Welcome to the Student Hospital Database. ";
    private static final String OPTION_GREETING = "You can select each options to explore the database further.";
    private static final String RETURN_GREETING = "Remember to enter 'return' to return to the main menu!";
    private static final String SAVE_GREETING = "Remember to enter 'save' if you would like to save your work!";
    private JLabel initGreeting;
    private JLabel optionGreeting;
    private JLabel returnGreeting;
    private JLabel saveGreeting;

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(SmartHospital controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        placeGreeting();
        placeStatusButton();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        initGreeting = new JLabel(INIT_GREETING);
        optionGreeting = new JLabel(OPTION_GREETING);
        returnGreeting = new JLabel(RETURN_GREETING);
        saveGreeting = new JLabel(SAVE_GREETING);
        initGreeting.setSize(WIDTH, HEIGHT);
        optionGreeting.setSize(WIDTH, HEIGHT);
        returnGreeting.setSize(WIDTH, HEIGHT);
        saveGreeting.setSize(WIDTH, HEIGHT);
        this.add(initGreeting);
        this.add(optionGreeting);
        this.add(returnGreeting);
        this.add(saveGreeting);

    }

    //EFFECTS: constructs a status button that switches to the settings tab on the console
    private void placeStatusButton() {
        JPanel statusBlock = new JPanel();
        JButton statusButton = new JButton("If you have read the above, click this button to proceed");
        statusBlock.add(formatButtonRow(statusButton));

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("If you have read the above, click this button to proceed")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.REPORT_TAB_INDEX_STAFF);
                }
            }
        });

        this.add(statusBlock);
    }
}
