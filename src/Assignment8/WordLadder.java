package Assignment8;

import java.util.*;

/**
 * 127. Word Ladder
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord
 * -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

    public static void main(String[] args) {
        //Test 1:
        String beginWord = "hit";
        String intendWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println("Test 1: "+ladderLength(beginWord, intendWord, wordList));// 5

        String beginWord2 = "hit";
        String intendWord2 = "cog";
        List<String> wordList2 = new ArrayList<String>();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println("Test 2: "+ladderLength(beginWord2, intendWord2, wordList2));// 0

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        int n = wordList.size();
        boolean[] visited = new boolean[n];

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        visited[n - 1] = true;

        int count = 0;

        boolean found = false;

        traverse:
        {
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                for (int i = 0; i < size; i++) {
                    String temp = queue.poll();
                    if (temp.equals(endWord)) {
                        found = true;
                        break traverse;
                    }


                    for (int j = 0; j < n; j++) {
                        String s = wordList.get(j);
                        if (!visited[j] && isAdjacent(temp, s)) {
                            visited[j] = true;
                            queue.add(s);
                        }
                    }


                }
            }
        }

        if (found == false) {
            return 0;
        } else {
            return count;
        }

    }

    public static boolean isAdjacent(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }

        if (count == 0) {
            return false;
        }

        return true;
    }
}
