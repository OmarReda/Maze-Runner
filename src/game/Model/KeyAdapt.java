
package game.Model;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter{
    
    Hero p;
    
    public KeyAdapt (Hero player){
     p = player;
     
    }
    public void keyPressed (KeyEvent e){
    p.keyPressed(e);
    }
    public void keyReleased (KeyEvent e){
    p.keyReleased(e);
    }
    
}
