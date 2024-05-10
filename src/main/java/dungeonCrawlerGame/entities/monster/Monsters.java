package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.entities.EnemyProperties;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters {

    private static List<Monster> monsters;
    private int damageCounter = 0;
    private int staminaCounter = 0;

    public Monsters()
    {
        monsters = new ArrayList<Monster>();
    }

    public void addMonster(Monster monster)
    {
        monsters.add(monster);
    }

    public void updateMonsters()
    {
        for (Monster monster : monsters)
        {
            monster.moveEntity();
        }
    }

    public void checkDead()
    {
        for (Monster monster : monsters)
        {
            if (monster.getHealth() <= 0)
            {
                //Location number 0 is the graveyard for monsters
                monster.setLocationNumber(0);
            }
        }
    }

    public void checkCollision()
    {
        for (Monster monster : monsters)
        {
            if (monster.getLocationNumber() == DungeonMap.getCurrentWorldLocation())
            {
                if (CollisionChecker.checkEntityCollision(GameInit.player, monster)){
                    damageCounter++;
                    if (damageCounter == 30)
                    {
                        damageCounter = 0;
                        GameInit.player.takeDamage(monster.attacks());
                    }
                    //System.out.println("Player health: " + GameInit.player.getHealth());
                    if (KeyAction.attack)
                    {
                        staminaCounter++;
                        if (staminaCounter == 10 && GameInit.player.getStamina() > 0)
                        {
                            staminaCounter = 0;
                            GameInit.player.setStamina(Config.STAMINA_REDUCE);
                            monster.takeDamage(GameInit.player.attacks());
                        }
                    }
                    //System.out.println("Monster health: " + monster.getHealth());
                }
            }
        }
    }

    public static List<Monster> getMonsters()
    {
        return monsters;
    }

    public void drawMonsters(Graphics2D g2d)
    {
        for (Monster monster : monsters)
        {
            if (monster.getLocationNumber() == DungeonMap.getCurrentWorldLocation())
            {
                g2d.drawImage(monster.getImage(), monster.getPosX(), monster.getPosY(), null);

                int healthBarWidth = (int) (monster.getHealth() / EnemyProperties.getHealth(monster.getEnemy()) * Config.CELL_SIZE);
                g2d.setColor(new Color(50,0,0));
                g2d.fillRoundRect( monster.getPosX()-3, monster.getPosY() - 23, Config.CELL_SIZE+6, 21, 10, 10);

                g2d.setColor(new Color(255,0,60));
                g2d.fillRoundRect( monster.getPosX(), monster.getPosY() - 20, healthBarWidth, 15, 10, 10);
            }
        }
    }
}
