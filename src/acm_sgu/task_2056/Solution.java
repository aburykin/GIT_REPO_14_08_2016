package acm_sgu.task_2056;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ABurykin on 13.08.2016.
 */

// Зачтена
public class Solution {


    public static void main(String[] args) throws IOException {

        HashMap<String, Integer>  mapWords = new HashMap();

        // считываем по словам и сразу пишем в массив и ищем максимум
        Scanner sc = new Scanner(System.in);
        int max = -1;
        while (sc.hasNext()) {
            String currWord = sc.next().toLowerCase();

            if ("".equals(currWord)) break;

            if (!mapWords.containsKey(currWord)){
                mapWords.put(currWord, 1);
                if (max == -1)
                {
                    max = 1;
                }
            } else {
                mapWords.put(currWord, (mapWords.get(currWord) + 1));
                if (max < mapWords.get(currWord))
                {
                    max = mapWords.get(currWord);
                }
            }
        }


        HashMap<String, Integer> famousWords = new HashMap();
        for (Map.Entry<String, Integer> currWord : mapWords.entrySet() ){
            if (max == currWord.getValue()){
                famousWords.put(currWord.getKey(), max);
            }
        }



        SortedSet<String> sortedFamousWords = new TreeSet(famousWords.keySet());
        for (String key : sortedFamousWords){
            System.out.println(key);
        }

    }
}






/*  HashMap<String, Integer>  mapWords = new HashMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // сначала считаем весь текст
        String text = "";
        String currLine;
        while (!"".equals(currLine = br.readLine())){
            text  = text + currLine;
        }
        text = text.toLowerCase();
     //   System.out.println("Input text:"+text);
        String[] massWords = text.split(" ");

        int max = -1;
        for (String currWord : massWords){
            if ("".equals(currWord)) continue;
            else if (!mapWords.containsKey(currWord)){
                mapWords.put(currWord, 1);
                if (max == -1) max = 1;
            } else {
                mapWords.put(currWord, (mapWords.get(currWord) + 1));
                if (max < mapWords.get(currWord)) max = mapWords.get(currWord);
            }
        }

        HashMap<String, Integer> famousWords = new HashMap();
        for (Map.Entry<String, Integer> currWord :mapWords.entrySet() ){
            if (max == currWord.getValue()){
                famousWords.put(currWord.getKey(), max);
            }
        }

        SortedSet<String> sortedFamousWords = new TreeSet(famousWords.keySet());
        for (String key : sortedFamousWords){
            System.out.println(key);
        }
*/