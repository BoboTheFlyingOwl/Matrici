package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import MatrixEcxeption.NotSquareException;

public class logicTest {
    
    @Test
    public void IsSameTest(){
        assertTrue(sampleMatrix.A.IsSame(sampleMatrix.A));
        assertFalse(sampleMatrix.A.IsSame(sampleMatrix.B));

    }

    @Test
    public void IsSquareTest(){
        assertTrue(sampleMatrix.A.IsSquare());
        assertTrue(sampleMatrix.A2.IsSquare());
        assertTrue(sampleMatrix.B.IsSquare());
        assertFalse(sampleMatrix.Col.IsSquare());
        assertFalse(sampleMatrix.Line.IsSquare());
    }

    @Test
    public void IsSymTest(){
        assertTrue(sampleMatrix.Sym.IsSym());
        assertFalse(sampleMatrix.A.IsSym());
    }

    @Test
    public void IsASymTest(){
        assertTrue(sampleMatrix.ASym.IsAsym());
        assertFalse(sampleMatrix.B.IsAsym());
    }

    @Test
    public void IsDiagonalTest() {
        try {
            assertTrue(sampleMatrix.Diag.IsDiagonal());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        //Check Exception
        try {
            sampleMatrix.C.IsDiagonal();
            assertTrue(false);
        } catch (NotSquareException e) {
            assertTrue(true);
        }
       
        try {
            assertFalse(sampleMatrix.A.IsDiagonal());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UpperTriangularTest(){
       
        try {
            assertTrue(sampleMatrix.UT.UpperTriangular());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        try {
            sampleMatrix.Line.UpperTriangular();
            assertTrue(false);
        } catch (NotSquareException e) {
            assertTrue(true);
        }

        try {
            assertFalse(sampleMatrix.A2.UpperTriangular());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void LowerTriangularTest(){
       
        try {
            assertTrue(sampleMatrix.LT.LowerTriangular());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        try {
            sampleMatrix.Line.LowerTriangular();
            assertTrue(false);
        } catch (NotSquareException e) {
            assertTrue(true);
        }

        try {
            assertFalse(sampleMatrix.A2.LowerTriangular());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void IsDiagonalUnitTest(){
       
        try {
            assertTrue(sampleMatrix.Un.IsDiagonalUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        try {
            sampleMatrix.Line.IsDiagonalUnit();
            assertTrue(false);
        } catch (NotSquareException e) {
            assertTrue(true);
        }

        try {
            assertFalse(sampleMatrix.A2.IsDiagonalUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void IsUnitTest(){
       
        try {
            assertTrue(sampleMatrix.Un2.IsUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        try {
            sampleMatrix.Line.IsUnit();
            assertTrue(false);
        } catch (NotSquareException e) {
            assertTrue(true);
        }

        try {
            assertFalse(sampleMatrix.A2.IsUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void sameUnitValueTest(){
        try {
            assertTrue(sampleMatrix.Un.IsUnit());
            assertTrue(sampleMatrix.Un2.IsUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

        try {
            assertTrue(sampleMatrix.Un.IsDiagonalUnit());
            assertFalse(sampleMatrix.Un2.IsDiagonalUnit());
        } catch (NotSquareException e) {
            e.printStackTrace();
        }

    }
}
