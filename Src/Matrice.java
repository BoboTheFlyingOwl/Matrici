package Src;

import Interface.Matrici;
import MatrixEcxeption.InvalidContentMatrix;
import MatrixEcxeption.NotSquareException;
import MatrixEcxeption.WrongDimensionException;

public class Matrice<T> implements Matrici {
    // STATE
    private final int I;
    private final int J;
    private float[][] content;

    // Costruttori
    // void constructor
    public Matrice() {
        this.I = 1;
        this.J = 1;
        this.content = new float[1][1];
    }

    // default init with specific dimension and default value of type
    public Matrice(int i, int j) {
        this.I = i;
        this.J = j;
        this.content = new float[i][j];
    }

    // init with dimensione and value in bidimensional array
    public Matrice(int i, int j, float[][] m) {
        this.I = i;
        this.J = j;
        this.content = new float[i][j];
        for (int y = 0; y < i; y++) {
            for (int x = 0; x < j; x++) {
                this.content[y][x] = m[y][x];
            }
        }
    }

    // init matrix colum or line
    public Matrice(boolean b, float[] f) {
        if (b) {
            // Matrice Colonna
            this.I = f.length;
            this.J = 1;
            this.content = new float[f.length][1];
            for (int y = 0; y < f.length; y++) {
                this.content[y][0] = f[y];
            }
        } else {
            // Matrice riga
            this.I = 1;
            this.J = f.length;
            this.content = new float[1][f.length];
            for (int x = 0; x < f.length; x++) {
                this.content[0][x] = f[x];
            }
        }

    }

