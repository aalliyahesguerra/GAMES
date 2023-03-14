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
        ImageIcon snakeImage= new ImageIcon("try.gif");
        imageLabel.setIcon(snakeImage);
        this.add(imageLabel);

        JButton easyButton = new JButton();
        ImageIcon easyB = new ImageIcon("easy.png");
        easyButton.setIcon(easyB);
        easyButton.setBounds(430, 170, 230, 49 );
        //1-left right 2-north south 3-width 4-height
        EventHandler easyHandler = new EventHandler(200);
        easyButton.addActionListener(easyHandler);
       

        JButton normalButton = new JButton();
        ImageIcon medB = new ImageIcon ("normal.png");
        normalButton.setIcon(medB);
        normalButton.setBounds(430, 250, 230, 49 );
        EventHandler normalHandler = new EventHandler(100);
        normalButton.addActionListener(normalHandler);


        JButton hardButton = new JButton();
        ImageIcon hardB = new ImageIcon("hard.png");
        hardButton.setIcon(hardB);
        hardButton.setBounds(430, 330, 230, 49);
        EventHandler hardHandler = new EventHandler(50);
        hardButton.addActionListener(hardHandler);

        JButton expertButton= new JButton();
        ImageIcon expertB = new ImageIcon("expert.png");
        expertButton.setIcon(expertB);
        expertButton.setBounds(430, 410, 230, 49);
        EventHandler handler3 = new EventHandler(40);
        expertButton.addActionListener(handler3);
        
        

        JButton godmodeButton= new JButton();
        ImageIcon godB = new ImageIcon("god.png");
        godmodeButton.setIcon(godB);
        godmodeButton.setBounds(430, 490, 230, 49);

        EventHandler handler4= new EventHandler(10);
        godmodeButton.addActionListener(handler4);
        
        imageLabel.add(easyButton);
        imageLabel.add(normalButton);
        imageLabel.add(hardButton);
        imageLabel.add(expertButton);
        imageLabel.add(godmodeButton);


        
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
