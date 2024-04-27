package org.example;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import org.example.panels.*;
public class Main extends JFrame {

    JLabel title;
    static DriveConstants driveConstants = new DriveConstants();
    static CreateVehicle createVehicle = new CreateVehicle();
    static SearchVehicle searchVehicle = new SearchVehicle();
    static CompareVehicles compareVehicles = new CompareVehicles();

    public static JTabbedPane tabbedPane;
    public Main() {
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 650));
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("eeeee");
        this.getContentPane().setBackground(new Color(0x3E84C2));

        title = new JLabel("cat in a car (minus the cats)", JLabel.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
        title.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0xB093E0), 4, true),
                "welcome to",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16),
                new Color(0xebddff)));
        title.setForeground(Color.white);

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        tabbedPane.addTab("Drive Constants", null, driveConstants, "Set constants for all vehicles.");



        this.add(title);
        title.setBounds(212, 20, 475, 75);

        this.add(tabbedPane);
        tabbedPane.setBounds(110, 105, 679, 475);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    public static void addTabs() {
        tabbedPane.addTab("Create Vehicle", null, createVehicle, "Enter parameters for a new vehicle.");
        tabbedPane.addTab("Search Vehicles", null, searchVehicle, "View all vehicles or search for a specific one.");
        tabbedPane.addTab("Compare Vehicles", null, compareVehicles, "Compare two vehicles given their license plates.");
    }
}