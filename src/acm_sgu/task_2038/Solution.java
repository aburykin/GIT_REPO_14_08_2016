package acm_sgu.task_2038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by ABurykin on 13.08.2016.
 */


public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Считываю строку
        char[] symbols =  br.readLine().toCharArray();
        int MaxWordcurr = 0;
        int MaxWordAll = 0;
        for (int i=0; i < symbols.length; i++ ){
            int curr = (int)symbols[i];
            if ((curr >= 65 && curr <= 90) || (curr >= 97 && curr <= 122)){
                MaxWordcurr++;
            } else {
                if (MaxWordAll < MaxWordcurr){
                    MaxWordAll = MaxWordcurr;
                }
                MaxWordcurr = 0;

            }
        }
        System.out.println(MaxWordAll);
    }
}







