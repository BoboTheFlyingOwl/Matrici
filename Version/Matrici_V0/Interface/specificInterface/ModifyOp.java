package Interface.specificInterface;

import MatrixEcxeption.WrongDimensionException;
import Src.Matrice;

public interface ModifyOp {
    
    //SELECT COLUMN
    //PRE: index i < this.i
    //POST: return specific column of this, if colum is valid
    public float[] Column(int i) throws WrongDimensionException;

    //PRE: forAll idx in int[] index i[idx] < this.i
    //POST: return specific column of this, if colum is valid
    public float[][] Column(int[] i) throws WrongDimensionException;

    //PRE: from < to and to < this.i 
    //POST: return specific column of this from from to to, if colum is valid
    public float[][] Column(int from, int to) throws WrongDimensionException;

    //PRE: index i < this.i
    //POST: return a matrix without a specific column, if column is valid
    public Matrice<Float> DeleteColum(int i) throws WrongDimensionException;
   
    //SELECT LINE
    //PRE: index j < this.j
    //POST: return specific Line of this, if Line is valid
    public float[] Line(int i) throws WrongDimensionException;

    //PRE: forAll idx in int[] index j[idx] < this.j
    //POST: return specific Line of this, if Line is valid
    public float[][] Line(int[] i) throws WrongDimensionException;

    //PRE: from < to and to < this.j
    //POST: return specific Line of this from from to to, if Line is valid
    public float[][] Line(int from, int to) throws WrongDimensionException;

    //PRE: index j < this.j
    //POST: return a matrix without a specific line, if line is valid
    public Matrice<Float> DeleteLine(int j) throws WrongDimensionException;


    public Matrice<Float> AddLeft(Matrice<Float> m ) throws WrongDimensionException;
    public Matrice<Float> AddRight(Matrice<Float> m ) throws WrongDimensionException;
   

    public Matrice<Float> AddTop(Matrice<Float> m ) throws WrongDimensionException;
    public Matrice<Float> AddBottom(Matrice<Float> m ) throws WrongDimensionException;
    
}
