package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameEngine;

import java.awt.*;

public class GameLoop implements Runnable{

    private GameEngine game;
    private boolean running;

    public GameLoop(GameEngine game){
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double nextDraw = System.nanoTime() + Config.INTERVAL;

        while (running){
            GameEngine.updateGame();
            GameEngine.renderGame();

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
