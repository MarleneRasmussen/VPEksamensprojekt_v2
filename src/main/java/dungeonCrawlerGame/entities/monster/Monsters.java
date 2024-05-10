package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters {

    private static List<Monster> monsters;

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
                if (monster.getPosX() < GameInit.player.getPosX() + Config.CELL_SIZE &&
                        monster.getPosX() + Config.CELL_SIZE > GameInit.player.getPosX() &&
                        monster.getPosY() < GameInit.player.getPosY() + Config.CELL_SIZE &&
                        monster.getPosY() + Config.CELL_SIZE > GameInit.player.getPosY())
                {
                    GameInit.player.takeDamage(monster.attacks());
                    if (KeyAction.attack)
                    {
                        monster.takeDamage(GameInit.player.attacks());
                    }
                    System.out.println("Monster health: " + monster.getHealth());
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
            }
        }
    }
}
