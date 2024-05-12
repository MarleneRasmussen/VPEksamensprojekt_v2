package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.EnemyProperties;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.entities.player.PlayerState;
import dungeonCrawlerGame.gameManager.GameUpdate;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.ItemProperties;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.gameManager.GameRender;

public class GameInit {

    public static Monsters monsters;
    public static Player player;
    public static dungeonCrawlerGame.items.Items items;
    public static PlayerState playerState;
    public static int currentLocationNum;

    public static int gameState;

    public static final int gameRunning = 1;
    public static final int gamePaused = 2;
    public static final int gameOver = 3;

    public GameInit(int width, int height) {
        GameFrame gameFrame = new GameFrame(width, height);

        gameState = gameRunning;

        DungeonMap.setDefaultLocation();

        player = new Player();
        playerState = new PlayerState();

        items = new dungeonCrawlerGame.items.Items();
        items.addItem(new ItemObject(200,300, 1, ItemProperties.DOOR));
        items.addItem(new ItemObject(400,300, 1, ItemProperties.KEY));


        monsters = new Monsters();
    }

    public static void renderGame() {
        GameRender.renderGame();
    }

    public static void updateGame() {
        GameUpdate.updateGame();
    }
}
