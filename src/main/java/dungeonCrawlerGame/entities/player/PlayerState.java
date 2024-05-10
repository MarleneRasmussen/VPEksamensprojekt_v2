package dungeonCrawlerGame.entities.player;

import java.awt.*;

import dungeonCrawlerGame.Config;
import static dungeonCrawlerGame.gameWindow.GameInit.player;

public class PlayerState {

    public void renderPlayerHP(Graphics2D g2d) {

        double playerHealth = player.getHealth();
        double playerMaxHealth = Config.DEFAULT_PLAYER_HEALTH;
        int barWidth = 200;
        int playerHealthBar = (int) ((playerHealth / playerMaxHealth) * barWidth);

        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRoundRect(100, 10,320, 50, 10, 10);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("HEALTH:" ,110, 43);

        g2d.setColor(new Color(50,0,0));
        g2d.fillRoundRect( 200, 20, barWidth + 6, 31, 10, 10);

        g2d.setColor(new Color(255,0,60));
        g2d.fillRoundRect( 203, 23, playerHealthBar, 25, 10, 10);
    }

    public void renderPlayerStamina(Graphics2D g2d) {

        double playerStamina = player.getStamina();
        double playerMaxStamina = Config.DEFAULT_PLAYER_STAMINA;
        int barWidth = 200;
        int playerStaminaBar = (int) ((playerStamina / playerMaxStamina) * barWidth);

        System.out.println(playerStamina);

        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRoundRect(500, 10,330, 50, 10, 10);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("STAMINA:" ,510, 43);

        g2d.setColor(new Color(20,0,90));
        g2d.fillRoundRect( 610, 20, barWidth + 6, 31, 10, 10);

        g2d.setColor(new Color(50,100,255));
        g2d.fillRoundRect( 613, 23, playerStaminaBar, 25, 10, 10);
    }
}

