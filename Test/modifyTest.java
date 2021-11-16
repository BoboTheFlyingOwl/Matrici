package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import MatrixEcxeption.WrongDimensionException;
import Src.Matrice;

public class modifyTest {
    
    @Test
    public void modTest() throws WrongDimensionException{
        Matrice<Float> M = sampleMatrix.C;

        assertTrue(M.DeleteColum(1).I() == M.DeleteColum(2).I());
        assertTrue(M.DeleteLine(1).I() == M.DeleteLine(2).I());

        int[] a1 = {0,1,2};
        int[] a2 = {1,2,3};
        assertTrue(M.Column(a1).length == M.Column(a2).length);

        int[] b1 = {0};
        int[] b2 = {2};
        assertTrue(M.Line(b1).length == M.Line(b2).length);

        assertTrue(M.Line(0)[0] == M.content(0, 0));
    }

    @Test
    public void addTest() throws WrongDimensionException{
        Matrice<Float> M = sampleMatrix.Col;

        assertTrue(M.AddLeft(M).IsSame(M.AddRight(M)));
        assertTrue(M.AddBottom(M).IsSame(M.AddTop(M)));
    }
}
