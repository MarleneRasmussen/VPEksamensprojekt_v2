package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CheckCell;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.EnemyProperties;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.Player;
import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Monster implements Entity {

    Player player = GameDisplay.player;

    private int posX;
    private int posY;
    private double health;
    private int locationNumber;
    public Direction direction;
    private Image image;
    private double damage;
    private boolean dead;
    private boolean collision;

    private int monsterSpeed;
    private EnemyProperties enemy;
    private int startPosX;
    private int startPosY;
    private int endPosX;
    private int endPosY;
    private boolean goBack = false;
    private int turnCounter = 0;

    public Monster(int startX, int startY, int location, Direction direction, EnemyProperties enemy) {
        this.posX = startX;
        this.posY = startY;
        this.locationNumber = location;
        this.direction = direction;
        this.health = EnemyProperties.getHealth(enemy);
        this.damage = EnemyProperties.getDamage(enemy);
        this.enemy = enemy;
    }

    @Override
    public void moveEntity() {
        collision = false;
        // Follow player if same location and player is nearby

        if (playerIsPlayerNearby() && locationNumber == DungeonMap.getCurrentWorldLocation()) {
            monsterSpeed = EnemyProperties.getHuntingSpeed(enemy);
            CheckCell.checkCellCollision(this);

            if (!collision)
                if (player.getPosX() >= posX + Config.CELL_SIZE) {
                    direction = Direction.RIGHT;
                    posX += monsterSpeed;
                } else if (player.getPosX() <= posX - Config.CELL_SIZE) {
                    direction = Direction.LEFT;
                    posX -= monsterSpeed;
                }

            if (player.getPosY() >= posY + Config.CELL_SIZE) {
                direction = Direction.DOWN;
                posY += monsterSpeed;
            } else if (player.getPosY() <= posY - Config.CELL_SIZE) {
                direction = Direction.UP;
                posY -= monsterSpeed;
            }
        } else {
            monsterSpeed = EnemyProperties.getSpeed(enemy);
            moveRandom();
        }
    }

    private void moveRandom() {

        turnCounter ++;
        if (turnCounter == 20) {
            Random random = new Random();
            int i = random.nextInt(10);
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
        CheckCell.checkCellCollision(this);
        if(!collision) {
            switch (direction) {
                case RIGHT:
                    posX += monsterSpeed;
                    break;
                case LEFT:
                    posX -= monsterSpeed;
                    break;
                case UP:
                    posY -= monsterSpeed;
                    break;
                case DOWN:
                    posY += monsterSpeed;
                    break;
            }
        }
    }

    private boolean playerIsPlayerNearby() {
        int distance = Config.CELL_SIZE * 2;
        if (posX < player.getPosX() + distance &&
                posX + Config.CELL_SIZE + distance > player.getPosX() &&
                posY < player.getPosY() + distance &&
                posY + Config.CELL_SIZE + distance > player.getPosY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getPosX() {
        return this.posX;
    }

    @Override
    public int getPosY() {
        return this.posY;
    }

    @Override
    public double getHealth() {
       return this.health;
    }

    @Override
    public void takeDamage(double i) {
        health = health - i;
    }

    @Override
    public int getSpeed() {
        return this.monsterSpeed;
    }

    @Override
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public int getLocationNumber() {
        return this.locationNumber;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public Image getImage() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        g.setColor(Color.RED);
        g.fillRect(0, 0, Config.CELL_SIZE, Config.CELL_SIZE);
        g.dispose();

        return image;
    }

    @Override
    public double attacks() {
        return this.damage;
    }

    @Override
    public boolean isDead() {
        return this.dead;
    }
}
