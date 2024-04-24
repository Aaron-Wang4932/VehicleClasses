package org.example.panels;
import javax.swing.*;
import java.awt.*;
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
        gasPrice.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));


        this.add(gasPricePrompt);
        gasPricePrompt.setBounds(15, 10, 375, 40);

        this.add(gasPrice);
        gasPrice.setBounds(460, 15, 200, 40);

        this.add(distancePrompt);
        distancePrompt.setBounds(15, 100, 400, 40);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.' && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
