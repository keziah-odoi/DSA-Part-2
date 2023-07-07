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
        int[] result;
        int sum = 0;
//        int start = 0, end = 0, newMax = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> resultMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            sum += arr[windowEnd];
            list.add(arr[windowEnd]);
            if (windowEnd >= k - 1) {
//                if (sum > newMax) {
//                    newMax = sum;
//                    start = windowStart;
//                    end = windowEnd;
//                }
                resultMap.put(sum, new ArrayList<>(list));
                sum -= arr[windowStart];
                windowStart++;
                list.remove(0);
            }

        }
        for (Map.Entry<Integer, ArrayList<Integer>> map : resultMap.entrySet()) {
            max = Math.max(map.getKey(), max);
        }
//        int []finalResult = Arrays.copyOfRange(arr, start, end + 1);
        result = resultMap.get(max).stream().mapToInt(i -> i).toArray();
        return result;
    }

    public static void main(String[] args) {
        int[] result = findSubArrayWithMaxSum(new int[]{2, 1, 5, 1, 3, 2}, 3);
//        int[] result = findSubArrayWithMaxSum(new int[]{2, 3, 4, 1, 5}, 2);

        System.out.println("result array " + Arrays.toString(result));
    }
}
