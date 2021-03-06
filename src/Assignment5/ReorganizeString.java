package Assignment5;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 * <p>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 */
public class ReorganizeString {


    public String reorganizeString(String S) {

        //create currmount
        int currAmount = S.length();

        //create a map to store the character and it frequency
        HashMap<Character, Integer> map = new HashMap<>();

        char[] arr = S.toCharArray();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //create a priorityQueue to flag the character and its order
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (map.get(c1) <= map.get(c2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        //construct queue
        for (char c : map.keySet()) {
            //check if a greater than left amount/2, can not be formed  return ""
            int freChar = map.get(c);
            if (freChar > (currAmount + 1) / 2) {
                return "";
            }
            queue.add(c);
        }

        //StringBuilder to get the result
        StringBuilder res = new StringBuilder();

        //use wile loop to get the first element,
        while (queue.size() >= 2) {

            char tempChar1 = queue.poll();
            char tempChar2 = queue.poll();

            res.append(tempChar1);
            res.append(tempChar2);

            map.put(tempChar1, map.get(tempChar1) - 1);
            map.put(tempChar2, map.get(tempChar2) - 1);

            if (map.get(tempChar1) > 0) {
                queue.add(tempChar1);
            }
            if (map.get(tempChar2) > 0) {
                queue.add(tempChar2);
            }
        }

        if (queue.size() > 0) {
            res.append(queue.poll());
        }

        return res.toString();
    }
}
