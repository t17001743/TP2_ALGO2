public class Noeud{

    private int valeur;
    private Noeud filsG, filsD;

    //Constructeur de noeud vide
    public Noeud(){
        valeur = 0;
        filsG = null;
        filsD = null;
    }

    //Constructeur de noeud avec paramètres
    public Noeud(Noeud filsG, int valeur, Noeud filsD){
        this.valeur = valeur;
        this.filsG = filsG;
        this.filsD = filsD;
    }

    public int getValeur() {
        return this.valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Noeud getFilsG() {
        return this.filsG;
    }

    public void setFilsG(Noeud filsG) {
        this.filsG = filsG;
    }

    public Noeud getFilsD() {
        return this.filsD;
    }

    public void setFilsD(Noeud filsD) {
        this.filsD = filsD;
    }
}
