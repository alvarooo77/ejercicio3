package ejercicio6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cluedo {

    static String[] personajesArray = { "Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco" }; // 6 elementos
    static String[] armasArray = { "bate", "pistola", "candelabro", "cuchillo", "cuerda", "hacha", "pesa", "veneno",
            "trofeo" }; // 9 elementos
    static String[] habitacionesArray = { "casa de invitados", "teatro", "spa", "observatorio", "comedor", "terraza",
            "salon", "cocina", "vestibulo" }; // 9 elementos
    static Jugador jugador;
    static List<Jugador> estadosJugador = new ArrayList<Jugador>();

    public static void main(String[] args) {

        String introDato;
        int num;
        Scanner in = new Scanner(System.in);
        
        String clave;

        // inicio de la aplicación.
        System.out.println("Bienvenido a CLUEDO");
        System.out.println("este programa se encarga de barajar las cartas de forma aleatoria para jugar al Cluedo.");
        // mostrar personajes, armas y habitaciones disponibles.
        System.out.println("Personajes Disponibles:");
        for (int i = 0; i < personajesArray.length; i++) {
            System.out.print(personajesArray[i] + " // ");
        }
        System.out.println("\nArmas Disponibles:");
        for (int i = 0; i < armasArray.length; i++) {
            System.out.print(armasArray[i] + " // ");
        }
        System.out.println("\nHabitaciones Disponibles:");
        for (int i = 0; i < habitacionesArray.length; i++) {
            System.out.print(habitacionesArray[i] + " // ");
        }

        // Preguntar si se quiere añadir algo mas

        int resp = -1;
        do {
            System.out.println("¿Quieres añadir algo mas?");
            System.out.println("menu para añadir mas informacion:");
            System.out.println("1.Personaje");
            System.out.println("2.Arma");
            System.out.println("3.Habitacion");
            System.out.println("4.Salir");

            resp = in.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("/nCuantos personajes quieres añadir: ?");
                    num = in.nextInt();
                    personajesArray = actualizarArray(personajesArray, num);
                    in.nextLine();
                    for (int i = personajesArray.length - num; i < habitacionesArray.length; i++) {
                        System.out.println("Introduce el nombre del personaje: ");
                        introDato = in.nextLine();
                        personajesArray[i] = introDato;
                    }
                    // visualizo todos los datos del nuevo array
                    System.out.println("Array de personajes actualizado: " + Arrays.toString(personajesArray));
                    break;

                case 2:
                    System.out.println("/nCuantos armas quieres añadir: ?");
                    num = in.nextInt();
                    armasArray = actualizarArray(armasArray, num);
                    in.nextLine();
                    for (int i = armasArray.length - num; i < armasArray.length; i++) {
                        System.out.println("Introduce el nombre del arma: ");
                        introDato = in.nextLine();
                        armasArray[i] = introDato;
                    }
                    // visualizo todos los datos del nuevo array
                    System.out.println("Array de armas actualizado: " + Arrays.toString(armasArray));
                    break;

                case 3:
                    System.out.println("/nCuantas habitaciones quieres añadir: ?");
                    num = in.nextInt();
                    habitacionesArray = actualizarArray(habitacionesArray, num);
                    in.nextLine();
                    for (int i = habitacionesArray.length - num; i < habitacionesArray.length; i++) {
                        System.out.println("Introduce el nombre de la habitacion: ");
                        introDato = in.nextLine();
                        habitacionesArray[i] = introDato;
                    }
                    // visualizo todos los datos del nuevo array
                    System.out.println("Array de personajes actualizado: " + Arrays.toString(habitacionesArray));
                    break;

                case 4:
                    System.out.println("GEnial, seguimos ...");
                    break;

                default:

                    break;

            }
        } while (resp != 4);
        System.out.println("barajando...");

        if(barajar()){
            System.out.println("si introduces la clave correcta puedo mostrar quien es el culpable...");
            clave = in.nextLine();

            if(clave == CLAVE){
                System.out.println(jugadorList.get(jugadorList.size() - 1));
            } else {
                System.out.println("no tienes derechor a ver nada");
            }
        } else{
            System.out.println("ha habiado un error al barajar");
        }

        System.out.println("quieres repetir la partida?");
        continuar = in.nextLine().toLowerCase().charAt(0);
        


        /*
         * for (int i = 0; i < 5; i++) {
         * jugador = new Jugador();
         * jugador.setArma(armasArray[i]);
         * jugador.setNombre(personajesArray[i]);
         * jugador.setHabitacion(habitacionesArray[i]);
         * jugador.setHoraPartida();
         *
         * estadosJugador.add(jugador);
         * }
         * for (int i = 0; i < estadosJugador.size(); i++) {
         * System.out.println(estadosJugador.get(i));
         * }
         * System.out.println(armasArray.length);
         * armasArray = actualizarArray(armasArray, 3);
         * System.out.println(armasArray.length);
         * for (int i = 0; i < armasArray.length; i++) {
         * System.out.println(armasArray[i]);
         * }
         */

        in.close();
    } // fin main

    public static String[] actualizarArray(String[] arrayAntiguo, int num) {
        String[] arrayNuevo = new String[arrayAntiguo.length + num];
        System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);
        return arrayNuevo;
    }

    public static boolean barajar() {

        Random aleatorio = new Random();
        int posArma, porPersonaje, posHabitacion;

        try{
            posArma = aleatorio.nextInt(armasArray.length);
            posHabitacion = aleatorio.nextInt(habitacionesArray.length);
            porPersonaje = aleatorio.nextInt(personajesArray.length);

            jugador = new Jugador();
            jugador.setArma(armasArray[posArma]);
            jugador.setHabitacion(habitacionesArray[posHabitacion]);
            jugador.setNombre(personajesArray[porPersonaje]);
            estadosJugador.add(jugador);
        return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());;
            return false;
        }
    }

} // cluedo