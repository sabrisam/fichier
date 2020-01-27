public class Vecteur {
    private double[] elements;  //tableau d'éléments de type double
    private int index;          //index qui permettera d'acceder à un élément'
    private double valeur;      //valeur de l'éléments'
    private double scalair;     //scalaire qui va servir pour la multiplication

    /**
     * Constructeur d'un vecteur
     * @param elements tableau d'éléments de type double
     */
    public Vecteur(double[] elements){
        this.elements = elements.clone();
    }

    /**
     * Setter qui permet de changer la valeur à l'index donnée
     * @param index l'emplecement ou l'on veut changer la donnée
     * @param valeur
     */
    public void setElement(int index, double valeur){
        this.index = index;
        this.valeur = valeur;
        this.elements[index] = valeur;
    }

    /**
     * Getter pour aller chercher la valeur d'un élément
     * @param index l'emplacement de l'élément
     * @return retourne la valeur de l'élément
     */
    private double getElement(int index){ //j'ai utilisé cette fonction dans la fonction print (afficher)
        return elements[index];
    }

    /**
     * Le produit scalaire d'un vecteur avec un autre vecteur
     * l'algo a été inspiré par un code de stackoverflow
     * https://stackoverflow.com/questions/58879154/dot-product-scalar-product-of-vectors-in-java
     * @param v l'autre vecteur
     * @return le résultat qui sera un nombre de type double
     */
    public double dotProduct(Vecteur v) {
        double scalair = 0.0;
        if(v.elements.length != elements.length){
            System.err.println("Erreur dans les dimensions des vecteurs");
            return Double.NaN;
        }else{
            for(int i=0; i<v.elements.length; i++){
                scalair = scalair + v.elements[i] * elements[i];
            }
        }
        return scalair;
    }

    /**
     * Affichage de vecteurs
     */
    public void afficher(){
        System.out.println( "{" + getElement(0) + ", " + getElement(1) + ", " + getElement(2) + "}" );
    }
}