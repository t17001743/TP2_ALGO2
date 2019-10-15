import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArbreAVL arbreAVL = new ArbreAVL();

        System.out.println("\n");
        System.out.println("Veuillez saisir un entier :");

        do {     //boucle pour chaque nouvelle saisie d'entier
            Scanner sc = new Scanner(System.in);
            int entree = sc.nextInt();
            arbreAVL.getRacine().setValeur(entree);

            System.out.println(entree + " (" + arbreAVL.getHauteur(arbreAVL.getRacine()) + ")");

            System.out.println(arbreAVL.affichageEntreCrochets(arbreAVL.getRacine()));
            System.out.println("\n");

            //arbreAVL.getFilsG().setHauteur(getHauteur++);
            //arbreAVL.getFilsD().setHauteur(getHauteur++);

            arbreAVL.getRacine().setFilsG(arbreAVL.getRacine().getFilsG());
            arbreAVL.getRacine().setFilsD(arbreAVL.getRacine().getFilsD());

            if (arbreAVL.getHauteur(arbreAVL.getRacine().getFilsG()) - arbreAVL.getHauteur(arbreAVL.getRacine().getFilsD()) == 2){
                System.out.println("Rééquilibrage de l'arbre...");
                arbreAVL.reequilibrage(arbreAVL.getRacine());
            }

            //arbreAVL.setFilsG(arbreAVL.getFilsG());
            //arbreAVL.setFilsD(arbreAVL.getFilsD());

        } while(arbreAVL.getRacine().getValeur() != 0);
    }

}

