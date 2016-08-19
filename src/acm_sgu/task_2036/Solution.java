package acm_sgu.task_2036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ABurykin on 13.08.2016.
 */

//  почему не проходит?
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList();

        // добавляю слова
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine().toLowerCase();
            list.add(input.toLowerCase());
        }

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()){
            String curr = iter.next().toString();
            if (curr.contains("eee") ||
                curr.contains("yyy") ||
                curr.contains("uuu") ||
                curr.contains("iii") ||
                curr.contains("ooo") ||
                curr.contains("aaa")) {
                iter.remove();
            }
        }

        for (String x : list) {
            System.out.println(x);
        }
    }
}







