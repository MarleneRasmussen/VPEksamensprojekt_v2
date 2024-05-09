package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.controller.Direction;

import java.awt.*;

public interface Entity {

    public int getX();
    public int getY();
    public int getHealth();
    public int getLocationNumber();
    public Direction getDirection();
    public Image getImage();
    public int getDamage();
    public boolean isDead();
    public void moveEntity();
    public void setHealth(int i);
    public int getSpeed();

}
