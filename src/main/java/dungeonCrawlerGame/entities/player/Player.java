package dungeonCrawlerGame.entities.player;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.EntityAnimation;
import dungeonCrawlerGame.entities.MonsterManager;
import dungeonCrawlerGame.items.Items;
import dungeonCrawlerGame.locations.Cells;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;

public class Player implements Entity{

    private int x;
    private int y;
    private int locationNumber;
    private Direction direction;
    private int playerSpeed;
    private final Rectangle solidBounds = new Rectangle(x, y, Config.CELL_SIZE, Config.CELL_SIZE);

    private int health;
    private int damage;
    private int stamina;
    private int staminaCounter;

    private boolean collision;
    private boolean monsterCollision;
    private boolean playerAttacks;

    private Image image;
    private int imageNumber;
    private int imageDelay;

    private int monsterIndex;
    private int itemIndex;

    public Player() {
        setDefaultSettings();
    }

    private void setDefaultSettings() {
        x = 1500;
        y = 200;
        health = Config.DEFAULT_PLAYER_HEALTH;
        stamina = Config.DEFAULT_PLAYER_STAMINA;
        damage = Config.DEFAULT_PLAYER_DAMAGE;
        direction = Direction.DOWN;
        imageNumber = 1;
    }

    public void checkCollision(){
        //Check collision with solid cells
        CollisionChecker.checkCellCollision(this);

        //Set player speed according to non-solid cells
        setPlayerSpeed(CollisionChecker.getCurrentCell(this));

        //Check collision with items
        CollisionChecker.checkItemCollision(this);
        this.itemIndex = CollisionChecker.checkItemCollision(this);
        if (itemIndex != -1) {
            PlayerState.updateInventory(Items.getItem().get(itemIndex));
        }

        //Check collision with monsters
        monsterIndex = CollisionChecker.checkEntityCollision(this, MonsterManager.getMonsters());
        if (monsterIndex != -1) {
            attack();
        }
    }

    public void setPlayerSpeed(Cells cell){
        this.playerSpeed = cell.getSpeedImpact();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void increaseStamina() {
        if (stamina < Config.DEFAULT_PLAYER_STAMINA) {
            staminaCounter++;
            if(staminaCounter > 50) {
                staminaCounter = 0;
                stamina++;
            }
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
        return this.playerSpeed;
    }

    @Override
    public void move() {
        playerAttacks = false;
        if (KeyAction.down || KeyAction.up || KeyAction.left || KeyAction.right || KeyAction.attack) {
            if (KeyAction.up) {
                direction = Direction.UP;
            } else if (KeyAction.down) {
                direction = Direction.DOWN;
            } else if (KeyAction.left) {
                direction = Direction.LEFT;
            } else if (KeyAction.right) {
                direction = Direction.RIGHT;
            } else if (KeyAction.attack) {
                playerAttacks = true;
            }

            //Reset collision
            collision = false;
            monsterCollision = false;

            //Check collision only inside current location if moving
            if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH
                    && y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {

                checkCollision();
            }

            if (direction != null && !collision && !playerAttacks) {
                switch (direction) {
                    case UP:
                        if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH) {
                            y -= playerSpeed;
                        }
                        break;
                    case DOWN:
                        if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH) {
                            y += playerSpeed;
                        }
                        break;
                    case LEFT:
                        if (y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {
                            x -= playerSpeed;
                        }
                        break;
                    case RIGHT:
                        if (y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {
                            x += playerSpeed;
                        }
                }
            }
            getImageNumber();
            imageDelay++;
            DungeonMap.getCurrentWorldLocation();
        }
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public void attack() {
        if(this.stamina > 0 && this.playerAttacks){
            stamina--;
            MonsterManager.getMonsters().get(this.monsterIndex).takeDamage(this.damage);
        }
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
    public void setPlayerMonsterCollision(boolean playerMonsterCollision) {
        this.monsterCollision = playerMonsterCollision;
    }

    @Override
    public Rectangle getSolidBounds() {
        return this.solidBounds;
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    @Override
    public void getImageNumber() {
        this.imageNumber = EntityAnimation.getImageNumber(this.imageNumber, this.imageDelay);
    }

    public double getStamina() {
        return this.stamina;
    }
    public void setHealth(int health) {
        this.health = health;
    }
}
