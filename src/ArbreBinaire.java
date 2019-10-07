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
     * Constructeur d'arbre non vide
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


    //fonction recherche élément


   /* public ArbreBinaire insertion(int cle,ArbreBinaire arbrebin){
        if (arbrebin == null ) {
            arbrebin = new ArbreBinaire(null, cle ,null);
        }
        if (cle<arbrebin.noeud){
            arbrebin.filsG= insertion(cle , arbrebin.filsG);
        }
        else if (cle>arbrebin.noeud){
            arbrebin.filsD= insertion(cle , arbrebin.filsD);
        }
        return arbrebin ;
    }*/


   /* public ArbreBinaire suppression(int cle , ArbreBinaire arbrebin){
        if (arbrebin.noeud == cle  && arbrebin.filsG==null && arbrebin.filsD == null) {
            return null;
        }
        else if (arbrebin.noeud == cle  && arbrebin.filsG != null && arbrebin.filsD != null){

        }
    }*/


    //fonction rééquilibrage


    //fonction affichage de l'arbre


}
