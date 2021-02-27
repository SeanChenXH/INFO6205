package Assignment4;

/**
 * 75. Sort Colors
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int first = 0;
        int last = nums.length - 1;
        int index = 0;
        while (index <= last) {
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, last);
                last--;
            } else {
                swap(nums, index, first);
                first++;
                index++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
