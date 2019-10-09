public class ArbreBinaire {
    int noeud, hauteur ;
    ArbreBinaire filsG , filsD ;
    //ArbreBinaire arbrebin ;

    /**
     * Constructeur d'arbre vide
     */
    public ArbreBinaire (){
        this.noeud = 0;
        this.hauteur = 0;
        this.filsG =null;
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
     * @param arbre un arbre binaire
     */
    public void calculerHauteurArbre(ArbreBinaire arbre){
        arbre.hauteur = 1 + Math.max(filsG.getHauteur(), filsD.getHauteur());
    }


    //fonction recherche élément


    /**
     * @param noeud le nouveau noeud à insérer dans l'arbre
     * @param arbre l'arbre dans lequel insérer le noeud
     * @return un nouvel arbre contenant le nouveau noeud
     */
    public ArbreBinaire insertion(int noeud, ArbreBinaire arbre){
        if (arbre == null) {
            return new ArbreBinaire(new ArbreBinaire(), noeud , new ArbreBinaire());
        }
        if (noeud < arbre.getNoeud()){
            arbre.filsG = insertion(noeud , arbre.getFilsG());
        }
        else if (noeud > arbre.getNoeud()){
            arbre.filsD = insertion(noeud , arbre.getFilsD());
        }
        return reequilibrage(arbre);
    }

    /*
     * @param noeud le noeud à supprimer de l'arbre
     * @param arbre l'arbre dans lequel supprimer le noeud
     * @return un nouvel arbre ne contenant plus le noeud

    public ArbreBinaire suppression(int noeud , ArbreBinaire arbrebin){
        if (arbrebin.noeud == noeud  && arbrebin.filsG == null && arbrebin.filsD == null) {
            return null;
        }
        else if ((arbrebin.noeud == noeud  && arbrebin.filsG != null && arbrebin.filsD == null) || (arbrebin.noeud == noeud  && arbrebin.filsG == null && arbrebin.filsD != null)){

        }
        else if
    }*/


    public ArbreBinaire reequilibrageDroite(ArbreBinaire arbre){
        ArbreBinaire b = arbre.filsG;
        ArbreBinaire c = new ArbreBinaire(arbre.filsD, arbre.noeud, b.filsD);
        return new ArbreBinaire(c, b.noeud, b.filsG);
    }


    public ArbreBinaire reequilibrageGauche(ArbreBinaire arbre){
        ArbreBinaire b = arbre.filsD;
        ArbreBinaire c = new ArbreBinaire(arbre.filsG, arbre.noeud, b.filsG);
        return new ArbreBinaire(c, b.noeud, b.filsD);
    }


    /**
     * @param arbre l'arbre à rééquilibrer après une modification (insertion/suppression)
     * @return l'arbre rééquilibré
     */
    public ArbreBinaire reequilibrage(ArbreBinaire arbre){
        calculerHauteurArbre(arbre);
        if (arbre.filsG.getHauteur() - arbre.filsD.getHauteur() == 2){
            if (arbre.filsG.filsG.getHauteur() < arbre.filsG.filsD.getHauteur())
                arbre.filsG = reequilibrageGauche(arbre.filsG);
            return reequilibrageDroite(arbre);
        } //else
        /*if (arbre.filsG.getHauteur() - arbre.filsD.getHauteur() == -2){
            ...
        }*/
        return arbre;
    }


    /*fonction affichage de l'arbre
    public void afficherArbre(Arbre *racine, ulong prof)
    {
        ulong i;
        for (i=0; i < prof; i++)
        {
            fputs("|___ ", stdout);
        }

        printf("[%s]\n", facine->nom);
        if (racine->g) aff(racine->g, prof + 1);
        if (racine->d) aff(racine->d, prof + 1);
    }*/


}
