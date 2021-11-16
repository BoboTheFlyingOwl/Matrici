package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import MatrixEcxeption.NotSquareException;
import MatrixEcxeption.WrongDimensionException;
import Src.Matrice;

public class AritmeticTest{
    //Sum
    @Test
    public void MathAritTest() throws WrongDimensionException, NotSquareException{
        Matrice<Float> A = sampleMatrix.A;
        Matrice<Float> At = sampleMatrix.At;
        Matrice<Float> Q = sampleMatrix.D;
        Matrice<Float> Sum = sampleMatrix.A2;

        assertTrue(A.Sum(A).IsSame(Sum));
        assertTrue(Sum.Diff(A).IsSame(A));
        assertTrue(A.ProductK(2.0f).IsSame(Sum));
        assertTrue(A.ProductPtp(Q).IsSame(Sum));
        assertTrue(A.Opposite().Opposite().IsSame(A));
        assertFalse(A.Opposite().IsSame(A));
        assertTrue(A.Traspose().IsSame(At));
        assertTrue(A.Traspose().Traspose().Traspose().Traspose().IsSame(A));
        assertTrue(A.Inverse().Inverse().IsSame(A));

        assertTrue(A.Det() == -2.0f);
        
    }
}