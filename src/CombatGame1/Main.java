package CombatGame1;

import java.util.Scanner;

public class Main {
    // Códigos de cores ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ANSI_YELLOW + "Digite os dados do primeiro campeão:" + ANSI_RESET);
        
        System.out.print(ANSI_YELLOW + "Nome: " + ANSI_RESET);
        String name1 = scanner.nextLine();

        int health1 = getIntInput(scanner, "Vida inicial: ");
        int attack1 = getIntInput(scanner, "Ataque: ");
        int armor1 = getIntInput(scanner, "Armadura: ");

        // Campeão 1 com nome em azul
        Champion champion1 = new Champion(name1, health1, attack1, armor1, ANSI_BLUE);

        System.out.println("\n" + ANSI_YELLOW + "Digite os dados do segundo campeão:" + ANSI_RESET);
        
        System.out.print(ANSI_YELLOW + "Nome: " + ANSI_RESET);
        String name2 = scanner.nextLine();

        int health2 = getIntInput(scanner, "Vida inicial: ");
        int attack2 = getIntInput(scanner, "Ataque: ");
        int armor2 = getIntInput(scanner, "Armadura: ");

        // Campeão 2 com nome em vermelho
        Champion champion2 = new Champion(name2, health2, attack2, armor2, ANSI_RED);

        boolean keepFighting = true;
        
        while (keepFighting) {
            // Verifica se ambos os campeões estão vivos antes de começar novos turnos
            if (!champion1.isAlive() || !champion2.isAlive()) {
                System.out.println(ANSI_RED + "Um dos campeões morreu. Combate encerrado." + ANSI_RESET);
                break;
            }

            System.out.print("\n" + ANSI_YELLOW + "Quantos turnos você deseja executar? " + ANSI_RESET);
            int turns = getIntInput(scanner, "");

            System.out.println("\nIniciando o combate...\n");

            // Inicia o combate com o número de turnos especificado
            Combat combat = new Combat(champion1, champion2, turns);
            combat.start();

            // Verifica novamente após o combate se ambos estão vivos
            if (!champion1.isAlive() || !champion2.isAlive()) {
                System.out.println(ANSI_RED + "Um dos campeões morreu durante o combate. Combate encerrado." + ANSI_RESET);
                break;
            }

            // Pergunta ao usuário se deseja continuar ou finalizar
            System.out.print(ANSI_YELLOW + "Deseja continuar o combate? (s/n): " + ANSI_RESET);
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("s")) {
                keepFighting = false;
                System.out.println(ANSI_RED + "Combate finalizado." + ANSI_RESET);
            }
        }

        scanner.close();
    }

    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(ANSI_YELLOW + message + ANSI_RESET);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                return value;
            } else {
                System.out.println(ANSI_RED + "Entrada inválida! Por favor, insira um número inteiro." + ANSI_RESET);
                scanner.nextLine(); // Limpar o buffer
            }
        }
    }
}
