// crear un array de 1000 persona
// introducir la misma persona pero con edad consectivo
// crear un directorio "persona"
// crear archivo en dierectroio "personas" llamado "personaInicial.dat"
// almacenar en dicho archivo tods las personas
// crear dos archivos "personaPar.dat" y "personaImpar.dat"
// leer personas de personaInicial.dat y almacenar dependiendo del dni en uno u otro
// el que corresponda


package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio4Nuestro {
    public static void main(String[] args) throws IOException {

        Persona[] arrayPersonas = new Persona[1000];
        Persona persona = new Persona("77773745G", "Alvaro", "leiva", 0);
        File f = new File(".//ejercicio3//src//ejercicio4//personas");
        f.mkdir();
        
        for (int i = 0; i < arrayPersonas.length; i++) {
            persona.setEdad(i);
            arrayPersonas[i] = persona;
        }
        ObjectOutputStream escritor = null;
    
        
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(f));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(escritor!=null) escritor.close();
        }
        

        


    }
}
