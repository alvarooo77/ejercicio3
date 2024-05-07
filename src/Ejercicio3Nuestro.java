import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Ejercicio3Nuestro{
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[3];
        String asig[] = new String[3];
        String nombre;

        for (int al = 0; al<3 ; al++){
            System.out.println("creacion alumno " + al);
            System.out.println("nombre :");
            nombre = teclado.nextLine();
            for(int j=0; j<3 ;j++){
                System.out.println("asignatura " +j+ ": ");
                asig[j] = teclado.nextLine();
            }
            alumnos[al] = new Alumno(nombre,asig);
        }
        teclado.close();

        for(int cont=0; cont<3;cont++){
            System.out.println(alumnos[cont].getId());
        }
        System.out.println(Alumno.getIdActual());
    

        // almacenar el objeto creando un fichero
        ObjectOutputStream escritor = null;

        String pathFicheroNuestro = "src//ejercicio3//tres.dat";

        try {
            escritor = new ObjectOutputStream(new FileOutputStream(pathFicheroNuestro));
            escritor.writeObject(alumnos[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(escritor !=null) escritor.close();
        }

        alumnos[0] = null;
        alumnos[1] = null;
        alumnos[2] = null;
        // leer

        ObjectInputStream lector = null;

        try {
            lector = new ObjectInputStream(new FileInputStream(pathFicheroNuestro));
            int cont = 0;
            while(lector.available()>0){
                alumnos[cont]=(Alumno) lector.readObject();
                System.out.println(alumnos[cont].getNombre());
                cont ++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(lector!=null) lector.close();
        }
    }
}

class Alumno implements Serializable{
    // Atributos
    private static int idActual=0;
    private int id;
    private String nombre;
    

    private String[] asignaturas = new String[3];

    // Constructor
    public Alumno(String nombre, String[] asignaturas) {
        idActual++;
        this.id=idActual;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    // Getter and setter
    public static int getIdActual() {
        return idActual;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getAsignaturas() {
        return asignaturas;
    }

    public static void setIdActual(int idActual) {
        Alumno.idActual = idActual;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignaturas(String[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    
}