package acm_sgu.task_2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by ABurykin on 13.08.2016.
 */

// можно отправлять на проверку
public class Solution {

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer>  mapWords = new HashMap();
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

    }
}




/*
        for (Map.Entry<String, Integer> currWord :mapWords.entrySet() ){
            System.out.println(currWord.getKey() + ":" + currWord.getValue() + "max = " + max);
        }
        */



        /*
        // считываем массив слов и строк
        int max = -1;



            for (String word: line) {
                if ("".equals(word)) continue;

                if (!words.containsKey(word)){
                    words.put(word, 1);
                    if (max < 1) max = 1;
                } else {
                    words.put(word, (words.get(word) + 1));
                    if (max < words.get(word)) max = words.get(word);
                }
            }


        // теперь отбираю только самые популярные слова
        HashMap<String, Integer> famousWords = new HashMap();
        for (Map.Entry<String, Integer> currWord :words.entrySet() ){
            if (max == currWord.getValue()){
                famousWords.put(currWord.getKey(), max);
            }
        }

        // сортируем их и выводим на экран
        SortedSet<String> sortedFamousWords = new TreeSet(famousWords.keySet());
        for (String key : sortedFamousWords){
            System.out.println(key);
        }
        */

/*


*/


/*
ТЕСТЫ

qwe rty uio kjh Rty

a aa aaa aaaa
a aa aaa bbbb

*/

/*
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer>  words = new HashMap();

        // считываю тест
        String currStr;
        while (!"".equals(currStr = br.readLine().toLowerCase())){ // пока строка не пустая
            char[] symbols = (currStr+" ").toCharArray();

            // считываю слова
            String word = "";
            for (int i=0; i < symbols.length; i++ ){
                int curr = (int)symbols[i];
                if ((curr >= 65 && curr <= 90) || (curr >= 97 && curr <= 122)){
                    word += symbols[i];
                } else {
                    // слово закончилось, начинаю считать такие слова
                    if ("".equals(word)) {
                        continue;

                    }
                    else if (words.get(word) == null ){
                        words.put(word,1);
                    } else {
                        words.put(word,(words.get(word) + 1));
                    }
                    word = "";
                }
            }
        }

        // теперь количество повторений самых популярных слов
        int maxRepeat = 0;
        for (Map.Entry<String, Integer> pair : words.entrySet() ){
              if (maxRepeat < pair.getValue()) {
                  maxRepeat = pair.getValue();
              }
        }

        // теперь удаляю из коллекции все не популярные слова
        for (Map.Entry<String, Integer> pair : words.entrySet() ){
            if (maxRepeat != pair.getValue()) {
                // печатаю тест
                System.out.println(pair.getKey() + "  :  "+ pair.getValue());

                words.remove(pair.getKey()); // удаляю непопулярные слова
            }
        }



        // теперь сортирую коллекцию и вывожу на экран
        SortedSet<String> sortedFamousWords = new TreeSet(words.keySet());
        for (String key : sortedFamousWords){
            System.out.println(key);

        }
*/