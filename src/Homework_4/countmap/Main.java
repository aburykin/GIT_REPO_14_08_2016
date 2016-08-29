package Homework_4.countmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ABurykin on 19.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        CountMapImpl<Integer> countMap = new CountMapImpl(new HashMap<Integer, Integer>());

        System.out.println("Проверяю add");
        countMap.add(5);
        countMap.add(5);
        countMap.add(3);
        countMap.add(4);
        countMap.add(4);
        countMap.add(4);
        countMap.add(2);
        countMap.printCountMap();
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю getCount");
        System.out.println("countMap.getCount(5) = " + countMap.getCount(5));
        System.out.println("countMap.getCount(4) = " + countMap.getCount(4));
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю remove");
        System.out.println("countMap.remove(4) = " + countMap.remove(4));
        System.out.println("countMap.remove(4) = " + countMap.remove(4));
        System.out.println("countMap.getCount(4) = " + countMap.getCount(4));
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю size");
        System.out.println("countMap.size() = " + countMap.size());
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю addAll, наполняю коллекцию:");
        CountMapImpl<Integer> sourceMap = new CountMapImpl(new HashMap<Integer, Integer>());
        sourceMap.add(7);
        sourceMap.add(7);
        sourceMap.add(7);
        sourceMap.add(3);
        sourceMap.add(3);
        sourceMap.add(3);
        sourceMap.printCountMap();
        System.out.println("--------------- Добавляю одну коллекцию к другой--------------------------------");
        countMap.addAll(sourceMap);
        countMap.printCountMap();
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю toMap<T,T>");
        Map someMap = countMap.toMap();
        System.out.println("countMap.remove(2) = " + countMap.remove(2));
        System.out.println("------------------ countMap -----------------------------");
        countMap.printCountMap();
        System.out.println("------------------ someMap -----------------------------");
        for (Object o : someMap.keySet()) System.out.println(o + ":" + someMap.get(o));
        System.out.println("-----------------------------------------------");

        System.out.println("Проверяю toMap(Map<T,T> destination)");
        Map someMap2 = new HashMap<Integer, Integer>();
        countMap.toMap(someMap2);
    }
}

