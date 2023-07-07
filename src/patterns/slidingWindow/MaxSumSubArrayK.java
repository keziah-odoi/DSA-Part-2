package patterns.slidingWindow;


import java.util.*;

public class MaxSumSubArrayK {

    /*Given an array of positive numbers and a positive number ‘k,’
    find the maximum sum of any contiguous subarray of size ‘k’.*/

    public static int[] findSubArrayWithMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }
        int windowStart = 0;
        int length = arr.length;
        int sum = 0;
        int start = 0, end = 0, newMax = 0;
        int max = 0;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            sum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                if (sum > newMax) {
                    newMax = sum;
                    start = windowStart;
                    end = windowEnd;
                }
                sum -= arr[windowStart];
                windowStart++;
            }

        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public static void main(String[] args) {
//        int[] result = findSubArrayWithMaxSum(new int[]{2, 1, 5, 1, 3, 2}, 3);
        int[] result = findSubArrayWithMaxSum(new int[]{2, 3, 4, 1, 5}, 2);

        System.out.println("result array " + Arrays.toString(result));
    }
}
