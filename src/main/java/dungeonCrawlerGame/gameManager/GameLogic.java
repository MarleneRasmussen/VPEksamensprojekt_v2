package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.gameManager.tools.CollisionDetector;

import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.ui.LocationRender;

public class GameLogic {

        public static void updateGame(){
                GameDisplay.monsters.updateMonsters();
                //CollisionDetector.checkObjectCollisions(GameDisplay.gameObjects, GameDisplay.player);
                GameDisplay.player.moveEntity();
                LocationRender.getNewLocation();
        }
}
