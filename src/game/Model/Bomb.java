
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


public class Bomb extends Entity{
    
    public Bomb(int x, int y) {
        super(x, y);
    }
    public boolean IsExploded=false;
    Random r = new Random();
    public int bombtype=r.nextInt(2);
    ImageIcon ic = new ImageIcon("bomb.png");
    
    @Override
     public void Update (){}
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getBombImage(), x+2,y, null);
    }
  
    public Image getBombImage(){
        
        if (bombtype==0){
        ic = new ImageIcon("bomb.png");
        }
        else {
        ic = new ImageIcon("bomb1.png");
        }
        return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x-1,y,22,30);
    }
}
