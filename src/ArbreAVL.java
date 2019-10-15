public class ArbreAVL {

    //nécessité des deux classes car impossible de manipuler un arbre vide correctement avec juste une des deux => NullPointerException

    private Noeud racine;
    private int hauteur;

    /**
     * Constructeur d'arbre vide
     */
    public ArbreAVL() {
        this.racine = null;
        this.hauteur = 0;
    }

    /**
     * Constructeur d'arbre non vide avec paramètres
     */
    public ArbreAVL(Noeud racine) {
        this.racine = racine;
        this.hauteur = 1 + Math.max(getHauteur(racine.getFilsG()), getHauteur(racine.getFilsD()));
    }


    public Noeud getRacine(){
        return this.racine;
    }


    public int getHauteur(Noeud noeud){
        if (noeud==null) return 0;
        else return 1 + Math.max(getHauteur(noeud.getFilsD()), getHauteur(noeud.getFilsD()));
    }


    /*
     * @param element l'élément à chercher dans l'arbre
     * @return un booléen indiquant vrai si l'élément a été trouvé dans l'arbre, faux sinon
     *
    public boolean rechercheElement(int element, ArbreAVL arbre) {
        if (element == arbre.getValeur())
            return true;
        if ((element < getNoeud()) && (getFilsG() != null))
            return (getFilsG().rechercheElement(element));
        if ((element > getNoeud()) && (getFilsD() != null))
            return (getFilsD().rechercheElement(element));
        return false;
    }*/


    /*
     * @param noeud le nouveau noeud à insérer dans l'arbre
     * @param arbre l'arbre dans lequel insérer le noeud
     * @return un nouvel arbre contenant le nouveau noeud
     *
    public ArbreAVL insertion(Noeud noeud, ArbreAVL arbre) {
        if (arbre == null) {
            return new ArbreAVL(new ArbreAVL(), noeud, new ArbreAVL());
        }
        if (noeud < arbre.getNoeud()) {
            arbre.filsG = insertion(noeud, arbre.getFilsG());
        } else if (noeud > arbre.getNoeud()) {
            arbre.filsD = insertion(noeud, arbre.getFilsD());
        }
        return reequilibrage(arbre);
    }



     * @param noeud le noeud à supprimer de l'arbre
     * @param arbre l'arbre dans lequel supprimer le noeud
     * @return un nouvel arbre ne contenant plus le noeud
     *
    public ArbreAVL suppression(int noeud, ArbreAVL arbre) {
        if (arbre == null)
            return arbre;
        if (noeud == arbre.noeud)
            return suppressionRacine(arbre);
        if (noeud < arbre.noeud)
            arbre.filsG = suppression(noeud, arbre.filsG);
        else
            arbre.filsD = suppression(noeud, arbre.filsD);
        return arbre;
    }



     * @param arbre l'arbre duquel supprimer la racine
     * @return l'arbre dont la racine a été supprimée
     *
    public ArbreAVL suppressionRacine(ArbreAVL arbre) {
        if (arbre.filsG == null)
            return arbre.filsD;
        if (arbre.filsD == null)
            return arbre.filsG;
        ArbreAVL arbre2 = descendant(arbre.filsG);
        arbre.noeud = arbre2.noeud;
        arbre.filsG = suppression(arbre2.noeud, arbre.filsG);
        return arbre;
    }*/


    /**
     * @param noeud le noeud pour lequel il faut chercher le descendant
     * @return le descendant d'un noeud
     */
    public Noeud descendant(Noeud noeud) {
        if (noeud.getFilsD() == null)
            return noeud;
        return descendant(noeud.getFilsD());
    }


    /**
     * @param noeud pour rééquilibrer l'arbre qui "penche" trop à droite
     * @return l'arbre rééquilibré à droite
     */
    public Noeud reequilibrageDroite(Noeud noeud) {
        Noeud b = noeud.getFilsG();
        Noeud c = new Noeud(noeud.getFilsD(), noeud.getValeur(), b.getFilsD());
        return new Noeud(c, b.getValeur(), b.getFilsG());
    }


    /**
     * @param noeud pour rééquilibrer l'arbre qui "penche" trop à gauche
     * @return l'arbre rééquilibré à gauche
     */
    public Noeud reequilibrageGauche(Noeud noeud) {
        Noeud b = noeud.getFilsD();
        Noeud c = new Noeud(noeud.getFilsG(), noeud.getValeur(), b.getFilsG());
        return new Noeud(c, b.getValeur(), b.getFilsD());
    }


    /**
     * @param noeud pour rééquilibrer l'arbre après une modification (insertion/suppression)
     * @return l'arbre rééquilibré
     */
    public Noeud reequilibrage(Noeud noeud) {
        if (getHauteur(noeud.getFilsG()) - getHauteur(noeud.getFilsD()) == 2) {
            if (getHauteur(noeud.getFilsG()) < getHauteur(noeud.getFilsG())){
                Noeud newNoeud = noeud.getFilsG();
                newNoeud = reequilibrageGauche(noeud.getFilsG());
            }

            return reequilibrageDroite(noeud);
        }
        return noeud;
    }

    public String affichageEntreCrochets(){
        return affichageEntreCrochets(racine);
    }



    /**
     * @param noeud le noeud à afficher
     * Afficher l'arbre dans la console avec des crochets sous la forme "[noeud, filsG, filsD]". Par exemple,
     * pour un arbre ne contenant qu'un seul noeud 30, il y aura "[30, null, null]".
     */
    public String affichageEntreCrochets(Noeud noeud){
        if (noeud==null) return "";
        else return (noeud.getValeur()+"["+ affichageEntreCrochets(noeud.getFilsG())+", "+ affichageEntreCrochets(noeud.getFilsD())+"]");
    }

}
