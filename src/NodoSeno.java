import java.lang.Math;
public class NodoSeno extends NodoOperador{
    
    public NodoSeno(CompositeEA izq, CompositeEA der){
        super(izq, der);
        precedence = 1;

    }
    public double evalua(){
        return Math.sin(der.evalua());
    }
}
