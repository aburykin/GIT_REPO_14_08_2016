package acm_sgu.task_2057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ABurykin on 13.08.2016.
 */

// нужно оптимизировать, слишком долго работает 27/30 пройдено
public class Solution {

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

}




/*


        // удаляем минимум
        iter = mass.iterator(); //сбросил итератор
        while (iter.hasNext()){
            int curr = iter.next();
            if (min == curr){
                iter.remove();
                System.out.println(curr);
                break;
            }
        }

        */

