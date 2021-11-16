package Interface;

import Interface.specificInterface.AritmeticOp;
import Interface.specificInterface.LogicOp;
import Interface.specificInterface.ModifyOp;
import Interface.specificInterface.ValueMatrix;

public interface Matrici extends AritmeticOp, LogicOp, ModifyOp, ValueMatrix{
    
    //OBJECT METHOD
    @Override
    public int hashCode();
    
    @Override
    public String toString();

    @Override
    public boolean equals(Object o);
}