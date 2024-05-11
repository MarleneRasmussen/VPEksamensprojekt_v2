package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.LocationRender;

public class GameUpdate {

        public static void updateGame(){
                if (GameInit.gameState == GameInit.gameRunning){
                        GameInit.monsters.updateMonsters();
                        GameInit.player.moveEntity();
                        GameInit.currentLocationNum = DungeonMap.getCurrentWorldLocation();
                        GameInit.monsters.checkDead();
                        LocationRender.getNewLocation();
                        GameInit.player.increaseStamina();
                        GameInit.monsters.checkForDamage();
                        GameInit.monsters.checkDead();
                }
        }
}
