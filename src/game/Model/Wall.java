
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Wall extends Entity {
    
    public ImageIcon wall;
    public Wall(int x, int y) {
        super(x, y);
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x,y,30, 30);
    }
   
    public Image getwallImage(int x){
    if (x == 1){
        wall = new ImageIcon("123.jpg");
        return wall.getImage();
    }else if (x == 3){
        wall = new ImageIcon("123_1.jpg");
        return wall.getImage();
    }else if (x == 2){
        wall = new ImageIcon("6789.jpg");
        return wall.getImage();
    }else if (x == 5){
        wall = new ImageIcon("357.jpg");
        return wall.getImage();
    }else if (x == 6){
        wall = new ImageIcon("846.jpg");
        return wall.getImage();
    }
    return wall.getImage();
    }
    
    public Image getobstacleImage(){
    ImageIcon obstacle = new ImageIcon("tree.png");
        return obstacle.getImage();
    }
    
    public Image getgroundImage(){
    ImageIcon ground = new ImageIcon("154141.jpg");
        return ground.getImage();
    }
    
}
