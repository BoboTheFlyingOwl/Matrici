package MatrixEcxeption;
public class WrongDimensionException extends Throwable{
    
    public WrongDimensionException (){
        super();
    }

    public WrongDimensionException (String s){
        super(s);
    }

}
