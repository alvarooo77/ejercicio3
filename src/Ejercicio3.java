import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) throws IOException {

        String pathFichero = "C:\\Users\\AlvaroleivaCardenas\\workspace vscode\\tres.dat";
        int num;
        Scanner teclado = new Scanner(System.in);
        ObjectOutputStream escritor = null;
        ObjectInputStream lector = null;

        try {
            escritor = new ObjectOutputStream(new FileOutputStream(pathFichero));
            System.out.println("Introduce números. Para terminar, introduce un número negativo:");
            num = teclado.nextInt();
            while (num >= 0) {
                escritor.writeObject(num);
                num = teclado.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escritor != null) escritor.close();
        }

        try {
            lector = new ObjectInputStream(new FileInputStream(pathFichero));

            while (true) {
                try {
                    num = (int) lector.readObject();
                    System.out.println(num);
                } catch (EOFException e) {
                    // Se lanza esta excepción cuando llegamos al final del archivo
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "1");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "2");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "3");
        } finally {
            if (lector != null) lector.close();
        }

    }
}
