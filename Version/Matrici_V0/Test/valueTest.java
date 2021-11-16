package Test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import MatrixEcxeption.WrongDimensionException;
import Src.Matrice;

public class valueTest {
    
    //Test massimo
    @Test
    public void maxTest() throws WrongDimensionException{
        Matrice<Float> M = sampleMatrix.A;
        float maxC=0;
        for(int y=0; y < M.I(); y++){
            if(maxC < M.MaxCol(y)) maxC = M.MaxCol(y);
        }

        float maxL=0;
        for(int x=0; x < M.J(); x++){
            if(maxL < M.MaxLine(x)) maxL = M.MaxLine(x);
        }
        
        assertTrue(maxC == M.Max());
        assertTrue(maxL == M.Max());
    }

    //Test massimo
    @Test
    public void minTest() throws WrongDimensionException{
        Matrice<Float> M = sampleMatrix.A2;
        float minC = M.MinCol(0);
        for(int y=0; y < M.I(); y++){
            if(minC > M.MinCol(y)) minC = M.MinCol(y);
        }
        
        float minL=M.MinCol(0);
        for(int x=0; x < M.J(); x++){
            if(minL > M.MinLine(x)) minL = M.MinLine(x);
        }
        
        assertTrue(minC == M.Min());
        assertTrue(minL == M.Min());
    }


    @Test
    public void orderMaxMinTest() throws WrongDimensionException{
        Matrice<Float> M = sampleMatrix.A;
        assertTrue(M.Max() >= M.Min());
    }

    @Test
    public void collapseTest() {
        Matrice<Float> M = sampleMatrix.C;
        float[] totLine = M.CollapseLine();
        float[] totCol = M.CollapseCol();
        float tempTot = supportFoo(totLine) + supportFoo(totCol);

        float tot = M.Collapse();

        assertTrue(supportFoo(totLine) == supportFoo(totCol));
        assertTrue(2*tot == tempTot);
    }

    private float supportFoo(float[] a){
        float tot = 0f;;
        for(int i = 0; i < a.length; i++){
            tot += a[i];
        }
        return tot;
        
    }
}
