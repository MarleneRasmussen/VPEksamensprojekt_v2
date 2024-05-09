package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.controller.Direction;

import java.awt.*;

public interface Entity {

    public int getPosX();
    public int getPosY();
    public double getHealth();
    public int getLocationNumber();
    public Direction getDirection();
    public Image getImage();
    public double attacks();
    public boolean isDead();
    public void moveEntity();
    public void takeDamage(double i);
    public int getSpeed();
    public void setCollision(boolean collision);
}
