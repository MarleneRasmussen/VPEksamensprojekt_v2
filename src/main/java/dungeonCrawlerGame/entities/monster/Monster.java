package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.EntityAnimation;
import dungeonCrawlerGame.gameWindow.GameEngine;

import java.awt.*;
import java.util.Random;

public class Monster implements Entity {

    private int x;
    private int y;
    private int locationNumber;
    private Direction direction;
    private final Rectangle solidBounds = new Rectangle(x, y, Config.CELL_SIZE, Config.CELL_SIZE);

    private int health;
    private int damage;

    private boolean collision;
    boolean playerCollision;

    private Image image;
    private int imageNumber;
    private int imageDelay;
    private int turnCounter = 0;

    private final MonsterProperties monsterProperties;

    public Monster(int x, int y, int locationNumber, MonsterProperties monsterProperties) {
        this.x = x;
        this.y = y;
        this.locationNumber = locationNumber;
        this.monsterProperties = monsterProperties;
    }

    @Override
    public void setPlayerMonsterCollision(boolean playerMonsterCollision){
        this.playerCollision = playerMonsterCollision;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getLocationNumber() {
        return this.locationNumber;
    }

    @Override
    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public int getSpeed() {
        return MonsterProperties.getSpeed(this.monsterProperties);
    }

    @Override
    public void move() {
        //Cant move out of the location
        if (x >= Config.CELL_SIZE && y >= Config.CELL_SIZE && x + Config.CELL_SIZE <= Config.LOCATION_WIDTH - Config.CELL_SIZE &&
                y + Config.CELL_SIZE <= Config.LOCATION_HEIGHT - Config.CELL_SIZE && !collision) {
            moveRandom();
            getImageNumber();
        }
        imageDelay++;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public void attack() {
        GameEngine.player.takeDamage(damage);
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public Rectangle getSolidBounds() {
        return this.solidBounds;
    }

    @Override
    public Image getImage() {
        return monsterProperties.getImage(this.imageNumber, this.direction);
    }

    @Override
    public void getImageNumber() {
        this.imageNumber = EntityAnimation.getImageNumber(this.imageNumber, this.imageDelay);
    }

    public void moveRandom() {
        turnCounter++;
        if (turnCounter == 10) {
            Random random = new Random();
            int i = random.nextInt(4);
            switch (i) {
                case 0:
                    direction = Direction.RIGHT;
                    break;
                case 1:
                    direction = Direction.LEFT;
                    break;
                case 2:
                    direction = Direction.UP;
                    break;
                case 3:
                    direction = Direction.DOWN;
                    break;
            }
            turnCounter = 0;
        }

        if(!collision) {
            switch (direction) {
                case RIGHT:
                    x += MonsterProperties.getSpeed(monsterProperties);
                    break;
                case LEFT:
                    x -= MonsterProperties.getSpeed(monsterProperties);
                    break;
                case UP:
                    y -= MonsterProperties.getSpeed(monsterProperties);
                    break;
                case DOWN:
                    y += MonsterProperties.getSpeed(monsterProperties);
                    break;
            }
        }
    }

    public MonsterProperties getMonsterProperties() {
        return this.monsterProperties;
    }

}
