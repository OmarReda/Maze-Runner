
package game.Model;

import game.Controller.Save;
import game.View.Entity;
import game.View.GameFrame;
import static game.View.GameFrame.enemycount;
import game.View.InfoBar;
import game.View.Observer;
import game.View.PlayerChooser;
import game.View.PlayerName;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Hero extends Entity implements Subject{
    int infcounter=0;
    public static int timej=180;
    Save s=new Save();
    int velx=0; int vely=0;
    int[] flagaction={0,0,0,0};
    public static int index = 1;
    public static int hp=100;
    int armorflag=0;
    PlayerChooser p = new PlayerChooser();
    ImageIcon ic = new ImageIcon("player2.png");
    int saved=0;
    Observer observerBar=new InfoBar();
    PlayerState hitbombNoArmor;
    PlayerState hitBombWithArmor;
    
    PlayerState playerState;

    public Hero(int x,int y) {
        super(x,y);
        
        hitbombNoArmor = new HitBomb1();
        hitBombWithArmor = new HitBombWithArmor();
        playerState = hitbombNoArmor;
    }
    
    public void setPlayerState(PlayerState newplayerState){
    playerState = newplayerState;
    }
    
    public void hitBombNoArmor(int bombtype){
    playerState.hitBombNoArmor(bombtype);
    }
    
    public void HitBombwithArmor(){
    playerState.HitBombwithArmor();
    }
     
     public PlayerState yeshitNoArmor(){return hitbombNoArmor;}
     public PlayerState yeshitwitharmor(){return hitBombWithArmor;}

    @Override
    public void Update(){

    if (hp<=0){
    JOptionPane.showMessageDialog(null, "      Ops!, You Have Died"+"\n"+"      Good Luck Next Time");
    System.exit(0);
    }

    
    y += vely;
    x += velx;
    CheckCollision();
    NotifyObservers();
    }
    
    @Override
    public void draw(Graphics2D g2d){
    g2d.drawImage(getPlayerImage(),x,y, null);
    }

    public Image getPlayerImage(){

        if (p.playerflag==0||p.playerflag ==1){
        if (index == 1){
    ImageIcon ic = new ImageIcon("player2.png");
    return ic.getImage();}
        else if (index == 2){
    ImageIcon ic = new ImageIcon("player2_1.png");
    return ic.getImage();}
        else {
    ImageIcon ic = new ImageIcon("player2.png");
    return ic.getImage();}
        }else {
        if (index == 2){
    ImageIcon ic = new ImageIcon("player1.png");
    return ic.getImage();}
        else if (index == 1){
    ImageIcon ic = new ImageIcon("player1_2.png");
    return ic.getImage();}
        else {
    ImageIcon ic = new ImageIcon("player1_2.png");
    return ic.getImage();
                }
        }
    }
    
    public void keyPressed (KeyEvent e){

    int key = e.getKeyCode();

            if (key==KeyEvent.VK_W || key==KeyEvent.VK_UP){
     vely = -4;
     flagaction[0]=1;
     index = 3;
    }
    else if (key==KeyEvent.VK_S || key==KeyEvent.VK_DOWN){
     vely = 4;
     flagaction[1]=1;
     index = 4;
    }
    else if (key==KeyEvent.VK_A || key==KeyEvent.VK_LEFT){
    index = 2;
    velx = -4;
    flagaction[2]=1;
    }
    else if (key==KeyEvent.VK_D || key==KeyEvent.VK_RIGHT){
    index = 1;
    velx = 4;
    flagaction[3]=1;
    }
            else if (key==KeyEvent.VK_SPACE){
               Weapon z= new Weapon(x,y+10);
               if(Weapon.Currentnumberofbullets>0)
               {
    z.indexw=index;
    GameFrame.addWeapon(z);
    Weapon.Currentnumberofbullets--;
    }
    }
            Update();
    }

    public void keyReleased (KeyEvent e){
    flagaction[0]=0;
    flagaction[1]=0;
    flagaction[2]=0;
    flagaction[3]=0;
    int key = e.getKeyCode();

    if (key==KeyEvent.VK_W || key==KeyEvent.VK_UP){
    vely = 0; velx = 0;
    }
    else if (key==KeyEvent.VK_S || key==KeyEvent.VK_DOWN){
    vely = 0; velx = 0;
    }
    else if (key==KeyEvent.VK_A || key==KeyEvent.VK_LEFT){
    velx = 0; vely = 0;
    }
    else if (key==KeyEvent.VK_D || key==KeyEvent.VK_RIGHT){
    velx = 0; vely = 0;
    }



    }

    public Rectangle getBounds(){
    return new Rectangle(x+10,y+10,10,17);
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
        if(enemies.get(i).enemytype==0){
            if(armorflag==1) armorflag=0;
            else hp-=20;
        enemies.remove(enemies.get(i));
        enemycount--;
        System.out.println(hp);
        }
        else
        {
          Weapon.Currentnumberofbullets=Weapon.Currentnumberofbullets-2;
         if(Weapon.Currentnumberofbullets<0) Weapon.Currentnumberofbullets=0;
         enemies.remove(enemies.get(i));
         if(armorflag==1) armorflag=0;
         else hp-=10;
         System.out.println(hp);
         enemycount--;
        }
        if (enemycount==0) Weapon.flag=1;
        }
    }
    for (int i = 0 ; i< obstacless.size() ;i++){
    
    if (
    getBounds().intersects(obstacless.get(i).getBounds())){
    velx=0;
    vely=0;

    if(flagaction[0]==1)
    {y=y+4;
    flagaction[0]=0;
    }
    if(flagaction[1]==1)
    {
    y=y-4;
    flagaction[1]=0;
    }
    if(flagaction[2]==1)
    {x=x+4;
    flagaction[2]=0;
    }
    if(flagaction[3]==1)
    { x=x-4;
    flagaction[3]=0;
    }
    }
    }
    

    for (int i = 0 ; i< wall.size() ;i++){
    if (
    getBounds().intersects(wall.get(i).getBounds())){
    velx=0;
    vely=0;

    if(flagaction[0]==1)
    {y=y+4;
    flagaction[0]=0;
    }
    if(flagaction[1]==1)
    {
    y=y-4;
    flagaction[1]=0;
    }
    if(flagaction[2]==1)
    {x=x+4;
    flagaction[2]=0;
    }
    if(flagaction[3]==1)
    { x=x-4;
    flagaction[3]=0;
    }
    }
    }
    for (int i = 0 ; i< bombs.size() ;i++){
    if (getBounds().intersects(bombs.get(i).getBounds())){
        
        velx = 0; vely = 0;
       
        HitBombwithArmor();
        if (bombs.get(i).bombtype==0)
            hitBombNoArmor(0);
         else 
            hitBombNoArmor(1);
        if (armorflag == 0)playerState = hitbombNoArmor;
        
        
        bombs.get(i).IsExploded=true;
        
        
    
    }

   }
    for (int i = 0 ; i< gift.size() ;i++){
    if (getBounds().intersects(gift.get(i).getBounds())){
        if(gift.get(i).gifttype==0)
        {
            gift.remove(gift.get(i));
            hp+=20;
            if(hp>100) hp=100;
        }
        else{
           gift.remove(gift.get(i));
        Weapon.Currentnumberofbullets+=3;
        }
           Weapon.score+=10;

                }
   }
    for (int i = 0 ; i< armor.size() ;i++){
    if (getBounds().intersects(armor.get(i).getBounds())){
        armor.remove(armor.get(i));
        armorflag=1;
        Weapon.score+=10;
        playerState = hitBombWithArmor;

                }
   }

   if(GameFrame.c!=null){
    if(getBounds().intersects(GameFrame.c.getBounds()))
    {
    GameFrame.c=null;
        try {
            s.savegame(x,y);
            if(!!GameFrame.players.contains(PlayerName.name))GameFrame.players.add(PlayerName.name);
        } catch (IOException ex) {
            Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
        }
    saved=1;
    }}
    
   if (getBounds().intersects(GameFrame.p.getBounds())){
       int Finaltime=(180-Integer.parseInt(InfoBar.time.getText()));
       int FinalScore=Integer.parseInt(InfoBar.score.getText())*Finaltime;
       System.out.println(FinalScore);
       JOptionPane.showMessageDialog(null, "      Wow!, You Win"+"\n"+"      Congratulations"+"\n"+"Your time :"+(Finaltime)+"\n"+"Your Score :" +(FinalScore) );
       System.exit(0);
   }
   
   }

    public int returnindex(){
        System.out.println(index);
        return index;
    }
      public int IsSaved()
{
return saved;
}

    

   @Override
    public void NotifyObservers() {
        InfoBar.t--;
     infcounter++;
     if(infcounter%60==0) {
         timej--;
         observerBar.EnemyUpdate(timej);
     }
        
       observerBar.HeroUpdate(hp, Weapon.score, Weapon.Currentnumberofbullets,armorflag,timej);
    }
}
