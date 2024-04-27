package org.example.panels;

import org.example.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CreateVehicle extends JPanel implements KeyListener {
    JLabel licensePrompt, numPassengerPrompt, farePrompt, fuelEfficiencyPrompt;
    JTextField license, numPassenger, fare, fuelEfficiency, output;
    JButton createCarBtn;
    public CreateVehicle() {
        this.setLayout(null);
        licensePrompt = new JLabel("Vehicle License Plate: ");
        licensePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        numPassengerPrompt = new JLabel("Number of Passengers: ");
        numPassengerPrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        farePrompt = new JLabel("Fare per Person ($): ");
        farePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        fuelEfficiencyPrompt = new JLabel("Fuel Efficiency (L/km): ");
        fuelEfficiencyPrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        license = new JTextField();
        license.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        license.setMargin(new Insets(5, 5, 5, 5));

        numPassenger = new JTextField();
        numPassenger.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        numPassenger.setMargin(new Insets(5, 5, 5, 5));
        numPassenger.addKeyListener(this);

        fare = new JTextField();
        fare.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        fare.setMargin(new Insets(5, 5, 5, 5));
        fare.addKeyListener(this);

        fuelEfficiency = new JTextField();
        fuelEfficiency.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        fuelEfficiency.setMargin(new Insets(5, 5, 5, 5));
        fuelEfficiency.addKeyListener(this);

        output = new JTextField("Please enter your vehicle information!");
        output.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        output.setEditable(false);
        output.setFocusable(false);
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setBorder(BorderFactory.createLineBorder(Color.black));

        createCarBtn = new JButton("Create Vehicle");
        createCarBtn.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
        createCarBtn.setFocusable(false);
        createCarBtn.addActionListener(e -> {
            // If text fields are empty return.
            if(license.getText().isEmpty() || numPassenger.getText().isEmpty() || fare.getText().isEmpty() || fuelEfficiency.getText().isEmpty()) {
                output.setText("Fill out the information.");
                return;
            }
            String plate = license.getText().trim().toUpperCase();
            int numPeople;
            double fareDouble, fuelEfficiencyDouble;
            // Determine if the entered license plate already exists
            if(Vehicle.searchVehicles(plate) != null) {
                    output.setText("The entered license plate is already registered.");
                    return;
            }

            // Determine if passenger count is valid. No half passengers.
            try {
                numPeople = Integer.parseInt(numPassenger.getText());
            } catch (NumberFormatException ignored) {
                output.setText("Ensure that your passenger count is valid.");
                return;
            }

            // Determine if other input is valid if validation fails.
            try {
                fareDouble = Double.parseDouble(fare.getText());
                fuelEfficiencyDouble = Double.parseDouble(fuelEfficiency.getText());
            } catch (NumberFormatException ignored) {
                output.setText("Ensure that your entered information is valid.");
                return;
            }

            Vehicle.activeVehicles.add(new Vehicle(plate, numPeople, fareDouble, fuelEfficiencyDouble));
            clearInput();
            output.setText("Created your vehicle with plate " + plate);
        });

        this.add(licensePrompt);
        licensePrompt.setBounds(30, 20, 375, 40);

        this.add(license);
        license.setBounds(445, 20, 200, 40);

        this.add(numPassengerPrompt);
        numPassengerPrompt.setBounds(30, 85, 375, 40);

        this.add(numPassenger);
        numPassenger.setBounds(445, 85, 200, 40);

        this.add(farePrompt);
        farePrompt.setBounds(30, 150, 375, 40);

        this.add(fare);
        fare.setBounds(445, 150, 200, 40);

        this.add(fuelEfficiencyPrompt);
        fuelEfficiencyPrompt.setBounds(30, 215, 375, 40);

        this.add(fuelEfficiency);
        fuelEfficiency.setBounds(445, 215, 200, 40);

        this.add(output);
        output.setBounds(30, 270, 615, 80);

        this.add(createCarBtn);
        createCarBtn.setBounds(200, 375, 280, 40);
    }

    public void clearInput() {
        license.setText("");
        numPassenger.setText("");
        fuelEfficiency.setText("");
        fare.setText("");
        output.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.' && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        try {
            Double.parseDouble(((JTextField)e.getSource()).getText());
        } catch (NumberFormatException ignored) {
            ((JTextField)e.getSource()).setText("");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
