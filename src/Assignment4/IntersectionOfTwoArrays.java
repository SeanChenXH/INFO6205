package Assignment4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * <p>
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> tempSet = new HashSet<>();
        List<Integer> retList = new ArrayList<>();

        for (int i : nums1) {
            tempSet.add(i);
        }

        for (int i : nums2) {
            if (tempSet.contains(i)) {
                retList.add(i);
                tempSet.remove(i);
            }
        }

        int[] arr = new int[retList.size()];

        for (int i = 0; i < retList.size(); i++) {
            arr[i] = retList.get(i);
        }
        return arr;
    }
}
