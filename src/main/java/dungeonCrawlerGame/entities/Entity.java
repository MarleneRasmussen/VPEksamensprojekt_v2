package dungeonCrawlerGame.entities;

import dungeonCrawlerGame.controller.Direction;

import java.awt.*;

public interface Entity {
    //Geometry
    public int getX();
    public int getY();
    public int getLocationNumber();
    public void setLocationNumber(int locationNumber);
    public Direction getDirection();
    public int getSpeed();
    public void move();

    //Combat and health
    public void takeDamage(int damage);
    public void attack();
    public int getHealth();

    //Collision
    public void setCollision(boolean collision);
    public void setPlayerMonsterCollision(boolean playerMonsterCollision);
    public Rectangle getSolidBounds();

    //Display and animation
    public Image getImage();
    public void getImageNumber();

}
