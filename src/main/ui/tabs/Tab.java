package ui.tabs;

import ui.Main;
import ui.SmartHospital;

import javax.swing.*;
import java.awt.*;

// The code below is taken and modified from the SmartHome project in LongFormProblemStarter file
public abstract class Tab extends JPanel {

    public final SmartHospital controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Tab(SmartHospital controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public SmartHospital getController() {
        return this.controller;
    }

}
