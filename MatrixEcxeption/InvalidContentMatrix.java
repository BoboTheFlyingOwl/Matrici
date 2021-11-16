package MatrixEcxeption;

public class InvalidContentMatrix extends Throwable{
    public InvalidContentMatrix(){
        super();
    }
    public InvalidContentMatrix(String s){
        super(s);
    }
}
