public class ArbreBinaire {
    int noeud ;
    ArbreBinaire filsG , filsD ;
    ArbreBinaire arbrebin ;

    public ArbreBinaire (){
        this.noeud =0;
        this.filsG =null;
        this.filsD = null;
    }

    public ArbreBinaire(ArbreBinaire filsG,int noeud, ArbreBinaire filsD) {
        this.noeud = noeud;
        this.filsG = filsG;
        this.filsD = filsD;
    }

    public ArbreBinaire insertion(int cle,ArbreBinaire arbrebin){
        if (arbrebin == null ) {
            return new ArbreBinaire(null, cle ,null);
        }
        if (cle<arbrebin.noeud){
            arbrebin.filsG= insertion(cle , arbrebin.filsG);
        }
        else if (cle>arbrebin.noeud){
            arbrebin.filsD= insertion(cle , arbrebin.filsD);
        }
        return arbrebin ;

    }



    public void suppression(int cle , ArbreBinaire arbrebin){


    }


}