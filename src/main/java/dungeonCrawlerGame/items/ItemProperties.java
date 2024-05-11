package dungeonCrawlerGame.items;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum ItemProperties {
    COIN("/Cells/BlackSpace.png", false),
    KEY("/Cells/BlackSpace.png", false),
    POTION("/Cells/BlackSpace.png", false),
    MANA("/Cells/BlackSpace.png", false);

    private String path;
    private boolean isSolid;
    private BufferedImage image;

    ItemProperties(String path, boolean isSolid) {
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSolid() {
        return isSolid;
    }

}

