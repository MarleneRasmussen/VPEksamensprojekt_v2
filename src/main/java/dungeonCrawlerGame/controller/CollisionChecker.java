package dungeonCrawlerGame.controller;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.Location;

import dungeonCrawlerGame.locations.Cells;

import java.util.List;

public class CollisionChecker {

    public static void checkCellCollision(Entity entity) {
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int entityLeft = entity.getPosX() + Config.CELL_SIZE / 6;
        int entityRight = entity.getPosX() + (Config.CELL_SIZE / 6) * 5;
        int entityTop = entity.getPosY() + Config.CELL_SIZE / 3;
        int entityBottom = entity.getPosY() + Config.CELL_SIZE;

        int entityRightColumn = entityRight / Config.CELL_SIZE;
        int entityLeftColumn = entityLeft / Config.CELL_SIZE;
        int entityTopRow = entityTop / Config.CELL_SIZE;
        int entityBottomRow = entityBottom / Config.CELL_SIZE;

        Cells cell1;
        Cells cell2;

        switch (entity.getDirection()) {
            case UP:
                entityTopRow = (entityTop - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityLeftColumn];
                cell2 = currentLocation[entityTopRow][entityRightColumn];

                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case DOWN:
                entityBottomRow = (entityBottom + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityBottomRow][entityLeftColumn];
                cell2 = currentLocation[entityBottomRow][entityRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case LEFT:
                entityLeftColumn = (entityLeft - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityLeftColumn];
                cell2 = currentLocation[entityBottomRow][entityLeftColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case RIGHT:
                entityRightColumn = (entityRight + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityRightColumn];
                cell2 = currentLocation[entityBottomRow][entityRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);
                break;
        }
    }

    public static Cells getCurrentCell(Player player) {
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int playerCenter = player.getPosX() + Config.CELL_SIZE / 2;
        int playerBottom = player.getPosY() + Config.CELL_SIZE - 10;

        int playerColumn = playerCenter / Config.CELL_SIZE;
        int playerBottomRow = playerBottom / Config.CELL_SIZE;

        return currentLocation[playerBottomRow][playerColumn];
    }

    public static int checkEntityCollision(Entity player, List<Monster> entity2) {

        int entityLeft = player.getPosX() + Config.CELL_SIZE / 6;
        int entityRight = player.getPosX() + (Config.CELL_SIZE / 6) * 5;
        int entityTop = player.getPosY() + Config.CELL_SIZE / 3;
        int entityBottom = player.getPosY() + Config.CELL_SIZE;

        for (int i = 0; i < entity2.size(); i++) {
            int entity2Left = entity2.get(i).getPosX() + Config.CELL_SIZE / 6;
            int entity2Right = entity2.get(i).getPosX() + (Config.CELL_SIZE / 6) * 5;
            int entity2Top = entity2.get(i).getPosY() + Config.CELL_SIZE / 3;
            int entity2Bottom = entity2.get(i).getPosY() + Config.CELL_SIZE;

            if (entityLeft < entity2Right &&
                    entityRight > entity2Left &&
                    entityTop < entity2Bottom &&
                    entityBottom > entity2Top) {
                return i;
            }
        }
        return -1;
    }
}

