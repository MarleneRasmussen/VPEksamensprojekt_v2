package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.ui.Cells;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements Entity {

    private static int x;
    private static int y;
    private int health;
    private int locationNumber;
    private Direction direction;
    private Image image;
    private int damage;
    private boolean dead;

    private int playerSpeed;
    private boolean collision = false;
    private int imageCounter = 0;
    private int imageNum = 1;

    public Player() {
        setDefaultSettings();
    }

    public void setDefaultSettings() {
        x = Config.LOCATION_WIDTH / 2;
        y = Config.LOCATION_HEIGHT / 2;
        playerSpeed = Config.DEFAULT_PLAYER_SPEED;
        collision = false;
        direction = Direction.DOWN;
    }

    public Direction checkDirection() {
        if (KeyAction.up) {
            direction = Direction.UP;
        }
        if (KeyAction.down) {
            direction = Direction.DOWN;
        }
        if (KeyAction.left) {
            direction = Direction.LEFT;
        }
        if (KeyAction.right) {
            direction = Direction.RIGHT;
        }
        return direction;
    }

    public void setPlayerSpeed(Cells cell) {
        playerSpeed = cell.getSpeedImpact();
    }


    @Override
    public void moveEntity() {
        direction = null;
        direction = checkDirection();

        collision = false;
        //Check cell collision only inside current location if moving
        /*if (KeyAction.down || KeyAction.up || KeyAction.left || KeyAction.right) {
            if (playerPosX >= 5 && playerPosX + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH
                    && playerPosY + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && playerPosY >= 5) {
                CheckCell.checkCellCollision(this);
                getPlayerSpeed(CheckCell.getCurrentCell(this));
            }*/

        if (direction != null && !collision) {
            switch (direction) {
                case UP:
                    if (x >= 10 && x + Config.CELL_SIZE + 10 <= Config.LOCATION_WIDTH) {
                        y -= playerSpeed;
                    }
                    break;
                case DOWN:
                    if (x >= 10 && x + Config.CELL_SIZE + 10 <= Config.LOCATION_WIDTH) {
                        y += playerSpeed;
                    }
                    break;
                case LEFT:
                    if (y + Config.CELL_SIZE + 10 <= Config.LOCATION_HEIGHT && y >= 10) {
                        x -= playerSpeed;
                    }
                    break;
                case RIGHT:
                    if (y + Config.CELL_SIZE + 10 <= Config.LOCATION_HEIGHT && y >= 10) {
                        x += playerSpeed;
                    }
                    break;
            }

            imageCounter++;
            if (imageCounter > 12) {
                if (imageNum == 1) {
                    imageNum = 2;
                } else if (imageNum == 2) {
                    imageNum = 1;
                }
                imageCounter = 0;
            }
            DungeonMap.getCurrentWorldLocation(this);
        }
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getSpeed() {
        return this.playerSpeed;
    }

    @Override
    public void setHealth(int i) {
        this.health = i;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getHealth() {
        return this.health;
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

        if (imageNum == 1) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.GREEN);
        }
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
