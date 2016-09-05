package Homework_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.Collections.sort;
import static java.lang.Integer.valueOf;

/**
 * Created by ABurykin on 05.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("John Lennon", 50, 200_000);
        Person p2 = new Person("John Paul McCartney", 45, 175_000);
        Person p3 = new Person("John George Harrison", 40, 150_000);
        Person p4 = new Person("John Ringo Starr", 35, 125_000);
        Person p5 = new Person("John Cash", 30, 100_000);

        List<Person> collection = Arrays.asList(p1, p2, p3, p4, p5);
        collection.forEach((val) -> System.out.println(val.getName() + " " + val.getAge() + " " + val.getSalary()));
        System.out.println("\n");

        List<Person> collection2 = collection.stream().filter(val -> val.getAge() <= 40).collect(Collectors.toList());
        collection2.forEach((val) -> System.out.println(val.getName() + " " + val.getAge() + " " + val.getSalary()));
        System.out.println("\n");

        // работа с custom Stream
        Streams myStream = Streams.of(collection);
        myStream.print();

        Streams.of(collection).filter(person -> person.getAge() > 40).print();
        Streams.of(collection).transform(p -> p.changedPerson(p.getName(), p.getAge(), p.getSalary() + 199)).print();

        System.out.println("\n");
        Map<String, Person> map = Streams.of(collection).toMap(t -> t.getName(), t -> t);
        for (String key : map.keySet()) {
            System.out.println("Map = " + key + " " + map.get(key));
        }
    }
}


/*    Просто варианты работы в Java 8

        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 6, 5);
        for (Integer number : numbers) System.out.print(number + " ");


        System.out.println();
        numbers.forEach((Integer value) -> System.out.print(value + " "));

        System.out.println();
        numbers.forEach((value) -> {
            value++;
            System.out.print(value + " ");
        });

        System.out.println();
        numbers.forEach(System.out::print);

        System.out.println();


        System.out.println(sumAll(numbers, numb -> true));
        System.out.println(sumAll(numbers, numb-> numb%2 != 0));


        List<String> strings = Arrays.asList("1", "10", "2");
        sort(strings, (s1, s2) -> valueOf(s1).compareTo(valueOf(s2)));
        strings.forEach((value) -> System.out.print(value + " "));

        System.out.println();
        List<String> names = Arrays.asList("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr");
        names.forEach((val) -> System.out.print(val + " "));

        System.out.println();
        List<String> result = names.stream().filter(value -> {
            System.out.println(value);
            return value.contains("Harrison");
        }).collect(Collectors.toList());
        result.forEach((val) -> System.out.print(val + " "));

        */
