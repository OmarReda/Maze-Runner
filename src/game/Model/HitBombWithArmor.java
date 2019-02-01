
package game.Model;

import game.View.GameFrame;


public class HitBombWithArmor implements PlayerState {

    public Hero newHero;
    //PlayerState playerState=GameFrame.player.hitbombNoArmor;
    public void hitbombwitharmour(){
    newHero = GameFrame.player;
    }
    
    @Override
    public void hitBombNoArmor(int bombtype) { }

    @Override
    public void HitBombwithArmor() {
        if (GameFrame.player.armorflag==1)GameFrame.player.armorflag=0;
        System.out.println("hit bomb with armour");        GameFrame.player.playerState = GameFrame.player.hitbombNoArmor;
        GameFrame.player.setPlayerState(GameFrame.player.yeshitwitharmor());
    }
    
}
