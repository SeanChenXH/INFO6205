package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 969. Pancake Sorting
 * <p>
 * Given an array of integers arr, sort the array by performing a series of pancake flips.
 * <p>
 * In one pancake flip we do the following steps:
 * <p>
 * Choose an integer k where 1 <= k <= arr.length.
 * Reverse the sub-array arr[0...k-1] (0-indexed).
 * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3,
 * we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
 * <p>
 * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr.
 * Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
 */
public class PancakeSorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList();
        int n = A.length;

        Integer[] B = new Integer[n];
        for (int i = 0; i < n; ++i)
            B[i] = i + 1;
        Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

        for (int i : B) {
            for (int f : res)
                if (i <= f)
                    i = f + 1 - i;
            res.add(i);
            res.add(n--);
        }

        return res;
    }
}
