import java.util.Random;

import skills.CombatSkills;
import skills.Skill;

public class SuperHuman implements CombatSkills {
   // los atributos numéricos siempre van a estar entre [0..100]
   // atributos:
   // nombre como string
   // caracteristicas (de tipo numérico):
   // inteligencia, agilidad, fuerza, resistencia.
   private String nombre;
   private int inteligencia;
   private int agilidad;
   private int fuerza;
   private int resistencia;

   // constructorES !!
   // con todos los parámetros.
   public SuperHuman(String nombre, int inteligencia, int agilidad, int fuerza, int resistencia) {
      this.nombre = nombre;
      // controlar que los parámetros sean válidos [0..10]
      // el q no lo sea se pone a 0

      if (inteligencia < 10 && inteligencia > 0) {
         this.inteligencia = inteligencia;
      } else {
         this.inteligencia = 0;
      }

      if (agilidad < 10 && agilidad > 0) {
         this.agilidad = agilidad;
      } else {
         this.agilidad = 0;
      }
      if (resistencia < 10 && resistencia > 0) {
         this.resistencia = resistencia;
      } else {
         this.resistencia = 0;
      }
      if (fuerza < 10 && fuerza > 0) {
         this.fuerza = fuerza;
      } else {
         this.fuerza = 0;
      }

   }

   // sin parámetros
   public SuperHuman() {
      Random aleatorio = new Random();
      this.nombre = "Unknown";
      this.inteligencia = aleatorio.nextInt(10);
      this.agilidad = aleatorio.nextInt(10);
      this.fuerza = aleatorio.nextInt(10);
      this.resistencia = aleatorio.nextInt(10);
   }

