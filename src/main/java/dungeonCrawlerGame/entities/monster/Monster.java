package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.Player;
import dungeonCrawlerGame.gameManager.tools.CheckCell;
import dungeonCrawlerGame.gameWindow.GameDisplay;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster implements Entity {

    Player player = GameDisplay.player;

    private int x;
    private int y;
    private int health;
    private int locationNumber;
    public Direction direction;
    private Image image;
    private int damage;
    private boolean dead;
    private boolean collision;

    private int monsterSpeed = Config.DEFAULT_MONSTER_SPEED;
    private int startPosX;
    private int startPosY;
    private int endPosX;
    private int endPosY;
    private boolean goBack = false;
    private Direction startDirection;

    public Monster(int x, int y, int location, Direction direction) {
        this.x = x;
        this.y = y;
        this.locationNumber = location;
        this.direction = direction;
        setEndPosition();
    }

    public void setEndPosition(){
        startPosX = x;
        startPosY = y;
        startDirection = direction;

        if (direction == Direction.RIGHT) {
            endPosX = startPosX + Config.CELL_SIZE * 3;
            endPosY = startPosY;
        }
        if (direction == Direction.LEFT) {
            endPosX = startPosX - Config.CELL_SIZE * 3;
            endPosY = startPosY;
        }
        if (direction == Direction.UP) {
            endPosX = startPosX;
            endPosY = startPosY - Config.CELL_SIZE * 3;
        }
        if (direction == Direction.DOWN) {
            endPosX = startPosX;
            endPosY = startPosY + Config.CELL_SIZE * 3;
        }
    }
    @Override
    public void moveEntity() {
        collision = false;

        collision = CheckCell.checkCellCollision(this);
        // Follow player if same location and player is nearby
        if (playerIsPlayerNearby() && locationNumber == DungeonMap.getCurrentWorldLocation() && !collision) {
            monsterSpeed = 4;
            int distanceX  = player.getX() - x;
            int distanceY = player.getY() - y;

            if (player.getX() >= x + Config.CELL_SIZE && distanceX > distanceY) {
                direction = Direction.RIGHT;
                x += monsterSpeed;
            } else if (player.getX() <= x - Config.CELL_SIZE && distanceX < distanceY) {
                direction = Direction.LEFT;
                x -= monsterSpeed;
            } else if (player.getY() >= y + Config.CELL_SIZE && distanceY > distanceX) {
                direction = Direction.DOWN;
                y += monsterSpeed;
            } else if (player.getY() <= y - Config.CELL_SIZE && distanceY < distanceX) {
                direction = Direction.UP;
                y -= monsterSpeed;
            }
            goBack = true;

        } else if (goBack && !playerIsPlayerNearby()) {
            monsterSpeed = 2;
            goBackToStart();
        } else {
            moveRegular();
        }
    }

    private void moveRegular() {
        if (direction == Direction.RIGHT) {
            if (x + monsterSpeed <= endPosX) {
                x += monsterSpeed;
            } else {
                direction = Direction.LEFT;
            }
        }
        if (direction == Direction.LEFT) {
            if (x - monsterSpeed >= endPosX) {
                x -= monsterSpeed;
            } else {
                direction = Direction.RIGHT;
            }
        }
        if (direction == Direction.UP) {
            if (y - monsterSpeed >= startPosY) {
                y -= monsterSpeed;
            } else {
                direction = Direction.DOWN;
            }
        }
        if (direction == Direction.DOWN) {
            if (y + monsterSpeed <= endPosY) {
                y += monsterSpeed;
            } else {
                direction = Direction.UP;
            }
        }
    }

    private boolean playerIsPlayerNearby() {
        int distance = Config.CELL_SIZE * 2;
        if (x < player.getX() + distance &&
                x + Config.CELL_SIZE + distance > player.getX() &&
                y < player.getY() + distance &&
                y + Config.CELL_SIZE + distance > player.getY()) {
            return true;
        } else {
            return false;
        }
    }

    private void goBackToStart() {
        int distanceX = startPosX - x;
        int distanceY = startPosY - y;

        if (x == startPosX && y == startPosY) {
            goBack = false;
            direction = startDirection;
        } else if (startPosX > x && distanceX >= distanceY) {
            if (collision)
            direction = Direction.RIGHT;
            x += 1;
        } else if (startPosX < x && distanceX <= distanceY) {
            direction = Direction.LEFT;
            x -= 1;
        } else if (startPosY > y && distanceY >= distanceX) {
            direction = Direction.DOWN;
            y += 1;
        } else if (startPosY < y && distanceY <= distanceX) {
            direction = Direction.UP;
            y -= 1;
        }
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
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int i) {
    }

    @Override
    public int getSpeed() {
        return this.monsterSpeed;
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
    public int getDamage() {
        return this.damage;
    }

    @Override
    public boolean isDead() {
        return this.dead;
    }


}
