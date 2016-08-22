package Homework_2;

/**
 * Created by ABurykin on 07.08.2016.
 */
public class Main {
    public static void main(String[] args){



        // ПРИМЕР 1  женим Васю и Аню
        Person Vasya = new Person(true, "Vasya");
        Person Anna = new Person(false, "Anna");    //  Жена васи

        System.out.println(" marry Vasya and Anna = " +  Vasya.marry(Anna));



        // ПРИМЕР 2 пытаемся поженить олега с замужней Марго, в результате марго разводится и не женится на Олеге
        Person Oleg = new Person(true, "Oleg");

        Person Margo = new Person(true, "Margo");
        Person Petr = new Person(true, "Petr");
        Petr.setSpouse(Margo);
        Margo.setSpouse(Petr);

        System.out.println("Margo hasn't got husband is " + (Margo.getSpouse() == null));
        System.out.println("Margo's husband = " + Margo.getSpouse().getName());
        System.out.println("marry Oleg and Margo = " +  Oleg.marry(Margo));
        System.out.println("Margo hasn't got husband is " + (Margo.getSpouse() == null));
    }
}
