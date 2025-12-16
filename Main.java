import java.util. Scanner;

public class Main {
    public static void main(String[] args) {
        Machine_caffe machine = new Machine_caffe();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Machine à Café ===");
            System.out.println("Choisissez un café :");
            System.out.println("1. inserer de l'argent");
            System.out.println("2. Prendre un Expresso (1.5)");
            System.out.println("3. Prendre un Cafe allongé (2.0)");
            System.out.println("4: faire à la maintenance");
            System.out.println("5. accés caisse");
            System.out.println("6. afficher l'état de la machine");
            System.out.println("7. Quitter");
            System.out.print("Votre choix: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Entrée invalide !");
                scanner.next();
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    machine.argent();
                    break;
                case 2:
                    machine.Cafe_court();
                    break;
                case 3:
                    machine.Cafe_long();
                    break;
                case 4:
                    machine.maintenance();
                    break;
                case 5:
                    machine.acces_caisse();
                    break;
                case 6:
                    machine.afficherEtat();
                    break;
                case 7:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
