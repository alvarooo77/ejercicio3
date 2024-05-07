package ejercicio4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException{

        // Pedir tantas personas como se quiera
        // al final de cada persona preguntar si se quiere introducir otra[s/n]
        // guardar las personas introducidas en una lista de tipo list

        List<Persona> personas = new ArrayList<Persona>();
        Scanner in = new Scanner(System.in);
        Persona persona;
        
        char continuar = 'S';

        System.out.println("Quieres introducir una persona? [s/N]");
        continuar = in.nextLine().toUpperCase().charAt(0);

        while (continuar == 'S'){
            persona= new Persona();
            System.out.println("Introuce el dni: ");
            persona.setDni(in.nextLine());
            in.nextLine();

            System.out.println("Introuce el nombre: ");
            persona.setNombre(in.nextLine());
            in.nextLine();

            System.out.println("Introuce el apellido: ");
            persona.setApellidos(in.nextLine());
            in.nextLine();
            
            System.out.println("Introuce el edad: ");
            persona.setEdad(in.nextInt());
            in.nextLine();

            personas.add(persona);

            System.out.println("Hasta ahora has introducido " + personas.size() + " personas" );
            







            System.out.println("Quieres introducir otra persona? [s/N]");
            continuar = in.nextLine().toUpperCase().charAt(0);
        }

        ObjectOutputStream escritor = null;
        String pathFicheroNuestro = "C:\\Users\\AlvaroleivaCardenas\\workspace vscode\\tres.dat";
        
        // for each
        for (Persona personaActual : personas) {
            System.out.println(personaActual.toString());
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(pathFicheroNuestro));
                escritor.writeObject(personaActual);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(escritor !=null) escritor.close();
            }
    
        }

       

        

        in.close();
       }
}
