package Assignment5;

/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array arr a mountain if the following properties hold:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that
 * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {

        int l = 0, h = arr.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;

            if (arr[m] < arr[m + 1])
                l = m + 1;
            else
                h = m;
        }
        return l;
    }
}
