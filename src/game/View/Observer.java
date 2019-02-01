
package game.View;


public interface Observer {
    
    public void HeroUpdate(int hp,int Score,int nobullets,int armorstate,int timeU);
    public void EnemyUpdate(int timeU);


    
}
