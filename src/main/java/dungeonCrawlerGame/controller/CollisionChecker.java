package dungeonCrawlerGame.controller;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.gameWindow.GameEngine;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.Items;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.Location;
import dungeonCrawlerGame.locations.Cells;

import java.util.List;

public class CollisionChecker {

    public static void checkCellCollision(Entity entity) {
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int entityLeft = entity.getX() + Config.CELL_SIZE / 6;
        int entityRight = entity.getX() + (Config.CELL_SIZE / 6) * 5;
        int entityTop = entity.getY() + Config.CELL_SIZE / 3;
        int entityBottom = entity.getY() + Config.CELL_SIZE;

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

        int playerCenter = player.getX() + Config.CELL_SIZE / 2;
        int playerBottom = player.getY() + Config.CELL_SIZE - 10;

        int playerColumn = playerCenter / Config.CELL_SIZE;
        int playerBottomRow = playerBottom / Config.CELL_SIZE;

        return currentLocation[playerBottomRow][playerColumn];
    }

    public static int checkEntityCollision(Entity entity, List<Monster> monsters) {

        int index = -1;
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {

                Monster monster = monsters.get(i);
                monster.getSolidBounds().x = monster.getX();
                monster.getSolidBounds().y = monster.getY();

                entity.getSolidBounds().x = entity.getX();
                entity.getSolidBounds().y = entity.getY();

                switch (entity.getDirection()) {
                    case UP:
                        entity.getSolidBounds().y -= entity.getSpeed();
                        if (entity.getSolidBounds().intersects(monster.getSolidBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case DOWN:
                        entity.getSolidBounds().y += entity.getSpeed();
                        if (entity.getSolidBounds().intersects(monster.getSolidBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case LEFT:
                        entity.getSolidBounds().x -= entity.getSpeed();
                        if (entity.getSolidBounds().intersects(monster.getSolidBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case RIGHT:
                        entity.getSolidBounds().x += entity.getSpeed();
                        if (entity.getSolidBounds().intersects(monster.getSolidBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                }
            }
        }
        return index;
    }

    public static boolean checkPlayerCollision(Entity entity) {

        boolean playerCollision = false;

        entity.getSolidBounds().x = entity.getX();
        entity.getSolidBounds().y = entity.getY();

        GameEngine.player.getSolidBounds().x = GameEngine.player.getX();
        GameEngine.player.getSolidBounds().y = GameEngine.player.getY();

        switch(entity.getDirection()){
            case UP:
                entity.getSolidBounds().y -= entity.getSpeed();
                if(entity.getSolidBounds().intersects(GameEngine.player.getSolidBounds())){
                    playerCollision = true;
                }
                break;
            case DOWN:
                entity.getSolidBounds().y += entity.getSpeed();
                if(entity.getSolidBounds().intersects(GameEngine.player.getSolidBounds())){
                    playerCollision = true;
                }
                break;
            case LEFT:
                entity.getSolidBounds().x -= entity.getSpeed();
                if(entity.getSolidBounds().intersects(GameEngine.player.getSolidBounds())){
                    playerCollision = true;
                }
                break;
            case RIGHT:
                entity.getSolidBounds().x += entity.getSpeed();
                if(entity.getSolidBounds().intersects(GameEngine.player.getSolidBounds())){
                    playerCollision = true;
                }
                break;
        }
        return playerCollision;
    }

    public static int checkItemCollision(Entity entity) {

        int index = -1;

        for (int i = 0; i < Items.getItem().size(); i++) {
            if (Items.getItem().get(i).getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {
                ItemObject item = Items.getItem().get(i);
                item.itemBounds.x = item.getPosX();
                item.itemBounds.y = item.getPosY();

                entity.getSolidBounds().x = entity.getX();
                entity.getSolidBounds().y = entity.getY();

                switch (entity.getDirection()) {
                    case UP:
                        entity.getSolidBounds().y -= entity.getSpeed();
                        if (entity.getSolidBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case DOWN:
                        entity.getSolidBounds().y += entity.getSpeed();
                        if (entity.getSolidBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case LEFT:
                        entity.getSolidBounds().x -= entity.getSpeed();
                        if (entity.getSolidBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case RIGHT:
                        entity.getSolidBounds().x += entity.getSpeed();
                        if (entity.getSolidBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                }
                entity.getSolidBounds().x = entity.getX();
                entity.getSolidBounds().y = entity.getY();
            }

        }
        return index;
    }
}

