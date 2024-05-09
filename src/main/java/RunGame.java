import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameManager.GameLoop;
import dungeonCrawlerGame.gameWindow.GameDisplay;

public class RunGame {

    public static void main(String[] args) {

        new Thread(new GameLoop(new GameDisplay(Config.LOCATION_WIDTH,Config.LOCATION_HEIGHT))).start();
    }
}
