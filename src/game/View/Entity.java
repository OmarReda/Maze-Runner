
package game.View;

import java.awt.Graphics2D;


public abstract class Entity {

    public int x,y; 
    
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
   
    public void Update (){
    }
    
    public void draw (Graphics2D g2d){
    
    }
}
