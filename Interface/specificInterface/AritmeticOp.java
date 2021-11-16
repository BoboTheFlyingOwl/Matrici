package Interface.specificInterface;
import MatrixEcxeption.*;
import Src.Matrice;

public interface AritmeticOp{
    //ARITMETICHE
    
    //Somma
    //PRE: this and m must have same size
    //POST: return matrix sum  
    public Matrice<Float> Sum(Matrice<Float> m ) throws WrongDimensionException;

    //Differenza
    //PRE: this and m must have same size
    //POST: return matrix sub  
    public Matrice<Float> Diff(Matrice<Float> m ) throws WrongDimensionException, NotSquareException;

    //Prodotto scalare
    //PRE: 
    //POST: return scalar product  
    public Matrice<Float> ProductK(float k);

    //Prodotto punto a punto
    //PRE: this and m must have same size
    //POST: Return matrix with product point on point
    public  Matrice<Float> ProductPtp(Matrice<Float> m )throws WrongDimensionException;

    //Prodotto matrice
    //PRE: this.j and m.i must have same size
    //POST: return product matrix  
    public Matrice<Float> Product(Matrice<Float> m ) throws WrongDimensionException;

    //DETERMINANTE
    //POST: return det of this matrix
    public float Det() throws NotSquareException, WrongDimensionException;

    //OPPOSTA
    //POST: return a opposite matrix of this
    public Matrice<Float> Opposite() ;

    //INVERSA

    public Matrice<Float> Inverse() ;

    //TRASPOSTA
    //POST: return a transpose matrix
    public Matrice<Float> Traspose();

    //MINOR
    //POST: return minor matrix of element i,j
    public Matrice<Float> Minor(int i, int j) throws WrongDimensionException;


}
