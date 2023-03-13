import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DifficultyMenu extends JFrame {

    DifficultyMenu() {
        super("Snake Game");
        JLabel imageLabel= new JLabel();
        ImageIcon snakeImage= new ImageIcon("draftsd.gif");
        imageLabel.setIcon(snakeImage);
        this.add(imageLabel);

        JButton easyButton = new JButton();
        ImageIcon easyB = new ImageIcon("easybutton.png");
        easyButton.setIcon(easyB);
        easyButton.setBounds(430, 170, 230, 49 );
        //2,north south 3,width 4,height
        imageLabel.add(easyButton);

        EventHandler easyHandler = new EventHandler(200);
        easyButton.addActionListener(easyHandler);
       

        JButton mediumButton = new JButton();
        ImageIcon medB = new ImageIcon ("normalbutton.png");
        mediumButton.setIcon(medB);
        mediumButton.setBounds(430, 250, 230, 49 );
        EventHandler mediumHandler = new EventHandler(100);
        mediumButton.addActionListener(mediumHandler);


        JButton hardButton = new JButton();
        hardButton.setText("Hard");
        hardButton.setForeground(Color.WHITE);
        hardButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        hardButton.setBackground(new Color(128,70,116));
        EventHandler hardHandler = new EventHandler(50);
        hardButton.addActionListener(hardHandler);

        JButton expertButton= new JButton();
        expertButton.setText("Expert");
        expertButton.setForeground(Color.WHITE);
        expertButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        expertButton.setBackground(new Color(128,70,116));
        EventHandler handler3 = new EventHandler(40);
        expertButton.addActionListener(handler3);
        
        

        JButton godmodeButton= new JButton();
        godmodeButton.setText("God Mode");
        godmodeButton.setForeground(Color.WHITE);
        godmodeButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        godmodeButton.setBackground(new Color(128,70,116));
        EventHandler handler4= new EventHandler(10);
        godmodeButton.addActionListener(handler4);
        
        
        imageLabel.add(mediumButton);
        // add(easyButton);
        // System.out.println("    \n");
        // add(mediumButton);
        // add(hardButton);
        // add(expertButton);
        // add(godmodeButton);

        
        this.setLayout(new FlowLayout());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,650);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    private class EventHandler implements ActionListener {

        int snakeSpeed;
        EventHandler (int speed) {
            this.snakeSpeed = speed;
        }

        public void actionPerformed(ActionEvent event) {
            Board gp = new Board();
            
            gp.DELAY = snakeSpeed;
        
            new ColorMenu();


        }
    }
}