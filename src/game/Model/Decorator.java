
package game.Model;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Decorator extends Bomb {
    
    Bomb tembBomb;
    ImageIcon iy = new ImageIcon("explode.png");
    
    public Decorator(int x, int y) {
        super(x, y);
        
    }
    
    @Override
    public Image getBombImage(){
        
        ic=new ImageIcon("explode.png");
        return ic.getImage();
    }
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getBombImage(), x+2,y, null);
    }
    
    
    
    
    
    
    
}
