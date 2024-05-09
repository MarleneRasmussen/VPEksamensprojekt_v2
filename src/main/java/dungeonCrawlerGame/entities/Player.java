package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.controller.CheckCell;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.ui.Cells;
import dungeonCrawlerGame.ui.EntityImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements Entity {

    private static int x;
    private static int y;
    private double health;
    private int locationNumber;
    public Direction direction;
    private Image image;
    private double damage;
    private boolean dead;

    private int playerSpeed;
    public boolean collision;
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
        health = Config.DEFAULT_PLAYER_HEALTH;
        this.damage = Config.DEFAULT_PLAYER_DAMAGE;
    }

    public Direction checkDirection() {
        if (KeyAction.up) {
            direction = Direction.UP;
        }
        else if (KeyAction.down) {
            direction = Direction.DOWN;
        }
        else if (KeyAction.left) {
            direction = Direction.LEFT;
        }
        else if (KeyAction.right) {
            direction = Direction.RIGHT;
        }
        else{
            direction = Direction.DOWN;
        }
        return direction;
    }

    public void setPlayerSpeed(Cells cell) {
        playerSpeed = cell.getSpeedImpact();
    }


    @Override
    public void moveEntity() {
        if (KeyAction.down || KeyAction.up || KeyAction.left || KeyAction.right) {
            direction = null;
            direction = checkDirection();

            collision = false;
            //Check cell collision only inside current location if moving

            if (x >= 1 && x + Config.CELL_SIZE + 1 <= Config.LOCATION_WIDTH
                    && y + Config.CELL_SIZE + 1 <= Config.LOCATION_HEIGHT && y >= 1) {
                CheckCell.checkCellCollision(this);
                setPlayerSpeed(CheckCell.getCurrentCell(this));
            }

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
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public void takeDamage(double i) {
        health = health - i;
    }

    @Override
    public int getPosX() {
        return x;
    }

    @Override
    public int getPosY() {
        return y;
    }

    @Override
    public double getHealth() {
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
        direction = null;
        direction = checkDirection();
        switch (direction) {
            case UP:
                if (imageNum == 1) {
                    image = EntityImage.PLAYER_UP1.getImage();
                } else if (imageNum == 2) {
                    image = EntityImage.PLAYER_UP2.getImage();
                }
                break;
            case DOWN:
                if (imageNum == 1) {
                    image = EntityImage.PLAYER_DOWN1.getImage();
                } else if (imageNum == 2) {
                    image = EntityImage.PLAYER_DOWN2.getImage();
                }
                break;
            case LEFT:
                if (imageNum == 1) {
                    image = EntityImage.PLAYER_LEFT1.getImage();
                } else if (imageNum == 2) {
                    image = EntityImage.PLAYER_LEFT2.getImage();
                }
                break;
            case RIGHT:
                if (imageNum == 1) {
                    image = EntityImage.PLAYER_RIGHT1.getImage();
                } else if (imageNum == 2) {
                    image = EntityImage.PLAYER_RIGHT2.getImage();
                }
                break;
        }
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
