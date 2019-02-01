
package game.Model;

import game.View.Entity;
import game.View.GameFrame;
import static game.View.GameFrame.enemycount;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Weapon extends Entity {
   
    
    
    public Weapon(int x, int y) {
        super(x, y);
    } 
    public static int Currentnumberofbullets=6;
    int maxnumberofbullets=6;
    int indexw;
    public static int score=0;
    public static int flag=0;
    @Override
   public void Update (){  
        switch (indexw) {
            case 2:
                x -=10;
                break;
            case 3:
                y -=10;
                break;
            case 4:
                y +=10;
                break;
            default:
                x+=10;
                break;
        }
       CheckCollision();
   }
    @Override
    public void draw (Graphics2D g2d){
    g2d.drawImage(getWeaponImage(), x,y, null);
    }
    
    public Image getWeaponImage(){
        
    ImageIcon ic = new ImageIcon("Bullet1.png");
        return ic.getImage();
    }
     
     public Rectangle getBounds(){
    return new Rectangle(x+5,y+5,10,10);
    }
     

    
    
     
     public void CheckCollision(){
     ArrayList <Enemy>enemies = GameFrame.getEnemyList();
    ArrayList <Wall> wall = GameFrame.getWallList();
    ArrayList <Gift> gift = GameFrame.getGiftList();
    ArrayList <Bomb> bombs = GameFrame.getBombList();
    ArrayList <Armor> armor = GameFrame.getArmorList();
    ArrayList <Obstacle> obstacless = GameFrame.getObstaclesList();
    for (int i = 0 ; i< enemies.size();i++){
    if (getBounds().intersects(enemies.get(i).getBounds())){
        GameFrame.removeEnemies(enemies.get(i));
        score+=20;
        GameFrame.removeWeapon(this);
        enemycount--;
    }
    }
    if (enemycount == 0){
    flag=1;
    }
    for (int i = 0 ; i< wall.size() ;i++){
    if (getBounds().intersects(wall.get(i).getBounds())){
      GameFrame.removeWeapon(this);
    }}
    
    for (int i = 0 ; i< bombs.size() ;i++){
    if (getBounds().intersects(bombs.get(i).getBounds())){
        bombs.remove(bombs.get(i));
        score+=10;
       GameFrame.removeWeapon(this);
    }
    
   }
    for (int i = 0 ; i< gift.size() ;i++){
    if (getBounds().intersects(gift.get(i).getBounds())){
            gift.remove(gift.get(i));
            GameFrame.removeWeapon(this);
                }
   }
    for (int i = 0 ; i< armor.size() ;i++){
    if (getBounds().intersects(armor.get(i).getBounds())){
        armor.remove(armor.get(i));
        GameFrame.removeWeapon(this);
                }
   }
    
    for (int i = 0 ; i< obstacless.size() ;i++){
    if (getBounds().intersects(obstacless.get(i).getBounds())){
        GameFrame.removeObstacle(obstacless.get(i));
        GameFrame.removeWeapon(this);
                }
   }
   }

    
     
     
     

   
}