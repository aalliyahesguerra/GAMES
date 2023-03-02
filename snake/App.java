import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;

public class App extends JFrame {

    public App() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new App();
            ex.setVisible(true);
        });


        MainMenu main = new MainMenu();
        
        main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
        main.setSize(480,450);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.getContentPane().setBackground(Color.RED);

       

    }
    
}