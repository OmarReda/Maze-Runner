
package game.Model;

import game.View.Entity;
import game.View.GameFrame;
import game.View.InfoBar;
import game.View.Observer;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


public class Enemy extends Entity {
    int infcounter=0;
    int timej=180;
    public int go=1;
    public int face=1;
    Observer INB = new InfoBar();
    public static int Velocity=2;
    public Enemy(int x, int y) {
        super(x, y);
    }
    Random r = new Random();
    public int enemytype=r.nextInt(2);
    
    
    @Override
     public void Update (){
     
     if(go==1) x=x+Velocity;
     else x=x-Velocity;
     
     CheckCollision();
     }
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getEnemyImage(), x,y, null);
    
    }
  
    public Image getEnemyImage(){
        ImageIcon ic = new ImageIcon("Enemy1.png");
    if(enemytype==0) {
                     if (face ==1){ic = new ImageIcon("Enemy1.png");}
                     else if (face ==2){ic = new ImageIcon("Enemy2.png");}
    }
    else { if (face ==1){ic = new ImageIcon("thief2.png");}
    else if (face == 2){ic = new ImageIcon("thief1.png");} }
        return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x+10,y+10,20,20);
    }
    
    public void CheckCollision(){
    ArrayList <Wall>wall = GameFrame.getWallList();
    
    
    for (int i = 0 ; i< wall.size() ;i++){
    if (getBounds().intersects(wall.get(i).getBounds())){ 
         if(go==1) {go=0;
         x=x-2;
         face = 2;}
         else {go=1;
         x=x+2;
         face = 1;}
    }
    }
   }
    
}
