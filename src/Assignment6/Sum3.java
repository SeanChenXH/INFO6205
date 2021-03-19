package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {

        //O(nlgn)
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int m = i + 1;
            int r = nums.length - 1;

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (m < r) {

                if (m != i + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }

                if (r != nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }

                int lef = nums[i];
                int mid = nums[m];
                int rig = nums[r];

                if (lef + mid + rig == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(lef);
                    temp.add(mid);
                    temp.add(rig);
                    list.add(temp);
                    m++;
                    r--;
                } else if (lef + mid + rig < 0) {
                    m++;
                } else {
                    r--;
                }
            }
        }

        return list;
    }
}
