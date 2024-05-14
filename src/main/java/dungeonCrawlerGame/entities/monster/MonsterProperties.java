package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.controller.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum MonsterProperties {
    BAT(100, 30, 2, 3, "/Monsters/Bat_Up1.png", "/Monsters/Bat_Up2.png", "/Monsters/Bat_Down1.png", "/Monsters/Bat_Down2.png", "/Monsters/Bat_Left1.png", "/Monsters/Bat_Left2.png", "/Monsters/Bat_Right1.png", "/Monsters/Bat_Right2.png"),
    SLIME(100, 30, 2, 3, "bla", "bla2", "bla", "bla2", "bla", "bla2", "bla", "bla2");

    private final int health;
    private final int damage;
    private final int speed;
    private final int huntingSpeed;
    private final String imagePath1UP ;
    private final String imagePath2UP;
    private final String imagePath1DOWN;
    private final String imagePath2DOWN;
    private final String imagePath1LEFT;
    private final String imagePath2LEFT;
    private final String imagePath1RIGHT;
    private final String imagePath2RIGHT;
    private BufferedImage imageUP1;
    private BufferedImage imageUP2;
    private BufferedImage imageDOWN1;
    private BufferedImage imageDOWN2;
    private BufferedImage imageLEFT1;
    private BufferedImage imageLEFT2;
    private BufferedImage imageRIGHT1;
    private BufferedImage imageRIGHT2;

    MonsterProperties(int health, int damage, int speed, int huntingSpeed, String imagePath1UP, String imagePath2UP, String imagePath1DOWN,
                      String imagePath2DOWN, String imagePath1LEFT, String imagePath2LEFT, String imagePath1RIGHT, String imagePath2RIGHT) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.huntingSpeed = huntingSpeed;
        this.imagePath1UP = imagePath1UP;
        this.imagePath2UP = imagePath2UP;
        this.imagePath1DOWN = imagePath1DOWN;
        this.imagePath2DOWN = imagePath2DOWN;
        this.imagePath1LEFT = imagePath1LEFT;
        this.imagePath2LEFT = imagePath2LEFT;
        this.imagePath1RIGHT = imagePath1RIGHT;
        this.imagePath2RIGHT = imagePath2RIGHT;
        try{
            this.imageUP1 = ImageIO.read(getClass().getResourceAsStream(imagePath1UP));
            this.imageUP2 = ImageIO.read(getClass().getResourceAsStream(imagePath2UP));
            this.imageDOWN1 = ImageIO.read(getClass().getResourceAsStream(imagePath1DOWN));
            this.imageDOWN2 = ImageIO.read(getClass().getResourceAsStream(imagePath2DOWN));
            this.imageLEFT1 = ImageIO.read(getClass().getResourceAsStream(imagePath1LEFT));
            this.imageLEFT2 = ImageIO.read(getClass().getResourceAsStream(imagePath2LEFT));
            this.imageRIGHT1 = ImageIO.read(getClass().getResourceAsStream(imagePath1RIGHT));
            this.imageRIGHT2 = ImageIO.read(getClass().getResourceAsStream(imagePath2RIGHT));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getHealth(MonsterProperties monster) {
        return monster.health;
    }

    public static int getDamage(MonsterProperties monster) {
        return monster.damage;
    }

    public static int getSpeed(MonsterProperties monster) {
        return monster.speed;
    }

    public static int getHuntingSpeed(MonsterProperties monster) {
        return monster.huntingSpeed;
    }

    public BufferedImage getImage(int imageNumber, Direction direction) {
        switch (direction) {
            case UP:
                if (imageNumber ==1) {
                    return imageUP1;
                } else {
                    return imageUP2;
                }
            case DOWN:
                if (imageNumber == 1) {
                    return imageDOWN1;
                } else {
                    return imageDOWN2;
                }
            case LEFT:
                if (imageNumber == 1) {
                    return imageLEFT1;
                } else {
                    return imageLEFT2;
                }
            case RIGHT:
                if (imageNumber == 1) {
                    return imageRIGHT1;
                } else {
                    return imageRIGHT2;
                }
            default:
                return null;
        }
    }
}
