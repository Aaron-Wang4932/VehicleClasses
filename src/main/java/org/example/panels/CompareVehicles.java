package org.example.panels;

import org.example.Vehicle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;

public class CompareVehicles extends JPanel {
    JLabel searchPrompt1, searchPrompt2;
    JTextField searchBar1, searchBar2;
    JTextArea list, output;
    JScrollPane listScroll, outputScroll;
    JButton compareBtn, listBtn;

    public CompareVehicles() {
        this.setLayout(null);
        searchPrompt1 = new JLabel("License Plate 1:");
        searchPrompt1.setFont(new Font("Century Gothic", Font.BOLD, 16));

        searchPrompt2 = new JLabel("License Plate 2:");
        searchPrompt2.setFont(new Font("Century Gothic", Font.BOLD, 16));

        searchBar1 = new JTextField();
        searchBar1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        searchBar1.setMargin(new Insets(5, 5, 5, 5));

        searchBar2 = new JTextField();
        searchBar2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        searchBar2.setMargin(new Insets(5, 5, 5, 5));

        list = new JTextArea();
        list.setMargin(new Insets(5, 5, 5, 5));
        list.setEditable(false);
        list.setLineWrap(true);
        list.setWrapStyleWord(true);
        list.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        listScroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        compareBtn = new JButton("Compare Vehicles");
        compareBtn.setFocusable(false);
        compareBtn.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        compareBtn.addActionListener(e -> {
            if(searchBar1.getText().isEmpty() || searchBar2.getText().isEmpty()) {
                output.setText("Ensure that both fields are filled out.");
                return;
            }
            String plate1 = searchBar1.getText().trim().toUpperCase(),
                   plate2 = searchBar2.getText().trim().toUpperCase();

            Vehicle foundVehicle1 = Vehicle.searchVehicles(plate1),
                    foundVehicle2 = Vehicle.searchVehicles(plate2),
                    profitableVehicle;

            if(foundVehicle1 == null && foundVehicle2  == null) {
                output.setText("Neither entered license plates are registered.");
                return;
            } else if (foundVehicle1 == null) {
                output.setText("License plate 1 is not registered.");
                return;
            } else if (foundVehicle2 == null) {
                output.setText("License plate 2 is not registered.");
                return;
            }

            profitableVehicle = Vehicle.compare(foundVehicle1, foundVehicle2);

            output.setText("The more profitable vehicle is " + profitableVehicle.getLicense() + ":\n" + profitableVehicle);
        });

        listBtn = new JButton("List All Cars");
        listBtn.setFocusable(false);
        listBtn.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        listBtn.addActionListener(e -> {
            if(Vehicle.activeVehicles.isEmpty()) {
                output.setText("You have no registered vehicles!");
                return;
            }
            list.setText("");
            for(Vehicle v : Vehicle.activeVehicles) {
                list.append(v.toString() + "\n\n");
            }
        });

        output = new JTextArea();
        output.setMargin(new Insets(5, 5, 5, 5));
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        outputScroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        this.add(searchPrompt1);
        searchPrompt1.setBounds(20, 20, 230, 40);

        this.add(searchBar1);
        searchBar1.setBounds(250, 25, 125, 30);

        this.add(searchPrompt2);
        searchPrompt2.setBounds(20, 80, 230, 40);

        this.add(searchBar2);
        searchBar2.setBounds(250, 80, 125, 30);

        this.add(listScroll);
        listScroll.setBounds(400, 20, 250, 400);

        this.add(compareBtn);
        compareBtn.setBounds(20, 130, 167, 35); //20

        this.add(listBtn);
        listBtn.setBounds(207, 130, 167, 35);

        this.add(outputScroll);
        outputScroll.setBounds(20, 185, 355, 235);
    }
}
