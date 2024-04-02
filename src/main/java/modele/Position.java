package modele;

public class Position {
    private static int nombreDePas = 0;
    private int abscisse;
    private int ordonnee;

    public Position(int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    /**
     * la méthode deplacementUneCase déplace la position this d'une case
     * pour la rapprocher de celle du paramètre parPosition
     * elle incrémente le champ static nombreDePas
     * @param parPosition : la position vers
     */
    public void deplacementUneCase (Position parPosition){
        nombreDePas++;
        int i = 0;
        if (this.abscisse > parPosition.abscisse) {
            this.abscisse -= 1;
            return;
        }
        if (this.abscisse < parPosition.abscisse) {
            this.abscisse += 1;
            return;
        }
        if (this.abscisse > parPosition.ordonnee) {
            this.abscisse += 1;
            return;
        }
        if (this.abscisse < parPosition.ordonnee) {
            this.abscisse -= 1;
            return;
        }

        if (this.equals(parPosition)){
            return;
        }

    }
    public int getAbscisse() {
        return this.abscisse;
    }


    public int getOrdonnee() {
        return this.ordonnee;
    }

    public String toString(){

        return abscisse + " " + ordonnee;
    }
}
