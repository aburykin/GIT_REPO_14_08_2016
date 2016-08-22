package Homework_4;

import java.util.*;

/**
 * Created by ABurykin on 21.08.2016.
 */

// работает с числами
public class CountMapImpl<T extends Number> implements CountMap<T>  {

    public HashMap<T,Integer> map;

    CountMapImpl(HashMap<T,Integer> map){
        this.map = map;
    }

    @Override
    public void add(T t) { // добавляет элемент в этот контейнер.
        if (map.get(t) == null){
            map.put(t, 1);
        } else {
            map.put(t, map.get(t)+1);
        }
    }

    @Override
    public int getCount(T t) { //Возвращает количество добавлений данного элемента
        return map.get(t);
    }

    @Override
    public int remove(T t) { //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
        int beforeRemoveCount = map.get(t);
        if (beforeRemoveCount == 1) {
            map.remove(t);
        } else {
            map.put(t, beforeRemoveCount-1);
        }

        return beforeRemoveCount;
    }

    @Override
    public int size() {//количество разных элементов
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {  //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения

        for (T source_key :  source.getMap().keySet()) {
           if (map.get(source_key) == null){ // если эелмента нет, то создать и скопировать
               add(source_key);
               map.put(source_key, source.getMap().get(source_key));
           } else { // суммиррвать значения
               map.put(source_key, map.get(source_key)+ source.getMap().get(source_key));
           }
        }
    }

    @Override
    public Map toMap() {   //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        return (Map)map.clone(); // клонирую, чтобы получилось два разныз Map, а не две ссылки на один и тот же Map.
    }

    @Override
    public void toMap(Map destination) { //Тот же самый контракт как и toMap(), только всю информацию записать в destination
        destination = toMap();
        for (Object o : destination.keySet()) {
            System.out.println("destination:"+o+ ":"+destination.get(o));
        }
    }

    public void printCountMap() {
        for (T t : map.keySet()) {
            System.out.println("key="+ t + ": val=" + map.get(t));
        }
    }


    public HashMap<T, Integer> getMap() {
        return this.map;
    }
}


 /*
    СТАРЫЕ КОДЫ - реализация на ArrayList

    ArrayList<T> list;

    // TreeMap<T,Integer> treeMap;

    CountMapImpl(ArrayList<T> list){
        this.list = list;
    }

    @Override
    public void add(T t) {   // добавляет элемент в этот контейнер.
        list.add(t);
    }

    @Override
    public int getCount(T t) {   //Возвращает количество добавлений данного элемента
        int count = 0;
        for (T iter_t : list) {
            if (t == iter_t)  count++;
        }
        return count;
    }

    @Override
    public int remove(T t) { //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
        int count = getCount(t);
        for (int i = 0; i < list.size(); i++){
            if (t == list.get(i)) {
                list.remove(i);
                break;
            }
        }
        return count;
    }

    @Override
    public int size() { //количество разных элементов
        HashMap<T,Integer> hm = new HashMap<T,Integer>();

        for (T t : list) {
            if (hm.get(t) == null) {
                hm.put(t,0);
            }
        }

        return   hm.size();
    }


    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    @Override
    public void addAll(CountMap source) {

    }

    @Override
    public Map toMap() { //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        return null;
    }

    @Override
    public void toMap(Map destination) {   //Тот же самый контракт как и toMap(), только всю информацию записать в destination

    }
*/