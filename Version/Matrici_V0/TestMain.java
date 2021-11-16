import MatrixEcxeption.NotSquareException;
import MatrixEcxeption.WrongDimensionException;
import Src.Matrice;
import Test.sampleMatrix;

public class TestMain {

    public static void main(String[] args) {
        float[][] a = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25},
        };

        float[][] b = {
            {1,2,3},
            {2,3,4}
        };

        float[][] c = {
            {1,1,1,1},
            {1,2,3,4},
            {2,3,4,5}
        };
        float[][] d1 = {
            {3,0,0},
            {1,4,0},
            {2,3,3}
        };

        float[] l = { 3, 1};

        float[] temp = {0,2,3};

        Matrice<Float> A = new Matrice<Float>(5, 5,a);
        Matrice<Float> B = new Matrice<Float>(2, 3,b);
        Matrice<Float> C = new Matrice<Float>(3, 4,c);
        Matrice<Float> D1 = new Matrice<Float>(3, 3,d1);
        Matrice<Float> T = new Matrice<Float>(false, l);
            
        Matrice<Float> A1 = sampleMatrix.A;
        Matrice<Float> Q1 = sampleMatrix.D;

            try {
           // float[][] f = A.Line(temp);
            float[] f2 = A.Line(0);
            
                System.out.println(A1.ProductPtp(Q1));
            } catch (  WrongDimensionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
       
    }

    private static String stampa(float[] f){
        String s = "{";
        for(int i =0; i < f.length; i++){
            s+= f[i] + ", ";
        }
        return s + "}";
    }
    private static String stampa(float[][] f){
        String s = "{";
        
        for(int i =0; i < f.length; i++){
            s += "\n";
            for(int j =0; j < f[0].length; j++){
            s+= f[i][j] + ", ";
            }
        }
        return s + "}";
    }

    

}
