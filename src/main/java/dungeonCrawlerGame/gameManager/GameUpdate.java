package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.entities.player.PlayerState;
import dungeonCrawlerGame.gameWindow.GameEngine;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.LocationRender;

public class GameUpdate {

        public static void updateGame() {
                if (GameEngine.gameState == GameEngine.gamePaused) {
                        return;
                } else if (GameEngine.gameState == GameEngine.gameOver) {
                        return;
                }else {

                        GameEngine.monsters.checkCollision();
                        GameEngine.monsters.updateMonsters();
                        GameEngine.player.move();
                        GameEngine.currentLocationNum = DungeonMap.getCurrentWorldLocation();
                        GameEngine.monsters.checkDead();
                        LocationRender.getNewLocation();
                        GameEngine.player.increaseStamina();
                        GameEngine.monsters.checkDead();
                        GameEngine.items.checkIfPickedUp();
                        PlayerState.useFromInventory();
                }
        }
}

