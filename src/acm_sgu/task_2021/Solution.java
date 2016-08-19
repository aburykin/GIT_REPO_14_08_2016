package acm_sgu.task_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ABurykin on 13.08.2016.
 */

// прошла тестирование
public class Solution {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // кол-во чисел
        int n = Integer.parseInt(br.readLine());

        Integer[] mass = new Integer[n];

        // считываю массив
        String[] inputMass = br.readLine().split(" ");

        int max = -1;
        for (int i = 0; i < n; i++){
            mass[i] = Integer.parseInt(inputMass[i]);

            //System.out.print(mass[i] + " ");
            if (max < mass[i])
                max = mass[i];
        }
        //System.out.println("max = " + max);

        // делю все максимумы на 2
        for (int i = 0; i < n; i++){
            if (mass[i] == max){
                mass[i] = mass[i]/2;
            }
          //  System.out.print(mass[i] + " ");
        }


        // ищу максимум
        max = -1;
        for (int i = 0; i < n; i++){
            if (max < mass[i])
                max = mass[i];
        }


        // снова делю на 2
        for (int i = 0; i < n; i++){
            if (mass[i] == max){
                mass[i] = mass[i]/2;
            }
            System.out.print(mass[i] + " ");
        }
    }

}
