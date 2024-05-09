package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.Player;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.gameManager.GameLogic;
import dungeonCrawlerGame.locations.DungeonMap;

import dungeonCrawlerGame.ui.GameRender;

import java.util.ArrayList;
import java.util.List;

public class GameDisplay {

    //public static List<GameObject> gameObjects;
    public static Monsters monsters;
    public static Player player;

    public GameDisplay(int width, int height) {
        GameFrame gameFrame = new GameFrame(width, height);

        DungeonMap.setDefaultLocation();

        player = new Player();

        monsters = new Monsters();
        monsters.addMonster(new Monster( 100, 100, 1, Direction.DOWN));

        //gameObjects = new ArrayList<>();
        //gameObjects.add(new Monsterssssss(100,100,1, Direction.DOWN));
    }

    public static void renderGame() {
        GameRender.renderGame();
    }

    public static void updateGame() {
        GameLogic.updateGame();
    }
}
