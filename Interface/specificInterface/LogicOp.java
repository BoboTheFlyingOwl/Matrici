package Interface.specificInterface;

import MatrixEcxeption.NotSquareException;
import Src.Matrice;

public interface LogicOp {

    //Logic
    
    //same matrix
    //POST: return if this are same of m
    public boolean IsSame(Matrice<Float> m);

    //square matrix
    //POST: return if this is a square matrix
    public boolean IsSquare() ;

    //Simmetrica
    //POST: return if this this are sym matrix
    public boolean IsSym() ;

    //ASIMMETRICA
    //POST: return if this this are asym matrix
    public boolean IsAsym() ;

    //MATRICE DIAGONALE
    //POST: return if this are diagonal matrix
    public boolean IsDiagonal()throws NotSquareException;

    //TRIANGOLARE ALTA
    //POST: return if this are upper triagonal matrix
    public boolean UpperTriangular()throws NotSquareException;

    //TRIANGOLARE BASSA
    //POST: return if this are lower triagonal matrix
    public boolean LowerTriangular()throws NotSquareException;

    //MATRICE IDENTITA 
    //POST: return if this are unit matrix
    public boolean IsUnit()throws NotSquareException;

    //MATRICE IDENTITA -> forma diagonale 1
    //POST: return if this are unit matrix
    public boolean IsDiagonalUnit() throws NotSquareException;
    
}
