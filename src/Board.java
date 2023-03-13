import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    
    private final int B_WIDTH = 1100;
    private final int B_HEIGHT = 650;
    private final int DOT_SIZE = 30;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 19;

    // Background color property
    static Color gameBGColor;

    // Game difficulty
    static int DELAY;

    int applesEaten;
    static String playerName;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    int highestScore;
    int foodsEaten;

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(gameBGColor);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 60 - z * 30;
            y[z] = 60;
        }
        
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {
             
            g.clearRect(0, 0, B_WIDTH, B_HEIGHT);
            g.setColor(gameBGColor);
            g.fillRect(0, 0, B_WIDTH, B_HEIGHT);

            g.drawImage(apple, apple_x, apple_y, this);
            
            // Grid
            g.setColor(Color.white);
            for (int i = 0; i < B_WIDTH / 30; i++) {
             g.drawLine(i * 30, 60, i * 30, B_HEIGHT);
        }
            for (int i = 2; i < 780 / 25; i ++) {
             g.drawLine(0, i * 30, B_WIDTH, i * 30 );
        }

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

            // Score
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());

            g.drawString("Score: " + applesEaten, (B_WIDTH - metrics.stringWidth("Score: " + B_HEIGHT)) / 2,
                    g.getFont().getSize());

            g.drawString("Player: " + playerName, 0,
                    g.getFont().getSize());

                    

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        //highest score
        if (foodsEaten >= highestScore) {
            highestScore = foodsEaten;
        }

        String hs = "Highest Score: ";

        Font hsf = new Font("Game Over Regular", Font.PLAIN, 100);
        FontMetrics metr1 = getFontMetrics(hsf);

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());

        g.drawString("Score: " + applesEaten, (B_WIDTH - metrics.stringWidth("Score: " + B_HEIGHT)) / 2,
                g.getFont().getSize());

        String msg = "VOVO KA BEH ULIT SNAKE NALANG YAN";
        Font small = new Font("Cooper Black", Font.BOLD, 44);
        FontMetrics metr = getFontMetrics(small);
        

        g.setColor(Color.pink);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 3);
        

        JFrame parentFrame = (JFrame) this.getTopLevelAncestor();
        
        parentFrame.dispose();
        // Open Try again frame
        new TryAgain();
        
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            applesEaten++;
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 3) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int)(Math.random() * 40) + 0;
        apple_x = ((r * 30));

        r = (int)(Math.random() * 26) + 0;
        apple_y = ((r * 30) + 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}