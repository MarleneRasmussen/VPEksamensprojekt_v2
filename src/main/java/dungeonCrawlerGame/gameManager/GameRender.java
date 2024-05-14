package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameEngine;
import dungeonCrawlerGame.locations.LocationRender;

import java.awt.*;
import java.awt.image.BufferStrategy;

import static dungeonCrawlerGame.gameWindow.GameFrame.canvas;

public class GameRender {

    public static void renderGame() {

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) graphics;

        //Draw current location
        LocationRender.drawCurrentLocation(g2d);

        //Draw player
        g2d.drawImage(GameEngine.player.getImage(), GameEngine.player.getX(), GameEngine.player.getY(), Config.CELL_SIZE, Config.CELL_SIZE, null);

        //Draw items in current location
        GameEngine.items.drawItems(g2d);

        //Draw monsters in current location
        GameEngine.monsters.drawMonsters(g2d);

        //Draw player health bar
        GameEngine.playerState.renderPlayerHP(g2d);

        //Draw player attack bar
        GameEngine.playerState.renderPlayerStamina(g2d);
        GameEngine.playerState.renderInventoryValue(g2d);
        GameEngine.playerState.renderInventoryImages(g2d);

        graphics.dispose();
        bufferStrategy.show();
    }
}


