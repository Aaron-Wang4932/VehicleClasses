package org.example.panels;


import org.example.Main;
import org.example.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DriveConstants extends JPanel implements KeyListener {
    JLabel gasPricePrompt, distancePrompt;
    JTextField gasPrice, distance, output;
    JButton submit;
    public DriveConstants() {
        this.setLayout(null);
        gasPricePrompt = new JLabel("Set the gas price per litre: ");
        gasPricePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        distancePrompt = new JLabel("Set the distance to travel (km): ");
        distancePrompt.setFont(new Font("Century Gothic", Font.BOLD, 24));

        gasPrice = new JTextField();
        gasPrice.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        gasPrice.setMargin(new Insets(5, 5, 5, 5));
        gasPrice.addKeyListener(this);

        distance = new JTextField();
        distance.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
        distance.addKeyListener(this);
        distance.setMargin(new Insets(5, 5, 5, 5));

        output = new JTextField("Specify the drive constants to proceed to vehicle creation.");
        output.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
        output.setEditable(false);
        output.setFocusable(false);
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setBorder(BorderFactory.createLineBorder(Color.black));

        submit = new JButton("Submit Information");
        submit.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
        submit.setFocusable(false);
        submit.addActionListener(e -> {
            // Ensure that there is input
            if(gasPrice.getText().isEmpty() || distance.getText().isEmpty()) {
                output.setText("Fill out the information.");
                return;
            }
            // Ensure valid input if validation ever fails
            try {
                Double.parseDouble(gasPrice.getText());
                Double.parseDouble(distance.getText());
            } catch (NumberFormatException ignored) {
                output.setText("Ensure that your input is numeric.");
                return;
            }
            output.setText("Your constants have been set.");
            if(Main.tabbedPane.getTabCount() == 1) {
                int l = output.getText().length();
                output.setText(output.getText().substring(0, l-1) + ". Enjoy creating vehicles!");
                Main.addTabs();
            }

            Vehicle.setGasPrice(Double.parseDouble(gasPrice.getText()));
            Vehicle.setDistanceKM(Double.parseDouble(distance.getText()));




        });


        this.add(gasPricePrompt);
        gasPricePrompt.setBounds(25, 35, 375, 40);

        this.add(gasPrice);
        gasPrice.setBounds(440, 40, 200, 40);

        this.add(distancePrompt);
        distancePrompt.setBounds(25, 125, 400, 40);

        this.add(distance);
        distance.setBounds(440, 130, 200, 40);

        this.add(output);
        output.setBounds(25, 215, 615, 80);

        this.add(submit);
        submit.setBounds(200, 335, 280, 40);

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





    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
}
