package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.ui.LocationRender;

public class GameLogic {

        public static void updateGame(){
                GameDisplay.monsters.updateMonsters();
                GameDisplay.monsters.checkCollision();
                GameDisplay.player.moveEntity();
                GameDisplay.currentLocationNum = DungeonMap.getCurrentWorldLocation();
                LocationRender.getNewLocation();
        }
}
