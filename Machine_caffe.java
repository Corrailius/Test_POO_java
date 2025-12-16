import java.util.Scanner;

class MachineCaffe {

    private int eau = 100;
    private int cafe = 50;
    private int gobelets = 10;
    private int nbCafe = 0;

    private final double PRIX_EXPRESSO = 1.5;
    private final double PRIX_CAFE_LONG = 2.0;
    private final int LIMITE_AVANT_MAINTENANCE = 5;

    private double argent = 0.0;
    private double totalCaisse = 0.0;

    private final Scanner scanner;

    public MachineCaffe(Scanner scanner) {
        this.scanner = scanner;
    }

    public void insererArgent() {
        System.out.print("Montant à insérer : ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Veuillez entrer un montant valide.");
            scanner.nextLine();
        }
        double montant = scanner.nextDouble();
        scanner.nextLine();
        argent += montant;
        System.out.println("Solde actuel : " + argent);
    }

    public void cafeCourt() {
        servirCafe(PRIX_EXPRESSO, 10, 10, "Expresso");
    }

    public void cafeLong() {
        servirCafe(PRIX_CAFE_LONG, 20, 10, "Café allongé");
    }

    private void servirCafe(double prix, int eauNecessaire, int cafeNecessaire, String nom) {
        if (nbCafe >= LIMITE_AVANT_MAINTENANCE) {
            System.out.println("Machine en maintenance.");
            return;
        }
        if (argent < prix) {
            System.out.println("Argent insuffisant.");
            return;
        }
        if (eau < eauNecessaire || cafe < cafeNecessaire || gobelets < 1) {
            System.out.println("Stock insuffisant.");
            return;
        }

        eau -= eauNecessaire;
        cafe -= cafeNecessaire;
        gobelets--;
        nbCafe++;
        argent -= prix;
        totalCaisse += prix;

        System.out.println(nom + " servi !");
        System.out.println("Monnaie restante : " + argent);
    }

    public void maintenance() {
        System.out.println("\n--- Maintenance ---");
        System.out.println("1. Remplir les ressources");
        System.out.println("2. Détartrer");
        System.out.print("Votre choix : ");

        int choix = readInt();

        if (choix == 1) {
            System.out.print("Ajouter eau : ");
            eau += readInt();
            System.out.print("Ajouter café : ");
            cafe += readInt();
            System.out.print("Ajouter gobelets : ");
            gobelets += readInt();
        } else if (choix == 2) {
            nbCafe = 0;
            System.out.println("Machine détartrée.");
        }
    }

    public void accesCaisse() {
        System.out.println("Total caisse : " + totalCaisse);
    }

    public void afficherEtat() {
        System.out.println("\n--- État de la machine ---");
        System.out.println("Eau : " + eau);
        System.out.println("Café : " + cafe);
        System.out.println("Gobelets : " + gobelets);
        System.out.println("Cafés servis : " + nbCafe);
        System.out.println("Argent inséré : " + argent);
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
