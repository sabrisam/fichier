public class Matrice {
    private int lignes;         //lignes pour la dimension
    private int cols;           //colonnes pour la dimension
    private double[][] donnee;  //tableau qui servira de modele pour stocker les donnees
    private double n;           //le nombre qui servira de scalaire pour l'addition et la multiplication
    private double valeur;      //valeur dans la matrice
    private int ligne;          //la ligne qui nous permettera d'aller chercher ou modifier un valeur en particulier
    private int col;            //la colonne qui nous permettera d'aller chercher ou modifier un valeur en particulier

    /**
     * Constructeur de matrice qui remplis des zeros
     *
     * @param lignes le nombre de lignes qu'aura la matrice (dimension)
     * @param cols le nombre de colonnes qu'aura la matrice (dimension)
     */
    public Matrice(int lignes, int cols) {
        if (lignes < 0 & cols < 0) {
            throw new IllegalArgumentException("Les dimensions ne doivent pas etre un nombre negatif");
        }
        this.lignes = lignes;
        this.cols = cols;
        donnee = new double[lignes][cols];
    }

    /**
     *  L'addition d'une matrice avec un scalaire
     * @param n le scalaire en question
     */
    public void additionnerScalaire(double n) {
        this.n = n;
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                donnee[i][j] = donnee[i][j] + this.n;
            }
        }
    }

    /**
     *  La multiplication d'une matrice un scalaire
     * @param n le scalaire en question
     */
    public void multiplierScalaire(double n) {
        this.n = n;
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                donnee[i][j] = donnee[i][j] * this.n;
            }
        }
    }

    /**
     *  Une matrice sera multiplier par une autre matrice
     * @param m l'autre matrice en question
     * @return le produit est retourné dans une nouvelle matrice X
     */
    public Matrice dotProduct(Matrice m) {
        Matrice base = this;
        if (base.cols != m.lignes) {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }
        Matrice X = new Matrice(base.lignes, m.cols);
        for (int i = 0; i < X.lignes; i++)
            for (int j = 0; j < X.cols; j++)
                for (int k = 0; k < base.cols; k++)
                    X.donnee[i][j] += (base.donnee[i][k] * m.donnee[k][j]);
        return X;
    }

    /**
     * Getter pour aller chercher une donnée particulière
     * @param ligne la ligne ou se trouve cette donnée
     * @param col la colonne ou se trouve cette donnée
     * @return la donnée
     */
    public double getCell(int ligne, int col) {
        this.ligne = ligne;
        this.col = col;
        return donnee[ligne][col];
    }

    /**
     * Setter qui permet de modifier une donnée particulière
     * @param ligne la ligne ou on veut modifier la donnée
     * @param col   la collone ou se trouve la donnée qu'on veut modifier
     * @param valeur la nouvelle donnée qu'on va mettre à l'emplacement spécifié
     */
    public void setCell(int ligne, int col, double valeur) {
        this.ligne = lignes;
        this.col = cols;
        this.valeur = valeur;
        donnee[ligne][col] = valeur;
    }

    /**
     * Retourne un nouveau vecteur contenant la Nieme ligne
     * @param ligne la Nieme ligne en question
     * @return le nouveau vecteur en question
     */
    public Vecteur getLine(int ligne){
        return new Vecteur(this.donnee[ligne-1]);
    }

    /**
     * Retourne un nouveau vecteur contenant la Nieme colonne
     * @param col la Nieme colonne en question
     * @return le nouveau vecteur en question
     */
    public Vecteur getCol(int col) {
        return new Vecteur(donnee[col]);
    }

    /**
     * Affiche la matrice et chaque ligne se trouve entre les crochets [ ]
     */
    public void afficher() {
        for (int i = 0; i < lignes; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(donnee[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Matrice transposée
     * @return retourne une version transposée de la matrice
     * !!(SANS modifier la matrice actuelle)!!
     */
    public Matrice transpose() {
        Matrice base = new Matrice(cols, lignes);
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < cols; j++) {
                base.donnee[j][i] = this.donnee[i][j];
            }
        }
        return base;
    }

    /**
     * Matrice identité
     * @param n dimension N x N
     * @return une instance de la matrice identité N x N
     */
    public static Matrice identite(int n) {
        Matrice I = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            I.donnee[i][i] = 1;
        }
        return I;
    }
}