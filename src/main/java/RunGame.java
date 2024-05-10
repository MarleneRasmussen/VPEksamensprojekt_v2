import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameManager.GameLoop;
import dungeonCrawlerGame.gameWindow.GameInit;

public class RunGame {

    public static void main(String[] args) {

        new Thread(new GameLoop(new GameInit(Config.LOCATION_WIDTH,Config.LOCATION_HEIGHT))).start();
    }
}
