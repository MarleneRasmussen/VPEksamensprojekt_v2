package dungeonCrawlerGame.gameWindow.menu;

import javax.swing.*;
import java.awt.*;

public class PauseMenu extends JPanel {

    private JButton resumeButton;
    private JButton exitButton;
    private JButton restartButton;

    public PauseMenu() {

        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();

    }

    public void createPauseMenu(Graphics2D g2d) {

        resumeButton = new JButton("RESUME");
        resumeButton.setBounds(200, 200, 400, 50);
        resumeButton.setFocusable(false);
        resumeButton.setContentAreaFilled(false);
        resumeButton.setBorderPainted(false);
        resumeButton.setFocusPainted(false);
        resumeButton.setForeground(Color.WHITE);
        resumeButton.setFont(new Font("Arial", Font.PLAIN, 50));

        exitButton = new JButton("EXIT");
        exitButton.setBounds(300, 300, 200, 50);
        exitButton.setFocusable(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 30));

        restartButton = new JButton("RESTART");
        restartButton.setBounds(300, 400, 200, 50);
        restartButton.setFocusable(false);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        restartButton.setForeground(Color.WHITE);
        restartButton.setFont(new Font("Arial", Font.PLAIN, 30));

        add(resumeButton);
        add(exitButton);
        add(restartButton);

    }

}



