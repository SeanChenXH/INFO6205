package Assignment4;

/**
 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element
 * in the given array. It is given that all array elements are distinct.
 */
public class KthSmallestElementInUnsortedArray {

    public int findKthSmallest(int[] nums, int k) {

        int start = 0;

        int end = nums.length - 1;

        int pivot = partition(nums, start, end);

        while (k != pivot) {

            if (pivot > k) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }

            pivot = partition(nums, start, end);
        }

        return nums[pivot];

    }

    public int partition(int[] nums, int start, int end) {

        int middle = start + (end - start) / 2;

        int pivotIndex = getPivot(nums, start, middle, end);

        swap(nums, pivotIndex, end);

        int pivot = end;

        int i = start - 1;


        for (int cur = start; cur < end; cur++) {
            if (nums[cur] <= nums[pivot]) {
                swap(nums, i + 1, cur);
                i = i + 1;
            }
        }

        swap(nums, i + 1, end);
        return i + 1;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int getPivot(int[] nums, int start, int middle, int end) {
        if ((nums[start] - nums[middle]) * (nums[start] - nums[end]) <= 0) {
            return start;
        } else if ((nums[end] - nums[middle]) * (nums[end] - nums[start]) <= 0) {
            return middle;
        } else {
            return end;
        }
    }
}
