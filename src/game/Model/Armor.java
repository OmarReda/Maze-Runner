
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Armor extends Entity {
    
    
    
    public Armor(int x, int y) {
        super(x, y);
    }
    
    @Override
     public void Update (){}
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getArmorImage(), x,y, null);
    }
  
    public Image getArmorImage(){
        
    ImageIcon ic = new ImageIcon("armor.png");
        return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x,y,25,30);
    }
}
