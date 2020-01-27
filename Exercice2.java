/******************************************************************************
 *  Compilation:  javac Exercice2.java
 *  Execution:    java Exercice2
 *
 * @author Sami-Yassine Sabri
 *         Matricule 20113533
 ******************************************************************************/public class Exercice2 {
    public static void main(String[] args) {

        double[] elements = new double[]{1, 2, 3};
        Vecteur v1 = new Vecteur(elements);
        Vecteur v2 = new Vecteur(elements);
        v2.setElement(0, 10);

        System.out.println("--- Vecteurs ---");
        v1.afficher();
        v2.afficher();

        System.out.println("--- Matrices ---");

        Matrice m1 = Matrice.identite(2);
        m1.multiplierScalaire(3);
        m1.setCell(0, 1, 5);
        m1.setCell(1, 0, -2);
        System.out.println("Matrice 1 :");
        m1.afficher();

        Matrice m2 = new Matrice(2, 1);
        m2.additionnerScalaire(10);
        System.out.println("Matrice 2 :");
        m2.afficher();

        Matrice m3 = m1.dotProduct(m2);
        System.out.println("Matrice 3 :");
        m3.afficher();

        //... d'autres tests que vous écrirez ...
        //getElement est utilisé dans la fonction afficher() des vecteurs
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("--- Mes tests ---");

        System.out.print("Version Transposée de la Matrice 3 :");
        m3.transpose().afficher();
        System.out.println("Preuve que la Matrice 3 n'a pas été modifiée par la transposée : ");
        m3.afficher();

        System.out.println("Premier élément de la Matrice 1 :");
        System.out.println(m1.getCell(0,0));

        double v4 = v1.dotProduct(v2);
        System.out.println("Produit scalaire du vecteur v1 avec le vecteur v2 : "+ v4);










        System.out.println("Deuxième ligne de la Matrice 2 :");





    }
}