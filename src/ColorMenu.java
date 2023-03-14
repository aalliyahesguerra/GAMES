import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

    
public class ColorMenu extends JFrame{

    // Jlist
    JList colorList;
    // Color arrays
    
    private String[] colorNameArray = {"PURPLE", "BLUE", "PINK", "YELLOW"};
    private Color[] colorClassArray = {new Color(120, 94, 143), new Color(110,144,186), 
                                        new Color(221, 110, 129), new Color(214, 170, 118) };
    
    ColorMenu(){

        // JLabel
        JLabel cm= new JLabel();
        ImageIcon icon= new ImageIcon("draftcolor.jpg");
        cm.setIcon(icon);
        this.add(cm);
        this.setResizable(false);

       //cm.setText("Choose background color");
        cm.setVerticalTextPosition(JLabel.BOTTOM);
        cm.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(cm);

        // Jlist
        colorList = new JList(colorNameArray);
        // Restricts to one selection
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.setFont(new Font("Arial", Font.BOLD, 25));
        colorList.setBackground(new Color(237,241,214));
        colorList.setBounds(600, 170, 230, 150);
        cm.add(colorList);

        bgColorEventHandler bgColorHandler= new bgColorEventHandler();
        colorList.addListSelectionListener(bgColorHandler);

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
    private class bgColorEventHandler implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent event) {
            Board gp= new Board();

            gp.gameBGColor= colorClassArray[colorList.getSelectedIndex()];
            
            new PlayerMenu();
        

            dispose();

    }
    
}
}
