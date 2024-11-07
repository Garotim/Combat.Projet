package CombatGame1;

public class Champion {
    private String name;
    private int health;
    private int attack;
    private int armor;
    private String nameColor;

    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Champion(String name, int health, int attack, int armor, String nameColor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
        this.nameColor = nameColor;
    }

    public void takeDamage(int opponentAttack) {
        int damage = Math.max(1, opponentAttack - armor);
        health = Math.max(0, health - damage); 
    }

    public String status() {
        String coloredName = nameColor + name + ANSI_RESET;
        String healthStatus = ANSI_GREEN + health + " de vida" + ANSI_RESET;
        
        if (health == 0) {
            healthStatus = ANSI_GREEN + "0 de vida (morreu)" + ANSI_RESET;
        }
        return coloredName + ": " + healthStatus;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }
}
