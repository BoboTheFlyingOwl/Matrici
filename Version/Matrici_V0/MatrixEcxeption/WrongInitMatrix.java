package MatrixEcxeption;
public class WrongInitMatrix extends Throwable{
    public WrongInitMatrix(){
        super();
    }
    public WrongInitMatrix(String s){
        super(s);
    }
}
