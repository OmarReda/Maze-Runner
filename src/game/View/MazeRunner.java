package game.View;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MazeRunner {

    static FileInputStream fl;
    static BufferedInputStream bl;
    static Player player;

    public static void main(String args[]) {

        Welcome w = new Welcome();
        w.setVisible(true);
        File record = new File("gametrack.mp3");
        play(record);
    }

    static void play(File sound) {

        try {
            fl = new FileInputStream(sound);
            bl = new BufferedInputStream(fl);
            player = new Player(bl);

            new Thread() {
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        } catch (IOException e) {
            Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, e);
        } catch (JavaLayerException ex) {
            Logger.getLogger(MazeRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
