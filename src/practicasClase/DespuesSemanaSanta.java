package practicasClase;

public class DespuesSemanaSanta {
    public static void main(String[] args) {
        // Creara un array de objetos staff de 10 elementos
        // insertatr diez objetos
        // comparar contador de la clase con long del array+
        int i =0;
        boolean bandera=true;
        Staff[] array = new Staff[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new Staff("Jose ramon garrido rodriguez");
            System.out.println(array[i].getNombre().toUpperCase());
            System.out.println(array[i].getNombre());
        }

        System.out.println(Staff.comparador(Staff.getCont(),array.length));


        while (array[i].getNombre().equals("Jose ramon garrido rodriguez")) {
        
            
        }

        for (int i = 0; i < 9; i++) {
            if(array[i].getNombre().equals(array[x].getNombre()) && bandera){
                x++;

            }else {
                bandera=false;
            }
        }
        System.out.println(bandera);
    }


}

//Crear clase con dos atributos
//un contador de objetos de la clase
// una cadena de caracteres nombre
//clase nombre:staff

class Staff{
    private static int cont=0;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Staff(String nombre) {
        this.nombre = nombre;
        cont++;
    }

    public static int getCont(){
        return cont;
    }

    public static boolean comparador(int a, int b){
        if(a==b){
            return true;
        } return false;
    }
    

    

}