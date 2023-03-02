import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import java.awt.*;
import java.beans.EventHandler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainMenu extends JFrame  {
    MainMenu() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

        //PICKING OF PHOTO FOR ICON
        ImageIcon icon= new ImageIcon("snake.gif");
        //ICON APPEARANCE ON SCREEN
        JLabel label= new JLabel();
        label.setIcon(icon);
        
        JButton button= new JButton ();
        button.setText("PLAY");
        button.setFont(new Font("Consolas", Font.BOLD, 20));
        button.setBackground(Color.WHITE);
    
        EventHandler handler= new EventHandler();
        button.addActionListener(handler);


        this.add(label);
        this.add(button);

    }
    //EVENT HANDLER CLASS
    private class EventHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            //JOptionPane.showMessageDialog(null, "HELLO BIANCA!");

            //SWITCHES TO GAME
            new Board();

            //Closes Main Menu
            dispose();
        }
    }
}