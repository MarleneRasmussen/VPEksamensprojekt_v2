package dungeonCrawlerGame.controller;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.Player;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.Location;

import dungeonCrawlerGame.ui.Cells;

public class CheckCell {

    public static boolean collision;

    public static void checkCellCollision(Entity entity){
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int playerLeft = entity.getPosX() + Config.CELL_SIZE/6;
        int playerRight = entity.getPosX() + (Config.CELL_SIZE/6)*5;
        int playerTop = entity.getPosY() + Config.CELL_SIZE/3;
        int playerBottom = entity.getPosY() + Config.CELL_SIZE;

        int playerRightColumn = playerRight / Config.CELL_SIZE;
        int playerLeftColumn = playerLeft / Config.CELL_SIZE;
        int playerTopRow = playerTop / Config.CELL_SIZE;
        int playerBottomRow = playerBottom / Config.CELL_SIZE;

        Cells cell1;
        Cells cell2;

        switch (entity.getDirection()) {
            case UP:
                playerTopRow = (playerTop - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[playerTopRow][playerLeftColumn];
                cell2 = currentLocation[playerTopRow][playerRightColumn];

                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case DOWN:
                playerBottomRow = (playerBottom + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[playerBottomRow][playerLeftColumn];
                cell2 = currentLocation[playerBottomRow][playerRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case LEFT:
                playerLeftColumn = (playerLeft - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[playerTopRow][playerLeftColumn];
                cell2 = currentLocation[playerBottomRow][playerLeftColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case RIGHT:
                playerRightColumn = (playerRight + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[playerTopRow][playerRightColumn];
                cell2 = currentLocation[playerBottomRow][playerRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);
                break;
        }
    }

    public static Cells getCurrentCell(Player player){
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int playerCenter = player.getPosX() + Config.CELL_SIZE/2;
        int playerBottom = player.getPosY() + Config.CELL_SIZE - 10;

        int playerColumn = playerCenter / Config.CELL_SIZE;
        int playerBottomRow = playerBottom / Config.CELL_SIZE;

        return currentLocation[playerBottomRow][playerColumn];
    }
}
