package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.MonsterProperties;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MonsterManager {
    private static List<Monster> monsters;
    private int attackCounter = 0;

    public MonsterManager() {
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {

        monsters.add(monster);
    }

    public void updateMonsters()
    {
        for (Monster monster : monsters)
        {
            monster.move();
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
        for (int i = 0; i < monsters.size(); i++)
        {
            monsters.get(i).setCollision(false);
            monsters.get(i).setPlayerMonsterCollision(false);

            CollisionChecker.checkEntityCollision(monsters.get(i),getMonsters());
            int index = CollisionChecker.checkEntityCollision(monsters.get(i),getMonsters());
            if (i == index)
            {
                monsters.get(i).setCollision(false);
            }
            if (CollisionChecker.checkPlayerCollision(monsters.get(i))){
                attackCounter++;
                if(attackCounter == 10){
                    monsters.get(i).attack();
                    attackCounter = 0;
                }
            }
            //CollisionChecker.checkItemCollision(monsters.get(i));
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
                g2d.drawImage(monster.getImage(), monster.getX(), monster.getY(), Config.CELL_SIZE, Config.CELL_SIZE, null);

                double monsterHealth = monster.getHealth();
                double monsterMaxHealth = MonsterProperties.getHealth(monster.getMonsterProperties());
                int monsterHealthBar = (int) ((monsterHealth / monsterMaxHealth) * Config.CELL_SIZE);

                g2d.setColor(new Color(50,0,0));
                g2d.fillRoundRect( monster.getX()-3, monster.getY() - 23, Config.CELL_SIZE+6, 21, 10, 10);

                g2d.setColor(new Color(255,0,60));
                g2d.fillRoundRect( monster.getX(), monster.getY() - 20, monsterHealthBar, 15, 10, 10);
            }
        }
    }
}
