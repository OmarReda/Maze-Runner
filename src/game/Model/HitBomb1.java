
package game.Model;

import game.View.GameFrame;


public class HitBomb1 implements PlayerState{

    public Hero newHero;
    
    public void hitbombnoarmour(){
      newHero = GameFrame.player;
    }
    
    @Override
    public void hitBombNoArmor(int bombtype) {
        if (bombtype==0){
        GameFrame.player.hp-=40;
        System.out.println("hit bomb1");}
    else{
        GameFrame.player.hp-=60;
        System.out.println("hit bomb2");}
        GameFrame.player.setPlayerState(GameFrame.player.yeshitNoArmor());
    }

    @Override
    public void HitBombwithArmor() { }
    
}
