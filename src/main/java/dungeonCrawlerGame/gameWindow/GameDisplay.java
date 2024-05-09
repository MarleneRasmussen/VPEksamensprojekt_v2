package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.EnemyProperties;
import dungeonCrawlerGame.entities.Player;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.gameManager.GameLogic;
import dungeonCrawlerGame.locations.DungeonMap;

import dungeonCrawlerGame.ui.GameRender;


public class GameDisplay {

    public static Monsters monsters;
    public static Player player;
    public static int currentLocationNum;

    public GameDisplay(int width, int height) {
        GameFrame gameFrame = new GameFrame(width, height);

        DungeonMap.setDefaultLocation();

        player = new Player();

        monsters = new Monsters();
        monsters.addMonster(new Monster( 100, 100, 1, Direction.DOWN, EnemyProperties.SKELETON));
        monsters.addMonster(new Monster( 100, 100,  2, Direction.RIGHT, EnemyProperties.BAT));

    }

    public static void renderGame() {
        GameRender.renderGame();
    }

    public static void updateGame() {
        GameLogic.updateGame();
    }
}
