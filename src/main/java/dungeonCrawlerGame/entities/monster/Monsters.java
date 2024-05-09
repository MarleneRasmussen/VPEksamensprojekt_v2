package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters {

    private final List<Monster> monsters;

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

    public void checkCollision()
    {
        for (Monster monster : monsters)
        {
            if (monster.getLocationNumber() == DungeonMap.getCurrentWorldLocation())
            {
                if (monster.getPosX() < GameDisplay.player.getPosX() + Config.CELL_SIZE &&
                        monster.getPosX() + Config.CELL_SIZE > GameDisplay.player.getPosX() &&
                        monster.getPosY() < GameDisplay.player.getPosY() + Config.CELL_SIZE &&
                        monster.getPosY() + Config.CELL_SIZE > GameDisplay.player.getPosY())
                {
                    GameDisplay.player.takeDamage(monster.attacks());
                    System.out.println("Player health: " + GameDisplay.player.getHealth());
                }
            }
        }
    }

    public List<Monster> getMonsters()
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
