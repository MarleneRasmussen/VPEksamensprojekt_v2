package dungeonCrawlerGame.entities;

public class EntityAnimation {

    private int imageNumber;
    private int imageDelay;

    public static int getImageNumber(int imageNumber, int imageDelay){
        imageDelay++;
        if(imageDelay>12) {
            if (imageNumber == 1) {
                imageNumber = 2;
            }
            else {
                imageNumber = 1;
            }
        }
        return imageNumber;
    }
}
