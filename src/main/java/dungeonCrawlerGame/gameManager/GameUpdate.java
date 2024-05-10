package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.LocationRender;

public class GameUpdate {

        public static void updateGame(){
                GameInit.monsters.updateMonsters();
                GameInit.monsters.checkCollision();
                GameInit.player.moveEntity();
                GameInit.currentLocationNum = DungeonMap.getCurrentWorldLocation();
                GameInit.monsters.checkDead();
                LocationRender.getNewLocation();
        }
}
