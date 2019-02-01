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
import java.util.Random;
import javax.swing.ImageIcon;


public class Gift extends Entity {    
    Random r = new Random();
    public int gifttype=r.nextInt(2);
    
    public Gift(int x, int y) {
        super(x, y);
    }
    
    @Override
     public void Update (){}
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getGiftImage(), x,y, null);
    }
  
    public Image getGiftImage(){
      ImageIcon ic;  
    if(gifttype==0) ic = new ImageIcon("health.png");
    else     ic = new ImageIcon("1234.png");
    return ic.getImage();
    }
    
    public Rectangle getBounds(){
    return new Rectangle(x,y,25,30);
    }
}
