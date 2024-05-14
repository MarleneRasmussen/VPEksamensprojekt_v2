package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.MonsterManager;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.MonsterProperties;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.entities.player.PlayerState;
import dungeonCrawlerGame.gameManager.GameUpdate;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.ItemProperties;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.gameManager.GameRender;

public class GameEngine {

    public static MonsterManager monsters;
    public static Player player;
    public static dungeonCrawlerGame.items.Items items;
    public static PlayerState playerState;
    public static int currentLocationNum;

    public static int gameState;
    public static final int gameMenu = 0;
    public static final int gameRunning = 1;
    public static final int gamePaused = 2;
    public static final int gameOver = 3;

    public GameEngine(int width, int height) {
        GameFrame gameFrame = new GameFrame(width, height);
        GameInit();
        gameState = gameRunning;
    }

    public static void GameInit() {
        DungeonMap.setDefaultLocation();

        player = new Player();
        playerState = new PlayerState();

        items = new dungeonCrawlerGame.items.Items();
        items.addItem(new ItemObject(2 * Config.CELL_SIZE, 2 * Config.CELL_SIZE, 1, ItemProperties.KEY));
        items.addItem(new ItemObject(14 * Config.CELL_SIZE, 9 * Config.CELL_SIZE, 1, ItemProperties.DOOR));

        items.addItem(new ItemObject(7 * Config.CELL_SIZE, 5 * Config.CELL_SIZE, 2, ItemProperties.DOOR));
        items.addItem(new ItemObject(6 * Config.CELL_SIZE, Config.CELL_SIZE, 2, ItemProperties.POTION));

        items.addItem(new ItemObject(3 * Config.CELL_SIZE, 5 * Config.CELL_SIZE, 3, ItemProperties.DOOR));
        items.addItem(new ItemObject(13 * Config.CELL_SIZE, 9 * Config.CELL_SIZE, 3, ItemProperties.DOOR));
        items.addItem(new ItemObject(10 * Config.CELL_SIZE, 3 * Config.CELL_SIZE, 3, ItemProperties.KEY));
        items.addItem(new ItemObject(Config.CELL_SIZE, 8 * Config.CELL_SIZE, 3, ItemProperties.POTION));

        items.addItem(new ItemObject(5 * Config.CELL_SIZE, 9 * Config.CELL_SIZE, 4, ItemProperties.DOOR));

        items.addItem(new ItemObject(14 * Config.CELL_SIZE, 6 * Config.CELL_SIZE, 5, ItemProperties.POTION));

        items.addItem(new ItemObject(13 * Config.CELL_SIZE, 9 * Config.CELL_SIZE, 6, ItemProperties.DOOR));
        items.addItem(new ItemObject(2 * Config.CELL_SIZE, 2 * Config.CELL_SIZE, 6, ItemProperties.KEY));

        items.addItem(new ItemObject(6 * Config.CELL_SIZE, 2 * Config.CELL_SIZE, 7, ItemProperties.KEY));
        items.addItem(new ItemObject(16 * Config.CELL_SIZE, 8 * Config.CELL_SIZE, 7, ItemProperties.KEY));
        items.addItem(new ItemObject(3 * Config.CELL_SIZE, Config.CELL_SIZE, 7, ItemProperties.POTION));

        items.addItem(new ItemObject(2 * Config.CELL_SIZE, 2 * Config.CELL_SIZE, 9, ItemProperties.KEY));

        items.addItem(new ItemObject(11 * Config.CELL_SIZE, 6 * Config.CELL_SIZE, 10, ItemProperties.POTION));

        items.addItem(new ItemObject(5 * Config.CELL_SIZE, 8 * Config.CELL_SIZE, 11, ItemProperties.KEY));

        items.addItem(new ItemObject(8 * Config.CELL_SIZE, 6 * Config.CELL_SIZE, 12, ItemProperties.DOOR));
        items.addItem(new ItemObject(9 * Config.CELL_SIZE, 4 * Config.CELL_SIZE, 12, ItemProperties.POTION));

        monsters = new MonsterManager();
        //monsters.addMonster(new Monster(400,200,1, MonsterProperties.BAT));
    }

    public static void renderGame() {
        GameRender.renderGame();
    }

    public static void updateGame() {
        if (gameState == gameRunning){
            GameUpdate.updateGame();
        }
    }
}

