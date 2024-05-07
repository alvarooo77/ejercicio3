public class ListasJava {
    public static void main(String[] args) {
        ListaInt milista = new ListaInt("miLista");
    }
}

class NodoListaInt {
    // atributos
    public int numero;
    public NodoListaInt sig;

    // constructor
    public NodoListaInt(int num, NodoListaInt nodoSig) {
        this.numero = num;
        this.sig = nodoSig;

    }
}

class ListaInt {
    // atributos
    public String nombre;
    public NodoListaInt inicio;

    // constructor
    public ListaInt(String nombre) {
        this.nombre = nombre;
        this.inicio = null;
    }

    // métodos
    
}
    

