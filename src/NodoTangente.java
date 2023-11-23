import java.lang.Math;
public class NodoTangente extends NodoOperador{
    
    public NodoTangente(CompositeEA izq, CompositeEA der){
        super(izq, der);
        precedence = 1;
    }
    public double evalua(){
        return Math.tan(der.evalua());
    }
    
}
