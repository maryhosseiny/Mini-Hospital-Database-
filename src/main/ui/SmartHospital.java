package ui;

import ui.tabs.HomeTab;
import ui.tabs.ReportTabStaff;

import javax.swing.*;
import java.io.FileNotFoundException;

public class SmartHospital extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
//    public static final int SETTINGS_TAB_INDEX = 1;
    public static final int REPORT_TAB_INDEX_STAFF = 1;
    public static final int REPORT_TAB_INDEX_MEDS = 3;
    public static final int REPORT_TAB_INDEX_PATS = 4;


    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private HospitalApp hospitalApp;

    //MODIFIES: this
    //EFFECTS: creates SmartHomeUI, loads SmartHome appliances, displays sidebar and tabs
    public SmartHospital() throws FileNotFoundException {
        JFrame frame = new JFrame();
        frame.setTitle("SmartHome Console");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        hospitalApp = new HospitalApp();
        loadTabs();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        frame.add(sidebar);
        frame.setVisible(true);
    }


    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
//        JPanel settingsTab = new SettingsTab(this);
        JPanel staffTab = new ReportTabStaff(this);
//        JPanel medTab = new ReportTabMeds(this);
//        JPanel patTab = new ReportTabPatients(this);


        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Greetings");
        sidebar.add(staffTab, REPORT_TAB_INDEX_STAFF);
        sidebar.setTitleAt(REPORT_TAB_INDEX_STAFF, "Staff Database");
//        sidebar.add(settingsTab, SETTINGS_TAB_INDEX);
//        sidebar.setTitleAt(SETTINGS_TAB_INDEX, "Main Menu");
//        sidebar.add(medTab, REPORT_TAB_INDEX_MEDS);
//        sidebar.setTitleAt(REPORT_TAB_INDEX_MEDS, "Medication Database");
//        sidebar.add(patTab, REPORT_TAB_INDEX_PATS);
//        sidebar.setTitleAt(REPORT_TAB_INDEX_PATS, "Patients Database");
    }

    //EFFECTS: returns SmartHome object controlled by this UI
    public HospitalApp getSmartHospital() {
        return hospitalApp;
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }


}