package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameDisplay;

public class GameLoop implements Runnable{

    private GameDisplay gameDisplay;
    private boolean running;

    public GameLoop(GameDisplay gameDisplay){
        this.gameDisplay = gameDisplay;
    }

    @Override
    public void run() {
        running = true;
        double nextDraw = System.nanoTime() + Config.INTERVAL;

        while (running){
            GameDisplay.updateGame();
            GameDisplay.renderGame();

            try {
                double remaining = nextDraw - System.nanoTime();
                if(remaining > 0)
                    Thread.sleep((long) (remaining / 1000000));
                nextDraw += Config.INTERVAL;
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
