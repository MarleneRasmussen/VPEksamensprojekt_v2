package dungeonCrawlerGame.locations;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.Player;


public class DungeonMap {
    static int worldColumn = 0;
    static int worldRow = 0;

    public static int currentLocation = 1;

    public static void setDefaultLocation() {
        worldColumn = 0;
        worldRow = 0;
    }

    private static final int[][] worldMap = {
            {1,  2, 3,  4},
            {5,  6, 7,  8},
            {9, 10, 11, 12}};

    public static void getCurrentWorldLocation(Player player) {
        if (player.getX() > Config.LOCATION_WIDTH) {
            player.setX(0);
            worldColumn++;
        }
        if (player.getX() < 0) {
            player.setX(Config.LOCATION_WIDTH);
            worldColumn--;
        }
        if (player.getY() > Config.LOCATION_HEIGHT) {
            player.setY(0);
            worldRow++;
        }
        if (player.getY() < 0) {
            player.setY(Config.LOCATION_HEIGHT);
            worldRow--;
        }
        currentLocation= worldMap[worldRow][worldColumn];
    }
    public static int getCurrentWorldLocation() {
        return currentLocation;
    }
}
