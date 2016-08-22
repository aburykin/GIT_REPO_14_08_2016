package acm_sgu.task_2057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by ABurykin on 13.08.2016.
 */

// Зачтено
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // сначала вводим количество операций
        int countOperations = Integer.parseInt(br.readLine());
        for (int i = 0; i < countOperations; i++){

            String[] action = br.readLine().split(" ");   // действие и число

            // добавление
            if (Integer.parseInt(action[0]) == 1)
            {
                if (treeMap.get(Integer.parseInt(action[1])) == null){
                    treeMap.put(Integer.parseInt(action[1]), 1);
                } else {
                    treeMap.put(Integer.parseInt(action[1]), treeMap.get(Integer.parseInt(action[1]))+1);
                }
            }

            // удаление минимального
            else  if (Integer.parseInt(action[0]) == 2)
            {
                removeMin(treeMap);
            }
        }
    }

    public static void removeMin(TreeMap<Integer, Integer> treeMap){
/*
        System.out.println("TREE MAP:");
        for (Integer key : treeMap.keySet()) {
            System.out.println("key =" + key+ " val = "  + treeMap.get(key));
        }
        */
        int key = treeMap.firstKey();
        int val = treeMap.get(key)-1;

        treeMap.put(key, val);
        System.out.println(key);
        //System.out.println("remove " + key + " val = "  + val);
        if (val == 0){
            treeMap.remove(key);
        }

    }
}


/*


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mass = new ArrayList();

        // сначала вводим количество операций
        int countOperations = Integer.parseInt(br.readLine());
        for (int i = 0; i < countOperations; i++){

            String[] action = br.readLine().split(" ");   // действие и число

            // добавление
            if (Integer.parseInt(action[0]) == 1)
            {
                mass.add(Integer.parseInt(action[1]));
            }

            // удаление минимального
            else  if (Integer.parseInt(action[0]) == 2)
            {
                removeMin(mass);
            }

        }

    }

    // найти минимум и удалить
    public static void removeMin(ArrayList mass){

        int min = -1;
        int removeElementIndex = 0;
        int count = 0;
        // ищем минимум
        Iterator<Integer> iter = mass.iterator();
        while (iter.hasNext()){
            int curr = iter.next();
            if (min == -1){
                min = curr;
                removeElementIndex = count;
            }
            else if (min > curr){
                min = curr;
                removeElementIndex = count;
            }

            count++;
        }
        System.out.println(mass.get(removeElementIndex));
       // System.out.println("min = " + min);
        mass.remove(removeElementIndex);

    }

 */