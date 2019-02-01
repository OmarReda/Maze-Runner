
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Checkpoint extends Entity{

public Checkpoint(int x, int y) {
super(x, y);
}
@Override
public void Update(){}



public void draw (Graphics2D g2d){
    g2d.drawImage(getCheckImage(), x,y, null);
    g2d.drawRect(x,y,30, 30);
    }
    
public Image getCheckImage(){
        
    ImageIcon ic = new ImageIcon("Checkpoint.png");
        return ic.getImage();
    }
public Rectangle getBounds(){
    return new Rectangle(x,y,30, 30);
    }

}
