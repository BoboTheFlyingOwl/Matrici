package Test;

import Src.Matrice;

public class sampleMatrix {


    public static final float[][] a = {
        {1.0f, 2.0f},
        {3.0f, 4.0f},
    };

    public static final float[][] a_2 = {
        {2.0f, 4.0f},
        {6.0f, 8.0f},
    };

    public static final float[][] b = {
        {1.0f, 2.0f, 3.0f},
        {2.0f, 3.0f, 4.0f},
        {3.0f, 4.0f, 5.0f},
    };

    public static final float[][] col = {
        {1.0f},
        {2.0f},
        {3.0f},
    };

    public static final float[][] line = {
        {1.0f,2.0f,3.0f}
    };

    public static final float[][] c = {
        {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f},
        {2.0f, 3.0f, 4.0f, 3.0f, 2.0f, 4.0f},
        {3.0f, 4.0f, 5.0f, 2.0f, 1.0f, 2.0f},
    };

    public static final float[][] sim = {
        {1.0f, 2.0f, 3.0f},
        {2.0f, 1.0f, 4.0f},
        {3.0f, 4.0f, 1.0f},
    };

    public static final float[][] asim = {
        {1.0f, 2.0f, 3.0f},
        {-2.0f, 1.0f, 4.0f},
        {-3.0f, -4.0f, 1.0f},
    };

    public static final float[][] diag = {
        {1.0f,.0f, .0f},
        {.0f, 1.0f, .0f},
        {.0f, .0f, .0f},
    };

    public static final float[][] uT = {
        {1.0f, 2.0f, .0f, .0f},
        {.0f, 1.0f, .0f, 6.0f},
        {.0f, .0f, 1.0f, 6.0f},
        {.0f, .0f, .0f, 1.0f}
    };

    public static final float[][] lT = {
        {1.0f, .0f, .0f, .0f},
        {2.0f, 1.0f, .0f, .0f},
        {.0f, 4.0f, 1.0f, .0f},
        {.0f, 3.0f, .0f, 1.0f}
    };

    public static final float[][] unit = {
        {1.0f, .0f, .0f},
        {.0f, 1.0f, .0f},
        {.0f, .0f, 1.0f},
    };

    public static final float[][] unit2 = {
        {1.0f, .0f, .0f},
        {.0f, .0f, 1.0f},
        {.0f, 1.0f, .0f},
    };

    public static final float[][] d = {
        {2.0f, 2.0f},
        {2.0f, 2.0f},
    };

    public static final float[][] at = {
        {1.0f, 3.0f},
        {2.0f, 4.0f},
    };

    public static float k1 = 2.0f;
    public static Matrice<Float> A = new Matrice<>(2,2,a);
    public static Matrice<Float> A2 = new Matrice<>(2,2,a_2);
    public static Matrice<Float> B = new Matrice<>(3,3,b);
    public static Matrice<Float> Col = new Matrice<>(3,1,col);
    public static Matrice<Float> Line = new Matrice<>(1,3,line);
    public static Matrice<Float> C = new Matrice<>(3,6,c);

    public static Matrice<Float> Sym = new Matrice<>(3,3,sim);
    public static Matrice<Float> ASym = new Matrice<>(3,3,asim);

    public static Matrice<Float> Diag = new Matrice<>(3,3,diag);
    public static Matrice<Float> UT = new Matrice<>(4,4, uT);
    public static Matrice<Float> LT = new Matrice<>(4,4, lT);
    public static Matrice<Float> Un = new Matrice<>(3,3, unit);
    public static Matrice<Float> Un2 = new Matrice<>(3,3, unit2);

    public static Matrice<Float> D = new Matrice<>(2,2, d);
    public static Matrice<Float> At = new Matrice<>(2,2, at);

}
