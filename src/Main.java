import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int noeud = 0;
        ArbreBinaire arbreBinaire = new ArbreBinaire(new ArbreBinaire(), noeud, new ArbreBinaire());
        int hauteur = 0;
        System.out.println("\n");
        System.out.println("Veuillez saisir un entier:");

        do {     //boucle pour chaque nouvelle saisie d'entier
            Scanner sc = new Scanner(System.in);
            noeud = sc.nextInt();
            hauteur++;
            System.out.println(noeud + " (" + hauteur + ")");

        } while(noeud != 0);


    }
}
