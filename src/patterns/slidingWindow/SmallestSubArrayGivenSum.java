package patterns.slidingWindow;


import java.util.ArrayList;

/*
 * Problem Statement
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum
 * is greater than or equal to ‘k’. Return 0 if no such subarray exists.
 * */
public class SmallestSubArrayGivenSum {
    public static int findSmallestSubArray(int arr[], int k) {
        int windowStart = 0;
        int sum = 0;
        int arrLength = arr.length;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arrLength; windowEnd++) {
            sum += arr[windowEnd];
            while (sum >= k) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = findSmallestSubArray(new int[]{2, 1, 5, 2, 8}, 7);
        System.out.println(result);
    }
}
