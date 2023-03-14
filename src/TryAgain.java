import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TryAgain extends JFrame{
    TryAgain(){
        super("Snake Game");
        this.setLayout(new FlowLayout());
        

        JLabel lb= new JLabel();
        lb.setText("Score:");
        

        JLabel imageLabel = new JLabel();
        ImageIcon gameOverIcon = new ImageIcon("game over.gif");
        imageLabel.setIcon(gameOverIcon);
        this.add(imageLabel);

        JButton tryAgainButton = new JButton();
        ImageIcon tryAgainB = new ImageIcon("tryagain.png");
        tryAgainButton.setIcon(tryAgainB);
        tryAgainButton.setBounds(425, 380, 260, 57 );
        EventHandler handler= new EventHandler();
        tryAgainButton.addActionListener(handler);


        JButton exitButton = new JButton();
        ImageIcon exitB = new ImageIcon("exitblue.png");
        exitButton.setIcon(exitB);
        exitButton.setBounds(425, 460, 260, 57 );
        EventHandler1 handler1= new EventHandler1();
        exitButton.addActionListener(handler1);

       // Add button to imageIcon
        imageLabel.add(tryAgainButton);
        imageLabel.add(exitButton);

        // this.add(tryAgainButton);
        // this.add(exitButton);
        


        this.setLayout(new FlowLayout());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,650);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        // set background color of frame
        this.getContentPane().setBackground(new Color(237,241,214));
        // lock frame
        this.setResizable(false);
    }
    private class EventHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event) {
            
            // open game frame
            new GameFrame();
            // Close main menu frame
            dispose();
        }
    }
        private class EventHandler1 implements ActionListener{
            
            public void actionPerformed(ActionEvent event) {
                
            
                dispose();
    }
}
    }
