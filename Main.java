import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineCaffe machine = new MachineCaffe(scanner);
        int choice;

        do {
            System.out.println("\n=== Machine à Café ===");
            System.out.println("1. Insérer de l'argent");
            System.out.println("2. Prendre un Expresso (1.5)");
            System.out.println("3. Prendre un Café allongé (2.0)");
            System.out.println("4. Maintenance");
            System.out.println("5. Accès caisse");
            System.out.println("6. Afficher l'état de la machine");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            choice = readInt(scanner);

            switch (choice) {
                case 1 -> machine.insererArgent();
                case 2 -> machine.cafeCourt();
                case 3 -> machine.cafeLong();
                case 4 -> machine.maintenance();
                case 5 -> machine.accesCaisse();
                case 6 -> machine.afficherEtat();
                case 7 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide, veuillez entrer un nombre.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}