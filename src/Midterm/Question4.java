package Midterm;

public class Question4 {

    public static void main(String[] args) {
        //Test Case 1
        int[] test1 = {2, 4, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9};
        int x1 = 7;
        System.out.println("Test1: " + getIndex(test1, x1)); // 5

        //Test Case 2
        int[] test2 = {2, 4, 7, 7, 7, 8, 9, 9, 9};
        int x2 = 7;
        System.out.println("Test2: " + getIndex(test2, x2)); // 2

        //Test Case 3
        int[] test3 = {2, 4, 5, 6, 7, 7, 9};
        int x3 = 6;
        System.out.println("Test3: " + getIndex(test3, x3)); // 3

        //Test Case 4
        int[] test4 = {2, 2, 2};
        int x4 = 2;
        System.out.println("Test4: " + getIndex(test4, x4)); // 0

        //Test Case 5: Edge cases
        int[] test5 = {2, 4, 5, 6, 7, 7, 9};
        int x5 = 11;
        System.out.println("Test5: " + getIndex(test5, x5)); // Not occurrence existed -1

        //Test Case 6: Edge cases
        int[] test6 = {};
        int x6 = 11;
        System.out.println("Test6: " + getIndex(test6, x6)); // Not occurrence existed -1
    }

    //Time Complexity: O(log(n))
    //Space Complexity: 1
    public static int getIndex(int[] nums, int x) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == x) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
