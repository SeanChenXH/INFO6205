package Assignment7;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. Reverse Words in a String
 * <p>
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {

        List<String> list = new ArrayList<>();

        int r = s.length() - 1;
        int l = s.length() - 1;

        while (l >= 0 && r >= 0) {
            char temp = s.charAt(r);
            if (temp == ' ') {
                l--;
                r--;
            } else {
                l--;

                if (l == -1 || s.charAt(l) == ' ') {
                    list.add(s.substring(l + 1, r + 1));
                    r = l;
                }

            }
        }

        String res = "";

        for (int i = 0; i < list.size(); i++) {
            String st = list.get(i);
            if (i != list.size() - 1) {
                res = res + st + " ";
            } else {
                res = res + st;
            }

        }
        return res;
    }
}
