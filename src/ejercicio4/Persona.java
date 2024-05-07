package ejercicio4;

import java.io.Serializable;

public class Persona implements Serializable {
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
