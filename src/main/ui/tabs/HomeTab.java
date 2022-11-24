package ui.tabs;

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
    private ImageIcon image;
    private JLabel icon;


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(SmartHospital controller) {
        super(controller);
        setLayout(new GridLayout(9, 1));
        setGreetings();
        setThisIsFineImage();
        setProceedButton();
    }

    //MODIFIES: this
    //EFFECTS: creates greeting and places them on the frame
    private void setGreetings() {
        initGreeting = new JLabel(INIT_GREETING);
        optionGreeting = new JLabel(OPTION_GREETING);
        returnGreeting = new JLabel(RETURN_GREETING);
        saveGreeting = new JLabel(SAVE_GREETING);
        initGreeting.setSize(WIDTH, HEIGHT);
        optionGreeting.setSize(WIDTH, HEIGHT);
        returnGreeting.setSize(WIDTH, HEIGHT);
        saveGreeting.setSize(WIDTH, HEIGHT);

        add(initGreeting);
        add(optionGreeting);
        add(returnGreeting);
        add(saveGreeting);
    }

    //MODIFIES: this
    //EFFECTS: uploads this is fine image onto the frame
    private void setThisIsFineImage() {
        icon = new JLabel();
        image = new ImageIcon("this_is_fine.jpg");
        icon.setSize(WIDTH, HEIGHT);
        icon.setIcon(image);
        add(icon);
    }

    //MODIFIES: this
    //EFFECTS: constructs a proceed button that switches to the settings tab
    private void setProceedButton() {
        JPanel statusBlock = new JPanel();
        JButton statusButton = new JButton("If you have read the above, click this button to proceed");
        statusBlock.add(formatButtonRow(statusButton));
        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals("If you have read the above, click this button to proceed")) {
                    getController().getTabbedPane().setSelectedIndex(SmartHospital.settingsTabIndex);
                }
            }
        });
        add(statusBlock);
    }
}