   // con un parametro q indica q parámetro va a a ser predominante.
   public SuperHuman(Skill habilidad) {
      Random aleatorio = new Random();
      this.nombre = "Unknown";
      switch (habilidad) {
         case inteligencia:
            this.inteligencia = aleatorio.nextInt(5, 10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;
         case agilidad:
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(5, 10);
            this.fuerza = aleatorio.nextInt(10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case fuerza:
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(5, 10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         case resistencia:
            this.inteligencia = aleatorio.nextInt(10);
            this.agilidad = aleatorio.nextInt(10);
            this.fuerza = aleatorio.nextInt(5, 10);
            this.resistencia = aleatorio.nextInt(10);
            break;

         default:
            break;
      }
   }

   // getters y setters
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public int getInteligencia() {
      return inteligencia;
   }

   private void setInteligencia(int valor) {
      this.inteligencia = this.inteligencia + valor;
      if (this.inteligencia > 100) {
         this.inteligencia = 100;
      }
   }

   public int getAgilidad() {
      return agilidad;
   }

   private void setAgilidad(int valor) {
      this.agilidad = this.agilidad + valor;
      if (this.agilidad > 100) {
         this.agilidad = 100;
      }
   }

   public int getFuerza() {
      return fuerza;
   }

   private void setFuerza(int valor) {
      this.fuerza = this.fuerza + valor;
      if (this.fuerza > 100) {
         this.fuerza = 100;
      }
   }

   public int getResistencia() {
      return resistencia;
   }

   private void setResistencia(int valor) {
      this.resistencia = this.resistencia + valor;
      if (this.resistencia > 100) {
         this.resistencia = 100;
      }
   }

   // toString (de VSC)
   @Override
   public String toString() {
      return "SuperHero [nombre=" + nombre + ", inteligencia=" + inteligencia + ", agilidad=" + agilidad + ", fuerza="
            + fuerza + ", resistencia=" + resistencia + "]";
   }

   // métodos:
   // public void entrenamiento(int dias,String caracteristica)
   // lo q hace es la caracteristica la incrementa en funcion del número de días
   // introducido pero que genere un valor aleatorio entre 0 y esos días y ese
   // valor
   // se le suma a la característica.
   // ejemplo: entrenamiento(5,"agilidad");
   // me incrementa agilidad en un valor=[0..5](aleatorio)
   public void entrenamiento(int dias, Skill caracteristica) {
      Random aleatorio = new Random();

      switch (caracteristica) {
         case inteligencia:
            this.setInteligencia(aleatorio.nextInt(dias));
            break;
         case agilidad:
            this.setAgilidad(aleatorio.nextInt(dias));
            break;
         case fuerza:
            this.setFuerza(aleatorio.nextInt(dias));
            break;
         case resistencia:
            this.setResistencia(aleatorio.nextInt(dias));
            break;
         default:
            break;
      }
   }

   public boolean combate(SuperHuman enemy) {
      // acaba cuando resistencia de algún luchador sea 0;
      int miResistencia = this.resistencia;
      int enemyResistencia = enemy.resistencia;
      int golpe = 0;
      while ((miResistencia > 0) && (enemyResistencia > 0)) {
         if (this.tiradaDados(Skill.inteligencia) > enemy.tiradaDados(Skill.inteligencia)) {
            // ataco yo
            enemyResistencia = ataque(this, enemy, enemyResistencia);
         } else {
            // atacas tu
            miResistencia = ataque(enemy, this, miResistencia);
         }
         System.out.println("[Mi resistencia: " + miResistencia +
               "] [Enemy resistencia: " + enemyResistencia + "]");

      }
      return (miResistencia > 0);
   }

   @Override
   public int kick() { // se basa en fuerza
      return tiradaDados(Skill.fuerza);
   }

   @Override
   public int punch() { // se basa en fuerza
      return tiradaDados(Skill.fuerza);
   }

   @Override
   public int shieldUp() { // se basa en agilidad
      return tiradaDados(Skill.agilidad);
   }

   @Override
   public int shieldDown() { // se basa en agilidad
      return tiradaDados(Skill.agilidad);
   }

   private int tiradaDados(Skill atributo) {
      Random aleatorio = new Random();
      int resultado = 0;
      switch (atributo) {
         case inteligencia:
            for (int i = 0; i < this.getInteligencia(); i++) {
               resultado = resultado + aleatorio.nextInt(10);
            }
            break;
         case agilidad:
            for (int i = 0; i < this.getAgilidad(); i++) {
               resultado = resultado + aleatorio.nextInt(10);
            }
            break;
         case fuerza:
            for (int i = 0; i < this.getFuerza(); i++) {
               resultado = resultado + aleatorio.nextInt(10);
            }
            break;
         case resistencia:
            for (int i = 0; i < this.getResistencia(); i++) {
               resultado = resultado + aleatorio.nextInt(10);
            }
            break;
         default:
            break;
      }

      return resultado;
   }

   // devolver la resistencia resultante en el defensor
   private static int ataque(SuperHuman atacante, SuperHuman defensor, int defensorResistencia) {
      Random aleatorio = new Random();
      int golpe = 0;
      boolean tipoAtaque;
      tipoAtaque=aleatorio.nextBoolean();

      System.out.print("Atacante: " + atacante.nombre + " [");
         if(tipoAtaque)System.out.println("Patada ");
         else System.out.println("Puñetazo ");
         
         if (aleatorio.nextInt(100) >= (100 - defensor.inteligencia)) {
            // exito en parar
            System.out.print("parada ");
            if(tipoAtaque)golpe = defensor.shieldDown() - atacante.kick();
            else golpe = defensor.shieldUp() - atacante.punch();
            
         } else {
            // fallo en parar
            System.out.print(" no parada ");
            // defiendo con la mitad.
            if(tipoAtaque)golpe = (defensor.shieldDown() / 2) - atacante.kick();
            else  golpe = (defensor.shieldUp() / 2) - atacante.punch();

         }
         if (golpe < 0) {
            // he parado pero me ha hecho daño.
            defensorResistencia = defensorResistencia + golpe;
         } // si he parado pero no me ha hecho daño, no hago nada.
      System.out.println("]");

      return defensorResistencia;
   }
}