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
    private String[] colorNameArray = {"PINK", "PURPLE", "WHITE", "BLACK"};
    private Color[] colorClassArray = {new Color(246,114,128), new Color(175, 175, 199), Color.WHITE, Color.BLACK};
    
    ColorMenu(){

        // JLabel
        JLabel cm= new JLabel();
        ImageIcon icon= new ImageIcon("500 (3).png");
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
        this.add(colorList);

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
