package org.example.panels;

import org.example.Vehicle;

import javax.swing.*;
import java.awt.*;
public class SearchVehicle extends JPanel {
    JLabel searchPrompt;
    JTextField searchBar;
    JTextArea list, output;
    JScrollPane listScroll, outputScroll;
    JButton searchBtn, listBtn;

    public SearchVehicle() {
        this.setLayout(null);
        searchPrompt = new JLabel("Search By License Plate: ");
        searchPrompt.setFont(new Font("Century Gothic", Font.BOLD, 16));

        searchBar = new JTextField();
        searchBar.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
        searchBar.setMargin(new Insets(5, 5, 5, 5));

        list = new JTextArea();
        list.setMargin(new Insets(5, 5, 5, 5));
        list.setEditable(false);
        list.setLineWrap(true);
        list.setWrapStyleWord(true);
        list.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        listScroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        searchBtn = new JButton("Search");
        searchBtn.setFocusable(false);
        searchBtn.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 16));
        searchBtn.addActionListener(e -> {
            if(searchBar.getText().isEmpty()) {
                output.setText("Provide a license plate to search!");
                return;
            }
            String plate = searchBar.getText().trim().toUpperCase();
            Vehicle foundVehicle;

            if((foundVehicle = Vehicle.searchVehicles(plate)) == null) {
                output.setText("The entered license plate does not exist.");
                return;
            }
            output.setText(foundVehicle.toString());
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


        this.add(searchPrompt);
        searchPrompt.setBounds(20, 20, 230, 40);

        this.add(searchBar);
        searchBar.setBounds(250, 25, 125, 30);

        this.add(listScroll);
        listScroll.setBounds(400, 20, 250, 400);

        this.add(searchBtn);
        searchBtn.setBounds(20, 80, 167, 35); //20

        this.add(listBtn);
        listBtn.setBounds(207, 80, 167, 35);

        this.add(outputScroll);
        outputScroll.setBounds(20, 135, 355, 285);
    }
}
