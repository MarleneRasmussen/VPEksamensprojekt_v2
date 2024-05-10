package dungeonCrawlerGame.entities;

public enum EnemyProperties {
    GHOST(100, 10, 1, 3),
    BAT(50, 10, 1, 4),
    SKELETON(150, 10, 1, 2);

    private final int health;
    private final double damage;
    private final int speed;
    private final int huntingSpeed;

    EnemyProperties(int health, double damage, int speed, int huntingSpeed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.huntingSpeed = huntingSpeed;
    }

    public static int getHealth(EnemyProperties enemy) {
        return enemy.health;
    }

    public static double getDamage(EnemyProperties enemy) {
        return enemy.damage;
    }

    public static int getSpeed(EnemyProperties enemy) {
        return enemy.speed;
    }

    public static int getHuntingSpeed(EnemyProperties enemy) {
        return enemy.huntingSpeed;
    }

}
