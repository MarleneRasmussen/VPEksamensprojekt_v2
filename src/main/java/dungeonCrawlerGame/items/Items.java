package dungeonCrawlerGame.items;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Items {

    private static List<ItemObject> items;
    private int damageCounter = 0;
    private int staminaCounter = 0;

    public Items()
    {
        items = new ArrayList<ItemObject>();
    }

    public void addItem(ItemObject item)
    {
        items.add(item);
    }


    public void checkIfPickedUp()
    {
        for (ItemObject item : items)
        {
            if (item.isPickedUp())
            {
                //Location number 0 is for picked up items
                item.setLocationNumber(0);
                //GameInit.playerState.updateInventory(item);
            }
        }
    }

    public static List<ItemObject> getItem()
    {
        return items;
    }

    public void drawItems(Graphics2D g2d)
    {
        for (ItemObject item : items)
        {
            if (item.getLocationNumber() == DungeonMap.getCurrentWorldLocation())
            {
                g2d.drawImage(item.getImage(), item.getPosX(), item.getPosY(), Config.CELL_SIZE, Config.CELL_SIZE, null);

            }
        }
    }
}
