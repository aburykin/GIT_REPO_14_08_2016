package Homework_4.countmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ABurykin on 21.08.2016.
 */

public class CountMapImpl<T extends Number> implements CountMap<T> {

    public HashMap<T, Integer> map;

    CountMapImpl(HashMap<T, Integer> map) {
        this.map = map;
    }

    @Override
    public void add(T t) {
        if (map.get(t) == null) {
            map.put(t, 1);
        } else {
            map.put(t, map.get(t) + 1);
        }
    }

    @Override
    public int getCount(T t) {
        return map.get(t);
    }

    @Override
    public int remove(T t) {
        int beforeRemoveCount = map.get(t);
        if (beforeRemoveCount == 1) {
            map.remove(t);
        } else {
            map.put(t, beforeRemoveCount - 1);
        }
        return beforeRemoveCount;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (T source_key : source.getMap().keySet()) {
            if (map.get(source_key) == null) {
                add(source_key);
                map.put(source_key, source.getMap().get(source_key));
            } else {
                map.put(source_key, map.get(source_key) + source.getMap().get(source_key));
            }
        }
    }

    @Override
    public Map<T, T> toMap() {
        return (Map<T, T>) map.clone();
    }

    @Override
    public void toMap(Map<T, T> destination) {
        destination = this.toMap();
        System.out.println(destination);
    }

    public void printCountMap() {
        for (T t : map.keySet()) {
            System.out.println("key=" + t + ": val=" + map.get(t));
        }
    }

    public HashMap<T, Integer> getMap() {
        return this.map;
    }
}
