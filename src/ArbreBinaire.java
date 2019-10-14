public class ArbreBinaire {

    private int noeud, hauteur;
    private ArbreBinaire filsG, filsD;

    /**
     * Constructeur d'arbre vide
     */
    public ArbreBinaire() {
        this.noeud = 0;
        this.hauteur = 0;
        this.filsG = null;
        this.filsD = null;
    }

    /**
     * Constructeur d'arbre non vide avec paramètres
     */
    public ArbreBinaire(ArbreBinaire filsG, int noeud, ArbreBinaire filsD) {
        this.noeud = noeud;
        this.hauteur = 1 + Math.max(filsG.getHauteur(), filsD.getHauteur());
        this.filsG = filsG;
        this.filsD = filsD;
    }

    public int getNoeud() {
        return noeud;
    }

    public void setNoeud(int noeud) {
        this.noeud = noeud;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public ArbreBinaire getFilsG() {
        return filsG;
    }

    public void setFilsG(ArbreBinaire filsG) {
        this.filsG = filsG;
    }

    public ArbreBinaire getFilsD() {
        return filsD;
    }

    public void setFilsD(ArbreBinaire filsD) {
        this.filsD = filsD;
    }


    /**
     * @param element l'élément à chercher dans l'arbre
     * @return un booléen indiquant vrai si l'élément a été trouvé dans l'arbre, faux sinon
     */
    public boolean rechercheElement(int element) {
        if (element == getNoeud())
            return true;
        if ((element < getNoeud()) && (getFilsG() != null))
            return (getFilsG().rechercheElement(element));
        if ((element > getNoeud()) && (getFilsD() != null))
            return (getFilsD().rechercheElement(element));
        return false;
    }


    /**
     * @param noeud le nouveau noeud à insérer dans l'arbre
     * @param arbre l'arbre dans lequel insérer le noeud
     * @return un nouvel arbre contenant le nouveau noeud
     */
    public ArbreBinaire insertion(int noeud, ArbreBinaire arbre) {
        if (arbre == null) {
            return new ArbreBinaire(new ArbreBinaire(), noeud, new ArbreBinaire());
        }
        if (noeud < arbre.getNoeud()) {
            arbre.filsG = insertion(noeud, arbre.getFilsG());
        } else if (noeud > arbre.getNoeud()) {
            arbre.filsD = insertion(noeud, arbre.getFilsD());
        }
        return reequilibrage(arbre);
    }


    /**
     * @param noeud le noeud à supprimer de l'arbre
     * @param arbre l'arbre dans lequel supprimer le noeud
     * @return un nouvel arbre ne contenant plus le noeud
     */
    public ArbreBinaire suppression(int noeud, ArbreBinaire arbre) {
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


    /**
     * @param arbre l'arbre duquel supprimer la racine
     * @return l'arbre dont la racine a été supprimée
     */
    public ArbreBinaire suppressionRacine(ArbreBinaire arbre) {
        if (arbre.filsG == null)
            return arbre.filsD;
        if (arbre.filsD == null)
            return arbre.filsG;
        ArbreBinaire arbre2 = descendant(arbre.filsG);
        arbre.noeud = arbre2.noeud;
        arbre.filsG = suppression(arbre2.noeud, arbre.filsG);
        return arbre;
    }


    /**
     * @param arbre l'arbre dans lequel faire la recherche
     * @return le descendant d'un noeud
     */
    public ArbreBinaire descendant(ArbreBinaire arbre) {
        if (arbre.filsD == null)
            return arbre;
        return descendant(arbre.filsD);
    }


    /**
     * @param arbre l'arbre à rééquilibrer, qui "penche" trop à droite
     * @return l'arbre rééquilibré à droite
     */
    public ArbreBinaire reequilibrageDroite(ArbreBinaire arbre) {
        ArbreBinaire b = arbre.filsG;
        ArbreBinaire c = new ArbreBinaire(arbre.filsD, arbre.noeud, b.filsD);
        return new ArbreBinaire(c, b.noeud, b.filsG);
    }


    /**
     * @param arbre l'arbre à rééquilibrer, qui "penche" trop à gauche
     * @return l'arbre rééquilibré à gauche
     */
    public ArbreBinaire reequilibrageGauche(ArbreBinaire arbre) {
        ArbreBinaire b = arbre.filsD;
        ArbreBinaire c = new ArbreBinaire(arbre.filsG, arbre.noeud, b.filsG);
        return new ArbreBinaire(c, b.noeud, b.filsD);
    }


    /**
     * @param arbre l'arbre à rééquilibrer après une modification (insertion/suppression)
     * @return l'arbre rééquilibré
     */
    public ArbreBinaire reequilibrage(ArbreBinaire arbre) {
        if (arbre.filsG.getHauteur() - arbre.filsD.getHauteur() == 2) {
            if (arbre.filsG.filsG.getHauteur() < arbre.filsG.filsD.getHauteur())
                arbre.filsG = reequilibrageGauche(arbre.filsG);
            return reequilibrageDroite(arbre);
        }
        return arbre;
    }


    /**
     * @param arbre l'arbre à afficher
     * Afficher l'arbre dans la console avec des crochets sous la forme "[noeud, filsG, filsD]". Par exemple,
     * pour un arbre ne contenant qu'un seul noeud 30, il y aura "[30, null, null]".
     */
    public void affichageArbreCrochets(ArbreBinaire arbre){
        System.out.println("[" + arbre.noeud + ", " + arbre.filsG.filsG + ", " + arbre.filsD.filsD + "]");
    }

}
