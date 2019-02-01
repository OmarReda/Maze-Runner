
package game.Controller;

import game.Model.Armor;
import game.Model.Bomb;
import game.Model.Enemy;
import game.Model.Gift;
import game.Model.Hero;
import game.Model.Obstacle;
import game.Model.Weapon;
import game.View.GameFrame;
import game.View.InfoBar;
import game.View.PlayerName;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Load {
    
    public Point xyz=new Point();
    
    public void Loadfile(String Fil)
    {
     PlayerName.name=Fil;
    Fil=Fil+".txt";
        try {
           Scanner  g = new Scanner(new File(Fil));
           Weapon.score=Integer.parseInt(g.nextLine());
            System.out.println(Weapon.score);
           Weapon.Currentnumberofbullets=Integer.parseInt(g.nextLine());
           Hero.hp=Integer.parseInt(g.nextLine());
           Hero.timej=Integer.parseInt(g.nextLine());
           String line=g.nextLine();
           
            String[] Contents= line.split(",");
            xyz.x=Integer.parseInt(Contents[0]);
            xyz.y=Integer.parseInt(Contents[1]);
            int J=Integer.parseInt(g.nextLine());
            GameFrame.enemycount=J;
            for(int i=0;i<J;i++)
            {
                line=g.nextLine();
                Contents= line.split(",");
                Enemy newEnemy=new Enemy(Integer.parseInt(Contents[0]),Integer.parseInt(Contents[1]));
                newEnemy.enemytype=Integer.parseInt(Contents[2]);
                newEnemy.face=Integer.parseInt(Contents[3]);
                newEnemy.go=Integer.parseInt(Contents[4]);
                GameFrame.enemies.add(newEnemy);
            }
            
            J=Integer.parseInt(g.nextLine());
            for(int i=0;i<J;i++)
            {
                line=g.nextLine();
                Contents= line.split(",");
                Bomb newBomb=new Bomb(Integer.parseInt(Contents[0]),Integer.parseInt(Contents[1]));
                newBomb.bombtype=Integer.parseInt(Contents[2]);
                GameFrame.bombs.add(newBomb);
            }
            
            J=Integer.parseInt(g.nextLine());
            for(int i=0;i<J;i++)
            {
                line=g.nextLine();
                Contents= line.split(",");
                Gift newGift=new Gift(Integer.parseInt(Contents[0]),Integer.parseInt(Contents[1]));
                newGift.gifttype=Integer.parseInt(Contents[2]);
                GameFrame.gifts.add(newGift);
            }
            J=Integer.parseInt(g.nextLine());
            for(int i=0;i<J;i++)
            {
                line=g.nextLine();
                Contents= line.split(",");
                Obstacle newObstacle=new Obstacle(Integer.parseInt(Contents[0]),Integer.parseInt(Contents[1]));
                GameFrame.obstacles.add(newObstacle);
            }
            
            J=Integer.parseInt(g.nextLine());
            for(int i=0;i<J;i++)
            {
                line=g.nextLine();
                Contents= line.split(",");
                Armor newArmor=new Armor(Integer.parseInt(Contents[0]),Integer.parseInt(Contents[1]));
                GameFrame.armor.add(newArmor);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
    public Point returnPoint()
    {
        return xyz;
    }
            
}

