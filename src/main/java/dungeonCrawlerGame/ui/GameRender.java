package dungeonCrawlerGame.ui;

import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.locations.DungeonMap;


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

        LocationRender.drawCurrentLocation(g2d);

        g2d.drawImage(GameDisplay.player.getImage(), GameDisplay.player.getX(), GameDisplay.player.getY(), null);

        GameDisplay.monsters.drawMonsters(g2d);

        //Render objects
        /*for(GameObject gameObject : GameDisplay.gameObjects){
            if (gameObject.getLocation() == DungeonMap.getCurrentWorldLocation()) {
                g2d.drawImage(gameObject.getImage(), gameObject.position.getX(), gameObject.position.getY(), null);
            }*/

        graphics.dispose();
        bufferStrategy.show();
    }
}
