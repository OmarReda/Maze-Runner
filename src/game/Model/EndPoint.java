
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class EndPoint extends Entity{
    
    public EndPoint(int x, int y) {
        super(x, y);
    }
    
     public void Update (){
         
    }
    
    public void draw (Graphics2D g2d){
     g2d.drawImage(getendImage(), x+2,y, null);
    }
  
    public Image getendImage(){
        ImageIcon ic = new ImageIcon("end.jpg");
        return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x-1,y,35,30);
    }
}
