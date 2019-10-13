import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        int noeud = 0, hauteur = 1;
        ArbreBinaire arbreBinaire = new ArbreBinaire(new ArbreBinaire(), noeud, new ArbreBinaire());

        System.out.println("\n");
        System.out.println("Veuillez saisir un entier:");

        do {     //boucle pour chaque nouvelle saisie d'entier
            Scanner sc = new Scanner(System.in);
            noeud = sc.nextInt();
            //hauteur++;
            System.out.println(noeud + " (" + hauteur + ")");
            System.out.println("\n");

            arbreBinaire.setNoeud(noeud);
            //arbreBinaire.affichageArbre(arbreBinaire, 0);
            arbreBinaire.affichageArbreCrochets(arbreBinaire);

            if (arbreBinaire.getFilsG().getHauteur() - arbreBinaire.getFilsD().getHauteur() == 2){
                System.out.println("Rééquilibrage de l'arbre...");
                arbreBinaire.reequilibrage(arbreBinaire);
            }

        } while(noeud != 0);



    }
}
