public class App {
    public static void main(String[] args) {
        SuperHero danielHero = new SuperHero();
        SuperVillain putin = new SuperVillain();
        danielHero.setNombre("daniel");
        System.out.println(danielHero.toString());
        System.out.println(putin.toString());

        danielHero.combate(putin);
    }
}