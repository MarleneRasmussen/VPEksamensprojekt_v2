package dungeonCrawlerGame.items;

import dungeonCrawlerGame.Config;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemObject implements Item{

    private int posX;
    private int posY;
    private int locationNumber;
    private ItemProperties itemProperties;
    private BufferedImage image;
    private boolean pickedUp;
    private boolean inRange;
    public Rectangle itemBounds = new Rectangle(posX, posY, Config.CELL_SIZE, Config.CELL_SIZE);

    public ItemObject(int posX, int posY, int locationNumber, ItemProperties itemProperties)
    {
        this.posX = posX;
        this.posY = posY;
        this.locationNumber = locationNumber;
        this.itemProperties = itemProperties;
        pickedUp = false;
        inRange = false;
    }

    @Override
    public void use() {
        switch (itemProperties) {
            case COIN:
                break;
            case KEY:
                break;
            case POTION:
                break;
            case MANA:
                break;
        }
    }

    @Override
    public void drop() {
    }

    @Override
    public void pickUp() {

    }

    @Override
    public BufferedImage getImage() {
        switch (itemProperties) {
            case COIN:
                image = ItemProperties.COIN.getImage();
                break;
            case KEY:
                image = ItemProperties.KEY.getImage();
                break;
            case POTION:
                image = ItemProperties.POTION.getImage();
                break;
            case MANA:
                image = ItemProperties.MANA.getImage();
                break;
        }
        return image;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getLocationNumber() {
        return locationNumber;
    }

    @Override
    public ItemProperties getItemProperties() {
        return itemProperties;
    }

    @Override
    public void setPosX(int posX) {

    }

    @Override
    public void setPosY(int posY) {

    }

    @Override
    public void setLocationNumber(int locationNumber) {

    }

    @Override
    public boolean isPickedUp() {
        return pickedUp;
    }

    @Override
    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }
}
