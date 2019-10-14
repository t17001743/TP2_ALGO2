import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int noeud = 0;
        ArbreBinaire arbreBinaire = new ArbreBinaire(new ArbreBinaire(), noeud, new ArbreBinaire());

        System.out.println("\n");
        System.out.println("Veuillez saisir un entier :");

        do {     //boucle pour chaque nouvelle saisie d'entier
            Scanner sc = new Scanner(System.in);
            noeud = sc.nextInt();

            //arbreBinaire.insertion(noeud, arbreBinaire);
            arbreBinaire.setNoeud(noeud);
            System.out.println(noeud + " (" + arbreBinaire.getHauteur() + ")");

            arbreBinaire.affichageArbreCrochets(arbreBinaire);
            System.out.println("\n");

            //arbreBinaire.getFilsG().setHauteur(hauteur++);
            //arbreBinaire.getFilsD().setHauteur(hauteur++);

            arbreBinaire.setFilsG(arbreBinaire.getFilsG());
            arbreBinaire.setFilsD(arbreBinaire.getFilsD());

            if (arbreBinaire.getFilsG().getHauteur() - arbreBinaire.getFilsD().getHauteur() == 2){
                System.out.println("Rééquilibrage de l'arbre...");
                arbreBinaire.reequilibrage(arbreBinaire);
            }

            //arbreBinaire.setFilsG(arbreBinaire.getFilsG());
            //arbreBinaire.setFilsD(arbreBinaire.getFilsD());

        } while(noeud != 0);
    }

}

