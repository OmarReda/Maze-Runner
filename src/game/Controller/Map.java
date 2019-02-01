
package game.Controller;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Map extends Entity{
    
    public Map(int x, int y) {
        super(x, y);
    }
    
    public void Update (){
    
    }
    
    public void draw (Graphics2D g2d){
    
    }
    
    public Image getwallImage(){
    ImageIcon wall = new ImageIcon("123.png");
        return wall.getImage();
    }
    
    public Image getobstacleImage(){
    ImageIcon obstacle = new ImageIcon("1234.png");
        return obstacle.getImage();
    }
    
    public Image getgroundImage(){
    ImageIcon ground = new ImageIcon("456.png");
        return ground.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x,y,30,30);
    }
    
}
