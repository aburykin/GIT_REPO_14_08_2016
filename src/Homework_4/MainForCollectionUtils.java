package Homework_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ABurykin on 22.08.2016.
 */
public class MainForCollectionUtils {
    public static void main(String[] args) {

        // проверяю функции

        List<Integer> producerList = new ArrayList<Integer>();
        producerList.add(100);
        CollectionUtils.add(producerList, 101);
        producerList.add(102);

        List<Number> consumerList = CollectionUtils.newArrayList();
        CollectionUtils.add(consumerList, 10F);
        consumerList.add(20L);
        consumerList.add(30D);


        CollectionUtils.addAll(producerList, consumerList);
        for (Number number : consumerList) {
            System.out.println("1 consumerList:"+number);
        }


        System.out.println(CollectionUtils.indexOf(consumerList, 20L)); // поиск элемента, возвращает 1 если нашел

        List subConsumer = CollectionUtils.limit(consumerList, 4);
        for (Object o : subConsumer) {
            System.out.println("2 consumerList:"+o);
        }
        System.out.println("------------------------------\n");
        // удаление
        producerList.add(201);
        producerList.add(202);
        for (Object o : producerList) {
            System.out.println("1 producerList:"+o);
        }
        CollectionUtils.removeAll(producerList, consumerList);
        for (Object o : producerList) {
            System.out.println("2 producerList:"+o);
        }


        List<Number> list3 = CollectionUtils.newArrayList();
        list3.add(201);
        list3.add(202);
        System.out.println("containsAll(producerList,list3) = " + CollectionUtils.containsAll(producerList,list3));

        list3.add(0,432);
        list3.add(301);
        list3.remove(2);
        for (Object o : list3) {
            System.out.println("data list3:"+o);
        }
        System.out.println("1 containsAny(producerList,list3) = " + CollectionUtils.containsAny(producerList,list3));
        list3.remove(1);
        for (Object o : list3) {
            System.out.println("data list3:"+o);
        }
        System.out.println("2 containsAny(producerList,list3) = " + CollectionUtils.containsAny(producerList,list3));




        // проверяю    range(List<? extends T> list, int min, int max)
        CollectionUtils.add(producerList, 6);
        CollectionUtils.add(producerList, 2);
        CollectionUtils.add(producerList, 5);
        CollectionUtils.add(producerList, 7);
        CollectionUtils.add(producerList, 3);
        CollectionUtils.add(producerList, 1);
        CollectionUtils.add(producerList, 4);
        for (Object o : producerList) {
            System.out.println("data producerList:"+o);
        }
        System.out.println("\n");

        List sortedList1 =  CollectionUtils.range(producerList, 3, 7);
        for (Object o : sortedList1) {
            System.out.println("data sortedList1:"+o);
        }



        Comparator<Number> myComparator = new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                double x1 =  Double.parseDouble(""+o1);
                double x2 =  Double.parseDouble(""+o2);

                if (x1 < x2) return -1;
                else if (x1 > x2) return 1;
                else return 0;
            }
        };

        System.out.println("\n");
        // проверяю    range(List<? extends T> list, int min, int max, Comparator comparator)
        List sortedList2 =  CollectionUtils.range(producerList, 3, 7, myComparator);
        for (Object o : sortedList2) {
            System.out.println("data sortedList2:"+o);
        }

    }
}