    // init matrix with bidimensional array
    public Matrice(float[][] f) throws InvalidContentMatrix {

        for (int x = 0; x < f[0].length; x++) {
            if (f[x].length != f[0].length)
                throw new InvalidContentMatrix();
        }

        this.I = f.length;
        this.J = f[0].length;
        this.content = new float[this.I][this.J];
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                this.content[y][x] = f[y][x];
            }
        }
    }

    // GET SET
    // POST: return i
    public int I() {
        return I;
    }

    // POST: return j
    public int J() {
        return J;
    }

    // PRIVATE CHECK DIMENSION
    private boolean validDimension(int i, int j) {
        if (i > this.I) {
            return false;
        } else if (j > this.J) {
            return false;
        } else {
            return true;
        }
    }

    // POST: return value in <i,j> position
    public float content(int i, int j) throws WrongDimensionException {
        if (validDimension(i, j)) {
            return this.content[i][j];
        } else {
            String err = "";
            if (i >= this.I) {
                err += "idx i " + i + " -> out of matrix";
            }
            if (j > +this.J) {
                err += "idx j " + j + " -> out of matrix";
            }
            throw new WrongDimensionException(err);

        }
    }

    // EFFECT: set value <i,j> with value a
    public void content(int i, int j, float a) throws WrongDimensionException {
        if (validDimension(i, j)) {
            this.content[i][j] = a;
        } else {
            // errore
            throw new WrongDimensionException("Invalid index: <" + i + "," + j + ">");
        }
    }

    // IMPLEMENTS
    // CHECK METHODS

    // Check same size
    // POST: return if this and m have same size
    public boolean Samesize(Matrice<Float> m) {
        if (m.I() == this.I && m.J() == this.J) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Matrice<Float> Sum(Matrice<Float> m) throws WrongDimensionException {
        if (Samesize(m)) {
            Matrice<Float> res = new Matrice<>(this.I, this.J);
            for (int y = 0; y < this.I; y++) {
                for (int x = 0; x < this.J; x++) {
                    res.content[y][x] = this.content[y][x] + m.content(y, x);
                }
            }
            return res;
        } else {
            throw new WrongDimensionException("The matrix must have same size");
        }
    }

    @Override
    public Matrice<Float> ProductK(float k) {
        Matrice<Float> res = new Matrice<>(this.I, this.J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                res.content[y][x] = this.content[y][x] * k;
            }
        }
        return res;
    }

    @Override
    public Matrice<Float> ProductPtp(Matrice<Float> m) throws WrongDimensionException {
        if (!Samesize(m))
            throw new WrongDimensionException();
        Matrice<Float> res = new Matrice<>(I, J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                res.content[y][x] = this.content[y][x] * m.content[y][x];
            }
        }
        return res;
    }

    @Override
    public Matrice<Float> Product(Matrice<Float> m) throws WrongDimensionException {
        // A[mxn] * B[nxp] = C[mxp]
        if (this.J != m.I())
            throw new WrongDimensionException("Line and colum not corrispond");
        // Var temporanea per memorizazzione
        float[][] temp = new float[this.I][m.J()];
        /*
         * res_{i1, j2} = sum{} a _{i1 ,n} * b_{ n, j2}
         */
        float tot = 0f;
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < m.J(); x++) {
                tot = 0f;
                for (int n = 0; n < this.J; n++) {
                    tot += this.content(y, n) * m.content(n, x);
                }
                temp[y][x] = tot;
            }
        }
        return new Matrice<Float>(this.I, m.J(), temp);
    }

    @Override
    public Matrice<Float> Opposite() {
        Matrice<Float> res = new Matrice<>(this.I, this.J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                res.content[y][x] = -this.content[y][x];
            }
        }
        return res;
    }

    @Override
    public Matrice<Float> Diff(Matrice<Float> m) throws WrongDimensionException {
        return this.Sum(m.Opposite());
    }

    @Override
    public Matrice<Float> Traspose() {
        Matrice<Float> mt = new Matrice<>(this.J, this.I);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                mt.content[y][x] = this.content[x][y];
            }
        }
        return mt;
    }

    @Override
    public boolean IsSame(Matrice<Float> m) {
        if (!Samesize(m))
            return false;
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                if (this.content[y][x] != m.content[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean IsSquare() {
        return this.I == this.J;
    }

    @Override
    public boolean IsSym() {
        if (!IsSquare())
            return false;
        for (int y = 0; y < this.I; y++) {
            for (int x = y + 1; x < this.J; x++) {
                if (this.content[y][x] != this.content[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean IsAsym() {
        if (!IsSquare())
            return false; 
        for (int y = 0; y < this.I; y++) {
            for (int x = y + 1; x < this.J; x++) {
                if (this.content[y][x] != -this.content[x][y] && x != y) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public float Det() throws NotSquareException, WrongDimensionException {
        return recDet(1.0f);
    }

    private float recDet(float det) throws NotSquareException, WrongDimensionException {
        if (!this.IsSquare())
            throw new NotSquareException();
        // CASI BASE
        if (this.I == 1) {
            // Square 1x1
            return this.content[0][0];
        } else if (this.I == 2) {
            // Square 2x2
            return this.content[0][0] * this.content[1][1] - this.content[1][0] * this.content[0][1];
        } else {
            // Square nxn
            for (int x = 0; x < this.J; x++) {
                det += Math.pow(-1, x) * this.content[0][x] * this.Minor(0, x).Det();
            }
            return det;
        }

    }

    
    @Override
    public float[] Column(int j) throws WrongDimensionException {
        if (this.J <= j) {
            throw new WrongDimensionException("Colonna selezionata non esiste");
        }
        float[] res = new float[this.I];
        for (int y = 0; y < this.J; y++) {
            res[y] = this.content(y, j);
        }
        return res;
    }

    @Override
    public float[][] Column(int[] j) throws WrongDimensionException {
        for (int i = 0; i < j.length; i++) {
            if (this.J <= j[i]) {
                throw new WrongDimensionException("Colonna selezionata j[" + i + "]->" + j[i] + "non esiste");
            }
        }
        float[][] res = new float[this.I][j.length];

        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < j.length; x++) {

                res[y][x] = this.content[y][j[x]];
            }

        }

        return res;
    }

    @Override
    public float[][] Column(int from, int to) throws WrongDimensionException {
        if (this.J <= from || this.J <= to || this.J < from) {
            throw new WrongDimensionException("Range Colonna non esiste");
        }
        to += 1;
        float[][] res = new float[this.I][to - from];
        int yt = 0;
        for (int y = from; y < this.I; y++) {
            for (int x = from; x < to; x++) {
                res[yt][x] = this.content[y][x];
            }
            yt++;
        }
        return res;
    }

    @Override
    public float[] Line(int i) throws WrongDimensionException {
        if (this.J <= i) {
            throw new WrongDimensionException("Line selezionata non esiste");
        }
        return this.content[i];
    }

    @Override
    public float[][] Line(int[] i) throws WrongDimensionException {
        for (int x = 0; x < i.length; x++) {
            if (this.J <= i[x]) {
                throw new WrongDimensionException("Line selezionata j[" + x + "]->" + i[x] + "non esiste");
            }
        }

        float[][] res = new float[i.length][this.J];
        for (int y = 0; y < i.length; y++) {
            res[y] = this.Line(i[y]);
        }

        return res;
    }

    @Override
    public float[][] Line(int from, int to) throws WrongDimensionException {
        if (this.J <= from || this.J <= to) {
            throw new WrongDimensionException("Range Line non esiste");
        }
        to += 1;
        float[][] res = new float[(to - from)][this.J];
        for (int y = from; y < to; y++) {
            res[y] = this.Line(y);
        }

        return res;
    }

    @Override
    public Matrice<Float> Minor(int i, int j) throws WrongDimensionException {
        return this.DeleteLine(i).DeleteColum(j);
    }

    @Override
    public Matrice<Float> DeleteColum(int j) throws WrongDimensionException {
        if (this.J < j)
            throw new WrongDimensionException(" Colonna " + j + " non valida");
        int[] idx = new int[this.J - 1];
        for (int k = 0; k < this.J - 1; k++) {
            if (k < j) {
                idx[k] = k;
            } else {
                idx[k] = k + 1;
            }
        }
        return new Matrice<>(this.I, this.J - 1, this.Column(idx));
    }

    @Override
    public Matrice<Float> DeleteLine(int i) throws WrongDimensionException {
        if (this.I < i)
            throw new WrongDimensionException(" Line " + i + " non valida");
        int[] idx = new int[this.I - 1];
        for (int k = 0; k < this.I - 1; k++) {
            if (k < i) {
                idx[k] = k;
            } else {
                idx[k] = k + 1;
            }
        }
        return new Matrice<>(this.I - 1, this.J, this.Line(idx));
    }

    @Override
    public float[] Diagonal() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException("Matrix non quadrata");
        float[] diagonal = new float[this.I];
        for (int idx = 0; idx < this.I; idx++) {
            diagonal[idx] = this.content[idx][idx];
        }
        return diagonal;
    }

    @Override
    public boolean IsDiagonal() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException();
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                if (x != y && this.content[y][x] != 0) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public boolean UpperTriangular() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException();
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < y; x++) {
                if (this.content[y][x] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean LowerTriangular() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException();
        for (int y = 0; y < this.I; y++) {
            for (int x = y+1; x < this.J; x++) {
                if (this.content[y][x] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean IsUnit() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException();
        int[] col = new int[this.I];
        int[] lin = new int[this.J];
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                if (this.content[y][x] == 1) {
                    col[y]++;
                    lin[x]++;
                } else if (this.content[y][x] > 1) {
                    return false;
                }
            }
        }
        for (int x = 0; x < this.J; x++) {
            if (col[x] != 1 && lin[x] != 1)
                return false;
        }
        return true;
    }

    @Override
    public boolean IsDiagonalUnit() throws NotSquareException {
        if (!IsSquare())
            throw new NotSquareException();
        if (IsDiagonal())
            return true;
        float[] d = Diagonal();
        for (int i = 0; i < d.length; i++) {
            if (d[i] != 1)
                return false;
        }

        return true;
    }

    @Override
    public float MaxCol(int i) throws WrongDimensionException {
        if (i > this.I)
            throw new WrongDimensionException();
        float max = this.content[i][0];
        for (int x = 1; x < this.J; x++) {
            if (max < this.content[i][x])
                max = this.content[i][x];
        }
        return max;
    }

    @Override
    public float MaxLine(int j) throws WrongDimensionException {
        if (j > this.J)
            throw new WrongDimensionException();
        float max = this.content[0][j];
        for (int y = 1; y < this.I; y++) {
            if (max < this.content[y][j])
                max = this.content[y][j];
        }
        return max;
    }

    @Override
    public float Max() throws WrongDimensionException {
        float max = this.content[0][0];
        for (int y = 1; y < this.I; y++) {
            for (int x = 1; x < this.J; x++) {
                if (max < this.content[y][x])
                    max = this.content[y][x];
            }
        }
        return max;
    }

    @Override
    public float MinCol(int i) throws WrongDimensionException {
        if (i > this.I)
            throw new WrongDimensionException();
        float min = this.content[i][0];
        for (int x = 1; x < this.J; x++) {
            if (min > this.content[i][x])
                min = this.content[i][x];
        }
        return min;
    }

    @Override
    public float MinLine(int j) throws WrongDimensionException {
        if (j > this.J)
            throw new WrongDimensionException();
        float min = this.content[0][j];
        for (int y = 1; y < this.I; y++) {
            if (min > this.content[y][j])
                min = this.content[y][j];
        }
        return min;
    }

    @Override
    public float Min() throws WrongDimensionException {
        float min = this.content[0][0];
        for (int y = 1; y < this.I; y++) {
            for (int x = 1; x < this.J; x++) {
                if (min > this.content[y][x])
                    min = this.content[y][x];
            }
        }
        return min;
    }

    @Override
    public float[] CollapseCol() {
        float[] totCol = new float[this.J];
        float tot = 0f;
        for (int x = 0; x < this.J; x++) {
            for (int y = 0; y < this.I; y++) {
                tot += this.content[y][x];
            }
            totCol[x] = tot;
            tot = 0f;
        }

        return totCol;
    }

    @Override
    public float[] CollapseLine() {
        float[] totLine = new float[this.I];
        float tot = 0f;
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                tot += this.content[y][x];
            }
            totLine[y] = tot;
            tot = 0f;
        }

        return totLine;
    }

    @Override
    public float Collapse() {
        float tot = 0f;
        float[] tempTot = CollapseCol();
        for (int i = 0; i < tempTot.length; i++) {
            tot += tempTot[i];
        }
        return tot;
    }

    // OBJECT METHOD
    @Override
    public int hashCode() {
        return (int) Collapse() + (I * J);
    }

    @Override
    public String toString() {
        String s = "";
        s += "{<" + this.I + ", " + this.J + ">}\n";

        s += "{";
        for (int y = 0; y < this.I - 1; y++) {
            for (int x = 0; x < this.J; x++) {
                s += this.content[y][x] + ",";
            }
            s += "\n";
        }
        for (int x = 0; x < this.J - 1; x++) {
            s += this.content[this.I - 1][x] + ",";
        }
        s += this.content[this.I - 1][this.J - 1] + "}";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Matrice) {
            Matrice<Float> m = (Matrice<Float>) o;
            return IsSame(m);
        } else {
            return false;
        }

    }

    @Override
    public Matrice<Float> Inverse() {
        Matrice<Float> invM = new Matrice<>(this.I, this.J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J; x++) {
                invM.content[y][x] = 1 / this.content[y][x];
            }
        }
        return invM;
    }

    @Override
    public Matrice<Float> AddLeft(Matrice<Float> m) throws WrongDimensionException {
        if (this.I != m.I)
            throw new WrongDimensionException();
        Matrice<Float> nm = new Matrice<>(this.I, this.J + m.J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J + m.J; x++) {
                if (x < m.J) {
                    nm.content[y][x] = m.content[y][x];
                } else {
                    nm.content[y][x] = this.content[y][x - m.J];
                }
            }
        }
        return nm;
    }

    @Override
    public Matrice<Float> AddRight(Matrice<Float> m) throws WrongDimensionException {
        if (this.I != m.I)
            throw new WrongDimensionException();
        Matrice<Float> nm = new Matrice<>(this.I, this.J + m.J);
        for (int y = 0; y < this.I; y++) {
            for (int x = 0; x < this.J + m.J; x++) {
                if (x < this.J) {

                    nm.content[y][x] = this.content[y][x];
                } else {

                    nm.content[y][x] = m.content[y][x - this.J];
                }
            }
        }
        return nm;
    }

    @Override
    public Matrice<Float> AddTop(Matrice<Float> m) throws WrongDimensionException {
        if (this.J != m.J)
            throw new WrongDimensionException();
        Matrice<Float> nm = new Matrice<>(this.I + m.I, this.J);
        for (int y = 0; y < this.I + m.I; y++) {
            for (int x = 0; x < this.J; x++) {
                if (y < m.I) {
                    nm.content[y][x] = m.content[y][x];
                } else {
                    nm.content[y][x] = this.content[y - m.I][x];
                }
            }
        }
        return nm;
    }

    @Override
    public Matrice<Float> AddBottom(Matrice<Float> m) throws WrongDimensionException {
        if (this.J != m.J)
            throw new WrongDimensionException();
        Matrice<Float> nm = new Matrice<>(this.I + m.I, this.J);
        for (int y = 0; y < this.I + m.I; y++) {
            for (int x = 0; x < this.J; x++) {
                if (y < this.I) {
                    nm.content[y][x] = m.content[y][x];
                } else {
                    nm.content[y][x] = this.content[y - this.I][x];
                }
            }
        }
        return nm;
    }

}
