package CombatGame1;

public class Combat {
    private Champion champion1;
    private Champion champion2;
    private int turns;

    public Combat(Champion champion1, Champion champion2, int turns) {
        this.champion1 = champion1;
        this.champion2 = champion2;
        this.turns = turns;
    }

    public void start() {
        for (int i = 1; i <= turns; i++) {
            if (!champion1.isAlive() || !champion2.isAlive()) {
                break; // finaliza
            }

            // ataque 
            champion1.takeDamage(champion2.getAttack());
            champion2.takeDamage(champion1.getAttack());

            System.out.println("Resultado do turno " + i + ":");
            System.out.println(champion1.status());
            System.out.println(champion2.status());
            System.out.println();

            if (!champion1.isAlive() || !champion2.isAlive()) {
                System.out.println("### FIM DO COMBATE ###");
                break;
            }
        }
    }
}
