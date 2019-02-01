
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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Save {
    
    String x = PlayerName.name+".txt"; 
    
    public void fileGenerate(int z,int y) throws IOException{
        try {
        
        FileWriter f = new FileWriter(x);
        BufferedWriter out = new BufferedWriter(f);
        out.write(String.valueOf(Weapon.score));
        out.newLine();
        out.write(String.valueOf(Weapon.Currentnumberofbullets));
        out.newLine();
        out.write(String.valueOf(Hero.hp));
        out.newLine();
        out.write(String.valueOf(Hero.timej));
        out.newLine();
        out.write(String.valueOf(z)+","+String.valueOf(y));
        out.newLine();
        ArrayList<Enemy> list= new ArrayList<>();
        list=GameFrame.getEnemyList();
        out.write(String.valueOf(list.size()));
        out.newLine();
        for(int i=0;i<GameFrame.getEnemyList().size();i++)
        {
            out.write(String.valueOf(list.get(i).x)+","+String.valueOf(list.get(i).y)+","+String.valueOf(list.get(i).enemytype));
                    out.write(","+String.valueOf(list.get(i).face)+","+String.valueOf(list.get(i).go));
                    out.newLine();
        }
        ArrayList<Bomb> list1= new ArrayList<>();
        list1=GameFrame.getBombList();
        out.write(String.valueOf(list1.size()));
        out.newLine();
        for(int i=0;i<GameFrame.getBombList().size();i++)
        {
            out.write(String.valueOf(list1.get(i).x)+","+String.valueOf(list1.get(i).y)+","+String.valueOf(list1.get(i).bombtype));
            out.newLine();
        }
        ArrayList<Gift> list2= new ArrayList<>();
        list2=GameFrame.getGiftList();
        out.write(String.valueOf(list2.size()));
        out.newLine();
        for(int i=0;i<GameFrame.getGiftList().size();i++)
        {
            out.write(String.valueOf(list2.get(i).x)+","+String.valueOf(list2.get(i).y)+","+String.valueOf(list2.get(i).gifttype));
            out.newLine();
        }
        ArrayList<Obstacle> list3= new ArrayList<>();
        list3=GameFrame.getObstaclesList();
        out.write(String.valueOf(list3.size()));
        out.newLine();
        for(int i=0;i<GameFrame.getObstaclesList().size();i++)
        {
            out.write(String.valueOf(list3.get(i).x)+","+String.valueOf(list3.get(i).y));
            out.newLine();
        }
        ArrayList<Armor> list4= new ArrayList<>();
        list4=GameFrame.getArmorList();
        out.write(String.valueOf(list4.size()));
        out.newLine();
        for(int i=0;i<GameFrame.getArmorList().size();i++)
        {
            out.write(String.valueOf(list4.get(i).x)+","+String.valueOf(list4.get(i).y));
            out.newLine();
        }
        
        out.close();    
        f.close();
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	}
    }
    
    public void savegame(int z,int y) throws IOException{
       fileGenerate(z,y);
    }
}
    
