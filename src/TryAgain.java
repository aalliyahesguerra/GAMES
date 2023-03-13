import javax.swing.BorderFactory;
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
        

        JLabel label = new JLabel();
        label.setText("VOVO KA BEH ULIT SNAKE NALANG YAN");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Times New Roman", Font.BOLD, 25));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        this.add(label);

         
        JLabel imageLabel= new JLabel();
        ImageIcon snakeImage= new ImageIcon("");
        imageLabel.setIcon(snakeImage);
        this.add(imageLabel);
        
        JButton tryAgainButton = new JButton();
        tryAgainButton.setText("Try Again");
        tryAgainButton.setBackground(new Color(128,70,116));
        tryAgainButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
        
        EventHandler handler= new EventHandler();
        tryAgainButton.addActionListener(handler);

       // Add button to frame
        this.add(tryAgainButton);
        
        
        // gbc.gridx=0;
        // gbc.gridy=0;
      //  tryAgainButton.setMargin(getInsets());
        
        // Add button to frame
        
        JButton exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setBackground(new Color(128,70,116));
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 25));

        EventHandler1 handler1= new EventHandler1();
        exitButton.addActionListener(handler1);

       // Add button to frame
        this.add(tryAgainButton);
        this.add(exitButton);


        // this.add(tryAgainButton);
        // this.add(exitButton);
        



        this.setLayout(new FlowLayout());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,700);
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
