package dungeonCrawlerGame.entities.monster;

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
                g2d.drawImage(monster.getImage(), monster.getX(), monster.getY(), null);
            }
        }
    }
}
