package Midterm;

public class Question3 {

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0};
        int[] test2 = {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0};
        int[] test3 = {0, 0, 0, 0, 0, 0, 0};
        int[] test4 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //No 1s
        int[] test5 = null;

        System.out.println(getMaxConsecutiveOnes(test1));// 3
        System.out.println(getMaxConsecutiveOnes(test2));// 7
        System.out.println(getMaxConsecutiveOnes(test3));// 0
        System.out.println(getMaxConsecutiveOnes(test4));// 9
        System.out.println(getMaxConsecutiveOnes(test5));// 0
    }

    //Time Complexity: O(n)
    //Space Complexity: 1
    public static int getMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int cur_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur_count++;
                max = Math.max(max, cur_count);
            } else {
                cur_count = 0;
            }
        }
        return max;
    }
}
