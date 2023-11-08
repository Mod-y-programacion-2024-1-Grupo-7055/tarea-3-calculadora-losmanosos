
/**
 * Clase abstracta que modela a los nodos que contienen operadores aritméticos
 * y paréntesis izquierdos. La clase no puede ser concreta porque la
 * evaluación de cada nodo depende del operador de cada nodo.
 * 
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public abstract class NodoOperador implements CompositeEA{

    /**
     * Los hijos <code> izq</code> y <code>der</code>
     * que cada operador podría tener.
     */
    protected CompositeEA izq, der;

    /**
     * La precedencia en la jerarquía de operadores.
     */
    protected int precedence;
    
    /**
     * Constructor por omisión.
     */
    public NodoOperador(){
        izq=null;
        der=null;
    }

    /**
     * Constructor que recibe parámetros.
     * @param izq
     * @param der
     */
    public NodoOperador(CompositeEA izq, CompositeEA der) {
        this.izq=izq;
        this.der=der;
    }
    
    /**
     * Constructor copia
     * @param n
     */
    public NodoOperador(NodoOperador n){
        izq=n.izq;
        der=n.der;
    }
    
    /**
     * 
     * @param izq
     */
    public void setIzq(CompositeEA izq){
        this.izq=izq;
    }
    
    /**
     *
     * @param der
     */
    public void setDer(CompositeEA der){
        this.der=der;
    }
    
    /**
     *
     * @return
     */
    public int getPrecedence(){
        return precedence;
    }
    
    /**
     * Método que se encarga de la represencación en una cadena de los nodos.
     * Este método se implementa en esta clase abstracta para evitar repetir el
     * código en las clases concretas.
     * @return 
     */
    @Override
    public String toString() {
        String operador = this instanceof NodoSuma ? " + "
                        : this instanceof NodoResta ? " - "
                        : this instanceof NodoMultiplicacion ? " * " : " / ";

        if (izq != null) {
            return "(" + izq + operador + der + ")";
        }
        return  "("+ operador + der + ")";

    }
    
    /**
     * Método estático que genera una instancia de {@link NodoOperador}, dependiendo
     * de el operando que representa.
     * @param s El token con el operador.
     * @param anteriorEsOperador Nos dice si el token anterior también fue operador
     * (es necesario para el caso en el que la resta opera como operador unario).
     * @return Un nodo concreto, dependiendo del operador <code>s</code>
     * @throws ErrorDeSintaxisException En caso de recibir caracteres extraños.
     */
    public static NodoOperador factoryMethodOperadorNuevo(String s,
            boolean anteriorEsOperador) throws ErrorDeSintaxisException{
        switch (s) {
                case "+":
                    return new NodoSuma(null,null);
                case "-":
                    NodoOperador o = new NodoResta(null,null);
                    o.precedence=anteriorEsOperador? 3:0;
                    return o;
                case "*":
                    return new NodoMultiplicacion(null,null);
                case "/":
                    return new NodoDivision(null,null);
                case "(":
                    return new NodoParentesis();
                default:
                    throw new ErrorDeSintaxisException("Error de Sintáxis");
            }
    }
    
}