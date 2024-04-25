package org.example.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CreateVehicle extends JPanel implements KeyListener {
    JLabel licensePrompt, numPassengerPrompt, farePrompt, fuelEfficiencyPrompt;
    JTextField license, numPassenger, fare, fuelEfficiency, output;
    JButton submit;
    public CreateVehicle() {
         this.setLayout(null);
         licensePrompt = new JLabel("Vehicle License Plate: ");
         licensePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

         numPassengerPrompt = new JLabel("Number of Passengers: ");
         numPassenger.setFont(new Font("Century Gothic", Font.BOLD, 24));

         farePrompt = new JLabel("Fare per Person ($): ");
         farePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

         fuelEfficiencyPrompt = new JLabel("Fuel Efficiency: ");
         fuelEfficiencyPrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));
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
