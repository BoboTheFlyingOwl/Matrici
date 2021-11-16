package Interface.specificInterface;

import MatrixEcxeption.NotSquareException;
import MatrixEcxeption.WrongDimensionException;

public interface ValueMatrix {
    //PRE: this must is a square matrix
    //POST: return the diagonal 
    public float[] Diagonal() throws NotSquareException;

    //MAX METHOD
    //PRE: i < this.i
    //POST: return max value in i column
    public float MaxCol(int i) throws WrongDimensionException;

    //PRE: j < this.j
    //POST: return max value in i line
    public float MaxLine(int j) throws WrongDimensionException;
    
    //POST: return max value in this matrix
    public float Max() throws WrongDimensionException;

    //MIN METHODS
    //PRE: i < this.i
    //POST: return min value in i column
    public float MinCol(int j) throws WrongDimensionException;

    //PRE: j < this.j
    //POST: return min value in i line
    public float MinLine(int j) throws WrongDimensionException;

    //POST: return min value in this matrix
    public float Min() throws WrongDimensionException;


    //COLLAPSE
    //POST: return an array with sum of value in columns
    public float[] CollapseCol();

    //POST: return an array with sum of value in line
    public float[] CollapseLine();

    //POST: return sum of all values in matrix
    public float Collapse();
}
