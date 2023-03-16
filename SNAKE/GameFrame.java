import javax.swing.JFrame;
// import java.io.File;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;
public class GameFrame extends JFrame {

    GameFrame() {

        this.add(new Board());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    // public static void PlayGameSong(String path){
    //     try {
    //         AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(new File("wavgamesong.wav"));
    //         Clip clip= AudioSystem.getClip();
    //         clip.open(audioInputStream);
    //         clip.loop(Clip.LOOP_CONTINUOUSLY);
    //         clip.start();
    //      //   clip.stop();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
} 
