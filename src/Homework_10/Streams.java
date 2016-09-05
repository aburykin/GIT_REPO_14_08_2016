package Homework_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by ABurykin on 05.09.2016.
 */

public class Streams<T> {

    List<T> someCollection;

    public Streams(List<T> list) {
        someCollection = new ArrayList();
        list.forEach(val -> someCollection.add(val));
    }

    public static <T> Streams<T> of(List<T> list) { // принимает коллекцию и создает новый объект Streams
        Streams newStream = new Streams<>(list);
        return newStream;
    }

    public Streams<T> filter(Predicate<? super T> predicate) { //  оставляет в коллекции только те элементы, которые удовлетворяют условию в лямбде.
        someCollection.removeIf(predicate);
        return this;
    }


    public <R> Streams<R> transform(Function<? super T, ? extends R> function) { //  преобразует элемент в другой.
        List<R> trans = new ArrayList<R>();
        someCollection.forEach(t -> trans.add(function.apply(t)));
        return new Streams<R>(trans);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMap, Function<? super T, ? extends V> valueMap) { //  принимает 2 лямбды для создания мапы, в одной указывается что использовать в качестве ключа, в другой что в качестве значения.
        Map<K, V> map = new HashMap<K, V>();
        someCollection.forEach(t -> map.put(keyMap.apply(t), valueMap.apply(t)));
        return map;
    }

    public void print() {
        System.out.println("\nStreams print:");
        someCollection.forEach(val -> System.out.println(val));
    }
}