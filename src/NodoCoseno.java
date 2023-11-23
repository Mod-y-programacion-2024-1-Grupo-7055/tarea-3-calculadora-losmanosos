import java.lang.Math;
public class NodoCoseno extends NodoOperador{
    
    public NodoCoseno(CompositeEA izq, CompositeEA der){
        super(izq, der);
        precedence = 1;
    }

    public double evalua() {
        return Math.cos(der.evalua());
   }
}

