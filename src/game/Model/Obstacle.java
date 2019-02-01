/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Model;

import game.View.Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Obstacle extends Entity{


    public Obstacle(int x, int y) {
    super(x, y);
    }
    
    @Override
     public void Update (){}
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getObstacleImage(), x,y, null);
    }
  
    public Image getObstacleImage(){
        ImageIcon ic = new ImageIcon("Tree.png");
        return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x+10,y+10,20,20);
    }

   
    
}

