package game.View;
import game.Model.Enemy;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame extends JFrame{
    static int flagframe=0;
    Frame(String name){
    setSize(1200,747);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          Enemy.Velocity=0;
        if (JOptionPane.showConfirmDialog(null, 
            "Are you sure to close this window?", "Really Closing?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            GameFrame.addtofile();
            System.exit(0);
        }
                    Enemy.Velocity=3;

    }
});
    setResizable(false);
    setLayout(null);
    setBackground(Color.BLACK);
    
    JPanel y=new JPanel();
    if(flagframe==0)y=new GameFrame();
    else y=new GameFrame(PlayerName.name);
    y.setBounds(0, 0,908, 747);
    JPanel x=new JPanel();
    x=new InfoBar();
    x.setBounds(908, 0, 300, 747);
    
    
    add(y);
    add(x);
    setVisible(true);
    }
    public static void main(String args[]) {
        Frame x=new Frame("Game");
    }
    
}