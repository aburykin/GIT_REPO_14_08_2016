package Homework_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by ABurykin on 19.08.2016.
 */
public class Main {

    public static void main(String[] args) {

        CountMapImpl<Integer>  countMap =  new CountMapImpl(new HashMap<Integer,Integer>());

        // проверяю add
        countMap.add(5);
        countMap.add(3);
        countMap.add(2);
        countMap.add(4);
        countMap.add(4);
        countMap.add(5);
        countMap.add(4);
        countMap.printCountMap();

        // проверяю getCount
        System.out.println("countMap.getCount(5) = " + countMap.getCount(5));
        System.out.println("countMap.getCount(4) = " + countMap.getCount(4));

        // проверяю remove
        System.out.println("countMap.remove(4) = "  + countMap.remove(4));
        System.out.println("countMap.remove(4) = "  + countMap.remove(4));
        System.out.println("countMap.getCount(4) = " + countMap.getCount(4));

        // проверяю size
        System.out.println("countMap.size() = "  + countMap.size());


        // проверяю addAll
        CountMapImpl<Integer>  sourceMap =  new CountMapImpl(new HashMap<Integer,Integer>());
        sourceMap.add(7);
        sourceMap.add(7);
        sourceMap.add(7);
        sourceMap.add(3);
        sourceMap.add(3);
        sourceMap.add(3);
        sourceMap.printCountMap();

        System.out.println("_____________addAll____________");
        countMap.addAll(sourceMap);
        countMap.printCountMap();


        System.out.println("___________toMap ______________");
        // проверяю toMap
        Map someMap = countMap.toMap();

        // проверяю что теперь это два разных HashMap
        System.out.println("countMap.remove(2) = "  + countMap.remove(2));
        countMap.printCountMap();
        for (Object o : someMap.keySet()) {
            System.out.println(o+ ":"+someMap.get(o));
        }

        System.out.println("____________toMap(someMap2) _____________");
        // КАК ТУТ ДЕЛАТЬ?  надо ведь передаваемой переменной установить новое значение, а функция ничего не возвращает.
        Map someMap2 =  new HashMap<Integer,Integer>();
        countMap.toMap(someMap2);
        for (Object o : someMap2.keySet()) {
            System.out.println("someMap2:"+o+ ":"+someMap2.get(o));
        }


    }
}

        /*for (Integer i : countMap.list) {
            System.out.println(i);
        }
        // проверяю getCount
        int count = 0;
        count = countMap.getCount(5);
        System.out.println("countMap.getCount(5) = "  + count);
        count = countMap.getCount(4);
        System.out.println("countMap.getCount(4) = "  + count);

        // проверяю remove
        System.out.println("countMap.remove(4) = "  + countMap.remove(4));
        System.out.println("countMap.remove(4) = "  + countMap.remove(4));

        // проверяю size
        System.out.println("countMap.size() = "  + countMap.size());


        CountMapImpl<Integer>  sourceMap =  new CountMapImpl(new ArrayList<>());
  */