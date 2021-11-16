package MatrixEcxeption;
public class NotSquareException extends Throwable{
    public NotSquareException(){
        super();
    }
    public NotSquareException(String s){
        super(s);
    }
}