package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.EnemyProperties;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.EntityImage;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.Random;

public class Monster implements Entity {

    Player player = GameInit.player;

    private int posX;
    private int posY;
    private int health;
    private int locationNumber;
    public Direction direction;
    private Image image;
    private final int damage;
    private boolean dead;
    private boolean collision;
    public boolean playerCollision;
    private int maxHealth;
    public Rectangle entityBounds = new Rectangle(posX, posY, Config.CELL_SIZE, Config.CELL_SIZE);

    private int monsterSpeed;
    private EnemyProperties enemy;
    private int turnCounter = 0;
    private int imageCounter = 0;
    private int imageNum = 1;

    public Monster(int startX, int startY, int location, Direction direction, EnemyProperties enemy) {
        this.posX = startX;
        this.posY = startY;
        this.locationNumber = location;
        this.direction = direction;
        this.maxHealth = EnemyProperties.getHealth(enemy);
        this.damage = EnemyProperties.getDamage(enemy);
        this.enemy = enemy;
        this.health = maxHealth;
    }

    public EnemyProperties getEnemy() {
        return enemy;
    }

    @Override
    public void moveEntity() {
        collision = false;
        playerCollision = false;

        //Cant move out of the location
        if (posX >= Config.CELL_SIZE && posY >= Config.CELL_SIZE && posX + Config.CELL_SIZE <= Config.LOCATION_WIDTH - Config.CELL_SIZE && posY + Config.CELL_SIZE <= Config.LOCATION_HEIGHT - Config.CELL_SIZE) {
            checkCollision();
            attacks();
            // Follow player if same location and player is nearby
            if (playerIsPlayerNearby() && locationNumber == DungeonMap.getCurrentWorldLocation()) {
                turnCounter = 0;
                monsterSpeed = EnemyProperties.getHuntingSpeed(enemy);

                if (!collision && !playerCollision) {
                    if (player.getPosX() >= posX) {
                        direction = Direction.RIGHT;
                        posX += monsterSpeed;
                    } else if (player.getPosX() <= posX) {
                        direction = Direction.LEFT;
                        posX -= monsterSpeed;
                    }

                    if (player.getPosY() >= posY) {
                        direction = Direction.DOWN;
                        posY += monsterSpeed;
                    } else if (player.getPosY() <= posY) {
                        direction = Direction.UP;
                        posY -= monsterSpeed;
                    }
                }

            } else {
                monsterSpeed = EnemyProperties.getSpeed(enemy);
                moveRandom();
            }
        } else {
            if (posX <= Config.CELL_SIZE) {
                direction = Direction.RIGHT;
                posX += monsterSpeed;
            } else if (posX + Config.CELL_SIZE >= Config.LOCATION_WIDTH - Config.CELL_SIZE) {
                direction = Direction.LEFT;
                posX -= monsterSpeed;
            } else if (posY <= Config.CELL_SIZE) {
                direction = Direction.DOWN;
                posY += monsterSpeed;
            } else {
                direction = Direction.UP;
                posY -= monsterSpeed;
            }
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
        //CollisionChecker.checkCellCollision(this);
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
    public void checkCollision() {

        CollisionChecker.checkCellCollision(this);
        CollisionChecker.checkItemCollision(this);
        CollisionChecker.checkPlayerCollision(this, player);
    }

    public void setPlayerMonsterCollision(boolean playerCollision) {
        this.playerCollision = playerCollision;
    }

    @Override
    public Rectangle getBounds() {
        return entityBounds;
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
    public int getHealth() {
       return this.health;
    }

    @Override
    public void takeDamage(int i) {
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
    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
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
        switch (direction) {
            case UP:
                if (imageNum == 1) {
                    image = EnemyProperties.BAT_UP1.getImage();
                } else if (imageNum == 2) {
                    image = EnemyProperties.BAT_UP2.getImage();
                }
                break;
            case DOWN:
                if (imageNum == 1) {
                    image = EnemyProperties.BAT_DOWN1.getImage();
                } else if (imageNum == 2) {
                        image = EnemyProperties.BAT_DOWN2.getImage();
                }
                break;
            case LEFT:
                if (imageNum == 1) {
                    image = EnemyProperties.BAT_LEFT1.getImage();
                } else if (imageNum == 2) {
                    image = EnemyProperties.BAT_LEFT2.getImage();
                }
                break;
            case RIGHT:
                if (imageNum == 1) {
                    image = EnemyProperties.BAT_RIGHT1.getImage();
                } else if (imageNum == 2) {
                    image = EnemyProperties.BAT_RIGHT2.getImage();
                }
                break;
        }
        return image;
    }

    @Override
    public int attacks() {
        return damage;
    }
}
