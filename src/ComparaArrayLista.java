// Crear array de 10000 elementos de tipo Persona
// crear una lista de 10000 elementos de tipo persona
// comparar el tiempo de insercion en cada caso
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComparaArrayLista {
    // cre4ar persona
    // Crear array de 10000 elementos de tipo Persona
    // introducir la misma persona en el mismo array

    
    public static void main(String[] args){
        Persona personaDeff = new Persona("77773745G", "alvaro", "Leiva", 18);
        Persona[] arrayPersona = new Persona[10000];
        List<Persona> listaPersona = new ArrayList<Persona>();

        long timeI = System.nanoTime();

        

        for (int i = 0; i < 10000; i++) {
            arrayPersona[i] = personaDeff;
        }

        System.out.println(System.nanoTime()-timeI);
        timeI = System.nanoTime();

        for (int index = 0; index < 10000; index++) {
            listaPersona.add(personaDeff);
        }
        System.out.println(System.nanoTime()-timeI);

        timeI = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            personaDeff = arrayPersona[i];
        }
        System.out.println(System.nanoTime()-timeI);


        timeI = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            personaDeff = listaPersona.get(i);
        }
        System.out.println(System.nanoTime()-timeI);

    }

    

}
    

class Persona implements Serializable {
    //Atributos dni, nombre, edad, apellidos

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;


    // Constructor

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }


    public Persona() {
        edad=-1;
        nombre=null;
        apellidos=null;
        dni=null;

    }

    // getter and setter

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String toString(){
        return ("[DNI: "+dni+
        ", NOMBRE:"+nombre+
        ", APELLIDO:"+apellidos+
        ", EDAD:" + edad
        +"]");
    }
}



