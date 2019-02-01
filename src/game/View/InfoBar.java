
package game.View;

import game.Model.Enemy;
import game.Model.Weapon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class InfoBar extends JPanel implements Observer{
    
    public static JProgressBar JBar;
    JLabel Health;
    JLabel Bullets;
    public static JLabel armor,NOBullets,time,score;
    JLabel timer,Score;
    JButton Button;
    ImageIcon IC= new ImageIcon("5644.png");
    public static int t=180;
    
    public InfoBar(){
        System.out.println("D5l el 2wl");
    setFocusable(true);
    setLayout(null);
    this.setBackground(Color.BLACK);
    JBar = new JProgressBar();
    JBar.setForeground(Color.RED);
    JBar.setBounds(30, 50, 240, 20);
    JBar.setValue(100);
    Health = new JLabel();
    Health.setText("HP");
    Health.setForeground(Color.WHITE);
    Health.setBounds(5,50,20,20);
    Bullets = new JLabel();
    Bullets.setText("Bullets");
    Bullets.setForeground(Color.WHITE);
    Bullets.setBounds(5,90,60,20);
    NOBullets = new JLabel();
    NOBullets.setForeground(Color.WHITE);
    NOBullets.setBounds(90,90,60,20);
    timer = new JLabel ();
    timer.setText("Timer"); 
    timer.setForeground(Color.WHITE);
    timer.setBounds(5,130,60,20);
    time = new JLabel ();
    time.setForeground(Color.WHITE);
    time.setBounds(90,130,60,20);
    armor = new JLabel();
    armor.setIcon(IC);
    armor.setBounds(30, 250, 64, 74);
    Score = new JLabel("Score");
    Score.setBounds(5,170,62,20);
    Score.setForeground(Color.WHITE);
    score = new JLabel("000");
    score.setBounds(90,170,62,20);
    score.setForeground(Color.WHITE);
    Button = new JButton("Pause");
    Button.setForeground(Color.BLACK);
    Button.setBounds(100, 600, 80, 20);
    add(score);
    add(Score);
    add(armor);
    add(timer);
    add(time);
    add(NOBullets);
    add(Bullets);
    add(Health);
    add(JBar);
    add(Button);
    JBar.setValue(100);
    score.setText(String.valueOf(0));
    NOBullets.setText(String.valueOf(6));
    Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              Enemy.Velocity=0;
        JOptionPane.showMessageDialog(null, " Game Paused ");
                
                    Enemy.Velocity=3;
        }
        
    });
    }

    @Override
    public void HeroUpdate(int hp, int Score,int nobullets, int armorflag,int timeU) {
        score.setText(String.valueOf(Score));
        NOBullets.setText(String.valueOf(nobullets));
        JBar.setValue(hp);
        if(armorflag==1)
    armor.setVisible(true);
    else
    armor.setVisible(false);
        time.setText(String.valueOf(timeU));
    }
    
    @Override
    public void EnemyUpdate(int timeU) {
        //time.setText(String.valueOf(timeU));
    }

    
    
    
}
    

