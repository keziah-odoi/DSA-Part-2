package patterns.slidingWindow;

import java.util.Arrays;

public class AverageOfSubArrayK {
    public static double[] findAverages(int k, int[] arr) {
        if (arr == null || arr.length == 0) return new double[]{};
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubArrayK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        double[] ans = AverageOfSubArrayK.findAverages(5, new int[]{});
        System.out.println("result is " + Arrays.toString(result));
        System.out.println("result is " + Arrays.toString(ans));

    }
}
