public class Machine_caffe {

    private int Eau = 100;
    private int Cafe = 50;  
    private int Gobelets = 10;
    private int Nb_Caffe = 0;
    private double prix_expresso = 1.5;
    private double prix_cafe_allonge = 2.0;
    private double argent = 0.0;
    private double total_caisse = 0.0;
    private final int Vie = 5;
    public void Cafe_court() {
        if (Eau >= 10 && Cafe >= 10 && Gobelets >= 1 && Nb_Caffe < Vie) {
            Eau -= 10;
            Cafe -= 10;
            Gobelets -= 1;
            Nb_Caffe += 1;
            System.out.println("Voici votre Expresso servi !");
            if (prix_expresso < argent) {
                System.out.println("Voici votre monnaie : " + (argent - prix_expresso));
                argent -= prix_expresso;
            }
            total_caisse += prix_expresso;
        } else if (Nb_Caffe >= Vie) {
            System.out.println("Machine en maintenance.");
        } else if (argent < prix_expresso) {
            System.out.println("Veuillez insérer plus d'argent pour un Expresso.");
        } else {
            System.out.println("Stock insuffisant pour un Expresso.");
        }
    }

    public void Cafe_long() {
        if (Eau >= 20 && Cafe >= 10 && Gobelets >= 1 && Nb_Caffe < Vie) {
            Eau -= 20;
            Cafe -= 10;
            Gobelets -= 1;
            Nb_Caffe += 1;
            total_caisse += prix_cafe_allonge;
            System.out.println("Voici votre Cafe allongé servi !");
            if (prix_cafe_allonge < argent) {
                System.out.println("Voici votre monnaie : " + (argent - prix_cafe_allonge));
                argent -= prix_cafe_allonge;
            }
            total_caisse += prix_cafe_allonge;
        } else if (Nb_Caffe >= Vie) {
            System.out.println("Machine en maintenance.");
        } else if (argent < prix_cafe_allonge) {
            System.out.println("Veuillez insérer plus d'argent pour un Cafe allongé.");
        } else {
            System.out.println("Stock insuffisant pour un Cafe allongé.");
        }
    }

    public void argent() {
        System.out.println("Veuillez insérer de l'argent : ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double montant = scanner.nextDouble();
        scanner.close();
        argent += montant;
        System.out.println("Vous avez inséré : " + montant + ". Solde actuel : " + argent + ".");
    }

    public void maintenance() {
        Nb_Caffe = 0;
        System.out.println("Machine remise en état de fonctionnement.");
    }

    public void acces_caisse() {
        System.out.println("Total en caisse : " + total_caisse);
    }

    public void afficherEtat() {
        System.out.println("État de la machine :");
        System.out.println("Eau restante : " + Eau + " unités");
        System.out.println("Café restant : " + Cafe + " unités");
        System.out.println("Gobelets restants : " + Gobelets);
        System.out.println("Nombre de cafés servis depuis la dernière maintenance : " + Nb_Caffe);
        System.out.println("Argent inséré : " + argent);
    }
}