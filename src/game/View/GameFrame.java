
package game.View;

import game.Controller.Load;
import game.Controller.Save;
import game.Model.Armor;
import game.Model.Bomb;
import game.Model.Checkpoint;
import game.Model.Decorator;
import game.Model.EndPoint;
import game.Model.Enemy;
import game.Model.Gift;
import game.Model.Hero;
import game.Model.KeyAdapt;
import game.Model.Obstacle;
import game.Model.Wall;
import game.Model.Weapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameFrame extends JPanel implements ActionListener, Serializable{
    
    public static int enemycount = 8;
    Timer mainTimer;
    public static Hero player;
    public static ArrayList<Enemy> enemies= new ArrayList<Enemy>();
    public static ArrayList<Weapon> bullets = new ArrayList<Weapon>();
    public static ArrayList<Wall> wall = new ArrayList<Wall>();
    public static ArrayList<Gift> gifts = new ArrayList<Gift>();
    public static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    public static ArrayList<Armor> armor = new ArrayList<Armor>();
    public static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    public static ArrayList<String>players = new ArrayList<String>();

    Random r = new Random();
    public static Checkpoint c=null;
    Save s = new Save();
    Load l=new Load();
    public static EndPoint p = new EndPoint(837,660);
    

    private int [][]maze = 
        { {6,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6},
          {4,0,1,1,1,0,1,0,0,0,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,2},
          {3,0,0,0,0,0,1,0,1,1,1,0,0,1,0,1,0,1,0,1,1,1,1,1,0,0,0,1,0,2},
          {3,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0,7,1,0,0,0,0,0,0,0,0,0,1,0,2},
          {3,0,1,0,0,0,1,0,1,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,1,0,2},
          {3,0,1,0,1,1,1,0,1,0,0,1,0,8,0,0,0,1,1,1,1,1,0,0,0,1,0,1,0,2},
          {3,0,1,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,2},
          {3,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,2},
          {3,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,2},
          {3,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,0,2},
          {3,8,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,2},
          {3,0,0,1,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,2},
          {3,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,1,1,0,1,0,0,2},
          {3,0,1,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,0,2},
          {3,0,1,0,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0,0,2},
          {3,1,1,1,1,0,1,1,0,0,1,0,0,8,0,1,0,0,0,1,0,0,0,0,1,0,1,1,1,2},
          {3,0,1,1,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,2},
          {3,0,0,1,0,0,1,1,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,1,0,0,1,0,0,2},
          {3,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,0,0,1,0,1,0,1,1,0,0,2},
          {3,0,1,1,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,0,2},
          {3,0,0,0,1,0,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,2},
          {3,0,1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,2},
          {3,0,0,0,0,0,0,1,1,1,1,1,0,8,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,2},
          {6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,6}
        };
 
    
    public GameFrame(){
    setFocusable(true);
    setBackground(Color.BLACK);
    player = new Hero(5,25);
    addKeyListener(new KeyAdapt(player));
    mainTimer = new Timer(10,this);
    mainTimer.start();
    
    for (int i = 0 ;i<enemycount ;i++ ){
        while (true) {
            int x = r.nextInt(23), y = r.nextInt(29);
            if (maze[x][y] != 1 && maze[x][y] != 2 && maze[x][y] != 3 && maze[x][y] != 5 && maze[x][y] != 6) {
                addEnemies(new Enemy((y * 30) -5,(x * 30) -2));
                break;
            }
        }
    
    }
    
    for (int i = 0 ;i<3;i++ ){
        while (true) {
            int x = r.nextInt(23), y = r.nextInt(29);
            if (maze[x][y] != 1 && maze[x][y] != 2 && maze[x][y] != 3 && maze[x][y] != 5 && maze[x][y] != 6) {
                addObstacle(new Obstacle((y * 30) -5,(x * 30) -2));
                break;
            }
        }
    
    }
    
    for (int i = 0 ;i<3 ;i++ ){
        while (true) {
            int x = r.nextInt(24), y = r.nextInt(30);
            if (maze[x][y] != 1 && maze[x][y] != 2 && maze[x][y] != 3 && maze[x][y] != 5 && maze[x][y] != 6) 
            {
              gifts.add(new Gift((y * 30) ,(x * 30) ));
                break;
            }
        }
    
    }
    for (int i = 0 ;i<3 ;i++ ){
        while (true) {
            int x = r.nextInt(24), y = r.nextInt(30);
            if (maze[x][y] != 1 && maze[x][y] != 2 && maze[x][y] != 3 && maze[x][y] != 5 && maze[x][y] != 6) 
            {
              bombs.add(new Bomb((y * 30) ,(x * 30) ));
                break;
            }
        }
    
    }
    for (int i = 0 ;i<1 ;i++ ){
        while (true) {
            int x = r.nextInt(24), y = r.nextInt(30);
            if (maze[x][y] != 1 && maze[x][y] != 2 && maze[x][y] != 3 && maze[x][y] != 5 && maze[x][y] != 6) 
            {
              armor.add(new Armor((y * 30) ,(x * 30) ));
                break;
            }
        }
    
    }
    
        try {
            s.savegame(5,25);
            players.add(PlayerName.name);
        } catch (IOException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public GameFrame(String file)
    {
        
        
        l.Loadfile(file);
        setFocusable(true);
    setBackground(Color.BLACK);
    player = new Hero(l.returnPoint().x,l.returnPoint().y);
    addKeyListener(new KeyAdapt(player));
    mainTimer = new Timer(10,this);
    mainTimer.start();
        

    }
    
    @Override
    public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Wall w= new Wall(30*col, 30*row);
                
                 switch (maze[row][col]) {
                      case 1 : addWall(w); g2d.drawImage(w.getwallImage(1), 30*col, 30*row, null);break;
                      case 2 : addWall(w); g2d.drawImage(w.getwallImage(2), 30*col, 30*row, null);break;
                      case 4 : g2d.drawImage(w.getgroundImage(), 30*col, 30*row, null);  player.draw(g2d);break;
                      case 3 : addWall(w); g2d.drawImage(w.getwallImage(3), 30*col, 30*row, null);break;
                      case 5 : addWall(w); g2d.drawImage(w.getwallImage(5), 30*col, 30*row, null);break;
                      case 6 : addWall(w); g2d.drawImage(w.getwallImage(6), 30*col, 30*row, null);break;
                      case 7 :
                      {
                          g2d.drawImage(w.getgroundImage(), 30*col, 30*row, null);
                       if(player.IsSaved()==0){c= new Checkpoint(30*col, 30*row); c.draw(g2d);
                                           ;}
                       else g2d.drawImage(w.getgroundImage(), 30*col, 30*row, null); 
                      }break;
                      
                          
                      default : g2d.drawImage(w.getgroundImage(), 30*col, 30*row, null); 
}}}
    for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Wall w= new Wall(30*col, 30*row);
                
                 switch (maze[row][col]) {
                      case 4 : g2d.drawImage(w.getgroundImage(), 30*col, 30*row, null);  player.draw(g2d);break;
}}}
                
    
        for (int i=0; i < enemies.size();i++){
        Enemy tempenemy = enemies.get(i);
            tempenemy.draw(g2d);
        }
        for (int i=0; i < bullets.size();i++){
         Weapon Weap = bullets.get(i);
            Weap.draw(g2d);
    }
        
        for (int i=0; i < gifts.size();i++){
         gifts.get(i).draw(g2d);
    }
        
        for (int i=0; i < bombs.size();i++){
            bombs.get(i).draw(g2d);
            if(bombs.get(i).IsExploded==true) 
            {
                
                Decorator Instanceomb=new Decorator(bombs.get(i).x,bombs.get(i).y);
                Instanceomb.draw(g2d);
                
                bombs.remove(bombs.get(i));
            }
        }
           for (int i=0; i < armor.size();i++){
         armor.get(i).draw(g2d);
    }
                      for (int i=0; i < obstacles.size();i++){
         obstacles.get(i).draw(g2d);
    }
                      
                      if (Weapon.flag == 1){
       p.draw(g2d);
       }

}

    public static void addtofile (){
    try {
        FileWriter f = new FileWriter("players.txt",true);
        BufferedWriter out = new BufferedWriter(f);
        for (int i=0 ; i<players.size();i++){
        out.append(players.get(i));
        out.newLine();
        }
        out.close();
        f.close();
        }
        catch (IOException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        player.Update();
        
        for (int i=0; i < enemies.size();i++){
            Enemy temp = enemies.get(i);
            temp.Update();
            }
        
        for (int i=0; i < bullets.size();i++){
            Weapon Weap = bullets.get(i);
            Weap.Update();
            }
        
        repaint();
        
    }
    
    
    
    public static void addEnemies(Enemy e){
    enemies.add(e);
    }
    
    public static void removeEnemies(Enemy e){
    enemies.remove(e);
    }
    
    public static ArrayList<Enemy> getEnemyList(){
    return enemies;
    }
    
    public static void addWeapon(Weapon w){
   bullets.add(w);
    }
    public static void addObstacle(Obstacle w){
   obstacles.add(w);
    }
    
    public static void removeWeapon(Weapon w){
    bullets.remove(w);
    }
    
    public static void removeWall(Wall w){
    wall.remove(w);
    }
    
    public static ArrayList<Weapon> getWeaponList(){
    return bullets;
    }
    
    public static void addWall(Wall wa){
    wall.add(wa);
    }

    public static ArrayList<Wall> getWallList(){
    return wall;
    }
    
    public static ArrayList<Gift> getGiftList(){
    return gifts;
    }
    
    public static ArrayList<Bomb> getBombList(){
    return bombs;
    }
    public static ArrayList<Armor> getArmorList(){
    return armor;
    }
    
    public static ArrayList<Obstacle> getObstaclesList(){
    return obstacles;
    }
    public static void removeObstacle(Obstacle w){
    obstacles.remove(w);
    }
}
