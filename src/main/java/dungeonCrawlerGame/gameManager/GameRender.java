package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.LocationRender;


import java.awt.*;
import java.awt.image.BufferStrategy;

import static dungeonCrawlerGame.gameWindow.GameFrame.canvas;

public class GameRender {

    public static void renderGame(){

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) graphics;

        //Set background color
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Draw current location
        LocationRender.drawCurrentLocation(g2d);

        //Draw player
        g2d.drawImage(GameInit.player.getImage(),GameInit.player.getPosX(), GameInit.player.getPosY() , Config.CELL_SIZE, Config.CELL_SIZE, null);
        //g2d.drawImage(GameInit.player.getImage(), GameInit.player.getPosX(), GameInit.player.getPosY(), null);

        //Draw monsters in current location
        GameInit.monsters.drawMonsters(g2d);

        graphics.dispose();
        bufferStrategy.show();
    }
}
