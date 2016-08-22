package Homework_4;

import java.util.*;

/**
 * Created by ABurykin on 22.08.2016.
 */

// Параметризовать методы, используя правило PECS, и реализовать их.
// PECS означает Producer-extends, consumer-super
public class CollectionUtils{

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }



    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }


    public static<T> int indexOf(List<? extends T> source, T t) {
       return source.indexOf(t);
    }

    public static<T> List limit(List<? extends T> source, int size) {
        return source.<T>subList(0,size);
    }

    public static<T> void add(List<? super T> source, T t) {
        source.add(t);
    }



    public static<T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        removeFrom.removeAll(c2);
    }


    //true если первый лист содержит все элементы второго
    public static<T> boolean containsAll(List<? extends T> c1, List<? super T> c2) {
        return c1.containsAll(c2);
    }


    //true если первый лист содержит хотя-бы 1 второго
    public static<T> boolean containsAny(List<? extends T> c1, List<? super T> c2) {
        for (T t : c1) {
            if (c2.contains(t)) return true;
        }

        return false;
    }


    //Нужно создать копию листа, отсортировать его, и вернуть sublist, в котором находятся элементы в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6} // В ПРИМЕРЕ СНАЧАЛА ВЫБОРКА, А ПОТОМ СОРТИРОВКА ?
    public static<T> List range(List<? extends T> list, int min, int max) {

            List<T> newList = new ArrayList<T>();
            for (T t : list) {
                add(newList,t);
            }

            // поскольку коллекция числовая, то реализую Comparator вместо interface Comparable
            Comparator<T> myComparator = new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    double x1 =  Double.parseDouble(""+o1);
                    double x2 =  Double.parseDouble(""+o2);

                    if (x1 < x2) return -1;
                    else if (x1 > x2) return 1;
                    else return 0;
                }
            };

            newList.sort(myComparator);


            return (List)newList.subList(min, max);
    }



    //Нужно создать копию листа, отсортировать его, и вернуть sublist, в котором находятся элементы в диапазоне от min до max.
    // Элементы сравнивать через Comparator.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T> List range(List<? extends T> list, int min, int max, Comparator comparator) {

        List<T> newList = new ArrayList<T>();
        for (T t : list) {
            add(newList,t);
        }
        newList.sort(comparator);

        return (List)newList.subList(min, max);
    }

}
